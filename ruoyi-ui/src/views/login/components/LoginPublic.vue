<template>
  <div class="login-body">
    <div class="left">
      <img src="../../../assets/logo.png" alt="" class="img-first" width="60" />

      <!-- <img src="../../../assets/bac1.png" alt="" class="img-second" /> -->

      <div class="info_outer">
        <router-view></router-view>
      </div>
    </div>
    <div class="content">
      <img src="../../../assets/banner.png" alt="" class="banner-img" />
    </div>
  </div>
</template>

<script>
  export default {}
</script>

<style lang="less" scoped>
  .login-body {
    width: 100%;
    display: flex;
    overflow: hidden;
    .left {
      width: 471px;
      min-height: 100vh;
      padding: 0 16px;
      background: fff;
      .img-first {
        position: absolute;
        top: 32px;
        left: 32px;
      }
      .img-second {
        position: absolute;
        top: 0;
        left: 334px;
      }
      .info_outer {
        padding: 0 48px;
        margin-top: 120px;
      }
    }
    .content {
      background: #f4f5f7;
      position: relative;
      flex: auto;
      .banner-img {
        height: 584px;
        position: absolute;
        top: 100px;
        left: 100px;
      }
    }
  }

  @media screen and (max-width: 600px) {
    .info_outer {
      padding: 0 !important;
    }
  }
</style>
