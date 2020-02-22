package io.cubita.trial.springboot.web.beans;

import java.util.List;

import org.springframework.core.annotation.AnnotationAwareOrderComparator;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public class CompositePerson implements Person {
    private Person deletgatedPerson;

    public CompositePerson(List<Person> persons) {
        AnnotationAwareOrderComparator.sort(persons);
        this.deletgatedPerson = persons.get(0);
    }

    @Override
    public String name() {
        return deletgatedPerson.name();
    }
}
