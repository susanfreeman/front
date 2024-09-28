<template>
  <div class="pc">
    <div class="user-info">
      <img src="../../../assets/user-me.png" alt="" class="user_img" />
      <span>{{ user.email }}</span>
<!--      <p>-->
<!--        UID:DP55858892-->
<!--        <img src="../../../assets/copy.png" alt="" class="copy" />-->
<!--      </p>-->
      <div class="bell">
        <img src="../../../assets/bell.png" alt="" />
        <span>0</span>
      </div>
    </div>

    <div class="shield" @click="gotosecurity">
      <div class="shield_l">
        <p>账户安全</p>
        <div>安全等级：低</div>
      </div>
      <i class="el-icon-arrow-right"></i>
      <img src="../../../assets/bac-1.png" alt="" class="shield_bg" />
    </div>

    <ul class="info">
      <li @click="goToCommission">
        <span>
          <img src="../../../assets/user-1.png" alt="" />
          邀请好友
        </span>
        <div>
          <span class="gold">领黑金卡</span>
          <i class="el-icon-arrow-right"></i>
        </div>
      </li>

      <li @click="goToManage">
        <span>
          <img src="../../../assets/user-2.png" alt="" />
          卡片管理
        </span>
        <div>
          <!-- <span class="gold">领黑金卡</span> -->
          <i class="el-icon-arrow-right"></i>
        </div>
      </li>

      <li @click="goToService">
        <span>
          <img src="../../../assets/user-3.png" alt="" />
          客服
        </span>
        <div>
          <!-- <span class="gold">领黑金卡</span> -->
          <i class="el-icon-arrow-right"></i>
        </div>
      </li>

      <li @click="goTohelp">
        <span>
          <img src="../../../assets/user-4.png" alt="" />
          帮助
        </span>
        <div>
          <!-- <span class="gold">领黑金卡</span> -->
          <i class="el-icon-arrow-right"></i>
        </div>
      </li>

      <li @click="goToMode">
        <span>
          <img src="../../../assets/user-5.png" alt="" />
          计价方式
        </span>
        <div>
          CNY
          <i class="el-icon-arrow-right"></i>
        </div>
      </li>

      <li @click="goToLanguage">
        <span>
          <img src="../../../assets/user-6.png" alt="" />
          语言
        </span>
        <div>
          简体中文
          <i class="el-icon-arrow-right"></i>
        </div>
      </li>
    </ul>

    <ul class="info login">
      <li @click="loginOut">
        <span>退出登录</span>
        <div>
          <i class="el-icon-arrow-right"></i>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>

import { getUserProfile } from "@/api/system/user";
import {logout} from "@/api/login";

  export default {
    name: "Profile",
    data() {
      return {
        user: {},
        userInfo: {},
        activeTab: "userinfo"
      };
    },
    created() {
      this.getUser();
    },
    methods: {
      getUser() {
        getUserProfile().then(response => {
          this.user = response.data;
        });
      },

      gotosecurity() {
        this.$router.push('/home/user/security')
      },

      goToCommission() {
        this.$router.push('/home/user/commission')
      },
      goToManage() {
        this.$router.push('/home/user/manage')
      },

      goTohelp() {
        this.$router.push('/home/help/help-index')
      },

      goToService() {
        this.$router.push('/home/user/service')
      },

      goToMode() {
        this.$router.push('/home/user/mode')
      },
      goToLanguage() {
        this.$router.push('/home/user/language')
      },

      loginOut() {
        this.$confirm('您将退出登录！', '退出', {
          confirmButtonText: '退出',
          cancelButtonText: '取消',
          type: 'warning'
        })
          .then(() => {
            logout();
            //
          })
          .catch(() => {
            //   this.$message({
            //     type: 'info',
            //     message: '已取消删除'
            //   });
          })
      }
    }
  }
</script>

<style lang="less" scoped>
  .pc {
    .user-info {
      width: 100%;
      padding-left: 59px;
      margin-bottom: 32px;
      display: flex;
      justify-content: center;
      flex-flow: column;
      font-size: 16px;
      font-weight: 700;
      color: #333;
      position: relative;
      .user_img {
        width: 46px;
        height: 46px;
        position: absolute;
        top: 0;
        left: 0;
      }
      p {
        margin-top: 3px;
        font-size: 12px;
        font-weight: 400;
        color: #6f7590;
        .copy {
          width: 18px;
          vertical-align: sub;
        }
      }
      .bell {
        width: 24px;
        position: absolute;
        top: 11px;
        right: 0;
        cursor: pointer;
        img {
          width: 24px;
        }
        span {
          width: 18px;
          height: 18px;
          line-height: 18px;
          text-align: center;
          display: block;
          background: #e94534;
          border-radius: 6px;
          position: absolute;
          top: -2px;
          right: -2px;
          font-size: 8px;
          font-weight: 700;
          color: #fff;
          cursor: pointer;
          transform: scale(0.67);
        }
      }
    }
    .shield {
      width: 100%;
      height: 58px;
      cursor: pointer;
      border-radius: 2px;
      margin-bottom: 10px;
      padding: 0 10px 0 56px;
      background-color: #3164f3;
      background-image: url('../../../assets/bac-2.png');
      background-repeat: no-repeat;
      background-position: 16px 14px;
      position: relative;
      display: flex;
      justify-content: space-between;
      align-items: center;
      .shield_l {
        color: #fff;
        font-weight: 700;
        font-size: 14px;
        div {
          font-size: 11px;
          font-weight: 400;
          opacity: 0.7;
        }
      }
      .shield_bg {
        position: absolute;
        top: 0;
        right: 4px;
      }
    }
    .info {
      background: #fff;
      border-radius: 2px;
      margin-bottom: 32px;
      li {
        height: 52px;
        cursor: pointer;
        padding: 0 10px 0 16px;
        border-radius: 2px;
        display: flex;
        justify-content: space-between;
        border-bottom: 1px solid #f5f5f8;
        align-items: center;
        span {
          cursor: pointer;
          font-weight: 700;
          color: #333;
          img {
            width: 20px;
            vertical-align: middle;
            margin-right: 9px;
          }
        }
        & > div {
          font-size: 12px;
          font-weight: 700;
          color: #6f7590;
          .gold {
            font-size: 12px;
            font-weight: 700;
            color: #d69419;
          }
          i {
            vertical-align: middle;
          }
        }
      }
    }
    .login {
      background: #fff;
      border-radius: 2px;
      margin-bottom: 32px;
    }
  }
</style>
