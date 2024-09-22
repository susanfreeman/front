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
          <el-button type="text" slot="suffix" @click="getCode">{{
            codeInput
          }}</el-button>
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
        registerForm: {
          email: '',
          code: '',
          pass: '',
          rePass: '',
          reCode: ''
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

        codeDisabled: false,
        codeInput: '获取验证码',
        time: 60
      }
    },
    methods: {
      //获取验证码
      getCode() {
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
            alert('submit!')
          } else {
            console.log('error submit!!')
            return false
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
</style>
