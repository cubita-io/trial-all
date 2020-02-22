package io.cubita.trial.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public class HelloConfig  {

    public void init() {
        System.out.println("init");
    }

    @Autowired
    public void setApplicationContext(ApplicationContext context) {
        System.out.println(context);
    }
}
