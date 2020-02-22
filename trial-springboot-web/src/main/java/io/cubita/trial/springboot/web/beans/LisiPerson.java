package io.cubita.trial.springboot.web.beans;

import org.springframework.core.annotation.Order;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@Order(1)
public class LisiPerson implements Person {
    @Override
    public String name() {
        return "lisi";
    }
}
