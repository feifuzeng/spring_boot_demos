package com.github.feifuzeng.study.service;

import com.github.feifuzeng.study.result.PlainResult;
import com.ohaotian.plugin.file.FileClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年06月03日 17:16:00
 */
@Service
@Log4j2
public class UploadService {

    @Resource
    FileClient fileClient;

    public PlainResult<String> upload(){
        PlainResult<String> result = new PlainResult<>();
        try {
            String filePath = "aaa/bbb/ccc";
            String fileName = "hello.pdf";
            File file = new File("/Users/feifuzeng/Desktop/unzipfile.pdf");
            InputStream inputStream = new FileInputStream(file);
            fileClient.uploadFileByInputStream(filePath, fileName, inputStream);
        }catch (Exception e){
            log.error(e);
        }
        return result;
    }

}
