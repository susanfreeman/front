import request from '@/utils/request'

// 查询可用卡宾
export function getCardBin() {
  return request({
    url: '/getCardBin',
    method: 'get'
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

// 查询币种兑换后金额
export function kec(data) {
  return request({
    url: '/kyc',
    method: 'post',
    data: data
  })
}
