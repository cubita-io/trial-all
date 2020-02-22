package io.cubita.trial.springboot.web.configuration;

import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.cubita.trial.springboot.web.beans.CompositePerson;
import io.cubita.trial.springboot.web.beans.LisiPerson;
import io.cubita.trial.springboot.web.beans.Person;
import io.cubita.trial.springboot.web.beans.ZhangSanPerson;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@Configuration(proxyBeanMethods = false)
public class PersonAutoConfiguration {

    @Bean
    @Primary
    public Person compositePerson(ObjectProvider<Person> people) {
        return new CompositePerson(people.stream().collect(Collectors.toList()));
    }

    @Bean
    public Person zhangsanPerson() {
        System.out.println("zhangsan");
        return new ZhangSanPerson();
    }

    @Bean
    public Person lisiPerson() {
        System.out.println("lisi");
        return new LisiPerson();
    }

}
