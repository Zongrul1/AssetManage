import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store/'
import ElementUI from 'element-ui'
import Axios from 'axios'
import 'element-ui/lib/theme-default/index.css'

Vue.prototype.$axios = Axios;

Vue.config.productionTip = false;

Vue.use(ElementUI);

// kg： 跨域保存cookie/session
Axios.defaults.withCredentials = true;

router.beforeEach((to, from, next)=>{
    console.log(to.meta);
    if(to.meta.loginRequest){
        console.log('aaaaaaa');
        console.log(sessionStorage.getItem("token"));
        if(sessionStorage.getItem("token")){

            next();
        }else{
            console.log('cccccc');
            next({
                path: '/',
                // query:{redirect: to.fullPath}
            });
        }
    }else{
        console.log('dddddddd');
        next();
    }
});

new Vue({
	el: '#app',
	router,
	store,
	template: '<App/>',
	components: { App }
})
