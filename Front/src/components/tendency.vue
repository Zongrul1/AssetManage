<template>
    <div class="line1">
        <div id="line1" class="" style="width: 90%;height:350px;"></div>
    </div>
</template>

<script>
    const axios = require('axios');
    import echarts from 'echarts/lib/echarts';
    // 引入柱状图
    import 'echarts/lib/chart/bar';
    import 'echarts/lib/chart/line';
    import 'echarts/lib/component/title';
    import 'echarts/lib/component/legend';
    import 'echarts/lib/component/toolbox';
    import 'echarts/lib/component/markPoint';
    import 'echarts/lib/component/tooltip';

    export default {
        mounted(){
            this.myChart = echarts.init(document.getElementById('line1'));
            this.initData();
        },
        props: ['value','date'],
        methods: {
            initData(){
                const colors = ['#5793f3'];
                const option = {
                    title: {
                        text: '财产趋势',
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    xAxis: {
                        type: 'category',
                        data: this.date,
                        boundaryGap: false,
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: this.value,
                        type: 'line',
                        areaStyle: {},
                        }]
        };
                this.myChart.setOption(option);
            }
        },
        watch: {
            value: function (){
                this.initData()
            },
            date: function (){
                this.initData()
            }
        }
    }
</script>

<style lang="less">
	@import '../style/mixin';
    .line1{
        display: flex;
        justify-content: center;
    }
</style>
