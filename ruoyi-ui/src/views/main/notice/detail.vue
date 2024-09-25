<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
    </div>

    <p class="title">{{ noticeMsg.noticeTitle }}</p>
    <p class="date">{{noticeMsg.createTime}}</p>
    <div class="content" v-html="noticeMsg.noticeContent">
    </div>
  </div>
</template>

<script>
  export default {
    props: ['notice'],
    data() {
      return {
        noticeMsg : {}
      }
    },
    created () {
      // console.log('created', this.$route)
    },
    mounted () {
      this.noticeMsg = this.$route.params.notice
      // console.log('mounted', this.$route.params.notice)
    },
    methods: {
      handleBack() {
        this.$router.push('/home/notice')
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
