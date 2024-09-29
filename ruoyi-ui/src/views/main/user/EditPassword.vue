<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      修改登录密码
    </div>

    <div class="form-area">
      <el-form :model="form" ref="form" label-position="top">
        <el-form-item
          label="当前密码"
          prop="currentpass"
          :rules="[
            { required: true, message: '请输入现在的密码', trigger: 'blur' }
          ]"
        >
          <el-input
            type="password"
            v-model="form.currentpass"
            autocomplete="off"
            placeholder="请输入现在的密码"
            show-password
          ></el-input>
        </el-form-item>

        <el-form-item
          label="新密码"
          prop="pass"
          :rules="[
            { required: true, message: '请输入新密码', trigger: 'blur' }
          ]"
        >
          <el-input
            type="password"
            v-model="form.pass"
            autocomplete="off"
            placeholder="请输入新密码"
            show-password
          ></el-input>
        </el-form-item>

        <el-form-item
          label="重复新密码"
          prop="rePass"
          :rules="[
            { required: true, message: '请再次输入新密码', trigger: 'blur' }
          ]"
        >
          <el-input
            type="password"
            v-model="form.rePass"
            autocomplete="off"
            placeholder="请再次输入新密码"
            show-password
          ></el-input>
        </el-form-item>
      </el-form>
      <div style="margin-top: 50px">
        <el-button type="primary" @click="visible = true" style="width: 100%">
          确 认
        </el-button>
      </div>
    </div>

    <el-dialog
      :visible.sync="visible"
      :width="isMobile ? '90%' : '30%'"
      :show-close="false"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
    >
      <el-result icon="success">
        <template slot="extra">
          <p class="dialog-title">密码修改成功</p>

          <el-button @click="goBackLogin">返回</el-button>
        </template>
      </el-result>
    </el-dialog>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  data() {
    return {
      form: {
        currentpass: "",
        pass: "",
        repass: ""
      },

      visible: false
    };
  },

  computed: {
    ...mapGetters(["isMobile"]),
  },
  methods: {
    handleBack() {
      this.$router.push("/home/user/security");
    },

    goBackLogin() {
      this.visible = false
    }
  },
};
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
  .form-area {
    padding: 0 20px;
  }
}

.dialog-title {
  font-size: 24px;
  font-weight: 700;
  line-height: 32px;
  color: #000;
  margin-bottom: 32px;
}
</style>
