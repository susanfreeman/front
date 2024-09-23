<template>
  <div class="login-info">
    <p class="title">
      HELLO!
      <br/>
      欢迎使用orbiterwallet
    </p>
    <p class="title2">使用邮箱登录</p>

    <el-form :model="loginForm" ref="loginForm">
      <el-form-item
        prop="username"
        label=""
        :rules="[
          { required: true, message: '请输入邮箱地址', trigger: 'blur' },
          {
            type: 'email',
            message: '请输入正确的邮箱地址',
            trigger: ['blur', 'change']
          }
        ]"
      >
        <el-input
          v-model="loginForm.username"
          placeholder="请输入邮箱地址"
        ></el-input>
      </el-form-item>

      <el-form-item
        label=""
        prop="password"
        :rules="[{ required: true, message: '请输入密码', trigger: 'blur' }]"
      >
        <el-input
          type="password"
          v-model="loginForm.password"
          autocomplete="on"
          placeholder="请输入密码"
          show-password
        ></el-input>
      </el-form-item>
      <el-form-item prop="code" v-if="captchaEnabled">
        <el-input
          v-model="loginForm.code"
          auto-complete="off"
          placeholder="验证码"
          style="width: 63%"
          @keyup.enter.native="handleLogin"
        >
          <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon"/>
        </el-input>
        <div class="login-code">
          <img :src="codeUrl" @click="getCode" class="login-code-img"/>
        </div>
      </el-form-item>
    </el-form>

    <div class="button-area">
      <el-button type="text" @click="goToAgreement">注册</el-button>

      <el-button type="text" @click="goToForgot">忘记密码</el-button>
    </div>
    <div class="login-button">
      <el-button type="primary" style="width: 100%" @click="handleSecond">登录</el-button>
    </div>
  </div>
</template>

<script>
import {getCodeImg} from "@/api/login";
import Cookies from "js-cookie";
import {encrypt} from "@/utils/jsencrypt";

export default {
  data() {
    return {
      codeUrl: "",
      loginForm: {
        username: '',
        password: '',
        code: "",
        uuid: ""
      },
      // 验证码开关
      captchaEnabled: true
    }
  },
  created() {
    this.getCode();
  },
  methods: {
    getCode() {
      getCodeImg().then(res => {
        this.captchaEnabled = res.captchaEnabled === undefined ? true : res.captchaEnabled;
        if (this.captchaEnabled) {
          this.codeUrl = "data:image/gif;base64," + res.img;
          this.loginForm.uuid = res.uuid;
        }
      });
    },
    //注册
    goToAgreement() {
      this.$router.push("agreement")
    },

    goToForgot() {
      this.$router.push("forgot")
    },
    handleSecond() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true;
          if (this.loginForm.rememberMe) {
            Cookies.set("username", this.loginForm.username, { expires: 30 });
            Cookies.set("password", encrypt(this.loginForm.password), { expires: 30 });
            Cookies.set('rememberMe', this.loginForm.rememberMe, { expires: 30 });
          } else {
            Cookies.remove("username");
            Cookies.remove("password");
            Cookies.remove('rememberMe');
          }
          this.$store.dispatch("Login", this.loginForm).then(() => {
            this.$router.push({ path: "/home" }).catch(()=>{});
          }).catch(() => {
            this.loading = false;
            if (this.captchaEnabled) {
              this.getCode();
            }
          });
        }
      });
      // this.$router.push("second")
    }
  }
}
</script>

<style lang="less" scoped>
.login-info {

.title {
  font-size: 24px;
  font-weight: 700;
  line-height: 32px;
  color: #000;
  margin: 0 0 32px;
}

.title2 {
  font-size: 18px;
  font-weight: 700;
  color: #000;
  margin-bottom: 20px;
}

.button-area {
  display: flex;
  justify-content: space-between;
}

.login-button {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

}
.login-code {
  width: 33%;
  height: 38px;
  float: right;

img {
  cursor: pointer;
  vertical-align: middle;
}

}
</style>
