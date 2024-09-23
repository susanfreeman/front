<template>
  <div class="pc">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      客服
    </div>

    <p class="hot_t">热门问题</p>
    <el-collapse v-model="activeNames" @change="handleChange">
      <el-collapse-item title="如何将USDT充值进Dupay Master/Visa卡？" name="1">
        <div>
          在欧易，币安等平台买USDT—提币到Dupay钱包账户（注意选择相同网络与链路）—Dupay钱包转成USD/GBP—充到Dupay预付卡/借记卡里。
        </div>
      </el-collapse-item>
      <el-collapse-item
        title="如何查看完整卡号，cvv安全码与卡片过期时间？"
        name="2"
      >
        <div>需要充值后才可以看到卡号，CVV安全码与过期时间。</div>
        <div>
          充值流程：充值USDT到钱包后，点击兑换成USD/GBP，将USD/GBP充值到卡内后就激活卡片。
        </div>
        <div>
          预付卡：标准卡、高级卡、lite卡最低充值30USD，白金卡黑金卡最低充值5USD
        </div>
        <div>借记卡：最低充值5GBP</div>
        <div>订阅卡：最低充值20USD</div>
        <div>
          进入App首页左下角-卡-上方CVV安全码，输入手机号验证后即可查看卡号、过期时间与CVV安全码。
        </div>
      </el-collapse-item>
      <el-collapse-item title="KYC认证需要什么资料？需要多久时间？" name="3">
        <div>预付卡KYC：</div>
        <div>中国大陆地区用户提供身份证，其他国家和地区用户提供护照。</div>
        <div>
          注：如果是身份证作为证件类型，则需要本人现场录制一段本人朗读随机数字的视频进行上传。
          预付卡一般一个工作日完成审核，如果未完成，请前往telegram联系人工客服。
        </div>
        <div>借记卡KYC：</div>
        <div>
          需支付认证费用，中国大陆地区用户提供身份证，其他国家和地区用户提供护照。
          认证时间需要3-5个工作日
        </div>
        <div>
          注：借记卡请提前准备证件避免中途中断，如果有问题可前往telegram联系人工客服进行帮助与指导。
        </div>
      </el-collapse-item>
      <el-collapse-item title="Dupay的使用场景有那些？" name="4">
        <div>Dupay的常见使用场景如下：</div>
        <div>
          1、Dupay Master/Visa卡支持绑定App store、Google play商店、Youtube
          premium、Paypal商户、Twitter premium和支持非3DS卡的电商网站等。
        </div>
        <div>2、暂不支持Apple pay和Google pay。</div>
        <div>3、支持绑定支付宝、淘宝、京东、拼多多、美团等场景消费。</div>
      </el-collapse-item>
      <el-collapse-item title="退款要多久？" name="5">
        <div>
          预付卡退款结算后会返回到原支付渠道，涉及国际结算需要7个工作日。目前借记卡退款周期较长，需1-3个月。还请耐心等待
        </div>
      </el-collapse-item>
    </el-collapse>

    <p class="seek_t">你是否在找？</p>
    <ul class="seek_ul">
      <a href="" target="_blank">
        <img src="../../../assets/service-1.png" alt="" />
        官方网站
      </a>

      <a href="" target="_blank">
        <img src="../../../assets/service-2.png" alt="" />
        联系邮箱
      </a>

      <a href="" target="_blank">
        <img src="../../../assets/service-3.png" alt="" />
        Telegram 社群
      </a>

      <a href="" target="_blank">
        <img src="../../../assets/service-4.png" alt="" />
        Twitter
      </a>
    </ul>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        activeNames: []
      }
    },
    methods: {
      handleChange(val) {
        console.log(val)
      },
      handleBack() {
        this.$router.push('/home/user/me')
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
    .hot_t {
      width: 100%;
      font-weight: 400;
      font-size: 12px;
      color: #6f7590;
      margin: 20px 0 10px;
    }
    .seek_t {
      width: 100%;
      font-weight: 400;
      font-size: 12px;
      color: #6f7590;
      margin: 20px 0 10px;
    }
    .seek_ul {
      display: flex;
      justify-content: space-between;
      flex-wrap: wrap;
      a {
        width: 168px;
        height: 52px;
        border-radius: 6px;
        box-sizing: border-box;
        cursor: pointer;
        border: 1px solid #e6e6e6;
        padding-left: 10px;
        margin-bottom: 10px;
        display: flex;
        align-items: center;
        font-weight: 700;
        font-size: 14px;
        color: #333;
        text-decoration: none;
        img {
          width: 32px;
          height: 32px;
          margin-right: 10px;
        }
      }
    }
  }
</style>
