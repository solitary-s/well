package com.aloneness.well.tool.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.aloneness.well.framework.enums.ErrorCodeEnum;
import com.aloneness.well.framework.exception.assertException.ApiAssert;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Value("${well.image.path}")
    private String imagePath;

    @Value("${well.image.url}")
    private String imageUrl;

    @GetMapping("/hello")
    public String hello(){
        return imagePath + " " + imageUrl;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        if (StrUtil.isEmpty(imagePath)) {
            ApiAssert.failure(ErrorCodeEnum.INTERNAL_SERVER_ERROR.convert("图片路径不存在"));
        }
        File file = new File(imagePath);
        // 创建文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
        String s = IdUtil.simpleUUID();
        String filePath = imagePath + s +multipartFile.getOriginalFilename();
        File upload = FileUtils.getFile(filePath);
        try {
            multipartFile.transferTo(upload);
        } catch (IOException e) {
            ApiAssert.failure(ErrorCodeEnum.INTERNAL_SERVER_ERROR.convert(e.getMessage()));
        }
        return imageUrl+ s + multipartFile.getOriginalFilename();
    }
}
