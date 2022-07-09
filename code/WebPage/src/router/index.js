import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/views/layout/index'
Vue.use(VueRouter)

const routes = [
	{
		path: "/home",
		component: ()=>import("@/views/home/"),
		meta: {title:"攀枝花物流管理系统"}
	},{
		path: "/about",
		component: ()=>import("@/views/about/AboutUs.vue"),
		meta: {title:"攀枝花物流管理系统"}
	},{
        path: '/',
        component: Layout,
        children: [
            {
                path: "",
                redirect: "/goods",
            },{
                path: 'goods',
                component: () => import('@/views/1_BasicInfoManage/goods_management.vue'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: 'company',
                component: () => import('@/views/1_BasicInfoManage/company_management.vue'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: 'employee',
                component: () => import('@/views/1_BasicInfoManage/employee_management.vue'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: 'warehouse',
                component: () => import('@/views/1_BasicInfoManage/warehouse_management.vue'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: 'warehouse/:id',
                component: () => import('@/views/1_BasicInfoManage/warehouse_details.vue'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: 'driver',
                component: () => import('@/views/4_DriverAndVehicle/DriverInfo.vue'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: 'vehicle',
                component: () => import('@/views/4_DriverAndVehicle/VehicleInfo.vue'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: 'order/record',
                component: () => import('@/views/2_OrderInfoManage/Order_record.vue'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: 'order/create',
                component: () => import('@/views/2_OrderInfoManage/Order_add.vue'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: 'delivery/create',
                component: () => import('@/views/3_DeliverInfoManage/Delivery_add.vue'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: 'delivery/record',
                component: () => import('@/views/3_DeliverInfoManage/Delivery_list.vue'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
							path: "statistic",
								component: ()=> import("@/views/5_DataStatistics"),
								meta: {auth: true,title:"攀枝花物流管理系统"},
						},{
                path: '403',
                component: () => import('@/views/error/403'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: '404',
                component: () => import('@/views/error/404'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },{
                path: '500',
                component: () => import('@/views/error/500'),
								meta: {auth: true,title:"攀枝花物流管理系统"},
            },

        ]
    },{
        path: '/login',
        name: 'Login',
        component: () => import('@/views/login/login.vue'),
        meta: {auth: false, title:"攀枝花物流管理系统"}
    },{
				path: "/register",
				name:"register",
				component: ()=> import("@/views/login/register.vue"),
				meta: {auth: false, title:"攀枝花物流管理系统"}
		},
		{
        path: "*",
        redirect: '/404'
    }

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

//路由卫士
router.beforeEach((to, from, next) => {
	var store = localStorage.getItem("user_email")
	to.meta.auth && !store ? next("/home") : next()
	document.title = to.meta.title
})

export default router
