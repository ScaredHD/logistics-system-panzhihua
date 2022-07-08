<template>
	<div class="content">
		<div id="lineChart"></div>
	</div>
</template>


<script>
	export default{
		data(){
			return {
				echarts: require('echarts'),
			}
		},
		mounted(){
			this.drawLineChart('lineChart')
		},
		methods: {
			drawLineChart(id){
				const setEchartWH = { //设置控制图表大小变量
				        width: 800,
				        height: 600
				    };
				this.echarts.init(document.getElementById(id)).dispose(); //初始化echarts之前先手动销毁之前的echarts图，防止显示错乱
				let lineChart = this.echarts.init(document.getElementById(id),null,setEchartWH); //初始化echarts
				// 添加配置项
				
				lineChart.setOption(
					{
					grid:{
						bottom: 50,
						top: 50,
						right: 0,
						left: 0,
						height: 500,
					},
					xAxis: {
						type: 'category',
						data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
					},
					yAxis: {
						type: 'value'
					},
					series: [
						{
							data: [150, 230, 224, 218, 135, 147, 260],
							type: 'line'
						}
					]
				});
			}
		}
	}
</script>


<style scoped>
    .lineChart{
        width:800px;
        height:800px
}
</style>