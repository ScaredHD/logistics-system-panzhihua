<template>
  <div class="main">
    <div class="header">
      <router-link to="/warehouse">
        <a-icon type="arrow-left" style="padding-right: 5px"/>
        返回上一页
      </router-link>
    </div>
    <div style="display: flex">
      <a-button class="editable-btn" @click="handleSubmit('in')">
        入库商品
      </a-button>
      <a-button class="editable-btn" @click="handleSubmit('out')">
        出库商品
      </a-button>
      
    </div>

    <a-table :loading="loading" :columns="columns" :data-source="data" rowKey="id">
      <a slot="name" slot-scope="text">{{ text }}</a>
      <span slot="customTitle"><a-icon type="smile-o"/> 商品名</span>
      <span slot="record_count" slot-scope="record_count">
        <a-tag color="#108ee9">{{ record_count }}</a-tag>
      </span>
    </a-table>

    <a-modal
        title="入库 ｜ 出库"
        :closable="false"
        :visible="visible"
        @ok="submit"
        @cancel="visible = false"
    >
      <a-form-model :model="form">
        <a-form-model-item label="请选商品">
          <a-select v-model="form.ir_goods_id" placeholder="请选择入库的商品">
            <a-select-option :value="item.goods_id" v-for="(item, index) in commodityList" :key="index">
              {{ item.goods_name }}
            </a-select-option>
          </a-select>
        </a-form-model-item>
        <a-form-model-item label="商品数量">
          <a-input-number id="inputNumber" v-model="form.record_count" :min="1"/>
        </a-form-model-item>
        <a-form-model-item label="备注">
          <a-input :rows="4" v-model="form.record_comments" type="textarea"/>
        </a-form-model-item>
      </a-form-model>
    </a-modal>

    <a-modal
        title="出入库记录"
        width="80%"
        :visible="recordVisible"
        :footer="null"
        @cancel="recordVisible = false"
    >
      <InventoryRecords :warehouse-id="id"/>
    </a-modal>

  </div>
</template>

<script>

import service from "@/utils/request"
function FindAllCommodity(){
	return service({
		url:"/goodss",
		method:"get"
	})
}
function FindAllInventory(){
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
	var temp_list = window.location.href.split("/")
	return service({
		url:"/inventoryRecords/",
		method:"post",
		data:value
	})
}
function InventoryRecords(){
	return service({
		url:"/inventoryRecords",
		method:"get"
	})
}

const columns = [
  {
    title: '商品ID',
    dataIndex: 'id',
    key: 'id',
    width: '50%'
  },
  {
    dataIndex: 'name',
    key: 'name',
    slots: {title: 'customTitle'},
    scopedSlots: {customRender: 'name'},
  },
  {
    title: '库存数量',
    dataIndex: 'record_count',
    key: 'record_count',
    scopedSlots: {customRender: 'record_count'},
  },
];

export default {

  components: {InventoryRecords},

  data() {
    return {
      json_fields: {
        "商品ID": "ir_goods_id",
        "商品名称": "name",
        "库存盘点数量": "record_count",
      },
      id: this.$route.params.id,
      loading: false,
      visible: false,
      recordVisible: false,
      selectIndex: 0,
      commodityVisible: false,
      data: [],
      columns,
      commodityList: [],
      submitType: '',
      form: {
        ir_warehouse_id: this.$route.params.id,
        ir_goods_id: '',
        name: '',
        record_comments: '',
        record_count: 50,
      },
    }
  },

  mounted() {
    this.loadData()
    FindAllCommodity().then((res) => {
      if (res.code==200) 
			this.commodityList = res.data
    })
  },

  methods: {

    loadData() {
      this.loading = true
      FindAllInventory(this.$route.params.id).then((res) => {
        setTimeout(() => {
          this.data = res.data
          this.loading = false
        }, 500)
      })
    },

    handleSubmit(type) {
      this.submitType = type
      this.visible = true
    },

    submit() {
			console.log()
      this.form.ir_goods_id = this.commodityList[this.selectIndex].goods_id
      //this.form.name = this.commodityList[this.selectIndex].goods_name
      InAndOut(this.submitType, this.form).then((res) => {
        if (res.code==200) this.$message.success("操作成功")
        this.visible = false
        this.loadData()
      })
    },

  }

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