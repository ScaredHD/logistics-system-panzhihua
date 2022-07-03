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
      <el-button style="margin-left: 10px" size="large" type="danger" @click="loadTableData">
        重置
      </el-button>
    </div>
    <a-table :loading="loading" :columns="columns" :data-source="data" rowKey="id">
      <a slot="name" slot-scope="text">{{ text }}</a>
      <span slot="customTitle"><a-icon type="smile-o"/> 商品名称</span>
      <span slot="action" slot-scope="text, record, index">
        <el-button @click="handleUpdate(record)" type="link"><a-icon type="edit"/> Update</el-button>
      <a-divider type="vertical"/>
         <el-button @click="handleDelete(record,index)" type="link"><a-icon type="delete"/> Delete</el-button>
    </span>
    </a-table>

    <a-modal
        title="商品信息"
        :closable="false"
        :visible="commodityVisible"
    >
      <a-form-model ref="ruleForm" :model="commodity">
        <a-form-model-item ref="name" label="商品名称" prop="name">
          <a-input v-model="commodity.name"/>
        </a-form-model-item>
        <a-form-model-item label="商品单价" prop="price">
          <a-input-number id="input" v-model="commodity.price" :min="1"/>
        </a-form-model-item>
        <a-form-model-item label="描述信息" prop="description">
          <a-input v-model="commodity.description" type="textarea"/>
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

function FindAllCommodity(){
	var res_data = {
		"code": 200,
		"status": true,
		"msg": null,
		"data": [
			{
				"id": "2a4b5d30-d5fe-472c-b3a9-41f1ab8f0268",
				"name": "ipad",
				"price": 3999,
				"description": "apple",
				"count": 100,
				"createAt": "2022-06-29 08:45:40",
				"updateAt": null
			},
			{
				"id": "c147a983-bf2e-4cc2-a21e-743e9026cf7c",
				"name": "dasd",
				"price": 8.99,
				"description": "商品简介",
				"count": 120,
				"createAt": "2022-06-25 15:41:20",
				"updateAt": null
			},
			{
				"id": "d6a444cc-e9d5-4430-8f5a-4dfef4bfd2c7",
				"name": "蓝牙耳机",
				"price": 200,
				"description": "200块，买不了吃亏买不了上当，走过路过不要错过，真真的无线蓝牙耳机，你值得拥有",
				"count": 98,
				"createAt": "2022-06-28 08:49:31",
				"updateAt": null
			}
		]
	}
	return res_data.data;
}
function SearchCommodity(value){
	
	return FindAllCommodity();
}
function SaveCommodity(value){
	setTimeout(() => {
	  this.modalLoading = false
	  this.commodityVisible = false
	  this.$message.success('商品信息提交成功');
	  this.loadTableData();
	}, 600)
}
function DeleteCommodityById(id){
	this.$message.success('商品信息删除成功');
}



const columns = [
  {
    dataIndex: 'name',
    key: 'name',
    slots: {title: 'customTitle'},
    scopedSlots: {customRender: 'name'},
  },
  {
    title: '库存数量',
    dataIndex: 'count',
    key: 'age',
  },
  {
    title: '描述信息',
    dataIndex: 'description',
    key: 'description',
  },
  {
    title: '入库时间',
    dataIndex: 'createAt',
    key: 'address',
  },
  {
    title: '商品单价',
    key: 'price',
    dataIndex: 'price',
    scopedSlots: {customRender: 'tags'},
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
      commodity: {
        name: '',
        description: '商品简介',
        count: 0,
        price: 9.99,
      },
      loading: false,
      modalLoading: false,
      commodityVisible: false,
      commodityLoading: false,
      data: [],
      columns,
    };
  },

  mounted() {
    this.loadTableData()
  },

  methods: {
    onSearch(value) {
      if (value){
        this.loading = true
				/***************************************************
				// this is a replace to the request data
				***************************************************/
				this.data = SearchCommodity(value);
				this.loading = false;
      }else {
        this.$message.warn("请输入搜索内容")
      }
    },

    loadTableData() {
      this.loading = true;
			this.data = FindAllCommodity();
			this.loading = false;
      /***************************************************
      // this is a replace to the request data
      ***************************************************/
    },

    submitCommodity() {
      this.modalLoading = true;
			SaveCommodity(this.commodity);
      /***************************************************
      // this is a replace to the request data
      ***************************************************/
    },

    handleDelete(r, index) {
			DeleteCommodityById(r.id);
     /***************************************************
     // this is a replace to the request data
     ***************************************************/
    },

    handleUpdate(r) {
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
