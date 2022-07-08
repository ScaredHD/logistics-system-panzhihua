<template>
  <div class="main">
    <a-steps :current="current">
      <a-step title="填写申请信息"></a-step>
      <a-step title="确认配送信息"/>
      <a-step title="完成申请"/>
    </a-steps>
    <div class="steps-content">
      <div v-if="current === 0">
        <a-form-model :model="form" :label-col="labelCol" :wrapper-col="wrapperCol">
					<a-form-model-item label="选择订单" required>
						<a-select v-model="form.d_order_id" placeholder="请选择订单号">
						  <a-select-option :value="item.order_id" v-for="(item, index) in orders" :key="index">
						  {{"订单 "+item.order_id}}
							</a-select-option>
						</a-select>
					</a-form-model-item>
         <a-form-model-item label="选择司机" required>
         	<a-select v-model="form.d_driver_id" placeholder="请选择司机">
         	  <a-select-option :value="item.driver_id" v-for="(item, index) in drivers" :key="index">
         	  {{item.driver_name}}
						<i class="dis" v-if="item.driving">
              <a-icon type="close-circle"/>
              正在途中
						</i>
         		</a-select-option>
         	</a-select>
         </a-form-model-item>
          <a-form-model-item label="选择运输车辆" required>
            <a-select v-model="form.d_vehicle_id" placeholder="请选择配送车辆">
              <a-select-option :value="item.vehicle_id" v-for="(item, index) in vehicles" :key="index" :disabled="item.vehicle=='1'">
                {{ item.vehicle_type }} : {{ item.vehicle_license_number }}
                <i class="dis" v-if="item.vehicle_status=='1'">
                  <a-icon type="close-circle"/>
                  正在途中</i>
              </a-select-option>
            </a-select>
          </a-form-model-item>
          <a-form-model-item label="预计交货时间" required>
            <a-date-picker
                v-model="form.deliver_time"
                show-time
                type="date"
                placeholder="选择日期"
                style="width: 100%;"
            />
          </a-form-model-item>
         
          <a-form-model-item label="客户地址" required>
            <a-input v-model="form.deliver_address" type="textarea" :rows="1"/>
          </a-form-model-item>
					<a-form-model-item label="注意事项">
						<a-input v-model="form.deliver_notice" type="textarea" :rows="4"/>
					</a-form-model-item>
          <a-form-model-item :wrapper-col="{ span: 14, offset: 6 }">
            <a-button type="primary" @click="next">
              下一步
            </a-button>
          </a-form-model-item>
        </a-form-model>
      </div>
      <div v-if="current === 1" class="check">
				<p>配送订单： {{form.d_order_id}}</p>
        <p>送货司机： {{getDriverById(form.d_driver_id).driver_name }}</p>
        <p>车牌号码： {{ getVehicleById(form.d_vehicle_id).vehicle_license_number }}</p>
        <p>客户地址： {{ form.deliver_address }}</p>
        <p>预计送达： {{ form.deliver_time }}</p>
				<p>注意事项： {{ form.deliver_notice}}</p>
        <a-button type="danger" style="margin-right: 20px" :loading="loading" @click="submit">提交</a-button>
        <a-button @click="current = 0">上一步</a-button>
      </div>
      <div v-if="current === 2">
        <a-result
            status="success"
            title="Submitted Successfully"
            sub-title="Please wait for the administrator to review the delivery request."
        >
          <template #extra>
            <router-link to="/delivery/record">
              <a-button key="console" type="primary">
                Go Console
              </a-button>
            </router-link>
            <a-button key="buy" @click="current = 0">
              Submit Again
            </a-button>
          </template>
        </a-result>
      </div>
    </div>
  </div>
</template>

<script>
// import {FindAllCanUse, SaveDistribution} from "../../api/distribution";
import service from "@/utils/request"
function FindAllOrder(){
	return service({
		url:"/orders",
		method:"get"
	})
}
function FindAllDriver(){
	return service({
		url:"/drivers",
		method:"get"
	})
}
function FindAllVehicle(){
	return service({
		url:"/vehicles",
		method:"get"
	})
}
function SaveDistribution(value){
	return service({
		url:"/deliveries",
		method:"post",
		data:value
	})
}
export default {

  data() {
    return {
      loading: false,
      labelCol: {span: 6},
      wrapperCol: {span: 12},
      current: 0,
      selectDriverIndex: 0,
      selectVehicleIndex: 0,
      drivers: [],
      vehicles: [],
			orders:[],
      form: {
        //deliver_id: '',
        d_driver_id: '',
        d_vehicle_id: '',
				d_order_id:"",
        driver: '',
        number: '',
        phone: '',
				deliver_notice:"",
        deliver_address: '',
        deliver_time: '',
        deliver_status: 0,
      },
    }
  },

  mounted() {
		FindAllDriver().then((res)=>{
			if(res.code==200){
				this.drivers = res.data
			}
		})
		FindAllVehicle().then((res)=>{
			if(res.code=200){
				this.vehicles = res.data
			}
		})
		FindAllOrder().then((res)=>{
			if(res.code==200){
				this.orders = res.data
			}
		})
  },

  methods: {
		getDriverById(id){
			for(var i=0;i<this.drivers.length;i++){
				if(this.drivers[i].driver_id == id){
					return {
						driver_name:this.drivers[i].driver_name
					}
				}
			}
		},
		getVehicleById(id){
			for(var i=0;i<this.vehicles.length;i++){
				if(this.vehicles[i].vehicle_id == id){
					return {
						vehicle_license_number:this.vehicles[i].vehicle_license_number
					}
				}
			}
		},
    next() {
      this.form.driver_name = this.getDriverById(this.form.d_driver_id).driver_name
			this.form.vehicle_license_number = this.getVehicleById(this.form.d_vehicle_id).vehicle_license_number
      
      this.current = 1
    },
    submit() {
      this.loading = true
      SaveDistribution(this.form).then((res) => {
        if (res.code==200) {
          setTimeout(() => {
            this.loading = false
            this.current = 2
            this.$message.success("提交成功，请等待审核")
          }, 800)
        } else {
          setTimeout(() => {
            this.loading = false
            this.$message.error("提交失败")
          }, 800)
        }
      })
    },
  },

}
</script>

<style scoped>
.main {
  padding: 50px 180px;
  background: #ffffff;
}

.steps-content {
  margin-top: 40px;
}

.check {
  padding-left: 200px;
}

.check p {
  padding-bottom: 10px;
}

.dis {
  padding-left: 10px;
  font-size: 10px;
  letter-spacing: 1px;
  color: red;
}

</style>