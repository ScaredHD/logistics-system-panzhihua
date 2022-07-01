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
		component: () => import('../views/login/index.vue')
		
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
