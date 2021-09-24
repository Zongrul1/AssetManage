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

router.beforeEach((to, from, next) => {

    if (to.path == '/' || sessionStorage.getItem("token")) {
        // 进入
        next();
    } else {
        next({
            // 跳回主界面、 登录界面
            path:'/',

        });
    }

});

new Vue({
	el: '#app',
	router,
	store,
	template: '<App/>',
	components: { App }
})
