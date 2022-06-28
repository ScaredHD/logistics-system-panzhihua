import Aside from 

<template>
  <el-container>
    <el-aside width="220px">
		<Aside/>
	</el-aside>
    <el-container>
	  <el-header>
		  <Header/>
	  </el-header>
      <el-main>
		  <Main/>
	  </el-main>
      <el-footer>
		  <Footer/>
	  </el-footer>
    </el-container>
  </el-container>
</template>

<script>
	import Aside from "@/views/layout/aside";
	import Header from "@/views/layout/header";
	import Main from "@/views/layout/main";
	import Footer from "@/views/layout/footer";
	
	export default {
	
	  components: {Aside, Header, Main, Footer},
	
	  mounted() {
	
	  }
	
	}
</script>

<style>
	.el-container{
		height: 100%;
	}
	.el-aside{
		height: 100%;
		background-color: antiquewhite;
	}
	.el-main {
	  height: 100%;
	  
	}
	.el-footer{
		display: flex;
		height: 4vh;
		width: 100%;
		align-items: center;
		text-align: center;
		  

	}
</style>