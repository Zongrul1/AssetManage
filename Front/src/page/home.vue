<template>
    <div>
		<section class="data_section">
			<header class="section_title">数据统计</header>
			<el-row :gutter="20" style="margin-bottom: 10px;">
                <el-col :span="4"><div class="data_list today_head"><span class="data_num head">总财产</span></div></el-col>
				<el-col :span="4"><div class="data_list"><span class="data_num" id="value"></span></div></el-col>
				<el-col :span="4"><div></div></el-col>
			</el-row>
            <el-row :gutter="20">
                <el-col :span="4"><div class="data_list all_head"><span class="data_num head">日期</span></div></el-col>
                <el-col :span="4"><div class="data_list"><span class="data_num" id="date"></span></div></el-col>
            </el-row>
		</section>
		<tendency :value='value' :date='date'></tendency>
    </div>
</template>

<script>
    const axios = require('axios');
	import tendency from '../components/tendency'
    export default {
	data() {
		return {
			value: [
			],
			date:[
			],
		}
    },
	components: {
    		tendency,
    	},
	created () {
		axios.get('http://localhost:10088/total/get-all')
		.then((response) => {
			var res = response.data.data;
			res.forEach(res => {
				this.value.push(res.value)
				this.date.push(res.date)
			});
			document.getElementById("value").innerHTML=response.data.data[response.data.data.length - 1].value;
			document.getElementById("date").innerHTML=response.data.data[response.data.data.length - 1].date;
		})
		.catch((error) => {
			console.log(error);
		});
	},
	mounted(){

    },
	computed: {

	},
	methods: {

	}
    }
</script>

<style lang="less">
	@import '../style/mixin';
	.data_section{
		padding: 20px;
		margin-bottom: 40px;
		.section_title{
			text-align: center;
			font-size: 30px;
			margin-bottom: 10px;
		}
		.data_list{
			text-align: center;
			font-size: 14px;
			color: #666;
            border-radius: 6px;
            background: #E5E9F2;
            .data_num{
                color: #333;
                font-size: 26px;

            }
            .head{
                border-radius: 6px;
                font-size: 22px;
                padding: 4px 0;
                color: #fff;
                display: inline-block;
            }
        }
        .today_head{
            background: #FF9800;
        }
        .all_head{
            background: #20A0FF;
        }
	}
    .wan{
        .sc(16px, #333)
    }
</style>
