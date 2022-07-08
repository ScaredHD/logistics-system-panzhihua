<template>
  <div>
    <h1>登录</h1>
    <form class="form-group">
      <input v-model="username" type="text" placeholder="用户名" required />
      <br />
      <input v-model="password" type="password" placeholder="密码" required />
      <p>
        没有账号?
        <router-link to="/register">注册</router-link>
      </p>
      <p><a href="#" @click="forgetPassword()">忘记密码?</a></p>
      <input type="submit" class="btn btn-primary" @click="doLogin" />
    </form>
  </div>
</template>

<script>
import service from "@/utils/request";

function Login() {
  return service({
    url: "/login",
    method: "post",
  });
}

export default {
  name: "login",
  data() {
    return {
      username: "",
      password: "",
    };
  },

  methods: {
    doLogin() {
      if (this.username === "" || this.password === "") {
        alert("用户名或密码不能为空");
      } else {
        Login().then((res) => {
          console.log(res.code);
          console.log(res.msg);
        });
      }
    },

    forgetPassword() {
      alert("请联系管理员");
    },
  },
};
</script>

<style>
</style>