package io.cubita.trial.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import io.cubita.trial.springboot.web.beans.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TrialSpringBootWebTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testOrderedPerson() {
        final Person person = applicationContext.getBean(Person.class);
        Assertions.assertThat(person.name()).isEqualTo("lisi");
    }

}
