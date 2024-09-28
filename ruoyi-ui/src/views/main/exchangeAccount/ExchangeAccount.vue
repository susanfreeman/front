<template>
  <div class="exchange">
    <div class="pc">
      <el-tabs
        v-model="activeName"
        @tab-click="handleClick"
        class="exchange-tabs"
      >
        <el-tab-pane label="钱包" name="first" class="account">
          <div class="balance_t">Total Balance</div>
          <div class="balance_b">
            <div class="money">$ {{ totalAmount }}</div>
            <div class="exchange" @click="swicthExchange">
              <img src="../../../assets/icon-15.png" alt="" />
              Exchange
            </div>
          </div>
          <div class="coin">
            <div @click="handleDepositCoins">
              充币
              <img src="../../../assets/icon-16.png" alt="" />
            </div>
            <div @click="handleWithdrawal">
              提币
              <img src="../../../assets/icon-17.png" alt="" />
            </div>
          </div>

          <ul class="list">
            <p class="list_t">我的资产</p>
            <li>
              <div class="list_l">
                <img src="../../../assets/newlogo-1.png" alt="" class="icon" />
                <span>USDT</span>
              </div>
              <div class="list_r">
                <div>{{ usdtBal }}</div>
                <p>$ {{ usdtBal }}</p>
              </div>
            </li>

            <li>
              <div class="list_l">
                <img src="../../../assets/newlogo-2.png" alt="" class="icon" />
                <span>USD</span>
              </div>
              <div class="list_r">
                <div>{{ usdBal }}</div>
                <p>$ {{ usdBal }}</p>
              </div>
            </li>

            <!-- <li>
              <div class="list_l">
                <img src="../../../assets/newlogo-3.png" alt="" class="icon" />
                <span>GBP</span>
              </div>
              <div class="list_r">
                <div>0.00</div>
                <p>￥ 0.00</p>
              </div>
            </li> -->

            <li>
              <div class="list_l">
                <img src="../../../assets/newlogo-1.png" alt="" class="icon" />
                <span>EUR</span>
              </div>
              <div class="list_r">
                <div>{{ eurBal }}</div>
                <p>$ {{ eur2UsdBal }}</p>
              </div>
            </li>
          </ul>
        </el-tab-pane>
        <el-tab-pane label="实时兑换" name="second" class="exchange">
          <div class="pay">
            <div>
              <p class="title">支付 {{ payObj.name }}</p>
              <div class="coin">
                <div class="coin_l">
                  <img
                    :src="payObj.img"
                    alt=""
                    class="coin_img"
                    @click="openPayment('支付')"
                  />
                  <img
                    src="../../../assets/down.png"
                    alt=""
                    class="pay_arrow_bottom"
                    @click="openPayment('支付')"
                  />
<!--                  <el-input v-model="getChangeAmtForm.sourceCurr" placeholder="0.00" @change="getTaExchange"  class="num" ></el-input>-->
                  <input v-model="getChangeAmtForm.sourceAmount" type="text" placeholder="0.00"  @change="getTaExchange" class="num" />
                </div>
                <img src="../../../assets/max.png" alt="" class="coin_r" @click="handleMax"/>
              </div>
              <p class="balance">余额({{payExchargeBal}})</p>

              <div class="line">
                <img @click="exchangeEvent" src="../../../assets/change.png" alt="" />
              </div>

              <p class="title">得到 {{ haveObj.name }}</p>
              <div class="coin">
                <div class="coin_l">
                  <img
                    :src="haveObj.img"
                    alt=""
                    class="coin_img"
                    @click="openPayment('得到')"
                  />
                  <img
                    src="../../../assets/down.png"
                    alt=""
                    class="pay_arrow_bottom"
                    @click="openPayment('得到')"
                  />
                  <input type="text" placeholder="0.00" v-model="getRechargeTargetAmount" class="num" />
                </div>
                <!-- <img src="../../../assets/max.png" alt="" class="coin_r" /> -->
              </div>

              <p class="balance">余额({{getExchargeBal}})</p>
              <p class="exchange">1 USDT ≈ 1 USD</p>
            </div>
            <div class="button">
              <el-button type="primary" @click="centerDialogVisible = true"
                >兑换</el-button
              >
            </div>
          </div>
          <div class="log" @click="gotoexchangeLog">
            兑换记录
            <i class="el-icon-arrow-right"></i>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>

    <el-dialog
      title="币种"
      :visible.sync="visible"
      :width="isMobile ? '90%' : '30%'"
      center
    >
      <ul class="list list2">
        <li @click="goToUSDT">
          <div class="list_l">
            <img
              src="../../../assets/newlogo-1.png"
              alt=""
              class="icon opacity2"
            />
            <span>
              <span class="opacity2">USDT/USDC</span>
            </span>
          </div>
          <div class="list_r">
            <div class="opacity2">{{ usdtBal }}</div>
            <p class="opacity2">$ {{ usdtBal }}</p>
          </div>
        </li>

        <li class="opacity">
          <div class="list_l">
            <img
              src="../../../assets/newlogo-2.png"
              alt=""
              class="icon opacity2"
            />
            <span>
              <span class="opacity2">USD</span>
            </span>
          </div>
          <div class="list_r">
            <div class="opacity2">{{ usdBal }}</div>
            <p class="opacity2">$ {{ usdBal }}</p>
          </div>
        </li>

        <!--        <li class="opacity">-->
        <!--          <div class="list_l">-->
        <!--            <img-->
        <!--              src="../../../assets/newlogo-3.png"-->
        <!--              alt=""-->
        <!--              class="icon opacity2"-->
        <!--            />-->
        <!--            <span>-->
        <!--              <span class="opacity2">GBP</span>-->
        <!--            </span>-->
        <!--          </div>-->
        <!--          <div class="list_r">-->
        <!--            <div class="opacity2">0.00</div>-->
        <!--            <p class="opacity2">$ 0.00</p>-->
        <!--          </div>-->
        <!--        </li>-->

        <li class="opacity">
          <div class="list_l">
            <img
              src="../../../assets/newlogo-4.png"
              alt=""
              class="icon opacity2"
            />
            <span>
              <span class="opacity2">EUR</span>
            </span>
          </div>
          <div class="list_r">
            <div class="opacity2">{{ eurBal }}</div>
            <p class="opacity2">$ {{ eur2UsdBal }}</p>
          </div>
        </li>
      </ul>
    </el-dialog>

    <el-dialog
      title="提示"
      :visible.sync="centerDialogVisible"
      :width="isMobile ? '90%' : '20%'"
      center
    >
      <div
        style="
          margin: 0 auto;
          font-size: 20px;
          color: #000;
          font-weight: 700;
          text-align: center;
        "
      >
        是否兑换
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="centerDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleExchange"
          >确 定</el-button
        >
      </span>
    </el-dialog>

    <el-dialog
      :title="payTitle"
      :visible.sync="paymentVisible"
      :width="isMobile ? '90%' : '30%'"
      center
    >
      <ul class="list list2">
        <li
          v-for="(item, index) in payList"
          :key="index"
          @click="handleSelectPay(item)"
        >
          <div class="list_l">
            <img :src="item.img" alt="" class="icon opacity2" />
            <span>
              <span class="opacity2">{{ item.name }}</span>
            </span>
          </div>
        </li>
      </ul>
    </el-dialog>
  </div>
</template>

<script>
import {
  change,
  getBalance,
  getRechargeAddr,
  getRechargeList,
  getTargetAmount,
} from "@/api/custom/exchange";
import { mapGetters } from "vuex";

export default {
  data() {
    return {
      activeName: "first",
      visible: false,
      current: 1,
      centerDialogVisible: false,
      usdtBal: 0,
      usdBal: 0,
      eurBal: 0,
      eur2UsdBal: 0,
      totalAmount: 0,
      changeAmtForm: {
        sourceCurr: "EUR",
        targetCurr: "USD",
        sourceAmount: 0,
      },

      getChangeAmtForm: {
        sourceCurr: "EUR",
        targetCurr: "USD",
        sourceAmount: '',
      },

      paymentVisible: false,
      payTitle: "",
      payList: [
        {
          img: require("../../../assets/newlogo-1.png"),
          name: "USDT",
        },
        {
          img: require("../../../assets/newlogo-2.png"),
          name: "USD",
        },
        {
          img: require("../../../assets/newlogo-4.png"),
          name: "EUR",
        },
      ],
      payObj: {
        img: require("../../../assets/newlogo-1.png"),
        name: "USDT",
      },
      haveObj: {
        img: require("../../../assets/newlogo-4.png"),
        name: "EUR",
      },
      getRechargeTargetAmount: 0,
      payExchargeBal: 0,
      getExchargeBal: 0
    };
  },
  created() {
    this.getBal();
  },
  computed: {
    ...mapGetters(["isMobile"]),
  },
  methods: {
    getBal() {
      getBalance().then((res) => {
        if (res.code == 200) {
          this.usdtBal = res.data.balanceUsdt;
          this.usdBal = res.data.balanceUsd;
          this.eurBal = res.data.balanceEur;
          this.changeAmtForm.sourceAmount = res.data.balanceEur;
          this.getTa();
        }
      });
    },
    getTa() {
      getTargetAmount(this.changeAmtForm).then((res) => {
        // console.log(res);
        if (res.code == 200) {
          this.eur2UsdBal = res.data;
          this.calculamount();
        }
      });
    },
    handleMax() {
      this.getChangeAmtForm.sourceAmount = this.payExchargeBal;
      this.getTaExchange();
    },
    getTaExchange() {
      this.getChangeAmtForm.sourceCurr = this.payObj.name;
      this.getChangeAmtForm.targetCurr = this.haveObj.name;
      console.log(this.getChangeAmtForm);
      getTargetAmount(this.getChangeAmtForm).then((res) => {
        console.log(res);
        if (res.code == 200) {
          this.getRechargeTargetAmount = res.data;
        }
      });
    },
    calculamount() {
      this.totalAmount = this.usdtBal + this.usdBal + this.eur2UsdBal;
    },
    handleClick(tab, event) {
      this.changeCurr("USDT", "pay");
      this.changeCurr("EUR", "have");
    },

    swicthExchange() {
      this.activeName = "second";
    },

    //充币
    handleDepositCoins() {
      this.current = 1;
      this.visible = true;
    },

    //提币
    handleWithdrawal() {
      this.current = 2;
      this.visible = true;
    },

    //前往充币
    goToUSDT() {
      if (this.current == 1) {
        this.$router.push("/home/exchange-account/coin-charge");
      } else if (this.current == 2) {
        this.$router.push("/home/exchange-account/coin-withdrawal");
      }
    },

    gotoexchangeLog() {
      this.$router.push("/home/exchange-account/exchangeLog");
    },
    openPayment(type) {
      this.paymentVisible = true;
      this.payTitle = type;
    },
    handleSelectPay(item) {
      // console.log(item)
      switch (this.payTitle) {
        case "支付":
          this.payObj = item;
          this.changeCurr(this.payObj.name,"pay")
          break;

        case "得到":
          this.haveObj = item;
          this.changeCurr(this.haveObj.name,"have")
          break;
      }
      this.paymentVisible = false
    },
    changeCurr(curr,filed) {
      switch (curr){
        case "EUR":
          if (filed == "pay") {
            this.payExchargeBal = this.eurBal;
          }
          else {
            this.getExchargeBal = this.eurBal;
          }
          break;
        case "USDT":
          if (filed == "pay") {
            this.payExchargeBal = this.usdtBal;
          }
          else {
            this.getExchargeBal = this.usdtBal;
          }
          break;
        case "USD":
          if (filed == "pay") {
            this.payExchargeBal = this.usdBal;
          }
          else {
            this.getExchargeBal = this.usdBal;
          }
          break;
      }
    },
    //互换
    exchangeEvent() {
      let savePay = JSON.parse(JSON.stringify(this.payObj))
      this.payObj = JSON.parse(JSON.stringify(this.haveObj))
      this.haveObj = savePay
      this.changeCurr(this.payObj.name,"pay")
      this.changeCurr(this.haveObj.name, "have");
      // this.handleMax();
      this.getTaExchange();
    },
    handleExchange() {
      this.centerDialogVisible = false;
      if (this.payExchargeBal < this.getChangeAmtForm.sourceAmount) {
        this.$message("余额不足，请先充值！");
        return;
      }
      change(this.getChangeAmtForm).then((res) => {
        this.$message(res.msg);
      });
    }
  },
};
</script>

<style lang="less" scoped>
.exchange {
  height: 100%;
  .pc {
    .account {
      .balance_t {
        font-size: 12px;
        font-weight: 400;
        line-height: 30px;
        margin: 0px 0 10px;
        color: #000;
      }
      .balance_b {
        margin-bottom: 32px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        .money {
          font-size: 32px;
          font-weight: 700;
          color: #333;
        }
        .exchange {
          width: 89px;
          height: 26px;
          line-height: 26px;
          background: #1a72ff;
          border-radius: 13px;
          font-size: 12px;
          font-weight: 700;
          cursor: pointer;
          color: #fff;
          text-align: center;
          img {
            vertical-align: middle;
            margin-right: 3px;
          }
        }
      }
      .coin {
        display: flex;
        justify-content: center;
        margin-bottom: 32px;
        div {
          display: flex;
          justify-content: center;
          width: 162px;
          height: 44px;
          background: #fff;
          border: 1px solid #e5e5e5;
          border-radius: 100px;
          align-items: center;
          cursor: pointer;
          font-size: 14px;
          font-weight: 700;
          color: #333;
          img {
            margin-left: 20px;
          }
        }
        div:first-child {
          margin-right: 12px;
        }
      }
      .list {
        width: calc(100% + 32px);
        min-height: calc(100vh - 324px);
        margin-left: -16px;
        background: #fff;
        border-radius: 4px 4px 0 0;
        padding: 0 16px;
        .list_t {
          width: 100%;
          height: 42px;
          line-height: 42px;
          font-size: 12px;
          font-weight: 700;
          color: #333;
        }
        li {
          width: 100%;
          height: 72px;
          cursor: pointer;
          border-bottom: 1px solid #eaeaea;
          display: flex;
          justify-content: space-between;
          .list_l {
            display: flex;
            align-items: center;
            font-size: 16px;
            font-weight: 700;
            color: #333;
            .icon {
              width: 40px;
              height: 40px;
              margin-right: 16px;
            }
            span {
              cursor: pointer;
            }
          }
          .list_r {
            text-align: right;
            padding-top: 20px;
            font-size: 16px;
            font-weight: 700;
            color: #333;
            p {
              font-size: 12px;
              font-weight: 500;
              color: #6f7590;
            }
          }
        }
      }
    }
    .exchange {
      .pay {
        width: 100%;
        height: 376px;
        background: #fff;
        padding: 16px;
        border: 1px solid #eaeaea;
        border-radius: 2px;
        & > div {
          .title {
            font-weight: 400;
            color: #333;
            font-size: 12px;
            margin-bottom: 10px;
          }
          .coin {
            display: flex;
            align-items: center;
            width: 100%;
            height: 66px;
            justify-content: space-between;
            .coin_l {
              display: flex;
              align-items: center;
              .coin_img {
                width: 36px;
                cursor: pointer;
              }
              .pay_arrow_bottom {
                width: 18px;
                height: 18px;
                margin-right: 10px;
              }
              .num {
                width: 200px;
                font-weight: 700;
                font-size: 22px;
                border: none;
                outline: none;
              }
            }
            .coin_r {
              cursor: pointer;
            }
          }
          .balance {
            font-size: 12px;
            font-weight: 400;
            color: #6f7590;
          }
          .line {
            width: 100%;
            height: 1px;
            background: #e8e8f0;
            margin: 20px 0;
            position: relative;
            img {
              position: absolute;
              right: 0;
              top: -20px;
              cursor: pointer;
            }
          }
          .exchange {
            font-size: 12px;
            font-weight: 700;
            color: #333;
            margin: 10px 0 20px;
          }
        }
        .button {
          width: 100%;
          display: flex;
          button {
            width: 100%;
          }
        }
      }
      .log {
        font-size: 12px;
        font-weight: 400;
        color: #1a72ff;
        text-align: center;
        margin-top: 32px;
        margin-bottom: 60px;
        cursor: pointer;
        i {
          margin-left: 4px;
        }
      }
    }
  }
}
.list {
  background: #fff;
  border-radius: 4px 4px 0 0;
  padding: 0 16px;
}
.list2 {
  width: 100%;
  height: auto;
  min-height: auto;
  margin-left: 0;
  margin-bottom: 0;
  padding-bottom: 80px;
  li {
    width: 100%;
    height: 72px;
    cursor: pointer;
    border-bottom: 1px solid #eaeaea;
    display: flex;
    justify-content: space-between;
    font-weight: 700;
    .list_l {
      display: flex;
      align-items: center;
      font-size: 16px;
      font-weight: 700;
      color: #333;
      .icon {
        width: 40px;
        height: 40px;
        margin-right: 16px;
      }
      span {
        cursor: pointer;
      }
    }
    .list_r {
      text-align: right;
      padding-top: 20px;
      font-size: 16px;
      font-weight: 700;
      color: #333;
      p {
        font-size: 12px;
        font-weight: 500;
        color: #6f7590;
      }
    }
  }
  .opacity {
    .opacity2 {
      opacity: 0.39;
    }
  }
}
</style>
<style lang="less">
.exchange-tabs {
  .el-tabs__nav-wrap::after {
    background: transparent !important;
  }
}
</style>
