package com.github.feifuzeng.study.controller;

import com.github.feifuzeng.study.result.PlainResult;
import com.github.feifuzeng.study.service.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author feifz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年06月03日 17:31:00
 */
@Controller
public class UploadController {
    @Resource
    UploadService uploadService;


    @RequestMapping("/upload")
    @ResponseBody
    public PlainResult<String> upload(){
        return uploadService.upload();
    }

}
