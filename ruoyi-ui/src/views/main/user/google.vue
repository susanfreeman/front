<template>
  <div class="pc_inner">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      谷歌验证器
    </div>

    <p class="word1">请下载谷歌验证应用程序并扫描二维码</p>
    <div
      id="qrCode5"
      title="otpauth://totp/Dupay-738296860@qq.com?secret=IQRUL46HLHOBBB3D"
    >
      <img
        alt="Scan me!"
        src="data:image/png;base64,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"
        style="display: block"
      />
    </div>

    <p class="code">
      IQRUL46HLHOBBB3D
      <img src="../../../assets/copy.png" />
    </p>
    <button class="button0" @click="gotobindGoogle">继续</button>
    <button class="button1" @click="gotoDown">下载谷歌验证器</button>
  </div>
</template>

<script>
  export default {
    data() {
      return {}
    },
    methods: {
      handleBack() {
        this.$router.push('/home/user/security')
      },

      gotobindGoogle() {
        this.$router.push('/home/user/bindGoogle') 
      },

      gotoDown() {
        this.$router.push('/home/user/google-authenticator')
      }
    }
  }
</script>

<style lang="less" scoped>
  .pc_inner {
    width: 602px;
    height: 685px;
    margin: 60px auto;
    border-radius: 14px;
    background: #fff;
    padding: 34px 32px 9px;
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
    .word1 {
      width: 154px;
      font-weight: 400;
      color: #5f6368;
      line-height: 16px;
      margin: 8px auto 32px;
      text-align: center;
    }
    #qrCode5 {
      margin: 32px auto 24px;
      width: 150px;
      height: 150px;
    }
    .code {
      font-size: 16px;
      font-weight: 700;
      color: #202124;
      margin: 24px auto 66px;
      text-align: center;
      img {
        margin-left: 6px;
        vertical-align: middle;
      }
    }
    .button0 {
      width: 343px;
      margin: 0 auto;
      cursor: pointer;
      height: 42px;
      line-height: 42px;
      color: #fff;
      background: #2e7cff;
      border-radius: 4px;
      text-align: center;
      display: block;
      font-size: 14px;
    }
    .button1 {
      width: 343px;
      height: 48px;
      display: block;
      cursor: pointer;
      border: 1px solid #e8e8f1;
      background: #fff;
      color: #1a72ff;
      margin: 10px auto 0;
      border-radius: 2px;
      line-height: 48px;
      text-align: center;
      font-size: 12px;
    }
  }
</style>
