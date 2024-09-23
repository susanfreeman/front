<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      绑定谷歌验证器
    </div>

    <div class="form-area">
      <el-form :model="form" ref="form" label-position="top">
        <el-form-item
          label="邮箱验证码"
          prop="code"
          :rules="[
            { required: true, message: '请输入验证码', trigger: 'blur' }
          ]"
        >
          <el-input v-model="form.code" placeholder="请输入邮箱验证码">
            <el-button
              type="text"
              slot="suffix"
              @click="getCode"
              :disabled="codeDisabled"
            >
              {{ codeInput }}
            </el-button>
          </el-input>
        </el-form-item>

        <el-form-item
          label="谷歌身份验证码"
          prop="code"
          :rules="[
            { required: true, message: '请输入验证码', trigger: 'blur' }
          ]"
        >
          <el-input v-model="form.code2" placeholder=""> </el-input>
        </el-form-item>
      </el-form>
      <div style="margin-top: 50px">
        <el-button type="primary" @click="visible = false" style="width: 100%"> 确 认 </el-button>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        form: {
          code: '',
          code2: ''
        },

        codeDisabled: false,
        codeInput: '获取验证码',
        time: 60
      }
    },
    methods: {
      handleBack() {
        this.$router.push('/home/user/google')
      },

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
      }
    }
  }
</script>

<style lang="less" scoped>
  .pc {
    @media screen and (min-width: 600px) {
      height: 685px !important;
    }
    .pc_back {
      display: flex;
      font-size: 16px;
      margin-bottom: 32px;
      font-weight: 700;
      color: #333;
      cursor: pointer;
      align-items: center;
      i {
        margin-right: 10px;
      }
    }
    .form-area {
        padding: 0 20px;
    }
  }
</style>
