import request from '@/utils/request'

#if($table.crud)
// 分页查询${functionName}列表
export function page${BusinessName}(query) {
    return request({
        url: '/${moduleName}/${businessName}/page',
        method: 'get',
        params: query
    })
}
#end

// 查询${functionName}列表
export function list${BusinessName}(query) {
    return request({
        url: '/${moduleName}/${businessName}/list',
        method: 'get',
        params: query
    })
}

// 查询${functionName}详细
export function get${BusinessName}(${pkColumn.javaField}) {
    return request({
        url: '/${moduleName}/${businessName}/' + ${pkColumn.javaField},
        method: 'get'
    })
}

// 新增${functionName}
export function add${BusinessName}(data) {
    return request({
        url: '/${moduleName}/${businessName}',
        method: 'post',
        data: data
    })
}

// 修改${functionName}
export function update${BusinessName}(data) {
    return request({
        url: '/${moduleName}/${businessName}',
        method: 'put',
        data: data
    })
}

// 删除${functionName}
export function del${BusinessName}(${pkColumn.javaField}) {
    return request({
        url: '/${moduleName}/${businessName}/' + ${pkColumn.javaField},
        method: 'delete'
    })
}

// 导出${functionName}
export function export${BusinessName}(query) {
    return request({
        url: '/${moduleName}/${businessName}/export',
        method: 'get',
        params: query
    })
}