<template>
  <div class="pc_inner">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      帮助
    </div>

    <p class="title">常见问题</p>
    <p class="title2">在这里寻找答案</p>

    <ul class="list">
      <li @click="toDetail">
        USD预付卡维护公告（消费，充值）
        <i class="el-icon-arrow-right"></i>
      </li>

      <li @click="toDetail">
        借记卡常见问题

        <i class="el-icon-arrow-right"></i>
      </li>

      <li @click="toDetail">
        账号相关问题
        <i class="el-icon-arrow-right"></i>
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
      toDetail() {
        this.$router.push('/home/help/help-detail')
      },

      handleBack() {
        this.$router.push('/home/help')
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
      padding-left: 16px;
      margin-top: 32px;
      color: #000;
    }
    .title2 {
      font-size: 12px;
      padding-left: 16px;
      margin-bottom: 16px;
      color: #ccc;
    }
    .list {
      position: relative;
      z-index: 1;
      li {
        width: 100%;
        height: 70px;
        padding: 0 16px;
        font-size: 14px;
        color: #333;
        border-bottom: 1px solid #f5f5f8;
        display: flex;
        justify-content: space-between;
        align-items: center;
        font-weight: 700;
      }
    }
  }
</style>
