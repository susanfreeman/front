(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4d3c07cb"],{"0eea":function(e,t,r){"use strict";r("f2e9")},4261:function(e,t,r){"use strict";r("ef07")},c0c7:function(e,t,r){"use strict";r.d(t,"k",(function(){return a})),r.d(t,"h",(function(){return l})),r.d(t,"f",(function(){return n})),r.d(t,"j",(function(){return s})),r.d(t,"n",(function(){return i})),r.d(t,"o",(function(){return u})),r.d(t,"p",(function(){return c}));var o=r("b775");r("c38a");function a(e,t){var r={userId:e,password:t};return Object(o["a"])({url:"/system/user/resetPwd",method:"put",data:r})}function l(){return Object(o["a"])({url:"/system/user/profile",method:"get"})}function n(){return Object(o["a"])({url:"/system/user/profile/getGoogle2fa",method:"get"})}function s(e){return Object(o["a"])({url:"/system/user/profile/reset2fa",method:"post",data:e})}function i(e){return Object(o["a"])({url:"/system/user/profile",method:"put",data:e})}function u(e){return Object(o["a"])({url:"/system/user/profile/resetPwd",method:"post",data:e})}function c(e){return Object(o["a"])({url:"/system/user/profile/avatar",method:"post",headers:{"Content-Type":"application/x-www-form-urlencoded"},data:e})}},d332:function(e,t,r){"use strict";r.d(t,"e",(function(){return a})),r.d(t,"h",(function(){return l})),r.d(t,"j",(function(){return n})),r.d(t,"d",(function(){return s})),r.d(t,"c",(function(){return i})),r.d(t,"a",(function(){return u})),r.d(t,"g",(function(){return c})),r.d(t,"i",(function(){return m})),r.d(t,"b",(function(){return f})),r.d(t,"f",(function(){return d}));var o=r("b775");function a(){return Object(o["a"])({url:"/getCardBin",method:"get"})}function l(e){return Object(o["a"])({url:"/kyc",method:"post",data:e})}function n(e){return Object(o["a"])({url:"/usercard/list",method:"post",data:e})}function s(e){return Object(o["a"])({url:"/usercard/cardRecharge",method:"post",data:e})}function i(e){return Object(o["a"])({url:"/usercard/cardInfoBy2fa",method:"post",data:e})}function u(e){return Object(o["a"])({url:"/applyCard",method:"post",data:e})}function c(e){return Object(o["a"])({url:"/usercard/getCardInfo/"+e,method:"get"})}function m(e){return Object(o["a"])({url:"/usercard/queryBalance/"+e,method:"get"})}function f(e){return Object(o["a"])({url:"/usercard/cancel/"+e,method:"get"})}function d(e){return Object(o["a"])({url:"/getCardBinByCbid/"+e,method:"get"})}},ef07:function(e,t,r){},eff7:function(e,t,r){"use strict";r.r(t);var o=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"pc"},[r("div",{staticClass:"pc_back",on:{click:e.handleBack}},[r("i",{staticClass:"el-icon-back"}),e._v(" KYC验证 ")]),r("div",{staticClass:"kyc-form"},[r("el-form",{ref:"form",attrs:{model:e.form,"label-width":"100px"}},[r("el-form-item",{attrs:{label:"币种:"}},[r("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择币种",clearable:""},model:{value:e.form.curr,callback:function(t){e.$set(e.form,"curr",t)},expression:"form.curr"}},e._l(e.dict.type.bus_cur,(function(e){return r("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),r("el-form-item",{attrs:{label:"姓氏:"}},[r("el-input",{model:{value:e.form.firstName,callback:function(t){e.$set(e.form,"firstName",t)},expression:"form.firstName"}})],1),r("el-form-item",{attrs:{label:"名:"}},[r("el-input",{model:{value:e.form.lastName,callback:function(t){e.$set(e.form,"lastName",t)},expression:"form.lastName"}})],1),r("el-form-item",{attrs:{label:"邮编:"}},[r("el-input",{model:{value:e.form.postCode,callback:function(t){e.$set(e.form,"postCode",t)},expression:"form.postCode"}})],1),r("el-form-item",{attrs:{label:"国家(地区):"}},[r("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择国家(地区)",clearable:""},model:{value:e.form.country,callback:function(t){e.$set(e.form,"country",t)},expression:"form.country"}},e._l(e.dict.type.buss_country,(function(e){return r("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),r("el-form-item",{attrs:{label:"省:"}},[r("el-input",{model:{value:e.form.province,callback:function(t){e.$set(e.form,"province",t)},expression:"form.province"}})],1),r("el-form-item",{attrs:{label:"城市:"}},[r("el-input",{model:{value:e.form.city,callback:function(t){e.$set(e.form,"city",t)},expression:"form.city"}})],1),r("el-form-item",{attrs:{label:"手机号前缀:"}},[r("el-input",{model:{value:e.form.mobilePrefix,callback:function(t){e.$set(e.form,"mobilePrefix",t)},expression:"form.mobilePrefix"}})],1),r("el-form-item",{attrs:{label:"手机号码:"}},[r("el-input",{model:{value:e.form.mobile,callback:function(t){e.$set(e.form,"mobile",t)},expression:"form.mobile"}})],1),r("el-form-item",{attrs:{label:"地址:"}},[r("el-input",{model:{value:e.form.address,callback:function(t){e.$set(e.form,"address",t)},expression:"form.address"}})],1),r("el-form-item",{attrs:{label:"邮箱:"}},[r("el-input",{model:{value:e.form.email,callback:function(t){e.$set(e.form,"email",t)},expression:"form.email"}})],1),r("el-form-item",{attrs:{label:"证件类型:"}},[r("el-select",{staticStyle:{width:"100%"},attrs:{placeholder:"请选择证件类型",clearable:""},model:{value:e.form.idType,callback:function(t){e.$set(e.form,"idType",t)},expression:"form.idType"}},e._l(e.dict.type.buss_cert_type,(function(e){return r("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),r("el-form-item",{attrs:{label:"证件号码:"}},[r("el-input",{model:{value:e.form.idNo,callback:function(t){e.$set(e.form,"idNo",t)},expression:"form.idNo"}})],1),r("el-form-item",{attrs:{label:"护照图片地址:"}},[r("el-input",{attrs:{disabled:!0,placeholder:"选择文件"},model:{value:e.form.passportImg,callback:function(t){e.$set(e.form,"passportImg",t)},expression:"form.passportImg"}},[r("el-button",{attrs:{slot:"append",type:"info"},on:{click:e.openPassport},slot:"append"},[e._v(" 选择... ")])],1),r("el-upload",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{action:"","auto-upload":!1,"show-file-list":!1,"on-change":e.passportChange}},[r("el-button",{attrs:{size:"small",type:"primary",id:"passportButton"}})],1)],1),r("el-form-item",{attrs:{label:"手持证件照:"}},[r("el-input",{attrs:{disabled:!0,placeholder:"选择文件"},model:{value:e.form.faceImg,callback:function(t){e.$set(e.form,"faceImg",t)},expression:"form.faceImg"}},[r("el-button",{attrs:{slot:"append",type:"info"},on:{click:e.openIDPhoto},slot:"append"},[e._v(" 选择...")])],1),r("el-upload",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{action:"","auto-upload":!1,"show-file-list":!1,"on-change":e.IDPhotoChange}},[r("el-button",{attrs:{size:"small",type:"primary",id:"IDPhotoButton"}})],1)],1),r("el-form-item",{attrs:{label:"生日:"}},[r("el-date-picker",{staticStyle:{width:"100%"},attrs:{type:"date",placeholder:"YYYY-MM-DD"},model:{value:e.form.birthday,callback:function(t){e.$set(e.form,"birthday",t)},expression:"form.birthday"}})],1),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v("KYC验证")])],1)],1)],1)])},a=[],l=(r("14d9"),r("b0c0"),r("d332")),n=r("c0c7"),s=r("bc3a"),i=r.n(s),u=r("5f87"),c={dicts:["bus_cur","buss_country","buss_cert_type"],data:function(){return{form:{curr:"",firstName:"",lastName:"",postCode:"",country:"",province:"",city:"",mobilePrefix:"",mobile:"",address:"",email:"",idType:"",idNo:"",passportImg:"",faceImg:"",birthday:""},urls:[],passportFile:null,IDPhotoFile:null}},created:function(){this.initData()},methods:{handleBack:function(){this.$router.push("/home/account/Created")},onSubmit:function(){this.uploadImage()},realSubmit:function(){var e=this;null!=this.urls&&2==this.urls.length&&(this.form.passportImg=this.urls[0],this.form.faceImg=this.urls[1],Object(l["h"])(this.form).then((function(t){e.$alert(t.msg)})))},openPassport:function(){document.getElementById("passportButton").click()},passportChange:function(e){var t=e.size/1024/1024<2;t?(this.form.passportImg=e.name,this.passportFile=e.raw,console.log(e)):this.$message.error("上传头像图片大小不能超过 2MB!")},openIDPhoto:function(){document.getElementById("IDPhotoButton").click()},IDPhotoChange:function(e){var t=e.size/1024/1024<2;t?(this.form.faceImg=e.name,this.IDPhotoFile=e.raw,console.log(e)):this.$message.error("上传头像图片大小不能超过 2MB!")},initData:function(){var e=this;Object(n["h"])().then((function(t){e.form=t.userInfo}))},uploadImage:function(){var e=this;if(null!=this.passportFile&&null!=this.IDPhotoFile){var t=new FormData;t.append("image",this.passportFile,this.form.passportImg),i.a.post("//common/uploadImage",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer "+Object(u["a"])()}}).then((function(t){e.urls[0]=t.data.url,null!=e.urls[1]&&e.realSubmit()}));var r=new FormData;r.append("image",this.IDPhotoFile,this.form.faceImg),i.a.post("//common/uploadImage",r,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer "+Object(u["a"])()}}).then((function(t){e.urls[1]=t.data.url,null!=e.urls[0]&&e.realSubmit()})),console.log(this.urls)}else this.$message.error("请先选择证照！")}}},m=c,f=(r("0eea"),r("4261"),r("2877")),d=Object(f["a"])(m,o,a,!1,null,"00176b32",null);t["default"]=d.exports},f2e9:function(e,t,r){}}]);