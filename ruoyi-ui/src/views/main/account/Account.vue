<template>
  <div class="account">
    <div class="account_l">
      <div class="item" @click="goToCreated">
        <img src="../../../assets/20240823-9.png" alt="" class="visa_img" />

        <div class="login">
          <p class="word">申请卡</p>
          <i class="el-icon-arrow-right"></i>
        </div>

        <img src="../../../assets/banklogo-7.png" alt="" class="visa_master" />
      </div>

      <div class="item" v-for="(item,index) in cardList" :key="index" @click="selectCardDiv(index)">
        <img src="../../../assets/20240823-9.png" alt="" class="visa_img" />
        <img src="../../../assets/banklogo-6.png" alt="" class="master_logo2" />

        <div class="login">
          <div class="balance">
            $ *** 查看
            <span>如何充值</span>
          </div>
        </div>

        <div class="visa_info">
          <p class="num">{{item.cardNo}}</p>
          <div>
            <p class="name">
              <span>{{item.firstName}} {{item.lastName}}</span>
              <span class="expiry">Expiry {{item.expire}}</span>
              <span class="expiry">cvv {{item.cvv}}</span>
            </p>
          </div>
        </div>

        <p class="card_type_word" >
          Subscription
          <i class="el-icon-arrow-right"></i>
        </p>
      </div>
    </div>

    <div class="account-carousel" >
      <el-carousel :autoplay="false" arrow="always" class="" @change="selectCard">
        <el-carousel-item>
          <div class="item" @click="goToCreated">
            <img src="../../../assets/20240823-9.png" alt="" class="visa_img" />

            <div class="login">
              <p class="word">申请卡</p>
              <i class="el-icon-arrow-right"></i>
            </div>

            <img
              src="../../../assets/banklogo-7.png"
              alt=""
              class="visa_master"
            />
          </div>
        </el-carousel-item>

        <el-carousel-item v-for="(item,index) in cardList" :key="index">
          <div class="item">
            <img src="../../../assets/20240823-9.png" alt="" class="visa_img" />
            <img
              src="../../../assets/banklogo-6.png"
              alt=""
              class="master_logo2"
            />

            <div class="login">
              <div class="balance">
                $ *** 查看
                <span>如何充值2</span>
              </div>
            </div>

            <div class="visa_info">
              <p class="num">{{item.cardNo}}</p>
              <div>
                <p class="name">
                  <span>{{item.firstName}} {{item.lastName}}</span>
                  <span class="expiry">Expiry: {{item.expire}}</span>
                  <span class="expiry">cvv: {{item.cvv}}</span>
                </p>
              </div>
            </div>

            <p class="card_type_word">
              Subscription
              <i class="el-icon-arrow-right"></i>
            </p>
          </div>
        </el-carousel-item>
      </el-carousel>
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
          <div class="content">{{card.cardNo}}</div>
        </li>

        <li>
          <p>Expire date</p>
          <div class="content">{{card.expire}}</div>
        </li>

        <li>
          <p>CVV安全码</p>
          <div class="content">{{card.cvv}}</div>
        </li>

        <li>
          <p>Card holder</p>
          <div class="content">{{card.firstName}} {{card.lastName}}</div>
        </li>
      </ul>

      <div class="menu">
        <div class="choose">
          <div @click="gotoCoinTransfer">
            <img src="../../../assets/icon-1.png" alt="" />
            <p>充值</p>
          </div>

<!--          <div @click="gotoCoinTransfer">-->
<!--            <img src="../../../assets/icon-2.png" alt="" />-->
<!--            <p>提现</p>-->
<!--          </div>-->

          <div @click="getCvv">
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

        <div class="no_data" style="">
          <img
            src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAYAAACOEfKtAAAC6UlEQVR4Xu3c326TUBwH8N8BapdWa8wuzJwPoDHemrjXMNubzJfYm0yfwwvvjRdbshv3pxeNi7a1FDgY5lYnQjmnX1po+ZL0Cr5w+PCDc4AGJZwgAQWlGRYCgkVAQAKCAmC8tAr8enq+F0dyCLanFvFIy9Hrl7ufTBpTGuCXk2/7KlbHJhut+zKxjg9evXj+waSdBMxQIqBJ6cxZhoAEBAXAOCuQgKAAGF9KBfb7g7eROO9z26blWRCFb8C2W8evf4yl5XnWuXmBJQFev9MSfyy1pSWs7PTsSnqPOtJqlYfYKMCTs6ubJyK9Xqe0SmwcYFLISsmfSizhdG4kYJmIjQUsC7HRgGUgVgI4DSIZjf3MfrXbacuDljubNxz5EoRR5rJPHnes+uakE8makGsiAW9FF0Uk4L2SXASRgKlz2haRgBkXRRtEAuZ0Q6aIlQCGYSQTP8xs+lbbE8/72wv/mgQSRTpz2YfdtlUvfNH/LmGoJTZMuY6Sbmdr7tJLAby8HOyL49TypdHPkS86RzCpOs91bn5u8nOUDMe+BEH2MCqRbRzgcDyV6FbQUUpcV83QHOf/92YETJ2AySA+mZIqywJLn68ENLze5S1GQAKCAmCcFUhAUACMswIJCAqAcVbgJgJqHUuYc38L7q91vGhAXcsKnPdI31oADKRfIazFnQgBC4560dMYAoKA854HgmekdTz9/HEtTmHrvawwUMtOpEIP600T0Jrs3wABCQgKgHFW4CYCchgDjgM5kCbgTKCS98KsQLAC+TgLBAQ7xpXGOYwBuQlIQFAAjLMCCQgKgPFaViDHgeAwhoAE5K3cncBavhcGr+srjdeyE1mpALgxAoKA48n0sz8JL/JWs5SPjxX9MwHcp9XGtT7Y2dk2+rhYUcOMPz5GwGxKAhaVWMF8AhJwAQFeAxdAux8h4BoCnvcHe0qcjfjIbCz6aPfpttFHZosOlXEnUrSips4nIHjkCUhAUACMswJBwN92tiSN4UlkyAAAAABJRU5ErkJggg=="
          />
          <p>没有记录</p>
        </div>
      </div>
    </div>

    <el-dialog title="安全验证" :visible.sync="visible" :width="isMobile ? '90%' : '25%'" center>
      <el-form :model="form" ref="form" label-position="top">
        <el-form-item
          label=""
          prop="verifyCode"
          :rules="[
            { required: true, message: '请输入验证码', trigger: 'blur' },
          ]"
        >
          <el-input v-model="form.verifyCode" placeholder="邮箱验证码">
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
          prop="confirm2fa"
          :rules="[
            { required: true, message: '请输入验证码', trigger: 'blur' },
          ]"
        >
          <el-input v-model="form.confirm2fa" placeholder="谷歌验证码">
            <el-button type="text" slot="suffix"> 如何获取？ </el-button>
          </el-input>
        </el-form-item>
      </el-form>

      <div style="text-align: center">
        <el-button type="primary" @click="showCardInfo" style="width: 50%">
          确 认
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import {userCardList,cardInfoBy2fa} from "@/api/custom/opencard";
import {captchaEmail} from "@/api/login";

export default {
  data() {
    return {
      loading: false,
      visible: false,
      isSelectCard: false,
      index: 0,
      form: {
        verifyCode: "",
        confirm2fa: "",
        uocId: "",
        uuid: ""
      },
      cardList: [],
      codeDisabled: false,
      card: {},
      codeInput: "获取验证码",
      time: 60,
      queryData: {
        cardStatus: "2"
      }
    };
  },
  created() {
    this.getOpenCardList();
  },
  computed: {
    ...mapGetters(["isMobile"]),
  },
  methods: {
    getCvv() {
      if (this.form.uocId == "") {
        this.$message("请先选择要查看的卡片");
        return;
      }
      this.visible = true;
    },
    getOpenCardList() {
      this.loading = true;
      userCardList(this.queryData).then(response => {
        // console.log(response)
        this.cardList = response.rows;
        this.loading = false;
        // this.selectCard(0);
      });
    },

    goToCreated() {
      this.$router.push("Created");
    },

    goToEquity() {
      // this.$router.push("");
      if (!this.isSelectCard) {
        this.$message('请先选择要充值的卡片');
        return;
      }
      this.$router.push({name:"Equity",params: {
          card: this.card
        }}
      );
    },

    //获取验证码
    getCode() {
      captchaEmail().then(response => {
        this.form.uuid = response.uuid;
        this.$message("邮件发送成功");
      });


      this.time = 60;
      this.codeInput = this.time + "s";
      this.codeDisabled = true;

      let timeEle = setInterval(() => {
        this.time--;

        this.codeInput = this.time + "s";
      }, 1000);

      setTimeout(() => {
        this.time = 0;
        this.codeInput = "再次发送";
        this.codeDisabled = false;

        clearInterval(timeEle);
        timeEle = null;
      }, 61000);
    },
    gotoCoinTransfer() {
      // this.$router.push("/home/account/coin-transfer");
      if (!this.isSelectCard) {
        this.$message('请先选择要充值的卡片');
        return;
      }
      this.$router.push({name:"coin-transfer",params: {
          card: this.card
        }}
      );
    },
    selectCard(index) {
      if (index > 0){
        this.card = this.cardList[index-1];
        this.form.uocId = this.card.uocId;
        this.isSelectCard = true;
        this.index = index;
        // console.log(this.card);
      }else {
        this.card = {};
      }
    },
    selectCardDiv(i) {
      this.selectCard(i + 1);
    },
    showCardInfo() {
      this.loading = true;
      cardInfoBy2fa(this.form).then(response => {
        this.cardList[this.index - 1] = response.data;
        this.card = response.data;
        this.loading = false;
        this.visible = false;
        this.$message(response.msg);
      });
    }
  },
};
</script>

<style lang="less" scoped>
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

.no_data {
  width: 100%;
  border-radius: 4px;
  overflow: hidden;
  img {
    display: block;
    margin: 66px auto 10px;
  }
  p {
    font-size: 12px;
    color: #333;
    text-align: center;
  }
}

// pc端
@media screen and (min-width: 600px) {
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
      overflow-y: scroll;
    }
    .account-carousel {
      display: none;
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
          content: "";
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
}

//移动端
@media screen and (max-width: 600px) {
  .account {
    display: flex;
    height: 100vh;
    width: 100%;
    margin: 0;
    border-radius: 0px;
    overflow-y: scroll;
    flex-direction: column;

    .account_l {
      display: none;
    }
    .account-carousel {
      width: 100%;
      padding: 20px 20px 0 20px;
      .item {
        height: 260px !important;
      }
    }

    .account_r {
      flex: auto;
      display: flex;
      flex-direction: column;
      // padding: 0 60px;
      // background: #fff;
      .card_title {
        display: none;
      }
      .card_info_pc {
        display: none;
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
        .choose {
          width: 100%;
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
        flex: auto;
        width: 100%;
        padding: 0 20px;
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
}
</style>

<style lang="less">
.account-carousel {
  .el-carousel__indicators--horizontal {
    width: 100%;
    text-align: center;
    .el-carousel__button {
      width: 6px;
      height: 4px;
    }
  }
}
</style>
