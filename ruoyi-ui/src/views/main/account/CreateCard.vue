<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      KYC验证
    </div>

    <div class="kyc-form">
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="币种:">
          <el-select v-model="form.curr" placeholder="请选择币种" clearable style="width:100%">
            <el-option
              v-for="dict in dict.type.bus_cur"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="姓氏:">
          <el-input v-model="form.firstName"></el-input>
        </el-form-item>

        <el-form-item label="名:">
          <el-input v-model="form.lastName"></el-input>
        </el-form-item>

        <el-form-item label="邮编:">
          <el-input v-model="form.postCode"></el-input>
        </el-form-item>

        <el-form-item label="国家(地区):">
          <el-select v-model="form.country" placeholder="请选择国家(地区)" clearable style="width:100%">
            <el-option
              v-for="dict in dict.type.buss_country"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="省:">
          <el-input v-model="form.province"></el-input>
        </el-form-item>

        <el-form-item label="城市:">
          <el-input v-model="form.city"></el-input>
        </el-form-item>

        <el-form-item label="手机号前缀:">
          <el-input v-model="form.mobilePrefix"></el-input>
        </el-form-item>

        <el-form-item label="手机号码:">
          <el-input v-model="form.mobile"></el-input>
        </el-form-item>

        <el-form-item label="地址:">
          <el-input v-model="form.address"></el-input>
        </el-form-item>

        <el-form-item label="邮箱:">
          <el-input v-model="form.email"></el-input>
        </el-form-item>

        <el-form-item label="证件类型:">
          <el-select v-model="form.idType" placeholder="请选择证件类型" clearable style="width:100%">
            <el-option
              v-for="dict in dict.type.buss_cert_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>

        <el-form-item label="证件号码:">
          <el-input v-model="form.idNo"></el-input>
        </el-form-item>

        <el-form-item label="护照图片地址:">
          <el-input
            v-model="form.passportImg"
            :disabled="true"
            placeholder="选择文件"
          >
            <el-button slot="append" type="info" @click="openPassport">
              选择...
            </el-button>
          </el-input>
          <el-upload
            action=""
            :auto-upload="false"
            :show-file-list="false"
            :on-change="passportChange"
            v-show="false"
          >
            <el-button
              size="small"
              type="primary"
              id="passportButton"
            ></el-button>
          </el-upload>
        </el-form-item>

        <el-form-item label="手持证件照:">
          <el-input
            v-model="form.faceImg"
            :disabled="true"
            placeholder="选择文件"
          >
            <el-button slot="append" type="info" @click="openIDPhoto">
              选择...</el-button
            >
          </el-input>

          <el-upload
            action=""
            :auto-upload="false"
            :show-file-list="false"
            :on-change="IDPhotoChange"
            v-show="false"
          >
            <el-button
              size="small"
              type="primary"
              id="IDPhotoButton"
            ></el-button>
          </el-upload>
        </el-form-item>

        <el-form-item label="生日:">
          <el-date-picker
            type="date"
            placeholder="YYYY-MM-DD"
            v-model="form.birthday"
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
import {kyc} from "@/api/custom/opencard";
import {getUserProfile} from "@/api/system/user";
import axios from "axios";
import {getToken} from "@/utils/auth";

export default {
  dicts: ["bus_cur", "buss_country","buss_cert_type"],
  data() {
    return {
      form: {
        curr: "",
        firstName: "",
        lastName: "",
        postCode: "",
        country: "",
        province: "",
        city: "",
        mobilePrefix: "",
        mobile: "",
        address: "",
        email: "",
        idType: "",
        idNo: "",
        passportImg: "",
        faceImg: "",
        birthday: "",
      },

      urls: [],
      passportFile: null,
      IDPhotoFile: null,
    };
  },
  created() {
    this.initData();
  },
  methods: {
    handleBack() {
      this.$router.push("/home/account/Created");
    },

    onSubmit() {
      this.uploadImage();
    },

    realSubmit() {
      if (this.urls != null && this.urls.length == 2) {
        this.form.passportImg = this.urls[0];
        this.form.faceImg = this.urls[1];
        kyc(this.form).then(res => {
          this.$alert(res.msg);
        })
      }
    },

    openPassport() {
      document.getElementById("passportButton").click();
    },
    //护照地址
    passportChange(file) {
      const isLt2M = file.size / 1024 / 1024 < 2
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
        return;
      }
      this.form.passportImg = file.name;
      this.passportFile = file.raw;
      console.log(file);
    },

    openIDPhoto() {
      document.getElementById("IDPhotoButton").click();
    },
    //手持证件照
    IDPhotoChange(file) {
      const isLt2M = file.size / 1024 / 1024 < 2
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
        return;
      }

      this.form.faceImg = file.name;
      this.IDPhotoFile = file.raw;
      console.log(file);
    },

    initData() {
      getUserProfile().then(res =>{
        this.form = res.userInfo;
      })
    },

    uploadImage() {
      if (this.passportFile == null || this.IDPhotoFile == null) {
        this.$message.error("请先选择证照！");
        return
      }
      const formData = new FormData();
      formData.append('image', this.passportFile, this.form.passportImg);
      axios.post(process.env.VUE_APP_BASE_API + '/common/uploadImage', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
          Authorization: "Bearer " + getToken()
        }
      })
        .then(response => {
          this.urls[0] = response.data.url;
          if (this.urls[1] != null) {
            this.realSubmit();
          }
        })

      const formData1 = new FormData();
      formData1.append('image', this.IDPhotoFile, this.form.faceImg);
      axios.post(process.env.VUE_APP_BASE_API + '/common/uploadImage', formData1, {
        headers: {
          'Content-Type': 'multipart/form-data',
          Authorization: "Bearer " + getToken()
        }
      })
        .then(response => {
          this.urls[1] = response.data.url;
          if (this.urls[0] != null) {
            this.realSubmit();
          }
        })

      console.log(this.urls);
    }
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
<style lang="less">
.el-input.is-disabled .el-input__inner {
  color: #000;
}
</style>
