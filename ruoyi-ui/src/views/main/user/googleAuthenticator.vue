<template>
  <div class="google_outer">
    <div class="pc_back" @click="handleBack">
      <i class="el-icon-back"></i>
      谷歌身份验证器
    </div>

    <div class="google_box">
      <p class="title">下载谷歌验证器</p>
      <p class="tip">下载谷歌验证器</p>
      <div class="code">
        <div>
          <img src="../../../assets/googleios.png" />
          IOS
        </div>
        <div>
          <img
            src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAZAAAAGQCAIAAAAP3aGbAAAACXBIWXMAAA7EAAAOxAGVKw4bAAALyUlEQVR4nO3dUa7bMA4F0LxB97/lzgIm7oSQyPKm53wHsuwkFwJMkD+/f/9+AST4z9/eAMCnBBYQQ2ABMQQWEENgATEEFhBDYAExBBYQQ2ABMQQWEENgATEEFhBDYAExBBYQ41fp0z8/P037OPfUJ+dpz28/X7rBvs48V/Zc2t6VRfpWfrvI/Dd+xfwjTfzbPnHCAmIILCCGwAJiCCwghsACYggsIEatrOGt+bk7V4oPSm/K+8xv4/wld+m1+pXqipIr3/hwgUtidUXVlXt0wgJiCCwghsACYggsIIbAAmIILCCGwAJiXKjDenJedrGnVKSvM8l8z5O+vjp9217+lM6L6fZ0hln+t3XCAmIILCCGwAJiCCwghsACYggsIEZjWcMSVyoV+jqTlFx5u39+L08fPh/q01c3cMX8Fd9aso2/wgkLiCGwgBgCC4ghsIAYAguIIbCAGAILiPH9dVh9Y75KFUalRa4U2pTqs/o+XFqk9GVVtzE/cOxzpdK2f5kTFhBDYAExBBYQQ2ABMQQWEENgATEayxqWv5E974VSMj/+pKSv+OPJlUqFpm281vw8/tkWOk+csIAYAguIIbCAGAILiCGwgBgCC4ghsIAYF+qwllcY7alweauv3md+Ctl50daVcrAlP8jlRVtLnlKVExYQQ2ABMQQWEENgATEEFhBDYAExamUNS0oBSpa/3V/ydvnKNoab8FT3vGQQzvnPo/qcE/+2T5ywgBgCC4ghsIAYAguIIbCAGAILiCGwgBiNY76Gy5GqK5f6uly54oaVr1xxfht9nu7lvABqfoBYYkOb6t6csIAYAguIIbCAGAILiCGwgBgCC4ghsIAYP8M9jPYU2rx1pQDqm9oPnVtS2la9Yp8r5Uh9zr+v1j+LExYQQ2ABMQQWEENgATEEFhBDYAExamUNw688S668GF5SA9HXJ+TJkjFfT/q2l9iS5cl895tzyhqAryWwgBgCC4ghsIAYAguIIbCAGAILiFEb89VXaDNfwvP2in3Trq4UbV2ZnFZ61MNtT5b3oplXqoq6cuN93W+ubM8JC4ghsIAYAguIIbCAGAILiCGwgBi1soa35ht0zOtrCbLhcn9r8Q2WPOorxTfVxc9XmB/244QFxBBYQAyBBcQQWEAMgQXEEFhADIEFxLgw5quv9cR8lceT4e31DXd6WrxvZNnybSy3pNnLnv+4ExYQQ2ABMQQWEENgATEEFhBDYAExLrSXuaI0HeTzFf6wyObuN0t6nlR38tb88J4rDyTxxq84/ye2csICYggsIIbAAmIILCCGwAJiCCwghsACYkzXYc0Xp5Tqs54+XCpOOS8aap2qtKQJzPkKS55G1fAjfVo8tJOPExYQQ2ABMQQWEENgATEEFhBDYAExLkzNKel7fXtleMy8voKJJ5sHscy3yumrTbmyjc9X+IP5P9fn2zA1B/haAguIIbCAGAILiCGwgBgCC4ghsIAYtTqs2tI7+lSUCm2WFGc9Wf6U5puNlJzXAS1/Sok/dXVYwNcSWEAMgQXEEFhADIEFxBBYQIza1Jy+Nhrno0RKA2+qi3y+QnWRkr4ZKleu2Ne4ZrnNHXuq5scIlThhATEEFhBDYAExBBYQQ2ABMQQWEENgATEa28u8v15bJVG1KqqvhKRvjtOVep/hoU97brzkvDDwyfDP4w+f/3wRY74AygQWEENgATEEFhBDYAExBBYQQ2ABMabrsK5Y0ndpSYVRta5qeCbVkqd0ZZHh2r2nK85X3j2Zn2/mhAXEEFhADIEFxBBYQAyBBcQQWECMWlnDks4kfS9T57vffL5C1fwIpvPvpXWO2ZJhXG/tKcrZHAgvJywgiMACYggsIIbAAmIILCCGwAJiCCwgxoX2MksKOqr66oA+v9yT1qKtvgFW5/rmaLUa7ne05M/ypPXLcsICYggsIIbAAmIILCCGwAJiCCwgxq/Sp5e85C552vP5y9fW6SB9Ervf9HUlKintef6RLmmV08oJC4ghsIAYAguIIbCAGAILiCGwgBgCC4hRq8M6L+G5UuXR183jyoSo8wKcKytfqQM6v+J8CdWSoq2S1uqn4e43T65c0QkLiCGwgBgCC4ghsIAYAguIIbCAGLWpOecvX6/UDZTMD/UZnsdT2saVnSxvY7Kkvc98l5u+72XPyk5YQAyBBcQQWEAMgQXEEFhADIEFxBBYQIxaHdaF660ZInQ+uWtJJdGeR3qu9caHZ7XNFwD26Wu7pA4L+FoCC4ghsIAYAguIIbCAGAILiFGbmnNlEEvTCvNzR0r6ykf6hvc8LbLke1nSRuY1Ps2oWjAxPGWq9Z/ohAXEEFhADIEFxBBYQAyBBcQQWEAMgQXEqNVhvdVXB9RXSXRl8b7+IVcKalrrsz5f+co2+la+csWSJeVjrbPC+jhhATEEFhBDYAExBBYQQ2ABMQQWEKNW1jDfTeLzbbSuPDwdpK9dSetOSiuc/5aWT8258ivtq664Yrjf1MsJCwgisIAYAguIIbCAGAILiCGwgBgCC4hxYczX/NCn+eqPc1fKkfqGPvWZf/7Li+lKi/TVjs13hbpSU+aEBcQQWEAMgQXEEFhADIEFxBBYQAyBBcRo7IfVV581X/l1br44aMmNz7ty48P9sOaHbi1vBPbECQuIIbCAGAILiCGwgBgCC4ghsIAYtbKGkiUv7Pve+u8ZYNVnyWC3eX3ztc5XvrKN+YKJK9twwgJiCCwghsACYggsIIbAAmIILCCGwAJi/AyXYywZuvVkeZeb+Y49w/VxfaVtVYnNkZb8udRhAbxeAgsIIrCAGAILiCGwgBgCC4jRWNbw/npt762r79rPb3xJl5UrNz7/4c9XuGVzx5j539KSYUvKGoCvJbCAGAILiCGwgBgCC4ghsIAYAguIUavDOq/RWNKZ5MoVn/TdyxV9BWhLStuWDLC6IrEXjfYyAK+XwAKCCCwghsACYggsIIbAAmL8Kn16+B38lYqEK+/gS/1DhlvlzM9KWdI4Zb5BypKWLE/6tnflT3Tlh+qEBcQQWEAMgQXEEFhADIEFxBBYQAyBBcS40F6mr2iob/bUHz7/ub4JUfPbKJlvAnP+w6va3ITnir76xBLtZYCvJbCAGAILiCGwgBgCC4ghsIAYtbKG90vsnqFyxeanVL1in+VtZ8630VeUc8XXP9KXExYQRGABMQQWEENgATEEFhBDYAExBBYQo7EOq2RJodOSnhtP5rfRN7LsrdYSnr5eKEu+8Sd9zXmGfx4vJywgiMACYggsIIbAAmIILCCGwAJiXJiaU5L4mrZ6xXPLqyvmLRlQ1Cf0m+0bffTECQuIIbCAGAILiCGwgBgCC4ghsIAYAguI8av06b7Ko5Ilg5Ja22icb6OvF8qSqqgr1Wp9lXfLx6w9WX7jTlhADIEFxBBYQAyBBcQQWEAMgQXEEFhAjFod1p5GPP/rqVSktU/W+cqJs6eeDHcNm7dkclpV3/cy/xtzwgJiCCwghsACYggsIIbAAmIILCBGrazhrfn31lfqBs7fLl9ZeU/jjnPDLXTmX8zvqSAp6fte5v/7TlhADIEFxBBYQAyBBcQQWEAMgQXEEFhAjJ/zOqD5cVJ925gvtDmvZFHhdWLJjYd+WeqwAB4JLCCGwAJiCCwghsACYggsIMaF9jLLlSoV+koE5lt8XLmX8yvOVyRcuWJiucnyla98L05YQAyBBcQQWEAMgQXEEFhADIEFxBBYQIzvr8NKHPPVVyNTXby0wnCzkdbLnbcwWj7+7kp9YsmVp+SEBcQQWEAMgQXEEFhADIEFxBBYQIzGsob517pv9Y3emR/qM69UdTF8L619dfrayzRdrnWRvgqeKicsIIbAAmIILCCGwAJiCCwghsACYggsIMaFOqzllURPNpeJ9fWiKW3jyof7qnKqK1/pHbTBlZ/ufJmY9jLAv0VgATEEFhBDYAExBBYQQ2ABMX6WvN0H+L+csIAYAguIIbCAGAILiCGwgBgCC4ghsIAYAguIIbCAGAILiCGwgBgCC4ghsIAYAguIIbCAGP8FADl+YJ0lXSwAAAAASUVORK5CYII="
          />
          Android
        </div>
      </div>
      <img src="../../../assets/google_img1.png" class="google_img" />
    </div>
  </div>
</template>

<script>
  export default {
    methods: {
      handleBack() {
        this.$router.push('/home/user/google')
      }
    }
  }
</script>

<style lang="less" scoped>
  @media screen and (min-width: 600px) {
    .google_outer {
      width: 100%;
      min-height: 500px;
      height: calc(100vh - 500px);
      overflow: hidden;
      background: #fff;
      .pc_back {
        display: none;
      }
      .google_box {
        width: 1366px;
        margin: 120px auto 60px;
        padding-left: 100px;
        position: relative;
        .title {
          color: #333;
          font-size: 30px;
          font-weight: 700;
        }
        .tip {
          color: #6f7590;
          font-size: 14px;
          margin: 10px 0 20px;
        }
        .code {
          color: #333;
          font-size: 14px;
          display: flex;
          text-align: center;
          div {
            margin-right: 24px;
            img {
              width: 140px;
              height: 140px;
              border: 1px solid #e8e8f1;
              display: block;
              margin-bottom: 6px;
            }
          }
        }
        .google_img {
          width: 157px;
          position: absolute;
          top: 52px;
          right: 215px;
        }
      }
    }
  }

  @media screen and (max-width: 600px) {
    .google_outer {
      width: 100%;
      height: 100%;
      margin: 0;
      border-radius: 0px;
      background: #fff;
      padding: 16px;
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
      .google_box {
        padding-top: 30px;
        .title {
          color: #333;
          font-size: 20px;
          font-weight: 700;
        }
        .tip {
          color: #6f7590;
          font-size: 14px;
          margin: 10px 0 20px;
        }
        .code {
          color: #333;
          font-size: 14px;
          display: flex;
          text-align: center;
          div {
            margin-right: 24px;
            img {
              width: 140px;
              height: 140px;
              border: 1px solid #e8e8f1;
              display: block;
              margin-bottom: 6px;
            }
          }
        }
        .google_img {
          display: none;
        }
      }
    }
  }
</style>
