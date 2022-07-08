<template>
  <div>
    <a-table :loading="loading" :columns="columns" :data-source="data" rowKey="id">
      <a slot="company_name" slot-scope="company_name">{{ company_name }}</a>
      <span slot="customTitle"><a-icon type="bank" /> 公司名称</span>
      <span slot="action" slot-scope="text, record, index">
        <a-tag color="red" v-if="record.order_status=='0'">等待结款</a-tag>
        <a-tag color="green" v-if="record.order_status=='1'">结款完成</a-tag>
        <a-button v-if="record.order_status=='0'" type="link" @click="confirm(record, index)">结款</a-button>
      </span>
    </a-table>

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
function FindAllOrder(){
	return service({
		url:"/orders",
		method:"get"
	})
}
function saveOrder(value){
	return service({
		url:"/orders",
		method:"put",
		data: value
	})
}
const columns = [
	{
		title: '订单号',
		dataIndex: 'order_id',
		key: 'order_id',
	},
  {
    dataIndex: 'company_name',
    key: 'company_name',
    slots: {title: 'customTitle'},
    scopedSlots: {customRender: 'company_name'},
  },
  {
    title: '商品',
    dataIndex: 'commodity_name',
    key: 'commodity_name',
  },
  {
    title: '数量',
    dataIndex: 'order_num',
    key: 'order_num',
  },
  {
    title: '总计',
    dataIndex: 'order_price',
    key: 'order_price',
  },
  {
    title: '预留电话',
    key: 'company_tel',
    dataIndex: 'company_tel',
  },
  {
    title: '备注',
    dataIndex: 'order_desc',
    key: 'order_desc',
  },
  {
    title: '开票时间',
    dataIndex: 'formatted_time',
    key: 'formatted_time',
  },
  {
    title: '更多操作',
    key: 'action',
    scopedSlots: {customRender: 'action'},
  },
];

const data = [];

export default {

  data() {
    return {
      loading: false,
      data: [],
      columns,
			companyList:[],
			commodityList:[],
			commodity_price:0,
			commodity_name:"",
			company_name:"",
			company_tel:""
    };
  },

  mounted() {
    this.loadTableData()
		FindAllCommodity().then((res)=>{
			this.commodityList = res.data
		})
		FindAllCompany().then((res)=>{
			this.companyList = res.data
		})
  },

  methods: {
		getCompanyNameById(o_company_id){
			for(var i=0;i<this.companyList.length;i++){
				if(this.companyList[i].company_id == o_company_id){
					return {
						"company_name":this.companyList[i].company_name,
						"company_tel":this.companyList[i].company_tel
					}
				}
			}
		},
		getCommodityNameById(o_goods_id){
			for(var i=0;i<this.commodityList.length;i++){
				if(this.commodityList[i].goods_id == o_goods_id){
					return {
						"commodity_name":this.commodityList[i].goods_name,
						"commodity_price":this.commodityList[i].goods_price
					}
				}
			}
		},
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
    loadTableData() {
      this.loading = true;
			FindAllOrder().then((res)=>{
				setTimeout(()=>{
					this.data = res.data;
					this.loading = false;
					for(var i=0;i<this.data.length;i++){
						this.data[i]["company_name"] = this.getCompanyNameById(this.data[i].o_company_id)["company_name"];
						this.data[i]["company_tel"] = this.getCompanyNameById(this.data[i].o_company_id)["company_tel"];
						this.data[i]["commodity_name"]=this.getCommodityNameById(this.data[i].o_goods_id)["commodity_name"];
						this.data[i]["commodity_price"]=this.getCommodityNameById(this.data[i].o_goods_id)["commodity_price"];
						this.data[i]["order_price"]=this.data[i].order_num * this.data[i].commodity_price
						this.data[i]["formatted_time"] = this.format(this.data[i].order_created_at)
					}
					console.log("data:",this.data)
				}, 600)
			})
    },

    confirm(record, index) {
      let that = this
			var value = {
				"order_id":record.order_id,
				"order_status":'1'
			}
      this.$confirm({
        title: '销售结款',
        content: '我已确定' + record.company_name + '的销售金额 ¥' + record.order_price + '已经打入账户!',
        okText: '确认',
        cancelText: '取消',
        onOk() {
          that.data[index].pay = true;
					saveOrder(value).then((res)=>{
						if (res.code == 200){
							that.$message.success("销售结款成功")
							console.log("success")
							that.loadTableData()
						}
						else
							that.$message.success("销售结款失败")
						
					})
					
        },
      });
    },


  },

};
</script>

<style scoped>
.editable-add-btn {
  margin-bottom: 15px;
}
</style>
