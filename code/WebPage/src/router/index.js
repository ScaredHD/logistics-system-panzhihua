import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/views/layout/index'
Vue.use(VueRouter)

const routes = [
	{
		path: "/home",
		component: ()=>import("@/views/home/")
	},{
		path: "/about",
		component: ()=>import("@/views/about/AboutUs.vue")
	},
    {
        path: '/',
        component: Layout,
        children: [
            {
                path: "",
                redirect: "/goods",
            },{
                path: 'goods',
                component: () => import('@/views/1_BasicInfoManage/goods_management.vue'),
            },{
                path: 'company',
                component: () => import('@/views/1_BasicInfoManage/company_management.vue'),
            },{
                path: 'employee',
                component: () => import('@/views/1_BasicInfoManage/employee_management.vue'),
            },{
                path: 'warehouse',
                component: () => import('@/views/1_BasicInfoManage/warehouse_management.vue'),
            },{
                path: 'warehouse/:id',
                component: () => import('@/views/1_BasicInfoManage/warehouse_details.vue'),
            },{
                path: 'driver',
                component: () => import('@/views/4_DriverAndVehicle/DriverInfo.vue'),
            },{
                path: 'vehicle',
                component: () => import('@/views/4_DriverAndVehicle/VehicleInfo.vue'),
            },{
                path: 'order/record',
                component: () => import('@/views/2_OrderInfoManage/Order_record.vue'),
            },{
                path: 'order/create',
                component: () => import('@/views/2_OrderInfoManage/Order_add.vue'),
            },{
                path: 'delivery/create',
                component: () => import('@/views/3_DeliverInfoManage/Delivery_add.vue'),
            },{
                path: 'delivery/list',
                component: () => import('@/views/3_DeliverInfoManage/Delivery_list.vue'),
            },{
                path: 'security',
                component: () => import('@/views/temp/index'),
            },{
                path: 'admin',
                component: () => import('@/views/temp/index'),
            },{
                path: 'role',
                component: () => import('@/views/temp/index'),
            },{
                path: '403',
                component: () => import('@/views/error/403'),
            },{
                path: '404',
                component: () => import('@/views/error/404'),
            },{
                path: '500',
                component: () => import('@/views/error/500'),
            },

        ]
    },{
        path: '/login',
        name: 'Login',
        component: () => import('@/views/login/login.vue'),
        meta: {auth: false}
    },{
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
//router.beforeEach((to, from, next) => {})

export default router
