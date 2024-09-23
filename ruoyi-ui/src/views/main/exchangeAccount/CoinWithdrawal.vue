<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      USDT提币
    </div>

    <div class="exchange_b">
      <div class="recharge">
        <p class="title">发送到</p>
        <div style="margin-bottom: 16px">
          <el-input
            v-model="input1"
            placeholder="请输入收款地址"
            class="coin-input"
          ></el-input>
        </div>

        <p class="title">主网</p>
        <div class="cont">
          <div class="select" @click="visible = true">
            <p>{{ radio ? radio : '选择主网' }}</p>
          </div>
          <i class="el-icon-arrow-right"></i>
        </div>

        <p class="title">提现金额(5.00USDT ~ 200,000.00USDT)</p>
        <div style="margin-bottom: 16px">
          <el-input
            v-model="input2"
            placeholder="请输入提现金额"
            class="coin-input"
          ></el-input>
        </div>

        <div class="available">
          <p>可用：</p>
          <p><label>0.00</label><span>全部</span></p>
        </div>
      </div>

      <div class="submit">
        <div class="submit_info">
          <label>手续费</label>
          <span>0.00 USDT</span>
        </div>
        <div class="submit_info">
          <label>实际到账</label>
          <span class="weight"> USDT</span>
        </div>
        <div>
          <el-button
            type="primary"
            disabled
            class="button0"
            style="width: 100%"
          >
            提币
          </el-button>
        </div>
      </div>
    </div>

    <el-dialog
      title="选择网络"
      :visible.sync="visible"
      :width="isMobile ? '90%' : '25%'"
      center
    >
      <div class="card_type_m">
        <i class="el-icon-info"></i>
        提示: 请选择与提币平台一致的网络进行充值,否则会 造成资金丢失。
      </div>

      <el-radio-group
        v-model="radio"
        class="coin-roaio-group"
        style="margin-bottom: 50px"
        @input="changeInput"
      >
        <el-radio label="POLYGON">
          <div class="item">
            <span>POLYGON</span>
            <span class="small"> 手续费： 1USDT </span>
          </div>
        </el-radio>
        <el-radio label="BNB SMART CHAIN (BEP20)">
          <div class="item">
            <span>BNB SMART CHAIN (BEP20)</span>
            <span class="small"> 手续费： 1USDT </span>
          </div>
        </el-radio>
        <el-radio label="TRC20">
          <div class="item">
            <span>TRC20</span>
            <span class="small"> 手续费： 2USDT </span>
          </div>
        </el-radio>
      </el-radio-group>
    </el-dialog>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'

  export default {
    data() {
      return {
        visible: false,

        radio: '',
        input1: '',
        input2: ''
      }
    },

    computed: {
      ...mapGetters(["isMobile"])
    },
    methods: {
      handleBack() {
        this.$router.push('/home/exchange-account/exchange')
      },

      changeInput(val) {
        this.radio = val
        this.visible = false
      }
    }
  }
</script>

<style lang="less" scoped>
  .pc {
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
    .exchange_b {
      width: 100%;
      padding-top: 16px;
      .recharge {
        width: 100%;
        background: #fff;
        margin: 0 auto 16px;
        border-radius: 4px;
        .title {
          font-size: 12px;
          font-weight: 400;
          margin-bottom: 7px;
          color: #6f7590;
        }

        .cont {
          width: 100%;
          height: 42px;
          border: 1px solid #ebecef;
          border-radius: 4px;
          font-weight: 700;
          color: #bbbec1;
          overflow: hidden;
          margin-bottom: 16px;
          position: relative;
          .select {
            line-height: 40px;
            width: 100%;
            height: 40px;
            padding-left: 10px;
            color: #000;
          }
          i {
            color: #333;
            position: absolute;
            top: 11px;
            right: 9px;
          }
        }
        .available {
          font-size: 12px;
          font-weight: 400;
          border-bottom: 1px solid #f0f0f3;
          padding-bottom: 16px;
          margin-bottom: 16px;
          display: -webkit-box;
          display: -ms-flexbox;
          display: flex;
          justify-content: space-between;
          color: #6f7590;
          label {
            color: #333;
          }
          span {
            margin-left: 7px;
            color: #1a72ff;
            cursor: pointer;
          }
        }
      }
      .submit {
        width: 100%;
        border-top: 1px solid #f0f0f3;
        padding: 17px 16px 30px;
        .submit_info {
          display: flex;
          justify-content: space-between;
          margin-bottom: 6px;
          font-size: 12px;
          font-weight: 400;
          label {
            color: #6f7590;
          }
          span {
            color: #333;
          }
        }
        .button0 {
          margin-top: 16px;
        }
      }
    }
  }

  .card_type_m {
    width: calc(100% - 32px);
    margin: 16px auto 10px;
    padding: 10px;
    background: #fff6d9;
    border-radius: 4px;
    font-size: 12px;
    font-weight: 400;
    color: #de8e21;
    line-height: 18px;
    display: flex;
    justify-content: space-between;
    i {
      font-size: 16px;
      margin-right: 4px;
    }
  }
</style>
<style lang="less">
  .coin-roaio-group {
    display: flex;
    flex-direction: column;
    .el-radio {
      height: 50px;
      border-bottom: 1px solid #f5f5f8;
      display: flex;
      align-items: center;
      .el-radio__label {
        width: 100%;
        display: flex;
        justify-content: space-between;
        align-items: center;
        p {
          height: 26px;
          line-height: 26px;
          padding: 0 6px;
          background: #fff6d9;
          border-radius: 4px;
          font-size: 12px;
          color: #de8e21;
          white-space: nowrap;
        }
      }
      .item {
        display: flex;
        flex-direction: column;
        font-size: 14px;
        font-weight: 700;
        color: #333;
        .small {
          font-size: 12px;
          color: #333;
          white-space: nowrap;
        }
      }
    }
  }

  .coin-input {
    .el-input__inner {
      border: 1px solid #ebecef;
    }
  }
</style>
