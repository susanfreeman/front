<template>
  <div class="main-body">
    <div class="left">
      <img
        src="../../../assets/logo2.png"
        alt=""
        class="logo-img"
        width="140"
      />

      <el-menu
        :default-active="$route.name"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        background-color="#fff"
        text-color="#000"
        router
      >
        <el-menu-item index="account" :route="{ path: '/home/account' }">
          <i class="el-icon-bank-card"></i>
          <span slot="title">卡管理</span>
        </el-menu-item>
        <el-menu-item
          index="exchange"
          :route="{ path: '/home/exchange-account/exchange' }"
        >
          <i class="el-icon-money"></i>
          <span slot="title">钱包管理</span>
        </el-menu-item>
        <el-menu-item index="notice-index" :route="{ path: '/home/notice' }">
          <i class="el-icon-tickets"></i>
          <span slot="title">公告栏</span>
        </el-menu-item>
        <el-menu-item index="help-index" :route="{ path: '/home/help' }">
          <i class="el-icon-chat-line-square"></i>
          <span slot="title">帮助中心</span>
        </el-menu-item>
        <el-menu-item index="contactUs" :route="{ path: '/home/contactUs' }">
          <i class="el-icon-phone-outline"></i>
          <span slot="title">联系我们</span>
        </el-menu-item>
      </el-menu>

      <div class="me" @click="handleToUser">
        <div class="commission">
          <p class="commission_l">
            邀请好友开卡
            <br />
            赚取 20% 返佣
          </p>
          <img src="../../../assets/image-fire.png" alt="" />
        </div>

        <div class="user">
          <img
            src="../../../assets/image-user.png"
            alt=""
            style="margin-right: 10px"
          />
          ME
        </div>
      </div>
    </div>
    <div class="content">
      <router-view></router-view>
    </div>

    <div class="footer">
      <el-menu
        :default-active="$route.name"
        class="mobile-menu"
        @open="handleOpen"
        @close="handleClose"
        background-color="#fff"
        mode="horizontal"
        text-color="#000"
        router
      >
        <el-menu-item index="account" :route="{ path: '/home/account' }">
          <i class="el-icon-bank-card"></i>
          <span slot="title">卡管理</span>
        </el-menu-item>
        <el-menu-item
          index="exchange"
          :route="{ path: '/home/exchange-account/exchange' }"
        >
          <i class="el-icon-money"></i>
          <span slot="title">钱包管理</span>
        </el-menu-item>
        <el-menu-item index="notice-index" :route="{ path: '/home/notice' }">
          <i class="el-icon-tickets"></i>
          <span slot="title">公告栏</span>
        </el-menu-item>
        <el-menu-item index="help-index" :route="{ path: '/home/help' }">
          <i class="el-icon-chat-line-square"></i>
          <span slot="title">帮助中心</span>
        </el-menu-item>
        <el-menu-item index="contactUs" :route="{ path: '/home/contactUs' }">
          <i class="el-icon-phone-outline"></i>
          <span slot="title">联系我们</span>
        </el-menu-item>
        <el-menu-item index="me" :route="{ path: '/home/user' }">
          <i class="el-icon-user"></i>
          <span slot="title">我的</span>
        </el-menu-item>
      </el-menu>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {}
    },

    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath)
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath)
      },

      handleToUser() {
        this.$router.push('/home/user')
      }
    }
  }
</script>

<style lang="less" scoped>
  .main-body {
    width: 100%;
    height: 100%;
    display: flex;
    overflow: hidden;
    @media screen and (max-width: 600px) {
      display: flex;
      flex-direction: column;
    }
    .left {
      width: 240px;
      height: 100vh;
      background: #fff;
      display: flex;
      flex-direction: column;
      flex-shrink: 0;
      @media screen and (max-width: 600px) {
        display: none;
      }
      .logo-img {
        display: block;
        margin: 20px auto;
      }

      .el-menu-vertical-demo {
        flex: 1;
        overflow: auto;
      }
      .me {
        padding: 24px;
        display: flex;
        flex-direction: column;
        .commission {
          width: 100%;
          height: 53px;
          background: #45a1ff;
          border-radius: 4px;
          display: flex;
          justify-content: space-between;
          align-items: center;
          cursor: pointer;
          padding: 0 14px 0 10px;
          .commission_l {
            font-size: 12px;
            font-weight: 700;
            line-height: 18px;
            color: #fff;
          }
        }
        .user {
          width: 100%;
          margin-top: 29px;
          display: flex;
          align-items: center;
          font-size: 14px;
          font-weight: 400;
          color: #000;
          cursor: pointer;
        }
      }
    }
    .content {
      background: #ccc;
      position: relative;
      flex: auto;
      overflow: auto;
    }
    .footer {
      width: 100%;
      height: 60px;
      background: #fff;
      display: none;
      @media screen and (max-width: 600px) {
        display: flex;
      }
    }
  }
</style>
<style lang="less">
  .el-menu-item.is-active {
    background: #45a1ff !important;
    color: #fff;
  }

  .mobile-menu {
    display: flex;
    width: 100%;
    .el-menu-item {
      flex: 1;
      display: flex;
      flex-direction: column;
      padding: 0;
      align-items: center;
      justify-content: center;
      i {
        margin-right: 0;
        margin-bottom: 5px;
      }
    }
    .el-menu-item,
    .el-submenu__title {
      line-height: 20px;
    }
  }
</style>
