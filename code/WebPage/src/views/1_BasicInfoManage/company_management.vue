<template>
  <div>
    <a-input-search
        placeholder="请输入公司名"
        enter-button="搜索来往公司"
        style="width: 400px;margin-bottom: 20px"
        size="large"
        @search="onSearch"
    />
    <el-button style="margin-left: 10px" size="large" type="danger" @click="loadTableData">
      重置
    </el-button>
    <a-table :loading="loading" :columns="columns" :data-source="data" rowKey="id">
      <a slot="company" slot-scope="company">{{ company }}</a>
      <span slot="customTitle"><a-icon type="bank"/> 公司名称</span>
    </a-table>

  </div>
</template>

<script>

function FindAllCompany(){
	return [
		{
			company:"攀枝花物流公司",
			phone:"+8512345678910",
			createAt:"2022-06-29 10:43:57"
		},{
			company:"攀枝花物流公司",
			phone:"+8512345678910",
			createAt:"2022-06-29 10:43:57"
		}
	]
}
function SearchCompany(value){
	return [
		{
			company:"攀枝花物流公司",
			phone:"+8512345678910",
			createAt:"2022-06-29 10:43:57"
		},{
			company:"攀枝花物流公司",
			phone:"+8512345678910",
			createAt:"2022-06-29 10:43:57"
		}
	]
}
const columns = [
  {
    dataIndex: 'company',
    key: 'company',
    slots: {title: 'customTitle'},
    scopedSlots: {customRender: 'company'},
  },
  {
    title: '预留电话',
    key: 'phone',
    dataIndex: 'phone',
  },
  {
    title: '时间',
    dataIndex: 'createAt',
    key: 'createAt',
  },
];

const data = [];

export default {

  data() {
    return {
      loading: false,
      data: [],
      columns,
    };
  },

  mounted() {
    this.loadTableData()
  },

  methods: {

    onSearch(value) {
      if (value) {
        this.loading = true
				/***************************************************
				// this is a replace to the request data
				***************************************************/
        this.data = SearchCompany(value)
				this.loading = false
      } else {
        this.$message.warn("请输入搜索内容")
      }
    },

    loadTableData() {
      this.loading = true;
			/***************************************************
			// this is a replace to the request data
			***************************************************/
			this.data = FindAllCompany();
			this.loading = false;
    }

  },

};
</script>

<style scoped>
.editable-add-btn {
  margin-bottom: 15px;
}
</style>
