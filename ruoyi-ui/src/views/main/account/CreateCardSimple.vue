<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      开卡
    </div>

    <div class="kyc-form">
      <el-form ref="form" :model="form" label-width="100px">
<!--        <el-form-item label="币种:">-->
<!--          <el-select-->
<!--            v-model="form.currency"-->
<!--            placeholder="请选择币种"-->
<!--            style="width: 100%"-->
<!--          >-->
<!--            <el-option label="人民币" value="人民币"></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->

        <el-form-item label="卡头:">
          <el-input v-model="form.cardHead" :disabled="true" ></el-input>
        </el-form-item>
        <el-form-item label="姓氏:">
          <el-input v-model="form.firstName"
                    :rules="[
            { required: true, message: '请输入姓氏', trigger: 'blur' }
          ]"></el-input>
        </el-form-item>

        <el-form-item label="名:">
          <el-input v-model="form.lastName" :rules="[
            { required: true, message: '请输入名', trigger: 'blur' }
          ]"></el-input>
        </el-form-item>

        <el-form-item label="充值金额:">
          <el-input type="number" v-model="form.chargeAmt" :rules="[
            { required: true, message: '请输入充值金额', trigger: 'blur' }
          ]" @blur="calculateFee"></el-input>
        </el-form-item>


        <el-form-item>
          <label>本次充值最小金额：{{cardVal.cardRechargeMin}}</label></br>
          <label>本次开卡手续费：{{cardVal.cardOpenFee}}</label></br>
          <label>本次充值手续费率：{{cardVal.cardRechargeFee}}%</label></br>
          <label>本次共消费金额预估：{{fee}}</label></br>
          <el-button type="primary" @click="onSubmit">开卡并充值</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import {getUserProfile} from "@/api/system/user";
import {applyCard} from "@/api/custom/opencard";

export default {
  data() {
    return {
      props: ['card'],
      form: {
        cardHead: "",
        firstName: "",
        lastName: "",
        chargeAmt: "",
      },
      cardVal: {},
      fee: 0
    };
  },
  created() {
    this.getUser();
  },
  mounted() {
    this.cardVal = this.$route.params.card;
    console.log(this.cardVal);
    this.form.cardHead = this.cardVal.cardBin;
  },
  methods: {
    handleBack() {
      this.$router.push("/home/account/Created");
    },

    getUser() {
      getUserProfile().then(response => {
        this.form.firstName = response.userInfo.firstName;
        this.form.lastName = response.userInfo.lastName;
      });
    },
    calculateFee() {
      this.fee = parseFloat(this.cardVal.cardOpenFee) + parseFloat(this.form.chargeAmt) + parseFloat(this.form.chargeAmt * this.cardVal.cardRechargeFee/100);
    },
    onSubmit() {
      this.$refs.form.validate(valid => {
        if (valid) {
          applyCard(this.form).then(res => {
            this.$alert(res.msg);
          })
        }
      })
    },
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
