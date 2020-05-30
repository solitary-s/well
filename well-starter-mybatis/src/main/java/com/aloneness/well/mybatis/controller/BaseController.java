package com.aloneness.well.mybatis.controller;

import com.aloneness.well.common.util.RequestUtil;
import com.github.pagehelper.PageHelper;

public class BaseController {

    public void startPage() {
        String pageNumStr = RequestUtil.getRequest().getParameter("pageNum");
        String pageSizeStr = RequestUtil.getRequest().getParameter("pageSize");

        int pageNum = Integer.valueOf(pageNumStr);
        int pageSize = Integer.valueOf(pageSizeStr);
        PageHelper.startPage(pageNum, pageSize);
    }


}
