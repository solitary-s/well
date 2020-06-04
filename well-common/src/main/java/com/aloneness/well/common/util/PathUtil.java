package com.aloneness.well.common.util;


import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ResourceUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 上传下载路径工具
 *
 * @author
 */
@Slf4j
public class PathUtil {

    /**
     * classpath文件路径
     *
     * @return
     */
    public static File classPathFilePath() {
        try {
            // 获取跟目录
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if (!path.exists()) {
                path = new File("");
            }
            return path;
        } catch (IllegalStateException | IOException e) {
            log.error("classpath路径失败");
        }
        return null;

    }

    /**
     * classpath绝对路径
     *
     * @return
     */
    public static String getAbsolutePath() {
        // 获取跟目录
        File path = classPathFilePath();
        log.info("path:" + path.getAbsolutePath());
        return path.getAbsolutePath();
    }

    /**
     * 上传绝对路径
     * <p>
     * 在开发测试模式时，得到的地址为：{项目跟目录}/target/static/images/upload/
     * <p>
     * 在打包成jar正式发布时，得到的地址为：{发布jar包目录}/static/images/upload/
     * <p>
     *
     * @param uploadPath
     * @return
     */
    public static String uploadPath(String uploadPath) {
        return uploadPath(getAbsolutePath(), uploadPath);
    }

    /**
     * 上传绝对路径
     * <p>
     * 在开发测试模式时，得到的地址为：{项目跟目录}/target/static/images/upload/
     * <p>
     * 在打包成jar正式发布时，得到的地址为：{发布jar包目录}/static/images/upload/
     * <p>
     *
     * @param path
     * @param uploadPath
     * @return
     */
    public static String uploadPath(File path, String uploadPath) {
        return uploadPath(path.getAbsolutePath(), uploadPath);
    }

    /**
     * 上传绝对路径
     * <p>
     * 在开发测试模式时，得到的地址为：{项目跟目录}/target/static/images/upload/
     * <p>
     * 在打包成jar正式发布时，得到的地址为：{发布jar包目录}/static/images/upload/
     * <p>
     *
     * @param absolutePath
     * @param uploadPath
     * @return
     */
    public static String uploadPath(String absolutePath, String uploadPath) {
        if (StringUtils.isBlank(uploadPath)) {
            uploadPath = "static/images/upload/";
        }
        // 如果上传目录为/static/images/upload/，则可以如下获取：
        File upload = new File(absolutePath, uploadPath);
        if (!upload.exists()) {
            upload.mkdirs();
        }
        log.info("upload url:" + upload.getAbsolutePath());
        return upload.getAbsolutePath() + File.separator;
    }

}