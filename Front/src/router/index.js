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

export default new Router({
	routes,
	strict: process.env.NODE_ENV !== 'production',
})

// Router.beforeEach((to,from,next) => {//判断该路由是否需要权限
// 	   if(store.state.token){  //判断store是否有登录信息，存储在token字段
// 			 next()
// 	   }else{
// 			 next({
// 				 path:'/login',
// 				 query:{redirect:to.fullPath}  //将该路由path传入login页面，登陆成功后跳转到该页面
// 			  })
// 	   }
// 	}
// )




