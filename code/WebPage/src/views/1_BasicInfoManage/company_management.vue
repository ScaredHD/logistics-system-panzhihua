<template>
  <div>
		<div style="display: flex">
			<el-button size="large" class="editable-add-btn" @click="companyVisible = true">
				<a-icon type="plus"/>
				新增公司
			</el-button>
			<a-input-search
					placeholder="请输入公司名"
					enter-button="搜索来往公司"
					style="width: 400px;margin-left: 20px"
					size="large"
					@search="onSearch"
			/>
			<el-button style="margin-left: 10px" class="editable-add-btn" size="large" type="danger" @click="loadTableData">
				重置
			</el-button>
		</div>
    <a-table :loading="loading" :columns="columns" :data-source="data" rowKey="id">
      <a slot="company" slot-scope="text">{{ company }}</a>
      <span slot="customTitle"><a-icon type="bank"/> 公司名称</span>
			<span slot="action" slot-scope="text, record, index">
			    <a-button @click="handleUpdate(record)" type="link"><a-icon type="edit"/> Update</a-button>
			  <a-divider type="vertical"/>
			     <a-button @click="handleDelete(record,index)" type="link"><a-icon type="delete"/> Delete</a-button>
			</span>
    </a-table>
		
		<a-modal
		    title="公司信息"
		    :closable="false"
		    :visible="companyVisible"
		>
		  <a-form-model ref="ruleForm" :model="company">
		    <a-form-model-item ref="name" label="公司名称" prop="name">
		      <a-input v-model="company.company_name"/>
		    </a-form-model-item>
		    <a-form-model-item label="公司联系电话" prop="telephone">
		      <a-input v-model="company.company_tel"/>
		    </a-form-model-item>
		    <a-form-model-item label="公司联系人" prop="contact_person">
		      <a-input v-model="company.company_contacts"/>
		    </a-form-model-item>
		  </a-form-model>
		  <template slot="footer">
		    <el-button key="back" @click="companyVisible = false">
		      Return
		    </el-button>
		    <el-button key="submit" type="primary" :loading="modalLoading" @click="submitCompany">
		      Submit
		    </el-button>
		  </template>
		</a-modal>
  </div>
</template>

<script>

import service from "@/utils/request.js";
function FindAllCompany(){
	return service({
		url:"/companys",
		method:"get"
	})
}
function SearchCompany(query){
	return service({
		url:"/companys/"+query,
		method:"get"
	})
}

function SaveCompany(value, update){
	var method;
	if (update)
		method = "put"
	else
		method = "post"
	return service({
		url: "/companys",
		method: method,
		data: value
	})
}
function DeleteCompanyById(company_id){
	return service({
		url: "/companys/"+company_id,
		method:"delete"
	})
	
}
const columns = [
  {
    dataIndex: 'company_name',
    key: 'company_name',
    slots: {title: 'customTitle'},
    scopedSlots: {customRender: 'company_name'},
  },
  {
    title: '预留电话',
    key: 'company_tel',
    dataIndex: 'company_tel',
  },
  {
    title: '联系人',
    dataIndex: 'company_contacts',
    key: 'company_contacts',
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
			company: {
				"company_id":"",
				"company_name":"",
				"company_tel":"",
				"company_contacts":""
			},
			companyVisible: false,
      loading: false,
			modalLoading: false,
			companyLoading: false,
      data: [],
      columns,
			update: false
    };
  },

  mounted() {
    this.loadTableData()
  },

  methods: {

    onSearch(value) {
      if (value) {
        this.loading = true
				SearchCompany(value).then((res)=>{
					setTimeout(() => {
						this.loading = false
						this.data = res.data
					}, 600)
				})
      } else {
        this.$message.warn("请输入搜索内容")
      }
    },

    loadTableData() {
      this.loading = true;
			FindAllCompany().then((res)=>{
				setTimeout(() => {
					this.loading = false
					this.data = res.data
				}, 600)
			})
    },
		submitCompany() {
		  this.modalLoading = true;
			var temp_commidity = this.company
			SaveCompany(temp_commidity, this.update).then((res)=>{
				setTimeout(() => {
				  this.modalLoading = false
				  this.companyVisible = false
				  this.$message.success('商品信息提交成功');
				  this.loadTableData();
				}, 600)
			})
			this.update = false;
		},
		handleDelete(r, index) {
			DeleteCompanyById(r.company_id).then((res)=>{
				this.$message.success('商品信息删除成功');
				this.loadTableData()
			})
		},
		
		handleUpdate(r) {
			this.update = true
			console.log(r)
		  this.company = r
		  this.companyVisible = true
		},
	},

};
</script>

<style scoped>
.editable-add-btn {
  margin-bottom: 15px;
}
</style>