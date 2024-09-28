import request from '@/utils/request'

// 查询余额
export function getBalance() {
  return request({
    url: '/getBalance',
    method: 'get'
  })
}

// 查询充值支持币种
export function getRechargeList() {
  return request({
    url: '/getRechargeList',
    method: 'get'
  })
}

// 查询币种地址
export function getRechargeAddr() {
  return request({
    url: '/getRechargeAddr',
    method: 'get'
  })
}

// 查询币种兑换后金额
export function getTargetAmount(data) {
  return request({
    url: '/exchange/getTargetAmount',
    method: 'post',
    data: data
  })
}

// 查询币种兑换后金额
export function change(data) {
  return request({
    url: '/exchange/change',
    method: 'post',
    data: data
  })
}
