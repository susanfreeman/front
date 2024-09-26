import request from '@/utils/request'

// 查询可用卡宾
export function getCardBin() {
  return request({
    url: '/getCardBin',
    method: 'get'
  })
}

// 查询币种兑换后金额
export function kyc(data) {
  return request({
    url: '/kyc',
    method: 'post',
    data: data
  })
}

// 查询已开卡
export function userCardList(data) {
  return request({
    url: '/usercard/list',
    method: 'post',
    data: data
  })
}

// 卡充值
export function cardRecharge(data) {
  return request({
    url: '/usercard/cardRecharge',
    method: 'post',
    data: data
  })
}

// 查询卡充值界面
export function getCardInfo(uocId) {
  return request({
    url: '/usercard/getCardInfo/'+uocId,
    method: 'get'
  })
}

// 查询卡余额
export function queryBalance(uocId) {
  return request({
    url: '/usercard/queryBalance/'+uocId,
    method: 'get'
  })
}
