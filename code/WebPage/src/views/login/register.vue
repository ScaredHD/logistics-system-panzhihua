<template>
<div>
	<h1>Sign up</h1>
    <form @submit.prevent="handleSubmit">
        <label>Email :</label>
        <input type="email" v-model="email" required>

        <label>Password :</label>  
        <input type="password" v-model="password" required>            
        <div v-if="passwordError" class="error">{{ passwordError }} </div>

        <div>
            <input type="checkbox" v-model="terms" required>
            <label>Please accept terms and conditions</label>
        </div>
				<p>已有账号? <router-link to="/login">登录</router-link></p>
        <div class="button">
            <button class="submit" type="submit">Sign up here</button>
        </div>
    </form>
</div>

</template>

<script>
export default{

    data() {
        return {
            email: '',
            password: '',
            terms: false,
            passwordError: ''
        }
    },
    methods: {
        handleSubmit() {
            //Validate password field length
            this.passwordError = this.password.length > 6 ? 
            '' : 'Password should be more than 6 characters long!';

            if(!this.passwordError) {
                console.log(this.email);
                console.log(this.password);
                console.log(this.terms);

            }
        }
    }
    
}
</script>

<style>
</style>