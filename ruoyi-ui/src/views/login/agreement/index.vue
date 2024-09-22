<template>
  <div class="agreement">
    <div class="res-login-header">
      <img
        src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAABR0lEQVQ4T63UsUrDUBQG4P80vQguVRcHZxFXqbg6iJtP4KzQRSp1SEHhlgy2DhbaQegj1DcwSHUVJys+gC8gQorEJjlyA5WWpLkxMVu44Tvn3v/kEv75oTTeiXW1zn5BdOXZm+57LagwwBgws0G+t9NpmO9JaCI4wQCsMXN/GDiHD1J6mcAsmCoU22FWLBbMg0XAvNgMWLFaGwLFexUAwP0XXx9AXDjhGVat9maAYABgVb0z+JWAxDSnMSZ67p7Xjn47PJXXK57BNgFbusGds/7Yuajtzmy5KttLfsG/I6JtZgwD9+tgJLzPNAVGgHcrpRMJ5bjZLC18F+0QBZ5cZ7zfa5mp0EnhyBzmRWMHO9y+EagzLf+107n/clY08XLIgmqvr4p5uSwWhc1E7IrxXs9MDkkLqvQUihJwU69/6MYoFahDptd/ANUGwhUwnh1lAAAAAElFTkSuQmCC"
        class="type"
        @click="goBack"
      />
      <p>服务协议列表</p>
    </div>

    <p class="title">服务协议</p>

    <el-collapse
      v-model="activeNames"
      @change="handleActive"
      class="agreement-collapse"
    >
      <el-collapse-item title="orbiterwallet注册协议" name="1">
      </el-collapse-item>
      <el-collapse-item title="隐私政策" name="2"> </el-collapse-item>
      <el-collapse-item title="Cookie政策" name="3"> </el-collapse-item>
      <el-collapse-item title="AML政策" name="4"> </el-collapse-item>
    </el-collapse>

    <!-- <el-radio v-model="radio" label="1">我同意所有协议</el-radio> -->
    <el-checkbox
      v-model="checked"
      class="agreement-checkbox"
      @change="handleChange"
    >
      我同意所有协议
    </el-checkbox>

    <el-button
      type="primary"
      :disabled="isDisabled"
      style="width: 100%"
      @click="goToRegister"
    >
      确认
    </el-button>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        activeNames: [],
        checked: false,
        isDisabled: true
      }
    },
    methods: {
      handleActive(val) {
        this.activeNames = []
        this.$router.push({ name: 'agreementDetail', params: { id: val[0] } })
      },

      handleChange(val) {
        this.checked = val
        this.isDisabled = !val
      },

      //前往注册
      goToRegister() {
        this.$router.push('register')
      },
      goBack() {
        this.$router.push('/login/login')
      }
    }
  }
</script>

<style lang="less" scoped>
  .agreement {
    .res-login-header {
      display: none;
    }
    .title {
      font-size: 24px;
      font-weight: 700;
      line-height: 32px;
      color: #000;
      margin-bottom: 32px;
    }
    .agreement-checkbox {
      margin: 32px 0;
    }
  }
</style>
<style lang="less">
  .agreement-collapse {
    .el-collapse-item__header {
      font-weight: 700;
      font-size: 16px;
    }
  }
</style>
