<template>
  <div class="pc">
    <span class="pc_back" @click="goBack"> 
      <i class="el-icon-back"></i>
      权益
    </span>

    <div class="card">
      <img src="../../../assets/20240823-9.png" alt="" class="visa_img" />

      <p class="high">订阅卡<span>预付卡</span></p>
      <div class="visa_info">
        <p class="num">4767 1500 6751 3281</p>
      </div>

      <img src="../../../assets/banklogo-9.png" alt="" class="master_logo" />
    </div>

    <div class="programme">
      <div class="rights">
        <div class="rights_content">
          <img src="../../../assets/icon-11.png" alt="" />
          <div>
            <p class="word1">月费</p>
            <p class="word2">1.00 USD</p>
          </div>
        </div>

        <div class="rights_content">
          <img src="../../../assets/icon-12.png" alt="" />
          <div>
            <p class="word1">充值上限</p>
            <p class="word2">500.00 USD</p>
          </div>
        </div>

        <div class="rights_content">
          <img src="../../../assets/icon-13.png" alt="" />
          <div>
            <p class="word1">卡片充值费用</p>
            <p class="word2">2.50%</p>
            <p class="word2">(Min 1USD)</p>
          </div>
        </div>

        <div class="rights_content">
          <img src="../../../assets/icon-14.png" alt="" />
          <div>
            <p class="word1">消费手续费</p>
            <p class="word2">0.5USD/笔（消费<1.01USD收取）</p>
          </div>
        </div>
      </div>
    </div>

    <div class="know">
      <p>用卡须知</p>
      <div>
        1、因资金不足导致授权失败累计达到10次，卡片将被冻结；
        <br />
        2、卡片的总授权失败率超过20%，卡片将被冻结；
        <br />
        3、卡片需支付0.5美元的每笔授权失败罚金方能解冻；
        <br />
        4、单笔消费≤1美元的交易，将收取每笔0.5美元的手续费;
        <br />
        5、申请无需KYC，卡片资金上限为500USD。
      </div>
    </div>

    <div class="jump">
      <div>
        <p class="tips">完成身份认证,免费升级为 <span>高级卡</span></p>
        <el-button type="primary" class="button0" round>去认证</el-button>
      </div>
      <div class="cancellation">注销卡片</div>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
        return {

        }
    },

    methods: {
        goBack() {
            this.$router.push("account")
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
    .card {
      width: 343px;
      height: 179px;
      margin: 0 auto;
      position: relative;
      .high {
        position: absolute;
        top: 26px;
        left: 24px;
        font-size: 16px;
        font-weight: 700;
        color: #fff;
        span {
          display: block;
          font-size: 12px;
          font-weight: 400;
          margin-top: 4px;
        }
      }
      .visa_img {
        width: 100%;
        height: 100%;
      }
      .visa_info {
        position: absolute;
        left: 0;
        font-size: 14px;
        color: #fff;
        bottom: 18px;
        padding-left: 24px;
        z-index: 1;
        .num {
          font-family: qiqi;
          letter-spacing: 2px;
        }
      }
      .master_logo {
        width: 45px !important;
        height: 32px !important;
        position: absolute;
        bottom: 12px;
        right: 20px;
        z-index: 1;
      }
    }
    .programme {
      width: 343px;
      margin: 0 auto;
      background: #fff;
      padding: 20px 16px;
      position: relative;
      z-index: 1;
      border-radius: 16px 16px 0 0;
      .rights {
        display: flex;
        flex-wrap: wrap;
        .rights_content {
          margin-bottom: 16px;
          display: flex;
          width: 50%;
          div {
            margin-left: 10px;
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            .word1 {
              font-size: 12px;
              font-weight: 400;
              color: #6f7590;
            }
            .word2 {
              font-weight: 700;
              color: #333;
            }
          }
        }
      }
    }

    .know {
      width: 343px;
      margin: 10px auto 130px;
      padding: 16px;
      background: #fff1de;
      border-radius: 4px;
      p {
        font-size: 12px;
        font-weight: 700;
        color: #c17613;
        margin-bottom: 10px;
      }
      div {
        font-size: 10px;
        font-weight: 400;
        color: #c17613;
        margin-bottom: 4px;
      }
    }
    .jump {
      width: 375px;
      border-top: 1px solid #e8e9eb;
      padding: 16px;
      margin: 0 auto;
      position: relative;
      .tips {
        width: 100%;
        position: absolute;
        top: -40px;
        left: 0;
        font-size: 12px;
        font-weight: 400;
        color: #333;
        margin-top: 10px;
        text-align: center;
        span {
          color: #2b5ef0;
        }
      }
      .button0 {
        margin: 0 auto 10px;
        width: calc(100% - 32px);
      }
      .cancellation {
        width: 100%;
        font-size: 14px;
        font-weight: 700;
        color: #e53e3e;
        cursor: pointer;
        text-align: center;
      }
    }
  }
</style>
