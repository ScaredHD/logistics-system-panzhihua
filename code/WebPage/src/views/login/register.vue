<template>
  <div>
    <h1>注册</h1>
    <form @submit.prevent="handleSubmit">
      <input v-model="username" type="text" placeholder="用户名" required />
      <br />
      <input v-model="password" type="password" placeholder="密码" required />
      <div v-if="passwordError" class="error">{{ passwordError }}</div>

      <div>
        <input type="checkbox" v-model="terms" required />
        <label>请接受用户条款</label>
      </div>
      <p>已有账号? <router-link to="/login">登录</router-link></p>
      <div>
        <input v-model="captcha" type="text" placeholder="验证码" required />
        <div>验证码图片</div>
      </div>
      <div class="button">
        <button class="submit" type="submit">点此注册</button>
      </div>
    </form>
  </div>
</template>

<script>
import service from "@/utils/request";

function Register() {
  return service({
    url: "/register",
    method: "post",
  });
}

export default {
  data() {
    return {
      username: "",
      password: "",
      terms: false,
      passwordError: "",
      captcha: "",
    };
  },
  methods: {
    handleSubmit() {
      this.passwordError =
        this.password.length > 6 ? "" : "密码长度至少为 6 个字符";

      if (!this.passwordError) {
        alert(this.passwordError);
      } else if (!captcha) {
        alert("请输入验证码");
        return;
      }

    },
  },
};
</script>

<style>
</style>