import request from '@/utils/request'

export function listDbTable() {
  return request({
    url: "/tool/gen/db/list",
    method: 'get'
  })
}