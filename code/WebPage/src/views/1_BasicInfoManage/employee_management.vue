<template>
  <div>
    <el-button size="large" class="editable-add-btn" @click="visible = true">
      <a-icon type="plus"/>
      新增员工
    </el-button>
    <a-table :loading="loading" :columns="columns" :data-source="data" bordered rowKey="employee_id">
      <template
          v-for="col in ['employee_name', 'employee_gender', 'employee_id_card','employee_tel', 'employee_address']"
          :slot="col"
          slot-scope="text, record, index"
      >
        <div :key="col">
          <a-input
              v-if="record.editable"
              style="margin: -5px 0"
              :value="text"
              @change="e => handleChange(e.target.value, record.employee_id, col)"
          />
          <template v-else>
            {{ text }}
          </template>
        </div>
      </template>
      <template slot="operation" slot-scope="text, record, index">
        <div class="editable-row-operations">
					<!-- <span v-if="record.editable">
          <a @click="() => save(record.employee_id, index)">保存</a>
          <a-popconfirm title="Sure to cancel?" @confirm="() => cancel(record.employee_id)">
            <a>取消</a>
          </a-popconfirm>
					</span>
          <span v-else>
          <a :disabled="editingKey !== ''" @click="() => edit(record.id)">编辑</a>
					</span> -->
          <a-popconfirm placement="top" ok-text="Yes" cancel-text="No" @confirm="confirm(record.employee_id)">
            <template slot="title">
              <p> 删除职员信息后将无法恢复，确定要删除吗？ </p>
            </template>
            <a-button type="link">删除</a-button>
          </a-popconfirm>
        </div>
      </template>
    </a-table>

    <a-modal
        title="Title"
        :visible="visible"
        @ok="submitForm"
        @cancel="visible = false"
    >
      <a-form-model :model="employee">
        <a-form-model-item label="姓名">
          <a-input v-model="employee.employee_name" placeholder="请输入员工姓名"/>
        </a-form-model-item>
				<a-form-model-item label="性别">
				  <a-radio-group v-model="employee.employee_gender">
				    <a-radio value="男性">男性</a-radio>
				    <a-radio value="女性">女性</a-radio>
				  </a-radio-group>
				</a-form-model-item>
        <a-form-model-item label="身份证号">
          <a-input v-model="employee.employee_id_card" placeholder="请输入员工身份证信息"/>
        </a-form-model-item>
        <a-form-model-item label="联系方式">
          <a-input v-model="employee.employee_tel" placeholder="请输入手机号码"/>
        </a-form-model-item>   
        <a-form-model-item label="家庭住址">
          <a-input v-model="employee.employee_address" type="textarea"/>
        </a-form-model-item>
      </a-form-model>
    </a-modal>

  </div>
</template>

<script>
import service from "@/utils/request.js";
function FindAllEmployee(){
	return service({
		url: "/employees",
		method: "get"
	})
}
function SaveEmployee(value, update_status){
	var method = "post"
	if(update_status)
		method = "put"
	return service({
		url:"/employees",
		method:method,
		data: value
	})
}
function DeleteEmployee(id){
	return service({
		url:"/employees/"+id,
		method:"delete"
	})
}

const columns = [
  {
    title: '名字',
    dataIndex: 'employee_name',
    scopedSlots: {customRender: 'employee_name'},
  },
  {
    title: '性别',
    dataIndex: 'employee_gender',
    scopedSlots: {customRender: 'employee_gender'},
  },
  {
    title: '身份证',
    dataIndex: 'employee_id_card',
    scopedSlots: {customRender: 'employee_id_card'},
  },
  {
    title: '联系电话',
    dataIndex: 'employee_tel',
    scopedSlots: {customRender: 'employee_tel'},
  },
  {
    title: '家庭住址',
    dataIndex: 'employee_address',
    scopedSlots: {customRender: 'employee_address'},
  },
  {
    title: '操作',
    dataIndex: 'operation',
    scopedSlots: {customRender: 'operation'},
  },
];

export default {
  data() {
    return {
      loading: false,
      employee: {
        cacheData: [],
        employee_name: '',
        employee_gender: '男性',
        employee_tel: '',
        employee_address: '',
        employee_id_card: '',
      },
      visible: false,
      data: [],
      columns,
      editingKey: '',
			update_status: false
    };
  },
  mounted() {
    this.loadTableData()
  },
  methods: {

    loadTableData() {
			this.loading = true;
			console.log("Find---")
			FindAllEmployee().then((res)=>{
				setTimeout(() => {
					this.data = res.data
					this.loading = false
				}, 600)
			})
    },

    submitForm() {
			var temp_employee = this.employee
			SaveEmployee(temp_employee, this.update_status).then((res)=>{
				if (res.status) 
					this.$message.success('员工信息提交成功')
				this.visible = false
				this.loadTableData()
			})
			this.update_status = false
    },

    handleChange(value, id, column) {
      const newData = [...this.data];
      const target = newData.filter(item => id === item.id)[0];
      if (target) {
        target[column] = value;
        this.data = newData;
      }
    },
    edit(id) {
			this.update_status = true;
      const newData = [...this.data];
      const target = newData.filter(item => id === item.id)[0];
      this.editingKey = id;
      if (target) {
        target.editable = true;
        this.data = newData;
      }
    },

    save(id, index) {
      const newData = [...this.data];
      const newCacheData = [...this.cacheData];
      const target = newData.filter(item => id === item.id)[0];
      const targetCache = newCacheData.filter(item => id === item.id)[0];
      if (target && targetCache) {
        delete target.editable;
        this.data = newData;
        Object.assign(targetCache, target);
        this.cacheData = newCacheData;
      }
      this.editingKey = '';
			/***************************************************
			// this is a replace to the request data
			***************************************************/
			SaveEmployee(newData[index]).then((res)=>{
				if (res.status) 
					this.$message.success("信息保存成功")
			})
      
    },
    cancel(id) {
      const newData = [...this.data];
      const target = newData.filter(item => id === item.id)[0];
      this.editingKey = '';
      if (target) {
        Object.assign(target, this.cacheData.filter(item => id === item.id)[0]);
        delete target.editable;
        this.data = newData;
      }
    },
    confirm(id) {
			DeleteEmployee(id).then((res)=>{
				if(res.status)
					this.$message.success('Delete success');
				this.loadTableData()
			})
			
      
    },
  },
};
</script>
<style scoped>

.editable-add-btn {
  margin-bottom: 15px;
}

.editable-row-operations a {
  margin-right: 8px;
}
</style>
