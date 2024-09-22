<template>
  <div class="login-info">
    <p class="title">
      HELLO!
      <br />
      欢迎使用orbiterwallet
    </p>
    <p class="title2">使用邮箱登录</p>

    <el-form :model="loginForm" ref="loginForm">
      <el-form-item
        prop="email"
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
          v-model="loginForm.email"
          placeholder="请输入邮箱地址"
        ></el-input>
      </el-form-item>

      <el-form-item
        label=""
        prop="pass"
        :rules="[{ required: true, message: '请输入密码', trigger: 'blur' }]"
      >
        <el-input
          type="password"
          v-model="loginForm.pass"
          autocomplete="on"
          placeholder="请输入密码"
          show-password
        ></el-input>
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
  export default {
    data() {
      return {
        loginForm: {
          email: '',
          pass: ''
        }
      }
    },

    methods: {
        //注册
        goToAgreement() {
            this.$router.push("agreement")
        },

        goToForgot() {
            this.$router.push("forgot")
        },
        handleSecond() {
            this.$router.push("second")

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
</style>
