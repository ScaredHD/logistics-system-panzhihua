<template>
  <div class="main">
    <a-steps :current="current">
      <a-step title="填写信息"></a-step>
      <a-step title="确认信息"/>
      <a-step title="完成"/>
    </a-steps>
    <div class="steps-content">
      <div v-if="current === 0">
        <a-form-model :model="form" :label-col="labelCol" :wrapper-col="wrapperCol">
          <a-form-model-item label="合作公司" required>
            <a-select v-model="form.o_company_id" placeholder="请选择公司">
              <a-select-option :value="item.company_id" v-for="(item, index) in companyList" :key="index">
                {{ item.company_name }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
          <a-form-model-item label="售出商品" required>
            <a-select v-model="form.o_goods_id" placeholder="请选择商品">
              <a-select-option :value="item.goods_id" v-for="(item, index) in commodityList" :key="index">
                {{ item.goods_name }}
              </a-select-option>
            </a-select>
          </a-form-model-item>
          <a-form-model-item label="商品数量" required>
            <a-input-number v-model="form.order_num"/>
          </a-form-model-item>
          <a-form-model-item label="备注信息" required>
            <a-input v-model="form.order_desc" type="textarea" :rows="4"/>
          </a-form-model-item>
          <a-form-model-item :wrapper-col="{ span: 14, offset: 6 }">
            <a-button type="primary" @click="next">
              下一步
            </a-button>
          </a-form-model-item>
        </a-form-model>
      </div>
      <div v-if="current === 1" class="check">
        <p>收货公司： {{ form.o_company_name }}</p>
        <!-- <p>打款账号： {{ form.number }}</p> -->
        <p>售出商品： {{ form.o_goods_name }}</p>
        <p>商品数量： {{ form.order_num }}</p>
        <p>预留电话： {{ form.tel_number }}</p>
        <p>备注信息： {{ form.order_desc }}</p>
        <a-divider orientation="right">
          金额总计： {{ form.order_price }}
        </a-divider>
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
            <router-link to="/order/record">
              <a-button key="console" type="primary">
                Go Back
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
import service from "@/utils/request"
function FindAllCompany(){
	return service({
		url:"/companys",
		method:"get"
	})
}
function FindAllCommodity(){
	return service({
		url:"/goodss",
		method:"get"
	})
}
	
function saveOrder(value){
	return service({
		url:"/orders",
		method:"post",
		data: value
	})
}
export default {

  data() {
    return {
      loading: false,
      labelCol: {span: 6},
      wrapperCol: {span: 12},
      current: 0,
      selectIndex: 0,
      drivers: [],
      vehicles: [],
      commodityList: [],
			companyList:[],
      form: {
        o_company_id: '',
        tel_number: '',
        o_goods_id: '',
        order_num: 50,
        order_price: 0,
        order_desc: '',
				o_company_name:"",
				o_goods_name:"",
				order_created_at:"",
				order_status: 0,
				order_money:0
      },
    }
  },

  mounted() {
		FindAllCommodity().then((res)=>{
			this.commodityList = res.data
		})
		FindAllCompany().then((res)=>{
			this.companyList = res.data
		})
  },

  methods: {
		getCompanyNameById(){
			for(var i=0;i<this.companyList.length;i++){
				if(this.companyList[i].company_id == this.form.o_company_id){
					this.form.tel_number = this.companyList[i].company_tel
					this.form.o_company_name = this.companyList[i].company_name
					return this.companyList[i].company_name
				}
			}
		},
		getCommodityNameById(){
			for(var i=0;i<this.commodityList.length;i++){
				if(this.commodityList[i].goods_id == this.form.o_goods_id){
					this.form.o_goods_name = this.commodityList[i].goods_name
					this.order_money = this.form.order_num*this.commodityList[i].goods_price
					return this.commodityList[i].goods_name
				}
			}
		},
    next() {
			this.form.o_company_name = this.getCompanyNameById()
			this.form.o_goods_name = this.getCommodityNameById()
			this.form.order_created_at = new Date().getTime()
      this.current = 1
    },
    submit() {
      this.loading = true
			saveOrder(this.form).then((res)=>{
				if(res.code=200){
					this.loading = false
					this.current = 2
					this.$message.success("提交成功")
				}else{
					this.loading = false
					this.current = 2
					this.$message.success("提交失败")
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