<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      KYC验证
    </div>

    <div class="kyc-form">
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="币种:">
          <el-select
            v-model="form.currency"
            placeholder="请选择币种"
            style="width: 100%"
          >
            <el-option label="人民币" value="人民币"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="姓氏:">
          <el-input v-model="form.surname"></el-input>
        </el-form-item>

        <el-form-item label="名:">
          <el-input v-model="form.name"></el-input>
        </el-form-item>

        <el-form-item label="邮编:">
          <el-input v-model="form.postalCode"></el-input>
        </el-form-item>

        <el-form-item label="国家(地区):">
          <el-select
            v-model="form.country"
            placeholder="请选择国家(地区)"
            style="width: 100%"
          >
            <el-option label="美国" value="美国"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="省:">
          <el-input v-model="form.province"></el-input>
        </el-form-item>

        <el-form-item label="城市:">
          <el-input v-model="form.city"></el-input>
        </el-form-item>

        <el-form-item label="手机号前缀:">
          <el-input v-model="form.phonePrefix"></el-input>
        </el-form-item>

        <el-form-item label="手机号码:">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>

        <el-form-item label="地址:">
          <el-input v-model="form.adress"></el-input>
        </el-form-item>

        <el-form-item label="邮箱:">
          <el-input v-model="form.email"></el-input>
        </el-form-item>

        <el-form-item label="证件类型:">
          <el-select
            v-model="form.document"
            placeholder="请选择证件类型"
            style="width: 100%"
          >
            <el-option label="护照" value="护照"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="证件号码:">
          <el-input v-model="form.documentNum"></el-input>
        </el-form-item>

        <el-form-item label="生日:">
          <el-date-picker
            type="date"
            placeholder="YYYY-MM-DD"
            v-model="form.date"
            style="width: 100%"
          ></el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">KYC验证</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        currency: "人民币",
        surname: "",
        name: "",
        postalCode: "",
        country: "美国",
        province: "",
        city: "",
        phonePrefix: "",
        phone: "",
        adress: "",
        email: "",
        document: "护照",
        documentNum: "",
        date: "",
      },
    };
  },
  methods: {
    handleBack() {
      this.$router.push("/home/account/Created");
    },

    onSubmit() {},
  },
};
</script>

<style lang="less" scoped>
.pc {
  background: #fff;
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
  .kyc-form {
    background: #fff;
  }
}
</style>
