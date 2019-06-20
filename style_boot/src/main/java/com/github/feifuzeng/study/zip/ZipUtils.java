package com.github.feifuzeng.study.zip;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author feifz
 * @version 1.0.0
 * @Description 压缩文件为.zip文件工具类
 * @createTime 2019年06月03日 11:10:00
 * @Refer https://www.cnblogs.com/lihaiming93/p/8098255.html
 */
@Log4j2
public class ZipUtils {

    /**
     * 压缩文件
     *
     * @param srcFilePath  压缩源路径(可为文件夹路径和具体文件路径)
     * @param destFilePath 压缩目的路径(包含文件名和文件后缀)
     *                     ⚠️目标路径不可包含在源路径下，否则会陷入死循环
     */
    public static void compress(String srcFilePath, String destFilePath) {
        File src = new File(srcFilePath);
        if (!src.exists()) {
            throw new RuntimeException(srcFilePath + "不存在");
        }
        File zipFile = new File(destFilePath);
        try {
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            String baseDir = "";
            compressbyType(src, zos, baseDir);
            zos.close();
            fos.close();
        } catch (Exception e) {
            log.error("压缩文件异常->{}", e);
            e.printStackTrace();
        }
    }

    /**
     * 按照原路径的类型就行压缩。文件路径直接把文件压缩，
     *
     * @param src
     * @param zos
     * @param baseDir
     */
    private static void compressbyType(File src, ZipOutputStream zos, String baseDir) {
        if (!src.exists()) {
            return;
        }
        log.info("compress dir->{}", baseDir + src.getName());
        if (src.isFile()) {
            compressFile(src, zos, baseDir);
        } else if (src.isDirectory()) {
            compressDir(src, zos, baseDir);
        }
    }

    /**
     * 压缩文件
     */
    private static void compressFile(File file, ZipOutputStream zos, String baseDir) {
        if (!file.exists()) {
            return;
        }
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            ZipEntry entry = new ZipEntry(baseDir + file.getName());
            zos.putNextEntry(entry);
            int count;
            byte[] buf = new byte[1024];
            while ((count = bis.read(buf)) != -1) {
                zos.write(buf, 0, count);
            }
            bis.close();
        } catch (Exception e) {
            log.error("压缩文件异常->{}", e);

        }
        return;
    }

    /**
     * 压缩文件夹
     */
    private static void compressDir(File dir, ZipOutputStream zos, String baseDir) {
        if (!dir.exists()) {
            return;
        }
        File[] files = dir.listFiles();
        if (files.length == 0) {
            try {
                zos.putNextEntry(new ZipEntry(baseDir + dir.getName() + File.separator));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (File file : files) {
            compressbyType(file, zos, baseDir + dir.getName() + File.separator);
        }
        return;
    }

    /**
     * @param args 主方法
     */
    public static void main(String[] args) {
        /** 第一个参数是需要压缩的源路径
         *  第二个参数是压缩文件的目的路径，这边需要将压缩的文件名字加上去
         *  ⚠️目标路径不可包含在源路径下，否则会陷入死循环
         * */
        compress("/Users/feifuzeng/Desktop", "/Users/feifuzeng/temp/test.zip");

    }
}