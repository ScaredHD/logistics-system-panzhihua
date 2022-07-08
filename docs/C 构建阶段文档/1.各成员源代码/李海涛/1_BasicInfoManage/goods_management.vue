<template>
  <div>
    <div style="display: flex">
      <el-button size="large" class="editable-add-btn" @click="commodityVisible = true">
        <a-icon type="plus"/>
        新增商品
      </el-button>
      <a-input-search
          placeholder="请输入商品名"
          enter-button="搜索商品"
          style="width: 400px;margin-left: 20px"
          size="large"
          @search="onSearch"
      />
			<el-button style="margin-left: 10px"  class="editable-add-btn" size="large" type="danger" @click="loadTableData">
			  重置
			</el-button>
    </div>
    <a-table :loading="loading" :columns="columns" :data-source="data" rowKey="id">
      <a slot="name" slot-scope="text">{{ text }}</a>
      <span slot="customTitle"><!-- <a-icon type="smile-o"/> -->
				商品名称
			</span>
      <span slot="action" slot-scope="text, record, index">
        <a-button @click="handleUpdate(record)" type="link"><a-icon type="edit"/> Update</a-button>
      <a-divider type="vertical"/>
         <a-button @click="handleDelete(record,index)" type="link"><a-icon type="delete"/> Delete</a-button>
    </span>
    </a-table>
    <a-modal
        title="商品信息"
        :closable="false"
        :visible="commodityVisible"
    >
      <a-form-model ref="ruleForm" :model="commodity">
        <a-form-model-item ref="name" label="商品名称" prop="name">
          <a-input v-model="commodity.goods_name"/>
        </a-form-model-item>
        <a-form-model-item label="商品单价" prop="price">
          <a-input-number id="input" v-model="commodity.goods_price" :min="1"/>
        </a-form-model-item>
        <a-form-model-item label="描述信息" prop="description">
          <a-input v-model="commodity.goods_desc" type="textarea"/>
        </a-form-model-item>
      </a-form-model>
      <template slot="footer">
        <el-button key="back" @click="commodityVisible = false">
          Return
        </el-button>
        <el-button key="submit" type="primary" :loading="modalLoading" @click="submitCommodity">
          Submit
        </el-button>
      </template>
    </a-modal>

  </div>
</template>

<script>
import service from "@/utils/request.js";
function FindAllCommodity(){
	return service({
	  url: '/goodss',
	  method: 'get'
	})
}
function SearchCommodity(query){
	return service({
		url: "/goodss/"+ query,
		method: 'get'
	})
}

function SaveCommodity(value, update){
	/*update的value不需要包含主键*/
	console.log(value)
	var method;
	if (update)
		method = "put"
	else
		method = "post"
	return service({
		url: "/goodss",
		method: method,
		data: value
	})
}
function DeleteCommodityById(goods_id){
	console.log(goods_id)
	return service({
		url: "/goodss/"+goods_id,
		method:"delete"
	})
	
}



const columns = [
  {
    dataIndex: 'goods_name',
    key: 'goods_name',
    slots: {title: 'customTitle'},
    scopedSlots: {customRender: 'name'},
  },
  {
    title: '商品单价',
    key: 'goods_price',
    dataIndex: 'goods_price',
    scopedSlots: {customRender: 'tags'},
  },
  {
    title: '描述信息',
    dataIndex: 'goods_desc',
    key: 'goods_desc',
  },
  {
    title: '更多操作',
    key: 'action',
    scopedSlots: {customRender: 'action'},
  },
];

export default {

  data() {
    return {
      commodity: {
				goods_id: "",
        goods_name: '',
        goods_desc: '商品简介',
        goods_price: 9.99,
      },
      loading: false,
      modalLoading: false,
      commodityVisible: false,
      commodityLoading: false,
      data: [],
      columns,
			update: false
    };
  },

  mounted() {
    this.loadTableData();
  },

  methods: {
    onSearch(value) {
      if (value){
        this.loading = true
				SearchCommodity(value).then((res)=>{
					setTimeout(() => {
						this.loading = false
						this.data = res.data
					}, 600)
				})
      }else {
        this.$message.warn("请输入搜索内容")
      }
    },

    loadTableData() {
      this.loading = true
			FindAllCommodity().then((res)=>{
				setTimeout(() => {
					this.loading = false
					this.data = res.data
				}, 600)
			})
    },

    submitCommodity() {
      this.modalLoading = true;
			var temp_commidity = this.commodity
			SaveCommodity(temp_commidity, this.update).then((res)=>{
				setTimeout(() => {
				  this.modalLoading = false
				  this.commodityVisible = false
				  this.$message.success('商品信息提交成功');
				  this.loadTableData();
				}, 600)
			})
			this.update = false;
    },

    handleDelete(r, index) {
			DeleteCommodityById(r.goods_id).then((res)=>{
				this.$message.success('商品信息删除成功');
				this.loadTableData()
			})
    },

    handleUpdate(r) {
			this.update = true
			console.log(r)
      this.commodity = r
      this.commodityVisible = true
    },

  },

};
</script>

<style scoped>
.editable-add-btn {
  margin-bottom: 15px;
}
</style>
