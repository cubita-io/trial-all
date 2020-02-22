package io.cubita.trial.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.cubita.trial.spring.test.HelloConfig;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping
    public void test() {
        System.out.println(applicationContext.getBean(HelloConfig.class));
    }

}
