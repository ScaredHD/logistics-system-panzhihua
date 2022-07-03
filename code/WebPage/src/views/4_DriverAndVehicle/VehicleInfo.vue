<template>
  <div>
    <a-spin size="large" :spinning="spinning">
      <a-row :gutter="20">
        <a-col :span="8" class="item">
          <a-card hoverable class="add-item" @click="visible = true">
            <a-icon type="plus"/>
            添加车辆
          </a-card>
        </a-col>
        <a-col :span="8" v-for="(item, index) in this.data" :key="index" class="item">
          <a-card hoverable>
            <template slot="actions" class="ant-card-actions">
              <a-tag :color=" item.driving ? 'orange': 'green'">{{ item.driving ? '正在途中' : '正在休息' }}</a-tag>
              <span>使用记录</span>
            </template>
            <a-card-meta
                :title="'车牌号：' + item.number"
                :description="'ID: ' + item.id">
              <a-badge :number-style="{ backgroundColor: '#52c41a' }"
                       slot="avatar"
                       :count="item.type"
                       :offset="[-80,10]">
                <img class="image" :src="require('../../assets/' +item.type+'.svg')" alt=""/>
              </a-badge>
            </a-card-meta>
          </a-card>
        </a-col>
      </a-row>
    </a-spin>
    <a-modal
        title="新增仓库"
        :visible="visible"
        @ok="submit"
        @cancel="visible = false"
    >
      <a-form-model :model="form">
        <a-form-model-item label="车牌号码">
          <a-input v-model="form.number"/>
        </a-form-model-item>
        <a-form-model-item label="车辆类型">
          <a-select v-model="form.type">
            <a-select-option value="小型汽车">小型汽车</a-select-option>
            <a-select-option value="货车">货车</a-select-option>
            <a-select-option value="卡车">卡车</a-select-option>
          </a-select>
        </a-form-model-item>
      </a-form-model>
    </a-modal>
  </div>
</template>

<script>

function FindAllVehicle(){
	var res_text = [
		{
			"id": "01f3976d-0e8b-4ac4-86bf-7a7de6489e65",
			"number": "京A0000",
			"type": "货车",
			"driving": false,
			"createAt": "2022-06-28 10:24:14"
		},
		{
			"id": "1c6c7597-c5f6-4a87-aa88-1b25a1f4120e",
			"number": "京A0001",
			"type": "货车",
			"driving": false,
			"createAt": "2022-06-25 16:54:23"
		},
		{
			"id": "2af71e17-ca63-4b5b-8fce-cbdd495b26dc",
			"number": "京A0002",
			"type": "货车",
			"driving": false,
			"createAt": "2022-06-25 16:54:16"
		},
	]
	return res_text;
}
function saveVehicle(){
	console.log("save successfully")
}
export default {
  name: "WareHouse",
  data() {
    return {
      visible: false,
      spinning: false,
      form: {
        number: '京A0000',
        type: '货车',
        driving: false,
      },
      data: [],
      imgList: [
        require('../../assets/warehouse0.svg'),
        require('../../assets/warehouse1.svg'),
        require('../../assets/warehouse2.svg'),]
    }
  },

  mounted() {
    this.loadData()
  },

  methods: {

    loadData() {
      this.spinning = true
			/***************************************************
			// this is a replace to the request data
			***************************************************/
			this.data = FindAllVehicle();
			setTimeout(() => {
			  this.spinning = false
			}, 600)
      
    },

    submit() {
			/***************************************************
			// this is a replace to the request data
			***************************************************/
			saveVehicle(this.form);
			this.$message.success("添加成功")
			this.visible = false
			this.loadData()
     
    }

  },

}
</script>

<style scoped>
.add-item {
  text-align: center;
  line-height: 120px;
  min-height: 120px;
  border: 1px dashed #91949c;
}

.add-item:hover {
  border: 1px dashed #5a84fd;
  color: #5a84fd;
}

.item {
  margin-bottom: 20px;
}

.image {
  width: 80px;
  height: 80px;
  margin-left: 20px;
}
</style>