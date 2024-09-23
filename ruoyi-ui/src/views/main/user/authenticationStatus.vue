<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      身份认证
    </div>

    <p class="title">产品</p>
    <ul class="cards">
      <li>
        <img src="../../../assets/status-1.png" />
        <label>Dupay 预付卡</label>
        <span class="">去认证</span>
      </li>
      <li>
        <img src="../../../assets/status-2.png" />
        <label>Dupay 借记卡 </label>
        <span class="">已注销</span>
      </li>
    </ul>
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
    .title {
      font-size: 14px;
      font-weight: 700;
      color: #333;
      margin-bottom: 10px;
    }
    .cards {
      width: 100%;
      border: 1px solid #f0f0f3;
      border-radius: 8px;
      li {
        width: 100%;
        height: 56px;
        position: relative;
        display: flex;
        justify-content: space-between;
        align-items: center;
        font-size: 14px;
        font-weight: 700;
        border-bottom: 1px solid #f0f0f3;
        padding-right: 16px;
        color: #333;
        padding-left: 58px;
        img {
          position: absolute;
          top: 12px;
          left: 16px;
        }
      }
    }
  }
</style>
