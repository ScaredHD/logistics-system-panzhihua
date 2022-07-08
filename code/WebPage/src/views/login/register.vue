<template>
  <div>
    <h1>注册</h1>
    <form @submit.prevent="handleSubmit">
      <!-- <label>用户名</label>
        <input type="text" v-model="username" required>

        <label>密码</label>  
        <input type="password" v-model="password" required>             -->
      <input v-model="username" type="text" placeholder="用户名" required />
			<br/>
      <input v-model="password" type="password" placeholder="密码" required />
      <div v-if="passwordError" class="error">{{ passwordError }}</div>

      <div>
        <input type="checkbox" v-model="terms" required />
        <label>请接受用户条款</label>
      </div>
      <p>已有账号? <router-link to="/login">登录</router-link></p>
      <div class="button">
        <button class="submit" type="submit">点此注册</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      password: "",
      terms: false,
      passwordError: "",
    };
  },
  methods: {
    handleSubmit() {
      //Validate password field length
      this.passwordError =
        this.password.length > 6
          ? ""
          : "Password should be more than 6 characters long!";

      if (!this.passwordError) {
        console.log(this.username);
        console.log(this.password);
        console.log(this.terms);
      }
    },
  },
};
</script>

<style>
</style>