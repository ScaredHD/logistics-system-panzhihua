<template>
  <div class="header">
    <el-row>
      <el-col :span="4">
			<el-button type="primary" @click="clickReload" icon="reload" style="margin:10px;">
				<!--<img style="height:20px;" src="../../assets/reload.svg">-->
				<span>刷新页面</span>
				</el-button>
	  </el-col>
      <el-col :span="4">
		  
	  </el-col>
      <el-col :span="8">
        <div style="height: 100%">
          <div style="height: 60px; width: 70px; float: left; margin-right: 20px">
            <!-- <img style="height: 100%; width: 100%; border-radius: 50%" src="../../assets/haimian.jpeg" /> -->
            <!-- <img class="header_img" style="height: 100%; width: 100%; border-radius: 50%" src="http://5b0988e595225.cdn.sohucs.com/images/20180101/9011b767d8344a658040619d6d2b4110.jpeg" /> -->
          </div>
          <div style="flex: right; padding: 20px; font-size: 20px; font-family: Heiti">
            <!-- <span>今天的不开心就到此为止吧， 明天依旧光芒万丈</span> -->
            <!-- <span>骐骥一跃，不能十步，驽马十驾， 功在不舍。</span> -->
			<span>欢迎来到攀枝花物流管理系统&nbsp;&nbsp;······</span>
          </div>
        </div>
      </el-col>
      <el-col :span="4"></el-col>
      <el-col :span="4" style="">
		  <el-menu
		     class="el-menu-vertical-demo api-menu"
		     router
			 mode="horizontal"
		     active-text-color="#409eff">
		     <el-submenu index="1">
		       <template slot="title">
					<img style="width:40px;height:40px;margin-right:10px;" src="https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png"/>
					<span class="bold-font">{{details}}</span>
		       </template>
		       <el-menu-item index="/security">
		           <span class="bold-font">个人中心</span>
		       </el-menu-item>
		       <el-menu-item index="/role">
		           <span class="bold-font">权限设置</span>
		       </el-menu-item>
			   <template style="opacity: 0.1;"><hr/></template>
			   <el-menu-item @click="handleLogout">
				   <a-icon style="margin-right: 10px;;" class="icon" type="logout"/>
			       <span class="bold-font">退出登录</span>
			   </el-menu-item>
		     </el-submenu>
		   </el-menu>
	  </el-col>
    </el-row>
  </div>
</template>

<script>
	export default {
	  data() {
	    return {
			details: "demo@qq.com"
	      /*details: this.$store.state.user.details ? this.$store.state.user.details : {}*/
	    }
	  },
	
	  methods: {
	    clickReload() {
		  //this.$router.go(val) => 在history记录中前进或者后退val步，当val为0时刷新当前页面。
		  this.$router.go(0)
	    },
	
	    handleLogout() {
		  //this.$router.push('/login');
		  //return;
	      let that = this;
	      this.$antdconfirm({
	        title: '你确定要注销你的登录信息吗?',
	        content: '点击确定将删除你在网站保留的登录信息！',
	        onOk() {
	          that.$router.push('/login')
			  that.$store.commit('user/userLogout');
	        },
			onabort(){
				this.$router.go(0);
			}
	      });
	    }
	
	  }
	
	}
</script>

<style>
.header {
  height: 100%;
}
.el-row:nth-child(1) {
  height: 100%;
}
.el-col {
  height: 100%;
}
.header_img:hover{
	transform:scale(1.);
}
</style>
