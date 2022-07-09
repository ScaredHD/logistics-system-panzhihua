<template>
	<div class="main">
		<div class="header">
		  <router-link to="/warehouse">
		    <a-icon type="arrow-left" style="padding-right: 5px"/>
		    返回上一页
		  </router-link>
		</div>
		<div style="display: flex">
		  <el-button class="editable-btn" @click="handleSubmit('in')">
		    入库商品
		  </el-button>
		  <el-button class="editable-btn" @click="handleSubmit('out')">
		    出库商品
		  </el-button>
		</div>
		<el-table :data="data" stripe style="width: 100%">
			<el-table-column prop="ir_goods_name" label="商品名称" />
			<el-table-column prop="record_created_at" label="记录创建时间" />
			<el-table-column prop="record_count" label="出入库商品数量" />
			<el-table-column prop="record_type" label="出库|入库" />
			<el-table-column prop="record_comments" label="出入库记录备注" />
		</el-table>
		<!--<a-table :loading="loading" :columns="columns" :data-source="data" rowKey="id">
		  <a slot="name" slot-scope="text">{{ text }}</a>
		  <span slot="customTitle"><a-icon type="smile-o"/> 商品名</span>
		  <!-- <span slot="count" slot-scope="count">
		    <a-tag color="#108ee9">{{ count }}</a-tag>
		  </span> --
		</a-table>-->
		<a-modal
		    title="入库 ｜ 出库"
		    :closable="false"
		    :visible="false"
		    @ok="submit"
		    @cancel="visible = false"
		>
		  <!-- <a-form-model :model="form">
		    <a-form-model-item label="请选商品">
		      <a-select v-model="selectIndex" placeholder="请选择入库的商品">
		        <a-select-option :value="index" v-for="(item, index) in goodsList" :key="index">
		          {{ item.name }}
		        </a-select-option>
		      </a-select>
		    </a-form-model-item>
		    <a-form-model-item label="商品数量">
		      <a-input-number id="inputNumber" v-model="form.record_count" :min="1"/>
		    </a-form-model-item>
		    <a-form-model-item label="备注">
		      <a-input :rows="4" v-model="form.record_comments" type="textarea"/>
		    </a-form-model-item>
		  </a-form-model> -->
		</a-modal>
	</div>
</template>

<script>
// import {FindAllCommodity} from "../../api/commodity";
// import {FindAllInventory, InAndOut} from "../../api/inventory";
import service from "@/utils/request"
function FindAllCommodity(){
	return service({
		url:"/goodss",
		method:"get"
	});
}
function FindAllInventory(){
<<<<<<< Updated upstream
=======
	return service({
		url:"/inventorys",
		method:"get"
	})
}
function InAndOut(type, value){
	if(type=="in")
		value.record_type = "0"
	else if(type=="out")
		value.record_type = "1"
	value.record_created_at = new Date().getTime()
>>>>>>> Stashed changes
	var temp_list = window.location.href.split("/")
	return service({
		url:"/inventoryRecords/"+temp_list[temp_list.length-1],
		method:"get"
	});
}
function InAndOut(){
	return [];
}
<<<<<<< Updated upstream
=======

const columns = [
  {
    dataIndex: 'name',
    key: 'name',
    slots: {title: 'customTitle'},
    scopedSlots: {customRender: 'name'},
  },
	{
		title:"",
		dataIndex:'',
		key:'',
	},
  {
    title: '库存数量',
    dataIndex: 'record_count',
    key: 'record_count',
    scopedSlots: {customRender: 'record_count'},
  },
];
>>>>>>> Stashed changes

export default {
  data() {
    return {
			id: window.location.href.split("/")[window.location.href.split("/").length-1],
      loading: false,
      visible: false,
      recordVisible: false,
      selectIndex: 0,
      commodityVisible: false,
      columns,
      commodityList: [],
      submitType: '',
			goodsList: [],
			data:[],
			form:{
				ir_warehouse_id:"",
				ir_goods_id:"",
				record_created_at:"",
				record_count:50,
				record_type:"",
				record_comments:""
			},
			formatted_data: []
		}
  },
  mounted() {
		FindAllCommodity().then((res)=>{
			this.goodsList = res.data
		})
		this.loadTable()
	},
  methods: {
		loadTable: function(){
			FindAllInventory().then((res)=>{
				setTimeout(()=>{
					this.data = res.data
					console.log(this.data)
					for(var i=0;i<this.data.length;i++)
					{
						this.data[i].ir_goods_name = this.get_goods_name_by_id(this.data[i].ir_goods_id)
					}
					console.log(this.data);
				}, 600)

			})
		},
		handleSubmit:function(type){
			
		},
		submit: function(){
			
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
		get_goods_name_by_id(id){
			for(var i=0;i<this.goodsList.length;i++){
				if(this.goodsList[i].goods_id == id){
					return this.goodsList[i].goods_name
				}
			}
		},
		submit() {
      this.form.cid = this.commodityList[this.selectIndex].id
      this.form.name = this.commodityList[this.selectIndex].name
      InAndOut(this.submitType, this.form).then((res) => {
        if (res.status) this.$message.success("操作成功")
        this.visible = false
        this.loadData()
      })
    },
		
		
	},
}
</script>


<style scoped>
.main {
  background: #ffffff;
  padding: 30px;
}

.header {
  font-size: 18px;
  margin-bottom: 40px;
}

a {
  color: #000000;
}

.header a:hover {
  color: #5a84fd;
}

.editable-btn {
  margin-bottom: 20px;
  margin-right: 10px;
}

.in-icon {
  transform: rotate(270deg);
}
</style>