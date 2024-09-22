<template>
  <div class="register-body">
    <i class="el-icon-back" @click="goToLogin"></i>
    <div v-show="current == 0">
      <p class="title">忘记密码</p>
      <p class="sub-title">邮箱</p>

      <el-form :model="registerForm" ref="registerForm">
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
            v-model="registerForm.email"
            placeholder="请输入邮箱地址"
          ></el-input>
        </el-form-item>

        <el-form-item
          label=""
          prop="code"
          :rules="[
            { required: true, message: '请输入验证码', trigger: 'blur' }
          ]"
        >
          <el-input v-model="registerForm.code" placeholder="请输入验证码">
            <el-button
              type="text"
              slot="suffix"
              @click="getCode"
              :disabled="codeDisabled"
              >{{ codeInput }}</el-button
            >
          </el-input>
        </el-form-item>
      </el-form>

      <el-button type="primary" style="width: 100%" @click="handleNext"
        >下一步</el-button
      >
    </div>

    <div v-show="current == 1">
      <p class="title">设置新密码</p>
      <el-form :model="setForm" ref="setForm">
        <el-form-item
          label=""
          prop="pass"
          :rules="[
            { required: true, message: '请输入新密码', trigger: 'blur' }
          ]"
        >
          <el-input
            type="password"
            v-model="setForm.pass"
            autocomplete="off"
            placeholder="请输入新密码"
            show-password
          ></el-input>
        </el-form-item>

        <el-form-item
          label=""
          prop="rePass"
          :rules="[
            { required: true, message: '请再次输入新密码', trigger: 'blur' }
          ]"
        >
          <el-input
            type="password"
            v-model="setForm.rePass"
            autocomplete="off"
            placeholder="请再次输入新密码"
            show-password
          ></el-input>
        </el-form-item>
      </el-form>

      <el-button
        type="primary"
        style="width: 100%; margin-top: 20px"
        @click="submit"
      >
        下一步
      </el-button>
    </div>

    <el-dialog
      :visible.sync="visible"
      width="30%"
      :show-close="false"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
    >
      <el-result icon="success">
        <template slot="extra">
          <p class="dialog-title">密码重置成功</p>

          <el-button @click="goBackLogin">返回登录</el-button>
        </template>
      </el-result>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        current: 0,

        registerForm: {
          email: '',
          code: ''
        },

        setForm: {
          pass: '',
          rePass: ''
        },

        codeDisabled: false,
        codeInput: '获取验证码',
        time: 60,

        visible: false
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

      handleNext() {
        this.current = 1
      },

      goToLogin() {
        if (this.current == 0) {
          this.$router.push('login')
        } else {
          this.current = 0
        }
      },

      submit() {
        this.visible = true
      },
      goBackLogin() {
        this.$router.push('login')
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
  .dialog-title {
    font-size: 24px;
      font-weight: 700;
      line-height: 32px;
      color: #000;
      margin-bottom: 32px;
  }
</style>
