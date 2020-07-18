package com.dish.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 肖远航
 */
@RestController
public class hello {
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
        return  "Hello SpringBoot";
    }
}
