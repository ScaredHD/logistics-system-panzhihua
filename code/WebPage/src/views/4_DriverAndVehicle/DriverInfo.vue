<template>
  <div>
    <a-button size="large" class="editable-add-btn" @click="visible = true">
      <a-icon type="plus"/>
      新增驾驶员
    </a-button>
    <a-table :loading="loading" :columns="columns" :data-source="data" bordered rowKey="id">
      <template
          v-for="col in ['driver_name', 'driver_gender', 'driver_tel','driver_license_score','driver_id_card','driver_address', 'driver_license']"
          :slot="col"
          slot-scope="text, record, index"
      >
        <div :key="col">
          <a-input
              v-if="record.editable"
              style="margin: -5px 0"
              :value="text"
              @change="e => handleChange(e.target.value, record.id, col)"
          />
          <template v-else>
            {{ text }}
          </template>
        </div>
      </template>
      <template slot="operation" slot-scope="text, record, index">
        <div class="editable-row-operations">
					<!-- <span v-if="record.editable">
						<a @click="() => save(record.id, index)">保存</a>
						<a-popconfirm title="Sure to cancel?" @confirm="() => cancel(record.id)">
							<a>取消</a>
						</a-popconfirm>
					</span>
          <span v-else>
						<a :disabled="editingKey !== ''" @click="() => edit(record.id)">编辑</a>
					</span> -->
          <a-popconfirm placement="top" ok-text="Yes" cancel-text="No" @confirm="confirm(record.driver_id)">
            <template slot="title">
              <p> 删除驾驶员信息后将无法恢复，确定要删除吗？ </p>
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
      <a-form-model :model="form">
        <a-form-model-item label="姓名">
          <a-input v-model="form.driver_name" placeholder="请输入司机姓名"/>
        </a-form-model-item>
        <a-form-model-item label="身份证号">
          <a-input v-model="form.driver_id_card" placeholder="请输入司机身份证信息"/>
        </a-form-model-item>
        <a-form-model-item label="联系方式">
          <a-input v-model="form.driver_tel" placeholder="请输入手机号码"/>
        </a-form-model-item>
        <a-form-item label="驾照信息">
          <a-row :gutter="20">
            <a-col :span="12">
              <a-input v-model="form.driver_license" addon-before="驾驶证" default-value="0571"/>
            </a-col>
            <a-col :span="7">
              <a-input-number v-model="form.driver_license_score" addon-before="分数" default-value="12" :min="0" :max="12"/>
            </a-col>
          </a-row>
        </a-form-item>
        <a-form-model-item label="性别">
          <a-radio-group v-model="form.driver_gender">
            <a-radio value="男性">男性</a-radio>
            <a-radio value="女性">女性</a-radio>
          </a-radio-group>
        </a-form-model-item>
        <a-form-model-item label="家庭住址">
          <a-input v-model="form.driver_address" type="textarea"/>
        </a-form-model-item>
      </a-form-model>
    </a-modal>

  </div>
</template>

<script>
import service from "@/utils/request"
function FindAllDriver(){
	return service({
		url:"/drivers",
		method:"get"
	})
}

function DeleteDriverById(id){
	return service({
		url:"/drivers/"+id,
		method:"delete"
	})
}
function SaveDriver(value, update=false){
	var method = "post";
	if(update) method = "put"
	return service({
		url:"/drivers",
		method:method,
		data:value
	})
}

const columns = [
  {
    title: '名字',
    dataIndex: 'driver_name',
    scopedSlots: {customRender: 'driver_name'},
  },
  {
    title: '性别',
    dataIndex: 'driver_gender',
    scopedSlots: {customRender: 'driver_gender'},
  },
  {
    title: '联系电话',
    dataIndex: 'driver_tel',
    scopedSlots: {customRender: 'driver_tel'},
  },
  {
    title: '驾驶证',
    dataIndex: 'driver_license',
    scopedSlots: {customRender: 'driver_license'},
  },
  {
    title: '驾证分数',
    dataIndex: 'driver_license_score',
    scopedSlots: {customRender: 'driver_license_score'},
  },
  {
    title: '身份证',
    dataIndex: 'driver_id_card',
    scopedSlots: {customRender: 'driver_id_card'},
  },
  {
    title: '家庭住址',
    dataIndex: 'driver_address',
    scopedSlots: {customRender: 'driver_address'},
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
      form: {
        cacheData: [],
        driver_name: '',
        driver_gender: '男性',
        driver_tel: '',
        driver_address: '',
        driver_id_card: '',
        driver_license: '',
        driver_license_score: 12,
				driver_status: 0
      },
      visible: false,
      data: [],
      columns,
      editingKey: '',
			update: false,
    };
  },
  mounted() {
    this.loadTableData()
  },
  methods: {
    loadTableData() {
      this.loading = true;
			FindAllDriver().then((res)=>{
				setTimeout(()=>{
					this.data = res.data;
					this.cacheData = res.data.map(item => ({...item}))
					this.loading = false;
				}, 300)
			})
    },
    submitForm() {
			SaveDriver(this.form).then((res)=>{
				this.$message.success('司机信息提交成功')
				this.visible = false
				this.loadTableData()
				this.update = false
			})
     
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
			this.update = true;
			SaveDriver(newData[index], this.update).then((res)=>{
				this.$message.success("信息保存成功");
				this.loadTableData()
			});
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
      DeleteDriverById(id).then((res) => {
        if (res.status)  this.$message.success('Delete success');
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
