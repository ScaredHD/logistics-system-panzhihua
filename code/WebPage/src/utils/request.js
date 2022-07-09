import request from "axios"
import { message } from 'ant-design-vue'
import router from '../router/index'

const token = localStorage.getItem("token")

const service = request.create({
    // baseURL: 'http://162.14.80.178:8082/lsp',
    baseURL: "http://127.0.0.1:8080/",
		timeout: 50000,
    headers: {
        'Authorization': token,
    }
});

service.interceptors.response.use(
    response => {

        const res = response.data;
        console.log(res);
        //判断response状态
        if (res.code != 200) {
            console.log(res.status);
            message.error('请求错误: ' + res.msg)
        }
        return res
    },

    error => {
        message.error(error)
        router.push('/500')
        return Promise.reject(error)
    }
);

export default service