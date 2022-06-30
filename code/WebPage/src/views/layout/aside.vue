<template>
	<div class="aside_comp">
		<a href="/" class="a-logo">
			<div class="logo">
				<img src="@/assets/logo.svg" alt="">
				物流管理系统
			</div>
		</a>
		<!--<el-menu :default-openeds="['1', '3']">-->
		<el-menu 
		 active-text-color="blue"
		 :default-openeds="[]"
		>
			<el-submenu v-for="(item, index) in menus" :index="index+''">
				<template slot="title">
					<a-icon :type="item.icon" class="icon" />
					<b>{{item.title}}</b>
				</template>
				<el-menu-item-group>
					<el-menu-item v-for="(item2, index2) in item.children" :index="index+'-'+index2">
						{{item2.title}}
					</el-menu-item>
				</el-menu-item-group>
			</el-submenu>
		</el-menu>
	</div>
</template>

<script>

export default {

  data() {
    return {
      menus: [
        {
          title: '基础信息管理',
          icon: 'home',
          children: [
            {title: '人员信息管理', path: '/'},
            {title: '公司信息管理', path: '/'},
            {title: '货物信息管理', path: '/'},
            {title: '仓库信息管理', path: '/'},
          ]
        },
        {
          title: '订单信息管理',
          icon: 'pay-circle',
          children: [
            {title: '新增订单', path: '/'},
            {title: '订单记录', path: '/'},
          ]
        },
        {
          title: '配送信息管理',
          icon: 'car',
          children: [
            {title: '新增配送', path: '/'},
            {title: '配送列表', path: '/'},
          ]
        },
        {
          title: '运输信息管理',
          icon: 'rocket',
          children: [
            {title: '车辆资料', path: '/'},
            {title: '驾驶员资料', path: '/'},
          ]
        },
        {
          title: '数据分析管理',
          icon: 'line-chart',
          children: [
          ]
        }
      ]
    }
  },

}

</script>

<style scoped>
	.a-logo{
		text-decoration: none;
		
	}
	.logo{
		padding: 10px 15px;
		height: 50px;
		font-size: 15px;
		margin: 16px;
		color: green; /*the color of the logo font*/
		letter-spacing: 2px;
	}
	.logo img {
	  width: 32px;
	  height: 32px;
	  margin-right: 5px;
	}
	.icon{
		margin-right: 10px;;
	}
	.el-menu{
		background-color: antiquewhite;
	}
	.el-submenu{
		background-color: antiquewhite;
	}
	.el-menu-item-group{
		background-color: antiquewhite;
	}
	.el-menu-item{
		background-color: antiquewhite;
	}
</style>