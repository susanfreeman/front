<template>
  <div class="pc_inner">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
    </div>

    <p class="title">Dupay预付卡维护通知</p>
    <p class="date">2024-09-07</p>
    <div class="content">
      <span>亲爱的用户：</span><br />
      <br />
      由于银行卡系统出现异常，部分用户可能会遇到消费失败,看不到卡等问题。请您无需担忧，我们已与银行积极沟通并正在紧急处理。<br />
      <br />
      在维护期间，请尽量避免消费，以防止大量授权失败导致卡片被收单方风控。同时，为避免问题进一步扩大，我们已暂时关闭了卡片的充值与提现功能。问题解决后，我们会第一时间通知大家。<br />
      <br />
      感谢您的理解与配合。<br />
      <br />
      <span>Dupay Teams</span><br />
      2024/09/07<br />
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
        this.$router.push('/home/help/common-problem')
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
    .title {
      font-weight: 700;
      font-size: 24px;
      color: #333;
    }
    .date {
      color: #ccc;
      font-size: 14px;
      margin-bottom: 36px;
    }
    .content {
      color: #636363;
      font-size: 17px;
      line-height: 26px;
    }
  }
</style>
