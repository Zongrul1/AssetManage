import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const manage = r => require.ensure([], () => r(require('@/page/manage')), 'manage');
const login = r => require.ensure([], () => r(require('@/page/login')), 'login');
const home = r => require.ensure([], () => r(require('@/page/home')), 'home');
const stockList = r => require.ensure([], () => r(require('@/page/stockList')), 'stockList');
const cashList = r => require.ensure([], () => r(require('@/page/cashList')), 'cashList');
const coinList = r => require.ensure([], () => r(require('@/page/coinList')), 'coinList');
const wechatList = r => require.ensure([], () => r(require('@/page/wechatList')), 'wechatList');
const alipayList = r => require.ensure([], () => r(require('@/page/alipayList')), 'alipayList');

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
			path: '/wechatList',
			component: wechatList,
			meta: ['数据管理', '微信'],
		},{
			path: '/alipayList',
			component: alipayList,
			meta: ['数据管理', '支付宝'],
		},
		{
			path: '/coinList',
			component: coinList,
			meta: ['数据管理', '数字货币列表'],
		},{
			path: '/cashList',
			component: cashList,
			meta: ['数据管理', '现金列表'],
		}
		]
	}
]

// routes.beforeEach((to,from,next)=>{
// 	if(to.meta.requireAuth){
// 		if(store.state.userId){
// 			next()
// 		}else{
// 			next({path:'/b'})
// 		}
// 	}else{
// 		next()
// 	}
// })

export default new Router({
	routes,
	strict: process.env.NODE_ENV !== 'production',
})



