<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      安全中心
    </div>

<!--    <div class="level">-->
<!--      <p class="level_t">安全等级： 低</p>-->
<!--      <el-progress :percentage="50" :show-text="false"></el-progress>-->
<!--    </div>-->

    <ul class="info">
      <li>
        <span>邮箱</span>
        <div class="info_r">
          <span>{{user.email}}</span>
          <i class="el-icon-arrow-right"></i>
        </div>
      </li>
      <li @click="gotoauthenticationStatus">
        <span>身份认证</span>
        <div class="info_r">
          <i class="el-icon-arrow-right"></i>
        </div>
      </li>
    </ul>
    <p class="title">验证方式</p>

    <ul class="info">
      <li>
        <span>电子邮箱</span>
        <div class="info_r">
          <el-switch
            v-model="value"
            active-color="#13ce66"
            inactive-color="#ff4949"
          >
          </el-switch>
        </div>
      </li>
      <li  @click="gotogoogle">
        <span>谷歌验证码</span>
        <div class="info_r">
          <span class="warn" v-show="!isBindGoogle"><i class="el-icon-warning"></i> 未绑定</span>
          <span class="success" v-show="isBindGoogle"><i class="el-icon-success"></i> 已绑定</span>
          <i class="el-icon-arrow-right"></i>
        </div>
      </li>
    </ul>

    <p class="title">密码管理</p>

    <ul class="info">
      <li>
        <span>修改登录密码</span>
        <div class="info_r">
          <i class="el-icon-arrow-right"></i>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import {getUserProfile} from "@/api/system/user";

export default {
  name: "Profile",
  data() {
    return {
      user: {},
      activeTab: "userinfo",
      value: false,
      isBindGoogle: false
    };
  },
  created() {
    this.getUser();
  },
  methods: {
    getUser() {
      getUserProfile().then(response => {
        this.user = response.data;
        this.userInfo = response.userInfo;
        if (this.userInfo.code2fa != '') {
          this.isBindGoogle = true;
        }
      });
    },

      handleBack() {
        this.$router.push('/home/user/me')
      },

      gotoauthenticationStatus() {
        this.$router.push('/home/user/authenticationStatus')
      },

      gotogoogle() {
      if(!this.isBindGoogle){
        this.$router.push('/home/user/google')
      }
      }
    }
  }
</script>

<style lang="less" scoped>
  .pc {
    @media screen and (min-width: 600px) {
      height: 685px !important;
    }
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
    .level {
      width: 100%;
      margin: 16px 0;
      .level_t {
        font-size: 14px;
        font-weight: 700;
        color: #333;
        margin-bottom: 10px;
      }
    }
    .info {
      background: #fff;
      border-radius: 2px;
      margin-top: 10px;
      li {
        height: 52px;
        cursor: pointer;
        padding-right: 16px;
        display: flex;
        justify-content: space-between;
        border-bottom: 1px solid #f5f5f8;
        align-items: center;
        & > span {
          font-weight: 700;
          color: #333;
        }
        .info_r {
          font-size: 12px;
          font-weight: 700;
          color: #6f7590;
          .warn {
            color: #e53e3e;
            font-weight: 700;
          }
        }
      }
    }
    .title {
      font-size: 12px;
      font-weight: 400;
      color: #6f7590;
      margin: 16px 0;
    }
  }
</style>
