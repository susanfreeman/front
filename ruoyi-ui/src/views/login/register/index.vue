<template>
  <div class="register-body">
    <i class="el-icon-back" @click="goToLogin"></i>
    <p class="title">注册账户</p>
    <p class="sub-title">邮箱</p>

    <el-form :model="registerForm" ref="registerForm" :rules="rules">
      <el-form-item prop="email" label="">
        <el-input
          v-model="registerForm.email"
          placeholder="请输入邮箱地址"
        ></el-input>
      </el-form-item>

      <el-form-item label="" prop="code">
        <el-input v-model="registerForm.code" placeholder="请输入验证码">
          <el-button type="text" slot="suffix" @click="getCode">{{ codeInput }}</el-button>
        </el-input>
      </el-form-item>

      <el-form-item label="" prop="pass">
        <el-input
          type="password"
          v-model="registerForm.pass"
          autocomplete="on"
          placeholder="登录密码"
          show-password
        ></el-input>
      </el-form-item>

      <el-form-item label="" prop="rePass">
        <el-input
          type="password"
          v-model="registerForm.rePass"
          autocomplete="on"
          placeholder="登录密码"
          show-password
        ></el-input>
      </el-form-item>

      <el-form-item prop="code" v-if="captchaEnabled">
        <el-input
          v-model="registerForm.validCode"
          auto-complete="off"
          placeholder="验证码"
          style="width: 63%"
          @keyup.enter.native="handleRegister"
        >
          <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />
        </el-input>
        <div class="register-code">
          <img :src="codeUrl" @click="getVerifyCode" class="register-code-img"/>
        </div>
      </el-form-item>

      <el-form-item label="">
        <el-input
          v-model="registerForm.reCode"
          placeholder="请输入推荐码（选填）"
        ></el-input>
      </el-form-item>
    </el-form>

    <el-button type="primary" style="width: 100%" @click="handleRegister"
      >注册</el-button
    >
  </div>
</template>

<script>
import {captchaEmail, getCodeImg, register} from "@/api/login";

  export default {
    data() {
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'))
        } else if (value !== this.registerForm.pass) {
          callback(new Error('两次输入密码不一致!'))
        } else {
          callback()
        }
      }

      return {
        loading: false,
        registerForm: {
          email: '',
          code: '',
          pass: '',
          rePass: '',
          validCode: '',
          reCode: '',
          uuid: "",
          mailUuid: ''
        },

        rules: {
          email: [
            { required: true, message: '请输入邮箱地址', trigger: 'blur' },
            {
              type: 'email',
              message: '请输入正确的邮箱地址',
              trigger: ['blur', 'change']
            }
          ],
          code: [{ required: true, message: '请输入验证码', trigger: 'blur' }],
          pass: [
            { required: true, message: '请输入登录密码', trigger: 'blur' }
          ],
          rePass: [{ validator: validatePass2, trigger: 'blur' }]
        },
        codeUrl:"",
        codeDisabled: false,
        codeInput: '获取验证码',
        captchaEnabled: true,
        time: 60
      }
    },
    created() {
      this.getVerifyCode();
    },
    methods: {
      getVerifyCode() {
        getCodeImg().then(res => {
          this.captchaEnabled = res.captchaEnabled === undefined ? true : res.captchaEnabled;
          if (this.captchaEnabled) {
            this.codeUrl = "data:image/gif;base64," + res.img;
            this.registerForm.uuid = res.uuid;
          }
        });
      },

      //获取验证码
      getCode() {
        captchaEmail(this.registerForm).then(response => {
          console.log(response.uuid)
          this.registerForm.mailUuid = response.uuid;
          this.$message("邮件发送成功");
        });

        this.time = 60
        this.codeInput = this.time + 's'
        this.codeDisabled = true

        let timeEle = setInterval(() => {
          this.time--

          this.codeInput = this.time + 's'
        }, 1000)

        setTimeout(() => {
          this.time = 0
          this.codeInput = '再次发送'
          this.codeDisabled = false

          clearInterval(timeEle)
          timeEle = null
        }, 61000)
      },

      goToLogin() {
        this.$router.push('login')
      },

      handleRegister() {
        this.$refs.registerForm.validate((valid) => {
          if (valid) {
            this.loading = true;
            const username = this.registerForm.username;
            register(this.registerForm).then(res => {
              this.$alert("<font color='red'>恭喜你，您的账号 " + username + " 注册成功！</font>", '系统提示', {
                dangerouslyUseHTMLString: true,
                type: 'success'
              }).then(() => {
                this.$router.push("/login");
              }).catch(() => {});
            }).catch(() => {
              this.loading = false;
              if (this.captchaEnabled) {
                this.getVerifyCode();
              }
            })
          //
          // } else {
          //   console.log('error submit!!')
          //   return false
          }
        })
      }
    }
  }
</script>

<style lang="less" scoped>
  .register-body {
    .el-icon-back {
      font-size: 30px;
      cursor: pointer;
      color: #333;
      @media screen and (max-width: 600px) {
        position: absolute;
        top: 10px;
      }
    }
    .title {
      font-size: 24px;
      font-weight: 700;
      line-height: 32px;
      color: #000;
      margin: 32px 0;
    }
    .sub-title {
      font-size: 16px;
      font-weight: 700;
      color: #000;
      margin-bottom: 32px;
    }
  }

.register-code {
    width: 33%;
    height: 38px;
    float: right;

  .register-code-img {
    height: 36px;
    float: right;
  }
  img {
    cursor: pointer;
    vertical-align: middle;
  }

  }
</style>
