<template>
  <div class="pc">
    <div class="body">
      <div class="header">
        <span @click="goBack">
          <i class="el-icon-arrow-left"></i>
          返回
        </span>
      </div>

      <div class="main">
        <div class="item">
          <el-carousel :autoplay="false" arrow="always" class="create-carousel">
            <el-carousel-item>
              <div class="card-item">
                <img
                  src="../../../assets/20240823-9.png"
                  alt=""
                  class="visa_img"
                />

                <div class="login">
                  <img src="../../../assets/logo3.png" alt="" width="150" />
                </div>

                <div class="visa_info">
                  <p class="num">4767 15●● ●●●● ●●●●</p>
                  <div>
                    <p class="name">
                      <span>YOUR NAME</span>
                      <!-- <span class="expiry">Expiry 08/2026</span> -->
                    </p>
                  </div>
                </div>

                <img
                  src="../../../assets/visa.png"
                  alt=""
                  class="card_type_word"
                />
              </div>
            </el-carousel-item>
            <el-carousel-item>
              <div class="card-item">
                <img
                  src="../../../assets/20240823-9.png"
                  alt=""
                  class="visa_img"
                />

                <div class="login">
                  <img src="../../../assets/logo3.png" alt="" width="150" />
                </div>

                <div class="visa_info">
                  <p class="num">4767 15●● ●●●● ●●●●</p>
                  <div>
                    <p class="name">
                      <span>YOUR NAME</span>
                      <!-- <span class="expiry">Expiry 08/2026</span> -->
                    </p>
                  </div>
                </div>

                <img
                  src="../../../assets/visa.png"
                  alt=""
                  class="card_type_word"
                />
              </div>
            </el-carousel-item>
            <el-carousel-item>
              <div class="card-item">
                <img
                  src="../../../assets/20240823-9.png"
                  alt=""
                  class="visa_img"
                />

                <div class="login">
                  <img src="../../../assets/logo3.png" alt="" width="150" />
                </div>

                <div class="visa_info">
                  <p class="num">4767 15●● ●●●● ●●●●</p>
                  <div>
                    <p class="name">
                      <span>YOUR NAME</span>
                      <!-- <span class="expiry">Expiry 08/2026</span> -->
                    </p>
                  </div>
                </div>

                <img
                  src="../../../assets/visa.png"
                  alt=""
                  class="card_type_word"
                />
              </div>
            </el-carousel-item>
          </el-carousel>

          <!-- <img src="../../../assets/20240823-9.png" alt="" width="100%" /> -->

          <ul class="info">
            <li>
              <p>卡片类型</p>
              <div>预付卡</div>
            </li>

            <li>
              <p>币种</p>
              <div>USD</div>
            </li>

            <li>
              <p>地区</p>
              <div>美国</div>
            </li>
          </ul>

          <ul class="tips">
            <li>
              <p>支持消费场景</p>
              <div>
                支持支付宝、PayPal、ChatGPT、OPEN AI、AppStore美区、Google
                play美区、MIDJOURNEY等支付场景
              </div>
            </li>

            <li class="tip">
              <p>用卡须知</p>
              <div>
                1、因资金不足导致授权失败累计达到10次，卡片将被冻结；
                <br />
                2、卡片的总授权失败率超过20%，卡片将被冻结；
                <br />
                3、卡片被冻结后，需支付0.5美元的每笔授权失败罚金方能解冻；
                <br />
                4、单笔消费≤1美元的交易，将收取每笔0.5美元的手续费。
              </div>
            </li>
          </ul>

          <div class="button">
            <el-button type="primary">立即开卡</el-button>
          </div>
        </div>

        <!-- <div class="item">
          <img src="../../../assets/20240823-9.png" alt="" width="100%" />

          <ul class="info">
            <li>
              <p>卡片类型</p>
              <div>预付卡</div>
            </li>

            <li>
              <p>币种</p>
              <div>USD</div>
            </li>

            <li>
              <p>地区</p>
              <div>美国</div>
            </li>
          </ul>

          <ul class="tips">
            <li>
              <p>支持消费场景</p>
              <div>
                支持支付宝、PayPal、ChatGPT、OPEN AI、AppStore美区、Google
                play美区、MIDJOURNEY等支付场景
              </div>
            </li>

            <li class="tip">
              <p>用卡须知</p>
              <div>
                1、因资金不足导致授权失败累计达到10次，卡片将被冻结；
                <br />
                2、卡片的总授权失败率超过20%，卡片将被冻结；
                <br />
                3、卡片被冻结后，需支付0.5美元的每笔授权失败罚金方能解冻；
                <br />
                4、单笔消费≤1美元的交易，将收取每笔0.5美元的手续费。
              </div>
            </li>
          </ul>

          <div class="button">
            <el-button type="primary">立即开卡</el-button>
          </div>
        </div>

        <div class="item">
          <img src="../../../assets/20240823-9.png" alt="" width="100%" />

          <ul class="info">
            <li>
              <p>卡片类型</p>
              <div>预付卡</div>
            </li>

            <li>
              <p>币种</p>
              <div>USD</div>
            </li>

            <li>
              <p>地区</p>
              <div>美国</div>
            </li>
          </ul>

          <ul class="tips">
            <li>
              <p>支持消费场景</p>
              <div>
                支持支付宝、PayPal、ChatGPT、OPEN AI、AppStore美区、Google
                play美区、MIDJOURNEY等支付场景
              </div>
            </li>

            <li class="tip">
              <p>用卡须知</p>
              <div>
                1、因资金不足导致授权失败累计达到10次，卡片将被冻结；
                <br />
                2、卡片的总授权失败率超过20%，卡片将被冻结；
                <br />
                3、卡片被冻结后，需支付0.5美元的每笔授权失败罚金方能解冻；
                <br />
                4、单笔消费≤1美元的交易，将收取每笔0.5美元的手续费。
              </div>
            </li>
          </ul>

          <div class="button">
            <el-button type="primary">立即开卡</el-button>
          </div>
        </div> -->
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {}
    },

    methods: {
      goBack() {
        this.$router.go(-1)
      }
    }
  }
</script>

<style lang="less" scoped>
  .pc {
    .body {
      //   background: #fff;
      //   border-radius: 10px;
      display: flex;
      flex-direction: column;
      .header {
        display: flex;
        align-items: center;
        font-size: 20px;
        color: #000;
        font-weight: 700;
        & > span {
          cursor: pointer;
        }
        .el-icon-arrow-left {
          margin-right: 10px;
        }
      }
      .main {
        flex: auto;
        display: flex;
        position: relative;
        padding-top: 20px;
        .item {
          margin-right: 20px;
          .info {
            width: 100%;
            height: 74px;
            margin: 10px 0;
            border: 1px solid #ebebeb;
            border-radius: 8px;
            display: flex;
            justify-content: space-around;
            align-items: center;
            p {
              height: 18px;
              font-size: 12px;
              font-weight: 400;
              color: #6f7590;
              margin-bottom: 4px;
            }
            div {
              height: 20px;
              font-size: 14px;
              font-weight: 700;
              color: #333;
            }
          }
          .tips {
            border: 1px solid #ebebeb;
            border-radius: 8px;
            padding: 16px;
            li {
              margin-bottom: 16px;
              padding-left: 30px;
              background-repeat: no-repeat;
              background-position: 0 0;
              p {
                height: 20px;
                font-size: 14px;
                font-weight: 700;
                color: #333;
                margin-bottom: 4px;
              }
              div {
                font-size: 12px;
                font-weight: 400;
                line-height: 22px;
                color: #6f7590;
              }
            }
            .tip {
              div {
                color: #c17613;
              }
            }
          }
          .button {
            margin-top: 20px;
            display: flex;
            justify-content: center;
          }
          .card-item {
            width: 100%;
            height: 279px;
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
            }
            .visa_info {
              position: absolute;
              left: 0;
              font-size: 14px;
              color: #fff;
              bottom: 20px;
              padding-left: 24px;
              z-index: 1;
              .num {
                font-family: qiqi;
                letter-spacing: 2px;
                font-weight: 700;
                font-size: 20px;
              }
              .name {
                font-weight: 400;
                margin-top: 6px;
                font-size: 16px;
                .expiry {
                  margin-left: 10px;
                }
              }
            }
            .card_type_word {
              position: absolute;
              right: 20px;
              bottom: 20px;
            }
            .visa_master {
              position: absolute;
              right: 20px;
              bottom: 18px;
              vertical-align: middle;
            }
          }
        }
        .item:last-child {
          margin-right: 0px;
        }
      }
    }
  }
</style>
<style lang="less">
    .create-carousel {
        .el-carousel__arrow {
            font-size: 20px;
            font-weight: 700;
        }
        .el-carousel__indicators--horizontal {
            bottom: 20px;
        }
    }
</style>