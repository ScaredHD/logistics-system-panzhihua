<template>
  <div>
    <a-spin size="large" :spinning="spinning">
      <a-row :gutter="20">
        <a-col :span="8" class="item">
          <a-card hoverable class="add-item" @click="visible = true">
            <a-icon type="plus"/>
            添加车辆
          </a-card>
        </a-col>
        <a-col :span="8" v-for="(item, index) in this.data" :key="index" class="item">
          <a-card hoverable>
            <template slot="actions" class="ant-card-actions">
              <a-tag :color=" item.vehicle_status ? 'orange': 'green'">{{ item.status ? '正在途中' : '正在休息' }}</a-tag>
              <!-- <span>使用记录</span> -->
            </template>
            <a-card-meta
                :title="'车牌号：' + item.vehicle_license_number"
                :description="'ID: ' + item.vehicle_id">
              <a-badge :number-style="{ backgroundColor: '#52c41a' }"
                       slot="avatar"
                       :count="item.vehicle_type"
                       :offset="[-80,10]">
                <img class="image" :src="require('../../assets/' +item.vehicle_type+'.svg')" alt=""/>
              </a-badge>
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
        <a-form-model-item label="车牌号码">
          <a-input v-model="form.vehicle_license_number"/>
        </a-form-model-item>
        <a-form-model-item label="车辆类型">
          <a-select v-model="form.vehicle_type">
            <a-select-option value="小型汽车">小型汽车</a-select-option>
            <a-select-option value="货车">货车</a-select-option>
            <a-select-option value="卡车">卡车</a-select-option>
          </a-select>
        </a-form-model-item>
      </a-form-model>
    </a-modal>
  </div>
</template>

<script>
import service from "@/utils/request"
function FindAllVehicle(){
	return service({
		url:"/vehicles",
		method:"get"
	})
}
function saveVehicle(value){
	return service({
		url:"/vehicles",
		method: "post",
		data: value
	})
}
export default {
  name: "WareHouse",
  data() {
    return {
      visible: false,
      spinning: false,
      form: {
        vehicle_license_number: '京A-00000',
        vehicle_type: '货车',
        vehicle_status: 0,
      },
      data: [],
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
      this.spinning = true
			
			FindAllVehicle().then((res)=>{
				setTimeout(()=>{
					this.data = res.data;
					console.log("data:",this.data)
				}, 100)
				this.spinning = false
			})   
    },

    submit() {
			saveVehicle(this.form).then((res)=>{
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
  margin-left: 20px;
}
</style>