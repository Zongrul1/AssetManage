import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const manage = r => require.ensure([], () => r(require('@/page/manage')), 'manage');
const login = r => require.ensure([], () => r(require('@/page/login')), 'login');
const home = r => require.ensure([], () => r(require('@/page/home')), 'home');
const stockList = r => require.ensure([], () => r(require('@/page/stockList')), 'stockList');
const fundList = r => require.ensure([], () => r(require('@/page/fundList')), 'fundList');
const coinList = r => require.ensure([], () => r(require('@/page/coinList')), 'coinList');
const cashList = r => require.ensure([], () => r(require('@/page/cashList')), 'cashList');

const routes = [
	{
		path: '/',
		component: login
	},
	{
		path: '/manage',
		component: manage,
		name: '',
		children: [{
			path: '/manage',
			component: home,
			meta: [],
		},{
			path: '/stockList',
			component: stockList,
			meta: ['数据管理', '股票列表'],
		},{
			path: '/fundList',
			component: fundList,
			meta: ['数据管理', '基金列表'],
		},{
			path: '/coinList',
			component: coinList,
			meta: ['数据管理', '数字货币列表'],
		},{
			path: '/cashList',
			component: cashList,
			meta: ['数据管理', '现金列表'],
		},
		]
	}
]

export default new Router({
	routes,
	strict: process.env.NODE_ENV !== 'production',
})
