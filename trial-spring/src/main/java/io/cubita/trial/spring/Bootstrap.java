package io.cubita.trial.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import io.cubita.trial.spring.config.ObjectPostProcessor;
import io.cubita.trial.spring.test.HelloConfig;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@SpringBootApplication
public class Bootstrap  {

    @Autowired
    private ObjectPostProcessor<Object> objectObjectPostProcessor;

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(Bootstrap.class, args);
//        final HelloConfig hello = context.getBean(HelloConfig.class);
//        System.out.println(hello);
    }

    @PostConstruct
    public void init() {
        final HelloConfig helloConfig = objectObjectPostProcessor.postProcess(new HelloConfig());
        System.out.println(applicationContext);
        System.out.println(helloConfig);
    }

}
