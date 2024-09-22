<template>
  <div class="second">
    <div class="res-login-header">
      <img
        src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAABR0lEQVQ4T63UsUrDUBQG4P80vQguVRcHZxFXqbg6iJtP4KzQRSp1SEHhlgy2DhbaQegj1DcwSHUVJys+gC8gQorEJjlyA5WWpLkxMVu44Tvn3v/kEv75oTTeiXW1zn5BdOXZm+57LagwwBgws0G+t9NpmO9JaCI4wQCsMXN/GDiHD1J6mcAsmCoU22FWLBbMg0XAvNgMWLFaGwLFexUAwP0XXx9AXDjhGVat9maAYABgVb0z+JWAxDSnMSZ67p7Xjn47PJXXK57BNgFbusGds/7Yuajtzmy5KttLfsG/I6JtZgwD9+tgJLzPNAVGgHcrpRMJ5bjZLC18F+0QBZ5cZ7zfa5mp0EnhyBzmRWMHO9y+EagzLf+107n/clY08XLIgmqvr4p5uSwWhc1E7IrxXs9MDkkLqvQUihJwU69/6MYoFahDptd/ANUGwhUwnh1lAAAAAElFTkSuQmCC"
        class="type"
        @click="goBack"
      />
      <p>二次验证</p>
    </div>

    <img src="../../../assets/image1.png" alt="" class="img-ele" />
    <p class="title">为了你的账户安全,本次操作需要二次验证</p>

    <el-form :model="secondForm" ref="secondForm" label-position="top">
      <el-form-item label="验证方式">
        <div class="check-input">
          <p class="input-title">电子邮箱</p>
          <div class="input-item">
            <p class="item-title">7****0@qq.com</p>
            <i class="el-icon-arrow-down"></i>
          </div>
        </div>
      </el-form-item>

      <el-form-item
        label="验证码"
        prop="code"
        :rules="[{ required: true, message: '请输入验证码', trigger: 'blur' }]"
      >
        <el-input v-model="secondForm.code" placeholder="请输入验证码">
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
    </el-form>

    <el-button
      type="primary"
      style="width: 100%; margin-top: 20px"
      @click="submit"
    >
      继续
    </el-button>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        secondForm: {
          email: '',
          code: ''
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

      submit() {
        this.$router.push('/home')
      },

      goBack() {
        this.$router.push('/login/login')
      }
    }
  }
</script>

<style lang="less" scoped>
  .second {
    width: 471px;
    height: 100%;
    background: #fff;
    margin-top: -120px;
    position: absolute;
    // float: left;
    left: 0;
    z-index: 100;
    padding: 0 48px;
    .res-login-header {
        display: none;
    }

    .img-ele {
      display: block;
      margin: 32px auto 16px;
      @media screen and (max-width: 600px) {
        margin: 60px auto 16px;
      }
    }
    .title {
      margin-bottom: 32px;
      text-align: center;
      font-size: 12px;
      font-weight: 700;
      color: #6f7590;
    }
  }

  .check-input {
    width: 100%;
    height: 40px;
    line-height: 40px;
    background-color: #fff;
    border-radius: 4px;
    border: 1px solid #000;
    padding: 0 10px;
    display: flex;
    justify-content: space-between;
    cursor: pointer;
    .input-title {
      font-weight: 700;
      color: #000;
    }
    .input-item {
      display: flex;
      align-items: center;
      font-size: 12px;
      font-weight: 700;
      color: #6f7590;
      .item-title {
        margin-right: 10px;
      }
    }
  }
  @media screen and (max-width: 600px) {
    .second {
      width: 100% !important;
      height: 100% !important;
      padding: 0 10px !important;
    }
  }
</style>
