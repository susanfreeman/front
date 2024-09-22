<template>
  <div class="account">
    <div class="account_l">
      <div class="item">
        <img src="../../../assets/20240823-9.png" alt="" class="visa_img" />
        <img src="../../../assets/banklogo-6.png" alt="" class="master_logo2" />

        <div class="login">
          <div class="balance">
            $ 17.00
            <span>如何充值</span>
          </div>
        </div>

        <div class="visa_info">
          <p class="num">4767 1500 6751 3281</p>
          <div>
            <p class="name">
              <span>JACK ZHA</span>
              <span class="expiry">Expiry 08/2026</span>
            </p>
          </div>
        </div>

        <p class="card_type_word">
          Subscription
          <i class="el-icon-arrow-right"></i>
        </p>
      </div>

      <div class="item" @click="goToCreated">
        <img src="../../../assets/20240823-9.png" alt="" class="visa_img" />

        <div class="login">
          <p class="word">申请卡</p>
          <i class="el-icon-arrow-right"></i>
        </div>

        <img src="../../../assets/banklogo-7.png" alt="" class="visa_master" />
      </div>
    </div>

    <div class="account_r">
      <div class="card_title">
        <img
          src="../../../assets/banklogo-8.png"
          alt=""
          style="margin-right: 10px"
        />
        Master card
      </div>

      <ul class="card_info_pc">
        <li style="min-width: 206px">
          <p>Card number</p>
          <div class="content"></div>
        </li>

        <li>
          <p>EXpire date</p>
          <div class="content"></div>
        </li>

        <li>
          <p>CVV安全码</p>
          <div class="content"></div>
        </li>

        <li>
          <p>Card holder</p>
          <div class="content"></div>
        </li>
      </ul>

      <div class="menu">
        <div class="choose">
          <div @click="gotoCoinTransfer">
            <img src="../../../assets/icon-1.png" alt="" />
            <p>充值</p>
          </div>

          <div @click="gotoCoinTransfer">
            <img src="../../../assets/icon-2.png" alt="" />
            <p>提现</p>
          </div>

          <div @click="visible = true">
            <img src="../../../assets/icon-3.png" alt="" />
            <p>CVV安全码</p>
          </div>

          <div @click="goToEquity">
            <img src="../../../assets/icon-4.png" alt="" />
            <p>权益</p>
          </div>
        </div>
      </div>

      <div class="bill_list">
        <p class="bill_list_t">
          <span class="lable">账单</span>
          <span class="title"
            >结算中
            <i class="el-icon-arrow-right"></i>
          </span>
        </p>
      </div>
    </div>

    <el-dialog title="安全验证" :visible.sync="visible" width="25%" center>
      <el-form :model="form" ref="form" label-position="top">
        <el-form-item
          label=""
          prop="code"
          :rules="[
            { required: true, message: '请输入验证码', trigger: 'blur' }
          ]"
        >
          <el-input v-model="form.code" placeholder="邮箱验证码">
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
          label=""
          prop="code"
          :rules="[
            { required: true, message: '请输入验证码', trigger: 'blur' }
          ]"
        >
          <el-input v-model="form.code2" placeholder="谷歌验证码">
            <el-button type="text" slot="suffix"> 如何获取？ </el-button>
          </el-input>
        </el-form-item>
      </el-form>

      <div style="text-align: center">
        <el-button type="primary" @click="visible = false" style="width: 50%">
          确 认
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        visible: false,

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
      goToCreated() {
        this.$router.push('Created')
      },

      goToEquity() {
        this.$router.push('Equity')
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
      },

      gotoCoinTransfer() {
        this.$router.push('/home/account/coin-transfer')
      }
    }
  }
</script>

<style lang="less" scoped>
  .account {
    min-width: 1110px;
    background: #f4f5f7;
    padding-bottom: 52px;
    display: flex;
    height: 100vh;
    overflow-y: scroll;
    .account_l {
      width: 407px;
      padding: 10px 32px;
      .item {
        width: 100%;
        height: 179px;
        margin-top: 4px;
        border-radius: 14px;
        overflow: hidden;
        padding: 20px 0 0 25px;
        margin-bottom: 22px;
        position: relative;
        background-size: 100%;
        background-repeat: no-repeat;
        .visa_img {
          position: absolute;
          top: 0;
          left: 0;
          width: 100%;
          height: 100%;
        }
        .master_logo2 {
          width: 45px;
          position: absolute;
          top: 18px;
          right: 24px;
          z-index: 1;
        }
        .login {
          position: relative;
          z-index: 1;
          font-size: 16px;
          font-weight: 700;
          color: #fff;
          display: flex;
          align-items: center;
          .balance {
            display: flex;
            align-items: center;
            font-size: 20px;
            font-weight: 700;
            color: #fff;
            span {
              height: 18px;
              background: hsla(0, 0%, 100%, 0.39);
              border-radius: 4px;
              font-size: 10px;
              font-weight: 400;
              color: #fff;
              padding: 1px 5px;
              margin-left: 3px;
            }
          }
          .word {
            cursor: pointer;
            margin-right: 10px;
          }
        }
        .visa_info {
          position: absolute;
          left: 0;
          font-size: 14px;
          color: #fff;
          bottom: 10px;
          padding-left: 24px;
          z-index: 1;
          .num {
            font-family: qiqi;
            letter-spacing: 2px;
            font-size: 12px;
          }
          .name {
            font-weight: 400;
            margin-top: 6px;
            font-size: 12px;
            .expiry {
              margin-left: 10px;
            }
          }
        }
        .card_type_word {
          font-size: 12px;
          font-weight: 400;
          color: #fff;
          position: absolute;
          right: 20px;
          bottom: 13px;
          cursor: pointer;
        }
        .visa_master {
          position: absolute;
          right: 20px;
          bottom: 18px;
          vertical-align: middle;
        }
      }
    }
    .account_r {
      flex: auto;
      padding: 0 60px;
      background: #fff;
      .card_title {
        width: 100%;
        height: 93px;
        display: flex;
        align-items: center;
        font-size: 20px;
        font-weight: 700;
        color: #2c335c;
        margin-right: 10px;
      }
      .card_info_pc {
        width: 100%;
        padding: 10px 0 32px;
        border-bottom: 1px solid #eaeaea;
        display: flex;
        li {
          min-width: 123px;
          padding-left: 0;
          padding: 0 20px;
          position: relative;
          p {
            font-size: 12px;
            color: #999;
            margin-bottom: 7px;
          }
          .content {
            height: 19px;
            background: #f4f5f7;
          }
        }
        li:after {
          position: absolute;
          top: 0;
          right: 0;
          content: '';
          width: 1px;
          height: 44px;
          background: #eaeaea;
        }
      }
      .menu {
        display: flex;
        justify-content: space-between;
        width: 100%;
        font-size: 12px;
        border-radius: 4px;
        color: #333;
        align-items: center;
        padding-bottom: 20px;
        border-bottom: 1px solid #eaeaea;
        margin-top: 22px;
        margin-bottom: 32px;
        .choose {
          width: 360px;
          display: flex;
          justify-content: space-around;
          text-align: center;
          position: relative;
          & > div {
            cursor: pointer;
          }
        }
      }
      .bill_list {
        width: calc(100% + 120px);
        margin-left: -60px;
        padding: 0 60px;
        border-radius: 4px;
        background: #fff;
        .bill_list_t {
          width: 100%;
          height: 42px;
          line-height: 42px;
          display: flex;
          justify-content: space-between;
          .lable {
            font-size: 16px;
            font-weight: 700;
            color: #2c335c;
          }
          .title {
            font-size: 12px;
            font-weight: 400;
            color: #1a72ff;
          }
        }
      }
    }
  }
</style>
