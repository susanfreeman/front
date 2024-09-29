import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: 路由配置项
 *
 * hidden: true                     // 当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面，或者如一些编辑页面/edit/1
 * alwaysShow: true                 // 当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面
 *                                  // 只有一个时，会将那个子路由当做根路由显示在侧边栏--如引导页面
 *                                  // 若你想不管路由下面的 children 声明的个数都显示你的根路由
 *                                  // 你可以设置 alwaysShow: true，这样它就会忽略之前定义的规则，一直显示根路由
 * redirect: noRedirect             // 当设置 noRedirect 的时候该路由在面包屑导航中不可被点击
 * name:'router-name'               // 设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题
 * query: '{"id": 1, "name": "ry"}' // 访问路由的默认传递参数
 * roles: ['admin', 'common']       // 访问路由的角色权限
 * permissions: ['a:a:a', 'b:b:b']  // 访问路由的菜单权限
 * meta : {
    noCache: true                   // 如果设置为true，则不会被 <keep-alive> 缓存(默认 false)
    title: 'title'                  // 设置该路由在侧边栏和面包屑中展示的名字
    icon: 'svg-name'                // 设置该路由的图标，对应路径src/assets/icons/svg
    breadcrumb: false               // 如果设置为false，则不会在breadcrumb面包屑中显示
    activeMenu: '/system/user'      // 当路由设置了该属性，则会高亮相对应的侧边栏。
  }
 */

// 公共路由
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path(.*)',
        component: () => import('@/views/redirect')
      }
    ]
  },
  {
    path: "/home",
    redirect: "/home/account/account"
  },
  {
    path: "/home/account",
    redirect: "/home/account/account"
  },
  {
    path: "/home/notice",
    redirect: "/home/notice/notice-index"
  },
  {
    path: "/home/help",
    redirect: "/home/help/help-index"
  },
  {
    path: "/login",
    redirect: "/login/login"
  },
  {
    path: "/home/exchange-account",
    redirect: "/home/exchange-account/exchange"
  },
  {
    path: "/home/user",
    redirect: "/home/user/me"
  },
  {
    path: '/login',
    component: () => import("@/views/login/components/LoginPublic.vue"),
    // component: () => import('@/views/login/login'),
    hidden: true,
    meta: "登录注册",
    children: [
      {
        path: "login",
        name: "login",
        component: () => import("@/views/login/login/index.vue"),
        meta: "登录页"
      },
      {
        path: "agreement",
        name: "agreement",
        component: () => import("@/views/login/agreement/index.vue"),
        meta: "服务协议"
      },
      {
        path: "agreement-detail",
        name: "agreementDetail",
        component: () => import("@/views/login/agreement/Detail.vue"),
        meta: "服务协议详情"
      },
      {
        path: "register",
        name: "register",
        component: () => import("@/views/login/register/index.vue"),
        meta: "注册账户"
      },
      {
        path: "forgot",
        name: "forgot",
        component: () => import("@/views/login/forgot/index.vue"),
        meta: "忘记密码"
      },
      {
        path: "second",
        name: "second",
        component: () => import("@/views/login/loginSecond/index.vue"),
        meta: "二次验证"
      },
    ]
  },
  {
    path: "/home",
    component: () => import("@/views/main/components/MainPublic.vue"),
    meta: "首页",
    children: [
      {
        path: "account",
        name: "account",
        component: () => import("@/views/main/account/index.vue"),
        children: [
          {
            path: "account",
            name: "account",
            component: () => import("@/views/main/account/Account.vue"),
            meta: "卡管理首页"
          },
          {
            path: "Created",
            name: "Created",
            component: () => import("@/views/main/account/Created.vue"),
            meta: "申请卡"
          },

          {
            path: "create-card",
            name: "create-card",
            component: () => import("@/views/main/account/CreateCard.vue"),
            meta: "kyc验证"
          },
          {
            path: "create-card-simple",
            name: "create-card-simple",
            component: () => import("@/views/main/account/CreateCardSimple.vue"),
            meta: "开卡"
          },

          {
            path: "Equity",
            name: "Equity",
            component: () => import("@/views/main/account/Equity.vue"),
            meta: "权益"
          },
          {
            path: "coin-transfer",
            name: "coin-transfer",
            component: () => import("@/views/main/account/CoinTransfer.vue"),
            meta: "充值"
          },
        ],
        meta: "卡管理"
      },
      {
        path: "exchange-account",
        name: "exchange-account",
        component: () => import("@/views/main/exchangeAccount/index.vue"),
        children: [
          {
            path: "exchange",
            name: "exchange",
            component: () => import("@/views/main/exchangeAccount/ExchangeAccount.vue"),
            meta: "钱包首页"
          },
          {
            path: "coin-charge",
            name: "coin-charge",
            component: () => import("@/views/main/exchangeAccount/CoinCharge.vue"),
            meta: "充币"
          },
          {
            path: "coin-withdrawal",
            name: "coin-withdrawal",
            component: () => import("@/views/main/exchangeAccount/CoinWithdrawal.vue"),
            meta: "提币"
          },
          {
            path: "exchangeLog",
            name: "exchangeLog",
            component: () => import("@/views/main/exchangeAccount/exchangeLog.vue"),
            meta: "兑换记录"
          },

        ],
        meta: "钱包管理"
      },
      {
        path: "notice",
        name: "notice",
        component: () => import("@/views/main/notice/index.vue"),
        children: [
          {
            path: "notice-index",
            name: "notice-index",
            component: () => import("@/views/main/notice/notice.vue"),
            meta: "公告"
          },
          {
            path: "notice-detail",
            name: "notice-detail",
            component: () => import("@/views/main/notice/detail.vue"),
            meta: "公告详情"
          },
        ],
        meta: "公告栏"
      },
      {
        path: "help",
        name: "help",
        component: () => import("@/views/main/help/index.vue"),
        children: [
          {
            path: "help-index",
            name: "help-index",
            component: () => import("@/views/main/help/help.vue"),
            meta: "帮助"
          },
          {
            path: "common-problem",
            name: "common-problem",
            component: () => import("@/views/main/help/CommonProblem.vue"),
            meta: "常见问题"
          },
          {
            path: "help-detail",
            name: "help-detail",
            component: () => import("@/views/main/help/helpDetail.vue"),
            meta: "详情"
          },
        ],
        meta: "帮助中心"
      },
      {
        path: "contactUs",
        name: "contactUs",
        component: () => import("@/views/main/contactUs/index.vue"),
        meta: "联系我们"
      },
      {
        path: "user",
        name: "user",
        component: () => import("@/views/main/account/index.vue"),
        children: [
          {
            path: "me",
            name: "me",
            component: () => import("@/views/main/user/User.vue"),
            meta: "我的首页"
          },

          {
            path: "security",
            name: "security",
            component: () => import("@/views/main/user/security.vue"),
            meta: "安全中心"
          },

          {
            path: "commission",
            name: "commission",
            component: () => import("@/views/main/user/commission.vue"),
            meta: "邀请好友"
          },

          {
            path: "manage",
            name: "manage",
            component: () => import("@/views/main/user/manage.vue"),
            meta: "卡片管理"
          },

          {
            path: "service",
            name: "service",
            component: () => import("@/views/main/user/service.vue"),
            meta: "客服"
          },

          {
            path: "mode",
            name: "mode",
            component: () => import("@/views/main/user/mode.vue"),
            meta: "计价方式"
          },
          {
            path: "language",
            name: "language",
            component: () => import("@/views/main/user/language.vue"),
            meta: "语言"
          },
          {
            path: "authenticationStatus",
            name: "authenticationStatus",
            component: () => import("@/views/main/user/authenticationStatus.vue"),
            meta: "身份认证"
          },
          {
            path: "google",
            name: "google",
            component: () => import("@/views/main/user/google.vue"),
            meta: "谷歌验证器"
          },
          {
            path: "bindGoogle",
            name: "bindGoogle",
            component: () => import("@/views/main/user/bindGoogle.vue"),
            meta: "绑定谷歌验证器"
          },
          {
            path: "google-authenticator",
            name: "google-authenticator",
            component: () => import("@/views/main/user/googleAuthenticator.vue"),
            meta: "下载谷歌验证器"
          },
          {
            path: "edit-password",
            name: "edit-password",
            component: () => import("@/views/main/user/EditPassword.vue"),
            meta: "修改登录密码"
          },
        ],
        meta: "我的"
      },
    ]
  },
  {
    path: '/register',
    component: () => import('@/views/register'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error/401'),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    redirect: 'index',
    children: [
      {
        path: 'index',
        component: () => import('@/views/main/account/index'),
        name: 'Index',
        meta: { title: '首页', icon: 'dashboard', affix: true }
      }
    ]
  },
  {
    path: '/user',
    component: Layout,
    hidden: true,
    redirect: 'noredirect',
    children: [
      {
        path: 'profile',
        component: () => import('@/views/system/user/profile/index'),
        name: 'Profile',
        meta: { title: '个人中心', icon: 'user' }
      }
    ]
  }

]

// 动态路由，基于用户权限动态去加载
export const dynamicRoutes = [
  {
    path: '/system/user-auth',
    component: Layout,
    hidden: true,
    permissions: ['system:user:edit'],
    children: [
      {
        path: 'role/:userId(\\d+)',
        component: () => import('@/views/system/user/authRole'),
        name: 'AuthRole',
        meta: { title: '分配角色', activeMenu: '/system/user' }
      }
    ]
  },
  {
    path: '/system/role-auth',
    component: Layout,
    hidden: true,
    permissions: ['system:role:edit'],
    children: [
      {
        path: 'user/:roleId(\\d+)',
        component: () => import('@/views/system/role/authUser'),
        name: 'AuthUser',
        meta: { title: '分配用户', activeMenu: '/system/role' }
      }
    ]
  },
  {
    path: '/system/dict-data',
    component: Layout,
    hidden: true,
    permissions: ['system:dict:list'],
    children: [
      {
        path: 'index/:dictId(\\d+)',
        component: () => import('@/views/system/dict/data'),
        name: 'Data',
        meta: { title: '字典数据', activeMenu: '/system/dict' }
      }
    ]
  },
  {
    path: '/monitor/job-log',
    component: Layout,
    hidden: true,
    permissions: ['monitor:job:list'],
    children: [
      {
        path: 'index/:jobId(\\d+)',
        component: () => import('@/views/monitor/job/log'),
        name: 'JobLog',
        meta: { title: '调度日志', activeMenu: '/monitor/job' }
      }
    ]
  },
  {
    path: '/tool/gen-edit',
    component: Layout,
    hidden: true,
    permissions: ['tool:gen:edit'],
    children: [
      {
        path: 'index/:tableId(\\d+)',
        component: () => import('@/views/tool/gen/editTable'),
        name: 'GenEdit',
        meta: { title: '修改生成配置', activeMenu: '/tool/gen' }
      }
    ]
  }
]

// 防止连续点击多次路由报错
let routerPush = Router.prototype.push;
let routerReplace = Router.prototype.replace;
// push
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(err => err)
}
// replace
Router.prototype.replace = function push(location) {
  return routerReplace.call(this, location).catch(err => err)
}

export default new Router({
  mode: 'history', // 去掉url中的#
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})
