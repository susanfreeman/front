<template>
  <div class="pc_inner">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      计价方式
    </div>

    <el-radio-group v-model="radio" class="mode-roaio-group">
      <el-radio :label="3">CNY</el-radio>
      <el-radio :label="6">GBP</el-radio>
      <el-radio :label="9">USD</el-radio>
    </el-radio-group>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        radio: 3
      }
    },
    methods: {
      handleBack() {
        this.$router.push('/home/user/me')
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
  }
</style>
<style lang="less">
    .mode-roaio-group {
        display: flex;
        flex-direction: column;
        .el-radio {
            height: 50px;
            border-bottom: 1px solid #f5f5f8;
            display: flex;
            align-items: center;
            .el-radio__input {
                display: none;
            }
        }
        .is-checked::after {
            content: "";
            width: 20px;
            height: 20px;
            position: absolute;
            right: 10px;
            background: url("../../../assets/checked.png");
        }
    }
</style>
