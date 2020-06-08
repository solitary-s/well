package com.aloneness.well.mybatis.controller;

import cn.hutool.http.HttpStatus;
import com.aloneness.well.framework.util.RequestUtil;
import com.aloneness.well.mybatis.domain.PageInfo;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class BaseController {

    /**
     * 设置请求分页数据
     */
    public void startPage() {
        String pageNumStr = RequestUtil.getRequest().getParameter("pageNum");
        String pageSizeStr = RequestUtil.getRequest().getParameter("pageSize");

        int pageNum = StringUtils.isEmpty(pageNumStr) ? 1 : Integer.valueOf(pageNumStr);
        int pageSize = StringUtils.isEmpty(pageSizeStr) ? 10 : Integer.valueOf(pageSizeStr);
        PageHelper.startPage(pageNum, pageSize);
    }

    /**
     * 响应请求分页数据
     *
     * @param list
     * @param <T>
     * @return
     */
    public <T> PageInfo<T> getPageInfo(List<T> list) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCode(HttpStatus.HTTP_OK);
        pageInfo.setRows(list);
        pageInfo.setTotal(new com.github.pagehelper.PageInfo(list).getTotal());
        return pageInfo;
    }

}
