<template>
  <div>
    <a-table :loading="loading" :columns="columns" :data-source="data" bordered rowKey="id">
      <span slot="deliver_status" slot-scope="deliver_status">
        <a-tag v-if="deliver_status==='0'" color="#f50">等待审核</a-tag>
        <a-tag v-if="deliver_status==='1'" color="#2db7f5">配送完成</a-tag>
      </span>
      <template
          v-for="col in ['phone','address']"
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
          <a-button @click="review(index)" type="link" v-if="record.deliver_status==='0'">审核</a-button>
          <a-button @click="review(index)" type="link" v-if="record.deliver_status==='1'">查看</a-button>
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
          <a-input v-model="form.name" placeholder="请输入司机姓名"/>
        </a-form-model-item>
        <a-form-model-item label="身份证号">
          <a-input v-model="form.idCard" placeholder="请输入司机身份证信息"/>
        </a-form-model-item>
        <a-form-model-item label="联系方式">
          <a-input v-model="form.phone" placeholder="请输入手机号码"/>
        </a-form-model-item>
        <a-form-item label="驾照信息">
          <a-row :gutter="20">
            <a-col :span="12">
              <a-input v-model="form.license" addon-before="驾驶证" default-value="0571"/>
            </a-col>
            <a-col :span="7">
              <a-input-number v-model="form.score" addon-before="分数" default-value="12" :min="0" :max="12"/>
            </a-col>
          </a-row>
        </a-form-item>
        <a-form-model-item label="性别">
          <a-radio-group v-model="form.gender">
            <a-radio value="男性">男性</a-radio>
            <a-radio value="女性">女性</a-radio>
          </a-radio-group>
        </a-form-model-item>
        <a-form-model-item label="家庭住址">
          <a-input v-model="form.address" type="textarea"/>
        </a-form-model-item>
      </a-form-model>
    </a-modal>

    <a-modal
        title="Title"
        :visible="visible2"
        width="60%"
        :footer="null"
        @cancel="visible2 = false"
    >
      <a-steps :current="parseInt(select.driver_status)" style="padding: 50px">
        <a-step title="确认信息无误"/>
        <!-- <a-step title="开始配送"/> -->
        <a-step title="配送完成"/>
      </a-steps>
      <div class="content">
        <div v-if="select.deliver_status === '0'" class="check">
          <p>送货司机： {{ select.driver_name }}</p>
          <p>车牌号码： {{ select.vehicle_license_number }}</p>
          <p>注意事项： {{ select.deliver_notice }}</p>
          <p>客户地址： {{ select.deliver_address }}</p>
          <p>预计送达： {{ select.formatted_time }}</p>
          <a-button type="danger" style="margin-right: 20px" :loading="loading" @click="agree">通过</a-button>
          <a-button @click="visible2 = false">不通过</a-button>
        </div>
        <div v-if="select.deliver_status === '1'">
          <a-result
              status="success"
              title="运输订单已成功送达"
          >
            <template #extra>
              <a-button @click="visible2 = false" key="console" type="primary">
                确定
              </a-button>
            </template>
          </a-result>
        </div>
      </div>

    </a-modal>

  </div>
</template>

<script>
import service from "@/utils/request"
function FindAllDistribution(){
	return service({
		url:"/deliveries",
		method:"get"
		
	})
}

function SaveDistribution(value){
	return service({
		url:"/deliveries",
		method:"put",
		data:value
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
const columns = [
  {
    title: '司机',
    dataIndex: 'driver_name',
    scopedSlots: {customRender: 'driver_name'},
  },
  {
    title: '车牌号',
    dataIndex: 'vehicle_license_number',
    scopedSlots: {customRender: 'vehicle_license_number'},
  },
  {
    title: '客户地址',
    dataIndex: 'deliver_address',
    scopedSlots: {customRender: 'deliver_address'},
  },
  {
    title: '注意事项',
    dataIndex: 'deliver_notice',
    scopedSlots: {customRender: 'deliver_notice'},
  },
  {
    title: '预计送达',
    dataIndex: 'formatted_time',
    scopedSlots: {customRender: 'formatted_time'},
  },
  {
    title: '当前状态',
    dataIndex: 'deliver_status',
    scopedSlots: {customRender: 'deliver_status'},
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
      select: {},
      loading: false,
			drivers: [],
			vehicles: [],
      form: {
        cacheData: [],
        name: '',
        gender: '男性',
        phone: '',
        address: '',
        idCard: '',
        license: '',
        score: 12,
      },
      visible: false,
			visible2:false,
      data: [],
      columns,
      editingKey: '',
    };
  },
  mounted() {
		FindAllDriver().then((res)=>{
			this.drivers = res.data
		})
		FindAllVehicle().then((res)=>{
			this.vehicles = res.data
		})
    this.loadTableData()
  },
  methods: {
		add0:function(m){
			return m<10?'0'+m:m 
		},
		format:function(shijianchuo){
			var time = new Date(shijianchuo);
			var y = time.getFullYear();
			var m = time.getMonth()+1;
			var d = time.getDate();
			var h = time.getHours();
			var mm = time.getMinutes();
			var s = time.getSeconds();
			return y+'-'+this.add0(m)+'-'+this.add0(d)+' '+this.add0(h)+':'+this.add0(mm)+':'+this.add0(s);
		},
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
    loadTableData() {
      this.loading = true
			FindAllDistribution().then((res)=>{
				setTimeout(() => {
				  this.loading = false
					this.data = res.data
					for(var i=0;i<this.data.length;i++){
						this.data[i]["driver_name"] = this.getDriverById(this.data[i].d_driver_id).driver_name;
						this.data[i]["vehicle_license_number"] = this.getVehicleById(this.data[i].d_vehicle_id).vehicle_license_number;
						this.data[i]["formatted_time"] = this.format(this.data[i].deliver_time)
					}
					console.log(this.data)
				}, 600)
			})
      
    },
    submitForm() {
			/***************************************************
			// this is a replace to the request data
			***************************************************/
			SaveDistribution(this.form).then((res)=>{
				this.$message.success('信息提交成功');
				this.visible = false
				this.loadTableData()
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
      SaveDistribution(newData[index]).then((res)=>{
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

    review(index) {
      this.select = this.data[index]
      this.visible2 = true
    },

    agree() {
      this.select.deliver_status = '1'
			SaveDistribution(this.select).then((res)=>{
				this.$message.success("配送信息确认成功")
			})
    },

   //  service(){
   //    this.select.status = 2
			// /***************************************************
			// // this is a replace to the request data
			// ***************************************************/
   //    SaveDistribution(this.select)
   //  },

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

.content {
  padding: 50px 0;
}


.check {
  padding-left: 200px;
}

.check p {
  padding-bottom: 20px;
}
</style>
