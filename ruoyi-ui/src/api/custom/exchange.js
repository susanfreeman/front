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
