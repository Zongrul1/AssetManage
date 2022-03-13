<template>
    <div class="pie1">
        <div id="pie1" class="" style="width: 110%;height:350px;"></div>
    </div>
</template>

<script>
    const axios = require('axios');
    import echarts from 'echarts/lib/echarts';
    // 引入柱状图
    import 'echarts/lib/chart/bar';
    import 'echarts/lib/chart/line';
    import 'echarts/lib/chart/pie';
    import 'echarts/lib/component/title';
    import 'echarts/lib/component/legend';
    import 'echarts/lib/component/toolbox';
    import 'echarts/lib/component/markPoint';
    import 'echarts/lib/component/tooltip';
    export default {
        mounted(){
            this.myChart = echarts.init(document.getElementById('pie1'));
            this.initData();
        },
        props: ['eachList'],
        methods: {
            initData(){
                const option = {
                        title: {
                            text: '财产分布',
                            left: 'center'
                        },
                        tooltip: {
                            trigger: 'item'
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left'
                        },
                        series: [{
                            data: this.eachList,
                            type: 'pie',
                            radius: '70%',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'outside',
                                    formatter: '{b}:{d}%',//模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。{d}数据会根据value值计算百分比

                                textStyle : {                   
                                    align : 'center',
                                    baseline : 'middle',
                                    fontFamily : '微软雅黑',
                                    fontSize : 15,
                                    fontWeight : 'bolder'
                                }
                                },
                            },
                            emphasis: {
                                itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                            }]
        };
                this.myChart.setOption(option);
            }
        },
        watch: {
            eachList: function (){
                this.initData()
            },
        }
    }
</script>

<style lang="less">
	@import '../style/mixin';
    .pie1{
        display: flex;
        justify-content: center;
    }
</style>
