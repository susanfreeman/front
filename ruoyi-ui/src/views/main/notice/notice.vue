<template>
  <div class="pc_inner">
    <p class="title">公告</p>
    <p class="title2">来自官方的发布</p>

    <ul class="list">
      <li @click="toDetail">
        Dupay预付卡维护通知
        <i class="el-icon-arrow-right"></i>
      </li>

      <li @click="toDetail">
        Dupay借记卡服务关闭通知
        <i class="el-icon-arrow-right"></i>
      </li>

      <li @click="toDetail">
        Dupay 卡BIN轮换计划公告
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
            this.$router.push("/home/notice/notice-detail")
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
