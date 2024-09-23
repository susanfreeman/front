<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      我的返佣
    </div>

    <div class="proportion">
      <p class="proportion_t">返佣比例</p>
      <div class="proportion_m">
        <p>
          <img src="../../../assets/star.png" alt="" />
          我的总佣金
        </p>
        <div>
          0.00 USD
          <i class="el-icon-arrow-right"></i>
        </div>
      </div>

      <ul class="proportion_b">
        <li>
          <p>20 %</p>
          <div>兑换返佣比例</div>
        </li>
        <li>
          <p>0 <i class="el-icon-arrow-right"></i></p>
          <div>总推荐人数</div>
        </li>
      </ul>

      <ul class="proportion_b proportion_b2">
        <li>
          <p>20 %</p>
          <div>开卡返佣比例</div>
        </li>
        <li>
          <p>0 <i class="el-icon-arrow-right"></i></p>
          <div>已开卡人数</div>
        </li>
      </ul>
    </div>

    <div class="friend">
      <p class="friend_t">邀请好友</p>
      <ul class="friend_m">
        <li>
          <span>我的推荐码</span>
          <p>
            vYha5F
            <img src="../../../assets/copy.png" alt="" class="copy" />
          </p>
        </li>

        <li>
          <span>我的推荐链接</span>
          <p>
            https://dupay...vYha5F
            <img src="../../../assets/copy.png" alt="" class="copy" />
          </p>
        </li>
      </ul>
    </div>

    <div class="friend_b">
      <el-button type="primary" class="button0">邀请好友</el-button>
      <div class="code">
        <img src="../../../assets/code.png" alt="" />
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
      handleBack() {
        this.$router.push('/home/user/me')
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
    .proportion {
      width: 100%;
      margin: 16px auto 10px;
      border-radius: 4px;
      .proportion_t {
        font-size: 12px;
        font-weight: 700;
        color: #333;
        margin-bottom: 10px;
      }
      .proportion_m {
        width: 100%;
        height: 40px;
        background: #fff6e5;
        display: flex;
        justify-content: space-between;
        align-items: center;
        border-radius: 4px;
        padding: 0 34px 0 10px;
        font-weight: 700;
        color: #333;
        cursor: pointer;
        p {
          img {
            vertical-align: bottom;
          }
        }
      }
      .proportion_b {
        cursor: pointer;
        border-radius: 8px 8px 0 0;
        background: #fff;
        margin-top: 10px;
        display: flex;
        border: 1px solid #f5f5f8;
        li {
          flex: 1;
          padding: 10px;
          p {
            font-size: 20px;
            font-weight: 700;
            color: #333;
            margin-bottom: 3px;
            display: flex;
            align-items: center;
          }
          div {
            font-size: 12px;
            font-weight: 400;
            color: #6f7590;
          }
        }
      }
      .proportion_b2 {
        border-radius: 0 0 8px 8px;
        border-top: none;
        margin-top: 0;
      }
    }
    .friend {
      width: 100%;
      //   height: 216px;
      border-radius: 4px;
      .friend_t {
        font-size: 14px;
        font-weight: 700;
        color: #333;
        margin-bottom: 16px;
      }
      .friend_m {
        padding: 0 16px;
        border-radius: 8px;
        border: 1px solid #f5f5f8;
        background: -webkit-gradient(
          linear,
          left top,
          left bottom,
          from(#f4f9ff),
          to(#fff)
        );
        background: linear-gradient(180deg, #f4f9ff, #fff);
        li {
          height: 50px;
          padding: 0 10px;
          display: flex;
          justify-content: space-between;
          align-items: center;
          border-bottom: 1px solid #f5f5f8;
          span {
            font-size: 12px;
            font-weight: 400;
            color: #6f7590;
          }
          p {
            font-size: 14px;
            font-weight: 700;
            color: #333;
            background: none;
          }
        }
      }
    }
    .friend_b {
      margin-top: 16px;
      display: flex;
      justify-content: center;
      .button0 {
        width: 294px;
        height: 38px;
        margin-right: 11px;
      }
      .code {
        border: 1px solid #e8e8f1;
        cursor: pointer;
        margin-left: 10px;
        width: 38px;
        height: 38px;
        background: #fff;
        border-radius: 4px;
        img {
          width: 20px;
          display: block;
          margin: 9px;
        }
      }
    }
  }
</style>
