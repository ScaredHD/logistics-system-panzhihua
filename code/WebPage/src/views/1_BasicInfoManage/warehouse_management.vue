<template>
  <div>
    <a-spin size="large" :spinning="spinning">
      <a-row :gutter="20">
        <a-col :span="8" class="item">
          <a-card hoverable class="add-item" @click="visible = true">
            <a-icon type="plus"/>
            添加仓库
          </a-card>
        </a-col>
        <a-col :span="8" v-for="(item, index) in this.data" :key="index" class="item">
          <a-card hoverable>
            <template slot="actions" class="ant-card-actions">
              <span>负责人: {{ item.warehouse_manager_id }}</span>
              <span>
                <router-link :to="'/warehouse/' + item.warehouse_id">
                  <a-icon type="bar-chart"/> 库存管理
                </router-link>
              </span>
            </template>
            <a-card-meta
                :title="item.warehouse_name"
                :description="'ID: ' + item.warehouse_id">
              <img class="image" slot="avatar" :src="imgList[Math.floor(Math.random() * 3)]"
                   alt=""/>
            </a-card-meta>
          </a-card>
        </a-col>
      </a-row>
    </a-spin>

    <a-modal
        title="新增仓库"
        :visible="visible"
        @ok="submit"
        @cancel="visible = false"
    >
		<a-form-model :model="form">
			<a-form-model-item label="仓库名称">
				<a-input v-model="form.warehouse_name" style="width: 300px;margin-bottom: 20px"/>
			</a-form-model-item>
			<a-form-model-item label="仓库负责人">
				<a-select style="width:400px" v-model="form.warehouse_manager_id"  placeholder="请选择员工所在仓库">
					<a-select-option style="width:300px;" :value="item.employee_id" v-for="(item,index) in EmployeeList">{{ item.employee_name }}</a-select-option>
				</a-select>
			</a-form-model-item>
		</a-form-model>
		</a-modal>
  </div>
</template>

<script>
import service from "@/utils/request"
function FindAllWareHouse(){
	return service({
		url:"/warehouses",
		method:"get"
	})
}
function FindAllEmployee(){
	return service({
		url:"/employees",
		method:"get"
	})
}

function SaveWarehouse(value){
	return service({
		url:"/warehouses",
		method:"post",
		data: value
	})
}
function DeleteWarehouse(warehouse_id){
	return service({
		url:"/warehouses/"+warehouse_id,
		method:"delete"
	})
}
function GetEmployeeNameById(id){
	return service({
		url:"/employees/"+id,
		method:"get"
	})
}
export default {
  name: "WareHouse",
  data() {
    return {
      visible: false,
      form: {warehouse_id: '', warehouse_manager_id: '', warehouse_name: ''},
      spinning: false,
      data: [],
			EmployeeList:[],
      imgList: [
        require('../../assets/warehouse0.svg'),
        require('../../assets/warehouse1.svg'),
        require('../../assets/warehouse2.svg'),]
    }
  },

  mounted() {
    this.loadData()
  },

  methods: {

    loadData() {
      this.spinning = true;
			FindAllWareHouse().then((res)=>{
				setTimeout(()=>{
					this.data = res.data;
					this.spinning = false;
				}, 600)
			})
			FindAllEmployee().then((res)=>{
				setTimeout(()=>{
					this.EmployeeList = res.data;
				},100)
			})
    },

    submit() {
			SaveWarehouse(this.form).then((res) => {
        if (res.status) 
					this.$message.success("添加成功")
        this.visible = false
        this.loadData()
      })  
    }

  },

}
</script>

<style scoped>
.add-item {
  text-align: center;
  line-height: 120px;
  min-height: 120px;
  border: 1px dashed #91949c;
}

.add-item:hover {
  border: 1px dashed #5a84fd;
  color: #5a84fd;
}

.item {
  margin-bottom: 20px;
}

.image {
  width: 80px;
  height: 80px;
}
</style>