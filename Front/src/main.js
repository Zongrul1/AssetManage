import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store/'
import ElementUI from 'element-ui'
import Axios from 'axios'
import 'element-ui/lib/theme-default/index.css'


Axios.interceptors.request.use( config => {
	// console.log(config)
	config.headers.token = localStorage.getItem("token")
	// 在最后必须 return config
	return config
  })


Axios.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    return response;
  }, function (error) {
    // 对响应错误做点什么
	if(error.response.status){
		switch(error.response.status){
			//未登录,跳转到登录页并携带当前页路径，登录成功后跳转
			case 401:
				router.replace({
						path:'/',
						query:{redirect:router.currentRoute.fullPath}
					})
			//token过期，对用户提示然后清除本地token再跳转
			case 403:
				Toast({
						message:'登陆过期',
						duration:1000,
					})
					localStorage.removeItem('token')
					store.commit('token')
					setTimeout(() => {
						  router.replace({
							  path:'/',
							  query:{redirect:router.currentRoute.fullPath}
						  })
					},1000)
			//请求不存在		
			case 404:
					Toast({
						message:'请求不存在',
						duration:1000,
					})
			break
			
			//其他错误，提示错误
			default:
					Toast({
					message:error.response.data.message,
					duration:1000,
				})
		}
	}
    return Promise.reject(error);
  })


Vue.prototype.$axios = Axios;

Vue.config.productionTip = false;

Vue.use(ElementUI);


new Vue({
	el: '#app',
	router,
	store,
	template: '<App/>',
	components: { App }
})
