<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      兑换记录
    </div>

    <ul class="log_list">
      <div class="no_data">
        <img src="../../../assets/no-data.png" alt="" />
        <p>没有记录</p>
      </div>
    </ul>
  </div>
</template>

<script>
import {getBaltrans} from "@/api/custom/trans";

  export default {
    data() {
      return {}
    },
    created() {

    },
    methods: {
      handleBack() {
        this.$router.push('/home/exchange-account/exchange')
      },
      queryBaltrans() {
        getBaltrans().then(res => {
          if (res.code == 200) {
            this.changeAmtForm.sourceAmount = res.data.balanceEur;
            this.getTa();
          }
        })
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
    .log_list {
      width: 100%;
      height: calc(100vh - 44px);
      overflow: auto;
      padding-left: 16px;
      @media screen and (max-width: 600px) {
        height: 90% !important;
      }
      .no_data {
        width: 100%;
        height: 240px;
        background: #fff;
        border-radius: 0 0 4px 4px;
        overflow: hidden;
        img {
          display: block;
          margin: 66px auto 10px;
        }
        p {
          font-size: 12px;
          color: #333;
          text-align: center;
        }
      }
    }
  }
</style>
