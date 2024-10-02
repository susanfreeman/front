import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";


// 用户密码重置
export function resetUserPwd(userId, password) {
  const data = {
    userId,
    password
  }
  return request({
    url: '/system/user/resetPwd',
    method: 'put',
    data: data
  })
}


// 查询用户个人信息
export function getUserProfile() {
  return request({
    url: '/system/user/profile',
    method: 'get'
  })
}

// 获取2fa
export function getGoogle2fa() {
  return request({
    url: '/system/user/profile/getGoogle2fa',
    method: 'get'
  })
}

// 获取2fa
export function reset2fa(data) {
  return request({
    url: '/system/user/profile/reset2fa',
    method: 'post',
    data: data
  })
}

// 修改用户个人信息
export function updateUserProfile(data) {
  return request({
    url: '/system/user/profile',
    method: 'put',
    data: data
  })
}

// 用户密码重置
export function updateUserPwd(data) {
  return request({
    url: '/system/user/profile/resetPwd',
    method: 'post',
    data: data
  })
}

// 用户头像上传
export function uploadAvatar(data) {
  return request({
    url: '/system/user/profile/avatar',
    method: 'post',
    headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
    data: data
  })
}


