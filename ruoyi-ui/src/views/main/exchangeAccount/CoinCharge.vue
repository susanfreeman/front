<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      USDT充币
    </div>

    <p class="title1">主网</p>
    <div class="select" @click="openSelect">
      <span> {{ radio ? radio : '选择主网' }}</span>
      <i class="el-icon-arrow-right"></i>
    </div>

    <div class="recharge">
      <p class="addr_t">
        <img src="../../../assets/newlogo-1.png" alt="" />
        USDT
      </p>
      <div class="qrcode2">
        <canvas ref="qrcode"></canvas>
<!--        <img-->
<!--          alt="Scan me!"-->
<!--          src="data:image/png;base64,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"-->
<!--          style="display: block"-->
<!--        />-->
      </div>
      <p class="title1">充值地址</p>
      <div class="addr_b">
        <span class="no_addr" style="display: none">选择主网显示充值地址</span>
        <span>{{coin}}</span>
        <img src="../../../assets/copy.png" alt="" />
      </div>
      <p class="tip1">平均到账时间:1分钟</p>
      <div class="tips" style="">
        <p class="tip1" style="display: none">
          如:充值100 USDT，手续费：USDT，到账数量USDT
        </p>
        <p class="tip1" style="display: none">
          For example: top up 100 USDT, handling fee: USDT, the amount received
          is USDT
        </p>
        <p class="tip2">1、此地址只可接受 USDT-Polygon 充值；</p>
        <p class="tip2">2、请不要向此地址充值除 USDT-Polygon 以外任何资产；</p>
        <p class="tip2">3、最低充值金额需大于 0.5USDT，≤0.5USDT 将无法入账；</p>
        <p class="tip2">4、不支持跨链等智能合约方式充值，否则无法入账；</p>
        <p class="tip2">5、如未完成KYC，提币总限额为500USDT；</p>
        <p class="tip2">6、充值需要300个网络确认才可入账。</p>
      </div>

      <div class="know" v-show="isKnow">
        <i class="el-icon-warning tips2"></i>
        如何充值? <span class="more">了解更多</span>
        <i @click="handleClose" class="el-icon-close close"></i>
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

      <el-radio-group v-model="radio" class="coin-roaio-group" style="margin-bottom: 50px" @input="changeInput">
        <el-radio
          v-for="coin in coinList"
          :key="coin"
          :value="coin"
          :label="coin"
        >{{coin}}</el-radio>
      </el-radio-group>

<!--      <el-radio-group-->
<!--        v-model="radio"-->
<!--        class="coin-roaio-group"-->
<!--        style="margin-bottom: 50px"-->
<!--        @input="changeInput"-->
<!--      >-->
<!--        <el-radio label="POLYGON"> POLYGON </el-radio>-->
<!--        <el-radio label="BNB SMART CHAIN (BEP20)">-->
<!--          BNB SMART CHAIN (BEP20)-->
<!--        </el-radio>-->
<!--        <el-radio label="TRC20">-->
<!--          TRC20-->
<!--          <p>入账手续费：<span>1</span>USDT</p>-->
<!--        </el-radio>-->
<!--      </el-radio-group>-->
    </el-dialog>
  </div>
</template>

<script>
  import { mapGetters } from 'vuex'
  import QRCode from 'qrcode'
  import {getBalance,getRechargeAddr,getRechargeList,getTargetAmount} from "@/api/custom/exchange";

  export default {
    data() {
      return {
        value: '',
        visible: true,
        isKnow: true,
        radio: '',
        form: {
          informantType: "",
        },
        coinList: [],
        coinAddrMap: {},
        coin: ''
      }
    },
    created() {
      this.getAllCurr();
      this.getAllAddr();
    },
    computed: {
      ...mapGetters(["isMobile"])
    },
    methods: {
      getAllCurr() {
        getRechargeList().then(res => {
          console.log(res);
          if (res.code == 200) {
            this.coinList = res.data;
          }
        });
      },
      getAllAddr() {
        getRechargeAddr().then(res => {
          console.log(res);
          if (res.code == 200) {
            this.coinAddrMap = res.data;
          }
        });
      },
      handleBack() {
        this.$router.push('/home/exchange-account/exchange')
      },

      handleClose() {
        this.isKnow = false
      },

      openSelect() {
        this.visible = true
      },

      generateQRCode() {
        QRCode.toCanvas(this.$refs.qrcode, this.coin, error => {
          if (error) console.error(error)
        })
      },

      changeInput(val) {
        this.visible = false
        this.coin = this.coinAddrMap[val];
        this.generateQRCode();
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
    .title1 {
      font-size: 12px;
      font-weight: 400;
      color: #333;
    }
    .select {
      width: 100%;
      height: 42px;
      background: #fff;
      border: 1px solid #f5f6f8;
      border-radius: 4px;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 0 10px;
      font-size: 12px;
      font-weight: 700;
      color: #333;
      margin-bottom: 10px;
    }
    .recharge {
      width: 100%;
      margin: 0 auto;
      background: #fff;
      box-shadow: 0 0 4px rgba(0, 0, 0, 0.16);
      border-radius: 4px;
      padding: 16px;
      .addr_t {
        color: #333;
        font-weight: 700;
        text-align: center;
        margin: 4px 0 23px;
        font-size: 12px;
        img {
          vertical-align: middle;
          width: 24px;
          margin-right: 4px;
        }
      }
      .qrcode2 {
        width: 120px;
        height: 120px;
        margin: 0 auto;
      }
      .addr_b {
        width: 100%;
        border: 1px solid #f6f5f8;
        text-align: center;
        color: #333;
        margin: 0 auto 16px;
        font-weight: 400;
        padding: 6px 10px 6px 10px;
        font-size: 12px;
        word-break: break-all;
        text-align: left;
        position: relative;
        display: flex;
        justify-content: space-between;
        align-items: center;
        .no_addr {
          color: #bfbfbf;
        }
      }
      & > .tip1 {
        margin-bottom: 10px;
        color: #000;
      }
      .tips {
        width: 100%;
        padding: 10px 7px;
        background: #fff6d9;
        font-size: 12px;
        line-height: 18px;
        color: #de8e21;
        .tip1 {
          margin-bottom: 10px;
        }
        .tip2 {
          word-break: break-all;
        }
      }
    }
    .know {
      width: 100%;
      height: 42px;
      border: 1px solid #f6f5f8;
      border-radius: 4px;
      margin: 10px auto;
      display: flex;
      align-items: center;
      position: relative;
      font-weight: 400;
      font-size: 12px;
      color: #333;
      padding-left: 16px;
      .tips2 {
        font-size: 16px;
        margin-right: 10px;
      }
      .more {
        font-weight: 400;
        color: #1a72ff;
        cursor: pointer;
      }
      .close {
        font-size: 20px;
        position: absolute;
        top: 11px;
        right: 16px;
        cursor: pointer;
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
    }
  }
</style>
