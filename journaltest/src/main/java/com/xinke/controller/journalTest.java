package com.xinke.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: journaltest
 * @description:
 * @author: zhaoxinke
 * @create: 2019-08-21 11:55
 * @version: 1.0
 * @update: [1][2019-08-21] [zhaoxinke][新建]
 **/
@RestController
public class journalTest {

    private static final Logger logger = LoggerFactory.getLogger(journalTest.class);

    @RequestMapping("/test")
    public void test(){
        logger.info("fastjson parse error, the json msg is {}");
    }

}
