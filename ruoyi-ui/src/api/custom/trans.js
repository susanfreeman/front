import request from '@/utils/request'

// 查询余额
export function getBaltrans(query) {
  return request({
    url: '/baltrans/list',
    method: 'post',
    params: query
  })
}

// 交易流水列表
export function getTrans(query) {
  return request({
    url: '/trans/list',
    method: 'post',
    params: query
  })
}
