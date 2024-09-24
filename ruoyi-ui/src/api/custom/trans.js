import request from '@/utils/request'

// 查询余额
export function getBaltrans() {
  return request({
    url: '/baltrans/list',
    method: 'get'
  })
}

// 交易流水列表
export function getTrans() {
  return request({
    url: '/trans/list',
    method: 'get'
  })
}
