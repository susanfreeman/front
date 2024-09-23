<template>
  <div class="pc">
    <div class="pc_back">
      <!-- <i class="el-icon-back"></i> -->
      帮助
    </div>

    <p class="title2">查看所有问题</p>

    <ul class="list">
      <li @click="gotoCommonProblem">
        <div class="info">
          <img src="../../../assets/help-1.png" alt="" class="info_l" />
          <div class="info_r">
            <div>常见问题</div>
            <p>在这里寻找答案</p>
          </div>
        </div>
        <i class="el-icon-arrow-right"></i>
      </li>

      <!-- <li>
        <div class="info">
          <img src="../../../assets/help-1.png" alt="" class="info_l" />
          <div class="info_r">
            <div>公告</div>
            <p>来自官方的发布</p>
          </div>
        </div>
        <i class="el-icon-arrow-right"></i>
      </li> -->

      <li @click="gotoCommonProblem">
        <div class="info">
          <img src="../../../assets/help-1.png" alt="" class="info_l" />
          <div class="info_r">
            <div>费用</div>
            <p>Dupay相关费用说明</p>
          </div>
        </div>
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
      handleBack() {
        this.$router.push('/home/user/me')
      },

      gotoCommonProblem() {
        this.$router.push('/home/help/common-problem')
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
    .title2 {
      font-size: 14px;
      padding-left: 16px;
      margin: 16px 0;
      color: #1a72ff;
    }
    .list {
      position: relative;
      z-index: 1;
      li {
        width: 100%;
        height: 100px;
        padding: 0 16px;
        font-size: 14px;
        color: #333;
        display: flex;
        border-bottom: 1px solid #f5f5f8;
        justify-content: space-between;
        align-items: center;
        .info {
          display: flex;
          .info_l {
            width: 40px;
            height: 40px;
            margin-right: 8px;
          }
          .info_r {
            div {
              font-size: 14px;
              font-weight: 700;
              margin-bottom: 2px;
            }
            p {
              font-size: 12px;
            }
          }
        }
      }
    }
  }
</style>
