import Vue from 'vue'
import App from './App.vue'
import router from "./router"
import Antd from 'ant-design-vue'
import ElementUI from 'element-ui'
import echarts from 'echarts'
import 'element-ui/lib/theme-chalk/index.css'
import 'ant-design-vue/dist/antd.css'
Vue.config.productionTip = false
Vue.prototype.$echarts = echarts
Vue.use(ElementUI);
Vue.use(Antd);

Vue.prototype.$antdconfirm = Vue.prototype.$confirm

new Vue({
	router,
	render: h => h(App),
  
}).$mount('#app')
