
import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/views/layout/index'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(VueRouter);
Vue.use(ElementUI);

//各页面路由配置
const routes = [
	{
		path: '/home',
		name: 'home',//登录页面
		component: () => import('../views/home/index.vue')
	},
	{
		path: '/',
		name: 'index',
		component: Layout,
		children: [
			{
				path: '/',
				name: 'index_1',
				component: ()=> import("../views/home")
			},
			{
				path: '/goods',
				name: 'goods',
				component: () => import("../views/1_BasicInfoManage/goods_management.vue")
			},
			{
				path: '/company',
				name: 'company',
				component: ()=> import("../views/1_BasicInfoManage/company_management.vue")
			},
			{
				path: '/employee',
				name: 'employee',
				component: ()=> import("../views/1_BasicInfoManage/employee_management.vue")
			},
			{
				path: '/warehouse',
				name: 'warehouse',
				component: ()=> import("../views/1_BasicInfoManage/warehouse_management.vue")
			},
			{
				path: '/order/create',
				name: 'create_goods_info',
				component: ()=> import("../views/2_OrderInfoManage/Order_add.vue")
			},
			{
				path: '/order/record',
				name: 'view_goods_info',
				component: ()=> import("../views/2_OrderInfoManage/Order_record.vue")
			},
			{
				path: '/delivery/create',
				name: 'create_delivery_info',
				component: ()=> import("../views/3_DeliverInfoManage/Delivery_add.vue")
			},
			{
				path: '/delivery/record',
				name: 'view_delivery_info',
				component: ()=> import("../views/3_DeliverInfoManage/Delivery_list.vue")
			},
			{
				path: '/driver',
				name: 'driver',
				component: ()=> import("../views/4_DriverAndVerhicle/DriverInfo.vue")
			},
			{
				path: '/vehicle',
				name: 'vehicle',
				component: ()=> import("../views/4_DriverAndVerhicle/VehicleInfo.vue")
			},
			{
				path: "/statistic",
				name: "statistic",
				component: ()=> import("../views/5_DataStatistics/index.vue")
			},
			{
				path: '/404',
				name: '404',
				component: () => import('../views/error/404.vue')
			},
			{
				path: '/403',
				name: '403',
				component: () => import('../views/error/403.vue')
			},
			{
				path: '/500',
				name: '500',
				component: ()=> import('../views/error/500.vue')
			},
		]
	}
	,
	{
		path: '/login',
		name: 'login',
		component: () => import('../views/login/login.vue')
		
	},{
		path: "/register",
		name: "register",
		component: () => import("../views/login/register.vue")
	},{
		path: "/about",
		name: 'about',
		component: () => import("../views/about/AboutUs.vue")
	},
	{
		path: '*',
		name: 'redirect_404',
		redirect: '/404'
	}

];

const router = new VueRouter({
	mode: 'history',
	routes
});

export default router;
