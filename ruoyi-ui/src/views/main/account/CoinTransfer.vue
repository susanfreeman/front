<template>
  <div class="pc">
    <span class="pc_back" @click="goBack">
      <i class="el-icon-back"></i>
    </span>

    <div class="card_balance">
      <div class="card_balance_l">
        <p>Balance</p>
        <div>{{this.cardBal}} USD</div>
        <img
          src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAYAAADhAJiYAAAAAXNSR0IArs4c6QAABBxJREFUWEftmGtQ1FUYh59d5bYQcb+IiLiAhHGrGSf4IHkrjEgbIqQQBxxmLIIcSmUwG0pNpFEn0ymdStRSuyBI2I0MZ4rsQ1QIcpPdADEYrrHAcmeb/9nCYUAWP4R82P30P+97znmf8zuXfeeVAeh0Oi8gC3gcsJJss/jrBb4B0mUymUqm0+m8gauA/SxCTBWqAwiRgC4AT99jmP/C50lAGuC+OQLUIwHp5giMwDACGdoNo0JGhQwpYMhvPEN3pVB71zAtbcPjY8xMZXgvthhvDwyOUdcwINqe7ma0tg/T1z+Go918nB1Mhb2pZZDrtf3iW+lhjpeH+fj47p4RbjYPifaDPoop2SZsmaZ3hOJfNHxa2EFRSbcYcGDHIhKjncT36QttvLK/AStLOeVfBRLyTIVYwKEMD6LW2ZGSWU/B5a4JgWq/D8L2/vlIi3l4fTmtHfoF/1bgj7ur2SSoO56hmNRafriq4cmVNpzMlrITWBtfyR9VWpJinEiJdyEg4pqwXznrx7kv2zl+rhVb63lsjHRgbExH/a1BPj4oJRMIf+qb9eMAH+xfwvo1djMHev9sC7sPN+HhZsqv+QGU12hZFVcpJvj582XUqAdI2KlCYS5HfSWYtZurRJ91YTbkZCuRy2UTgq2Jr6SsSssDXhZU1fWTHOdM5svuMweqqNWy8nk9gKo4mD1Hm8jJbWPFcmtyj/mw590mjpxuISTYioITvuw40MDJL9pE/wBfBXvT3AkJ1icRpRW9hCdU4+pkQsYLbqS8UU/oQ1ZcPO47cyApCfB9rIzOv0c4/443SRlqevpGOfW2kicetWXD1hpKSntI3uRMZqo72oFRdh28yScX25HyB7kcTmUrCQ+zJTnzTz671MFLm1x4LtKe0GevY6mQoy4OnqTktO/QlnSVOKSBvgrKqrUsdJG2z1+sSrnqd/q0Y3yYtYSnVt8+C5U3tMRuu8FfrcOsDrXmaKYngRHXGBrWERNhL+Y49FGzgP7x/DJ8lbdvsTTvtEA5ua1sz2ocl3XXi25sS3ClSqVlxUb9dpYVBtDYPChukXSVNb2jbH61jmr1ALGR9igXmbP32K1JWyMZjry+mNhIhwm+aYFUjQM8ElUhBpiayCi7FICDrQln8ttI29eAs4MJFV8HkravnjP57RMmtraaR8GJpcSl1dHUMkRitCNhy61Fn7zvOskv6iIhypHsdI+ZA0k9t+5Wo+0fI8hPQVriAjFYAir6qRv/pQq2Jy0g99sOCi930dw2jKWFnCA/S7ZEOwm13npPr072zkW4OOofz5JSjXgifDzNeS154d0BTan1/2g0/rkaEteokFEhQwoY8hvP0EwUmnPFhjxggyHyWfKLcoyUJUkFK5tZCnqnMJ2iYCV5dTqd8t+SXvi9Lun9A7+T7D2L0sieAAAAAElFTkSuQmCC"
        />
      </div>

      <div class="card_balance_r">
        {{cardVal.cardNo}}
        <img
          src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABIAAAASCAYAAABWzo5XAAAAAXNSR0IArs4c6QAAAPFJREFUOE/l00ELAUEUB/D/+xbU+hx8iVVakfakbR1IUXwAuW1KJOVir5s7x5X1UQgnTib2sKMhsi17mOvO9c37zeu9N8TYvRAEwZSIUpA7R4DqdL3ejgBkkffTBwFxuULCWUmCXNfF5XKGphUjrfN9H5PJGKVSGYqSCcUjPWo2G7DtOYbDEUyz9rksEF2vYLVawnEWUNV8PMQYg6YVsN16H+wb6fX66HS6kWp/Tu0bs6wB1mv3Wck/RKh/x//GPG/zfD0OiYVEUGCGUUU2m0Or1Y7d2yQtpOwHFj3aAVBkgVce3wtIBTADkJbBOOcnIjIfQwCcTYE0ey4AAAAASUVORK5CYII="
        />
      </div>
    </div>

    <div class="content">
      <el-tabs
        v-model="activeName"
        @tab-click="handleClick"
        class="exchange-tabs"
      >
        <el-tab-pane label="充值" name="first" class="account">
          <div class="recharge">
            <div class="inp">
              <el-input
                v-model="reChargeForm.amount"
                placeholder="请输入金额"
                class="coin-input"
              >
                <el-button type="text" slot="suffix" class="text-button">
                  USD
                </el-button>
              </el-input>
            </div>

            <div class="balance" style="">
              <p>可用 <label>{{usdBal}} USD</label></p>
              <p class="max">限额 ({{rechargeLimit.cardRechargeMin}} USD ~ {{rechargeLimit.cardRechargeMax}} USD)</p>
            </div>

            <el-button type="primary" :disabled="isUsed" @click="handleCharge">确认</el-button>
          </div>
        </el-tab-pane>
<!--        <el-tab-pane label="提现" name="second" class="exchange">-->
<!--          <div class="recharge">-->
<!--            <div class="inp">-->
<!--              <el-input-->
<!--                v-model="withdrawalValue"-->
<!--                placeholder="请输入金额"-->
<!--                class="coin-input"-->
<!--              >-->
<!--                <el-button type="text" slot="suffix"> 全部 </el-button>-->
<!--                <el-button type="text" slot="suffix" class="text-button">-->
<!--                  USD-->
<!--                </el-button>-->
<!--              </el-input>-->
<!--            </div>-->

<!--            <div class="balance" style="">-->
<!--              <p>卡余额 </p>-->
<!--              <p class="max">0.00 USD</p>-->
<!--            </div>-->

<!--            <el-button type="primary">确认</el-button>-->
<!--          </div>-->
<!--        </el-tab-pane>-->
      </el-tabs>
    </div>

    <div class="detail">
      <p class="title">明细</p>
<!--      <p class="total_money">-->
<!--        <label style="">充值总金额</label>-->
<!--        <label style="display: none">提现总金额</label>-->
<!--        <span>$ 20.00</span>-->
<!--      </p>-->

      <ul class="detail_b">
        <li v-for="(item,index) in transList" :key="index">
          <p class="info_t">
            <span>卡片充值</span>
            <!---->
            <label class="success">
                  <dict-tag :options="dict.type.bus_trans_status" :value="item.transStatus"/>
            </label>
          </p>
          <ul class="info_b">
            <li>
              <label>金额</label>
              <span>{{item.transAmt}} USD</span>
            </li>
            <li>
              <label>手续费</label>
              <span>{{item.transFee}} USD</span>
            </li>
            <li>
              <label>时间</label>
              <span>{{item.transTime}}</span>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import {getCardInfo,queryBalance,cardRecharge} from "@/api/custom/opencard";
import {getBalance} from "@/api/custom/exchange";
import {getTrans} from "@/api/custom/trans";

  export default {
    dicts: ['bus_trans_status'],
    props: ['card'],
    data() {
      return {
        activeName: 'first',
        input: '',
        withdrawalValue: '',
        cardVal: {},
        isUsed: false,
        // usdtBal: 0,
        // eurBal: 0,
        // eur2UsdBal: 0,
        // totalAmount: 0,
        usdBal: 0,
        cardBal: 0,
        rechargeLimit: {},
        reChargeForm: {
          amount: 0,
          uocId: null
        },
        transForm: {
          transType: 'R',
          uocId: '0'
        },
        transList: []
      }
    },
    created() {
      this.getBal();
    },
    mounted () {
      this.cardVal = this.$route.params.card
      this.reChargeForm.uocId = this.cardVal.uocId;
      this.transForm.uocId = this.cardVal.uocId;
      this.getCardLimitMethod();
      this.getCardBal();
      this.getRechargeTrans();
      console.log(this.cardVal);
    },
    methods: {
      getCardLimitMethod() {
        this.loading = true;
        console.log(this.cardVal);
        getCardInfo(this.cardVal.uocId).then(response => {
          this.rechargeLimit = response.data;
          this.loading = false;
        });
      },

      getBal() {
        getBalance().then(res => {
          if (res.code == 200) {
            this.usdBal = res.data.balanceUsd;
            // this.usdtBal = res.data.balanceUsdt;
            // this.eurBal = res.data.balanceEur;
            // this.changeAmtForm.sourceAmount = res.data.balanceEur;
          }
        });
      },

      getCardBal() {
        queryBalance(this.cardVal.uocId).then(res => {
          if (res.code == 200) {
            this.cardBal = res.data.balance;
          }
        });
      },

      handleCharge() {
        if (this.reChargeForm.amount < this.rechargeLimit.cardRechargeMin
          || this.reChargeForm.amount > this.rechargeLimit.cardRechargeMax) {
          this.$message("充值金额不在限额范围内，请检查！");
          return;
        }
        this.isUsed = true;
        cardRecharge(this.reChargeForm).then(res => {
          if (res.code == 200) {
            this.$message("处理中，请稍后查询！")
          }
        });
      },

      getRechargeTrans() {
        getTrans(this.transForm).then(res => {
          if (res.code == 200) {
            this.transList = res.rows;
          }
        });
      },

      goBack() {
        this.$router.push('account')
      },

      handleClick(tab, event) {
        console.log(tab, event)
      }
    }
  }
</script>

<style lang="less" scoped>
  .pc {
    .pc_back {
      display: flex;
      align-items: center;
      font-size: 16px;
      margin-bottom: 32px;
      font-weight: 700;
      color: #333;
      cursor: pointer;
      i {
        margin-right: 10px;
      }
    }
    .card_balance {
      width: 100%;
      height: 68px;
      border: 1px solid #eaeaea;
      background: #fff;
      cursor: pointer;
      border-radius: 4px;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 0 10px;
      .card_balance_l {
        padding-left: 46px;
        position: relative;
        p {
          font-size: 12px;
          font-weight: 400;
          color: #6f7590;
          margin-bottom: 3px;
        }
        div {
          font-size: 16px;
          font-weight: 700;
          color: #000;
        }
        img {
          position: absolute;
          top: 0;
          left: 0;
        }
      }
      .card_balance_r {
        font-size: 12px;
        font-weight: 700;
        color: #6f7590;
        img {
          vertical-align: bottom;
          margin-left: 11px;
          width: 18px;
        }
      }
    }
    .content {
      border: 1px solid #eaeaea;
      padding: 16px 16px 10px;
      margin-top: 11px;
      .recharge {
        display: flex;
        flex-direction: column;
        .inp {
          border-bottom: 1px solid #ededed;
          margin-bottom: 10px;
        }
        .balance {
          font-size: 12px;
          font-weight: 700;
          color: #333;
          display: flex;
          justify-content: space-between;
          margin-bottom: 21px;
          label {
            color: #6f7590;
            margin-left: 8px;
          }
          .max {
            font-size: 10px;
            font-weight: 400;
            color: #6f7590;
          }
        }
      }
    }
    .detail {
      width: 100%;
      background: #fff;
      margin-top: 10px;
      margin-left: -16px;
      border-radius: 4px;
      .title {
        width: 100%;
        height: 42px;
        line-height: 42px;
        padding-left: 16px;
        font-weight: 700;
        font-size: 14px;
        color: #333;
      }
      .total_money {
        width: 100%;
        height: 38px;
        background: #f7f7f7;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 0 20px;
        font-size: 12px;
        label {
          font-weight: 400;
          color: #333;
        }
        span {
          font-weight: 700;
          color: #04a875;
        }
      }
      .detail_b {
        padding: 0 16px;
        & > li {
          padding: 16px 0;
          border-bottom: 1px solid #f5f5f8;
          .info_t {
            font-size: 14px;
            font-weight: 700;
            color: #333;
            margin-bottom: 8px;
            display: flex;
            justify-content: space-between;
            .success {
              font-weight: 400;
              color: #04a875;
              position: relative;
            }
          }
          .info_b {
            display: flex;
            justify-content: space-between;
            & > li {
              font-size: 12px;
              font-weight: 400;
              color: #6f7590;
              margin-bottom: 4px;
              label {
                color: #6f7590;
                display: block;
              }
              span {
                color: #333;
                text-align: right;
              }
            }
          }
        }
      }
    }
  }
</style>
<style lang="less">
  .text-button {
    color: #000;
    font-weight: 700;
  }
  .coin-input {
    .el-input__inner {
      border: 0;
    }
  }
  .exchange-tabs {
    .el-tabs__nav-wrap::after {
      background: transparent !important;
    }
  }
</style>
