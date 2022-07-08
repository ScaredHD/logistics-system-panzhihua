<template>
	<div id="content">
		<div class="transp_bg"></div>
		<a name="home"/>
		<div style="background-color: white;">
			<div class="main">
				<div class="NavBar">
					<el-row>
					    <el-col :span="6">
							<div class="" style="line-height: 60px;margin:0;font-size: 35px;text-align: center">
								<b>攀枝花物流管理系统</b>
							</div>
						</el-col>
						<el-col :span="12">
							<div class="locate_down">
								<a  href="#home">
									<img src="../../assets/down.svg"/>
								</a>
							</div>
						</el-col>
						<el-col :span="6">
							<div class="">
								<el-col :span="12" class="contact_us">
									<div>
										<a class="contact_us_a" href="/about">
											<div class="contact_us_div" style=";">
												<span>联系我们</span>
											</div>
										</a>
									</div>
								</el-col>
								<el-col :span="5" class="login_icon_font">
									<img class="login_icon" src="../../assets/login.svg"/>
									<router-link to="/login"><span>登录</span></router-link>
									<!-- <a href="/login"><span>登录</span></a> -->
								</el-col>
								<el-col :span="5" class="register_icon_font">
									<img class="register_icon" src="../../assets/register.svg"/>
									<router-link to="/register"><span>注册</span></router-link>
								</el-col>
								<el-col :span="1"></el-col>
							</div>
						</el-col>
					  </el-row>
				</div>
				<hr/>
				<div class="main_content">
					<div style="height: 30px;"/>
					<!--<div class="headline">
						<el-row>
							<el-col :span="2">
								<div style="height: 100%;;">
									<img style="height: 100%;;" src="../../assets/headline_icon.svg"/>
								</div>
							</el-col>
							<el-col :span="16">
								<div style="font-family: HeiTi;font-size:23px;padding:20px;">
									<span><b>中国航天科工党组要求：深入学习贯彻习近平总书记关于加强和改进人民信访工作的重要指示批示精神，认真将《信访工作条例》落到实处</b></span>
								</div>
							</el-col>
							<el-col :span="6">
								<img style="margin-top:5px;" src="../../assets/18149442.jpg"/>
							</el-col>
						</el-row>
					</div>-->
					<!--<div style="width:100%;height:100px;">
						
					</div>-->
					<div style="height: 30px;"/>
					<!--<div style="font-size: 30px;;"><b>新闻头条</b></div>-->
					<div style="height: 30px;"/>
					<div class="content_main" style="height: 500px;;">
						<div class="news" style="height: 100%;">
							<el-row>
								<el-col :span="12">
									<!--轮播图-->
									<div class="lunbo" style="width:100%;height: 200px;border: 1p solid red;">
										<img style="width: 100%;;" src="../../assets/news_lun1.jpg"/>
									</div>
								</el-col>
								<el-col :span="12">
									<!--<div class="news_content">
										<ul>
											<li>走进县城看发展#【直播！#看见锦绣山河#[心]】</li>
											<li>香港特区成立25周年#【一组图看#大湾区珠江口跨海跨江通道群有多美#】</li>
											<li>618美妆服饰投诉量上涨近四成# 【#2022年618消费投诉数据报告#】</li>
											<li>政策加码与回暖 | 2022六月物流资产投资运营发展报告</li>
											<li>启示录：这届618，物流供应链发展的拐点？</li>
											<li>【男子称#入职德邦管培生被强制转岗快递员#：曾安排其他岗位 但并不满意】</li>
											<li>【市五届人大常委会第三次会议召开联组会议】#鄂尔多斯要闻#</li>
											<li>【诸暨定向发放消费券！“爱心礼包”，免费领！】</li>
											<li>#义乌政务# 【开工！义乌国际冷鲜城一区项目正式启动】</li>
											<li>#交通快讯#【交通运输部将全面排查交通物流各领域各环节收费情况】</li>
											<li>索尼INZONE电竞新开局# #索尼INZONE</li>
											<li>【#网络主播范思峰偷逃税被罚649.5万#】</li>
											<li>【#机票燃油附加费创历史新高#】</li>
											<li>#任天堂表示中国游戏机市场不大#【#任天堂与腾讯将联手推广游戏机#】</li>
										</ul>
									</div>-->
									<div style=""></div>
								</el-col>
							</el-row>
						</div>
						<div style="height: 30px;"/>
						<div style="font-size: 30px;;"><b>合作单位</b></div>
						<div style="height: 10px;"/>
						<div style="font-size: 20px;opacity:0.5;">50000家企业的选择</div>
						<div style="height: 30px;"/>
						<div>
							<el-row>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/362837752_1536510839.png"/>
								</el-col>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/-195154080_-1248383600.png"/>
								</el-col>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/388145178_-121875720.png"/>
								</el-col>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/-460311082_1205060527.png"/>
								</el-col>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/1365964286_-1431097033.png"/>
								</el-col>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/974612592_1204698864.png"/>
								</el-col>
							</el-row>
							<div style="height: 40px;"/>
							<el-row>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/1477047179_2128312708.png"/>
								</el-col>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/-1593712999_-493914635.png"/>
								</el-col>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/1606622043_-1607572915.png"/>
								</el-col>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/876123973_-2129350026.png"/>
								</el-col>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/-952425534_-1294524704.png"/>
								</el-col>
								<el-col :span="4">
									<img style="height:150px;" src="https://jmy-pic.baidu.com/0/pic/-723577130_876031784.png"/>
								</el-col>
							</el-row>
						</div>
						<div style="height:60px;"/>
						<div style="height:50px;line-height:50px;">
							<span class="text-ellipsis">&nbsp;2022 Copyright&nbsp;攀枝花物流管理系统 All Right Received 版权所有
							    <a href="http://beian.miit.gov.cn">蜀ICP备2021027452号 查看备案</a>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script> 
</script>

<style>
	body{
		/* background: url("../../assets/bg_image.jpg"); */
		background-repeat: no-repeat;
		background-attachment: fixed;
	}
	.transp_bg{
		opacity: 1;
		width: 100%;;
		height:820px;
	}
	.main{
		margin: 0 auto;
		width: 80%;
		height: 1410px;
		background-color: white;
	}
	.NavBar{
		width:100%;
		height: 60px;
	}
	.el-row:nth-child(1){
		width: 100%;
		height: 100%;;
	}
	.el-col, .el-col>div{
		height: 100%;
	}
	.login_icon, .register_icon{
		width: 25px;;
		height: 25px;
		margin-right: 10px;;
		margin-bottom: -5px;
		
	}
	.contact_us_a{
		text-decoration: none;
		color: black;
	}
	.login_icon_font, .register_icon_font{
		line-height: 60px;;
		font-size: 20px;;
	}
	.login_icon_font a, .register_icon_font a{
		text-decoration: none;
		color: black;
	}
	.login_icon_font a:hover, .register_icon_font a:hover{
		color: red;
		
	}
	.contact_us_div{
		text-align: center;
		line-height: 60px;
		font-size: 20px;
	}
	.contact_us_div:hover{
		color: red;
		cursor: -webkit-grab;
	}
	.locate_down{
		height: 100%;;
		
	}
	.locate_down img{
		height: 60%;
		/*border: 1px solid red;*/
		margin-top: 15px;;
		margin-left: 50%;
	}
	.locate_down img:hover{
		cursor: -webkit-grab;
		content:url("../../assets/down_red.svg")
	}
	.main_content{
		margin: 0 auto;
		height: 800px;;
	}
	.headline{
		height: 100px;;
	}
	.news_content ul{
		margin-left: 20px;;
		margin-top: 0px;;
	}
	.news_content li{
		list-style: none;
		font-size: 18px;;
		word-spacing: 1em;
		line-height: 2em;;
	}
	.text-ellipsis{
		text-align: center;
		display: block;
		width:100%;
		
	}
</style>