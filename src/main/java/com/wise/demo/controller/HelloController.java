package com.wise.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * 控制器
 * @author lingyuwang
 *
 */
@RestController
@Slf4j
public class HelloController {

	@RequestMapping(value = "/hello", method=RequestMethod.GET)
    public String hello() {
    	log.info("执行hello方法开始");
		
		log.debug("hello debug log ...");
		
		log.info("hello info log ...");
		
		log.warn("hello warn log ...");

		log.error("hello error log ...");
		
		log.info("执行hello方法结束");
        return "hi";
    }

}
