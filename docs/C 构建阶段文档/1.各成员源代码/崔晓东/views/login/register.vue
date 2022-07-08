<template>
  <div class="registerbody">
    <div class="registerdata" style="marign-top:100px;width:700px;height:400px;">
      <div class="registertext">
				<div style="height:40px;"/>
        <h2 style="color: aliceblue;">攀枝花物流管理系统</h2>
				<div style="height:30px;"/>
      </div>
      <div style="width:400px;margin: 0 auto;">
				<div class="formdata">
				  <el-form ref="form" :model="form" :rules="rules">
				    <el-form-item prop="user_email">
				      <el-input
				        v-model="form.user_email"
				        clearable
				        placeholder="请输入账号"
				      />
				    </el-form-item>
				    <el-form-item prop="password">
				      <el-input
				        v-model="form.password"
				        clearable
				        placeholder="请输入密码"
				        show-password
				      />
				    </el-form-item>
						<el-form-item prop="activation_code">
						  <el-input
						    v-model="form.activation_code"
						    clearable
						    placeholder="请输入激活码"
						  />
						</el-form-item>
				  </el-form>
				</div>
				
			</div>
      <div class="butt">
        <el-button class="shou" @click="JumpToLogin">登录</el-button>
        <el-button type="primary" @click.native.prevent="RegisterUser('form')">注册</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import service from "@/utils/request"
import { Message } from "element-ui";

function Register(value){
	return service({
		url:"/register",
		method:"post",
		header:{
			'Content-Type': 'application/x-www-form-urlencoded',
		},
		data:"user_email="+value.user_email+"&password="+value.password+"&activation_code="+value.activation_code
	})
}

export default {
  name: "register",
  data() {
    return {
      form: {
        password: "",
        user_email: "",
				activation_code:""
      },
      checked: false,
      rules: {
        user_email: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { max: 25, message: "不能大于25个字符", trigger: "blur" },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { max: 25, message: "不能大于25个字符", trigger: "blur" },
        ],
				activation_code: [
				  { required: true, message: "请输入激活码", trigger: "blur" },
				  { max: 25, message: "不能大于25个字符", trigger: "blur" },
				],
      },
    };
  },
  mounted() {
  },
  methods: {
		JumpToLogin(){
			location.href = "/login"
		},
    RegisterUser(form) {

			console.log("register")
      this.$refs[form].validate((valid) => {
        if (valid) {
					var form_content = {
						"user_email":this.form.user_email,
						"password":this.form.password,
						"activation_code":this.form.activation_code
					}
					console.log("format_content",form_content)
          Register(form_content).then((res) => {
						console.log("code:", res)
              if (res === true) {
								console.log("I'm here")
                Message({
                  message: "注册成功",
                  type: "success",
                  showClose: true,
                });
                this.$router.replace("/login");
              } else {
                Message({
                  message: "注册失败-1",
                  type: "error",
                  showClose: true,
                });
              }
            })
            .catch((err) => {
              Message({
                message: "注册失败-2",
                type: "error",
                showClose: true,
              });
            });
        } else {
          return false;
        }
      });
    },
    remember(data){
      this.checked=data
      if(this.checked){
          localStorage.setItem("user_email",JSON.stringify(this.form))
      }else{
        localStorage.removeItem("user_email")
      }
    },
    forgetpas() {
      Message({
        type:"info",
        message:"请联系系统管理员",
        showClose:true
      })
    },
    register() {},
  },
};
</script>

<style scoped>
.el-form{
}	

.registerbody {
  width: 100%;
  height: 100%;
  min-width: 1000px;
  background-image: url("../../assets/register.jpg");
  background-size: 100% 100%;
  background-position: center center;
  overflow: auto;
  background-repeat: no-repeat;
  position: fixed;
  line-height: 100%;
  padding-top: 150px;
}
.el-input{
}
.registertext {
  margin-bottom: 20px;
  line-height: 50px;
  text-align: center;
  font-size: 30px;
  font-weight: bolder;
  color: white;
  text-shadow: 2px 2px 4px #000000;
	
}

.registerdata {
  width: 400px;
  height: 300px;
  transform: translate(-50%);
  margin-left: 50%;
	backdrop-filter: blur(10px);
	margin-top:100px;;
	box-shadow: 0px 1px 1px rgba(0,0,0,0.3),0px 0px 50px #ddd inset;
	border-radius: 10px;;
	
}

.tool {
  display: flex;
  justify-content: space-between;
  color: #606266;
}

.butt {
  margin-top: 10px;
  text-align: center;
}

.shou {
  cursor: pointer;
  color: #606266;
}

/*ui*/
/* /deep/ .el-form-item__label {
  font-weight: bolder;
  font-size: 15px;
  text-align: left;
}

/deep/ .el-button {
  width: 100%;
  margin-bottom: 10px;

} */
</style>
