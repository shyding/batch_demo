package com.liquid.apw.demo.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.liquid.apw.demo.batch.beans.Person;

public class PersonItemReverseProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemReverseProcessor.class);

    @Override
    public Person process(final Person person) throws Exception {
        final String firstName = new StringBuffer(person.getFirstName()).reverse().toString();
        final String lastName = new StringBuffer(person.getLastName()).reverse().toString();

        final Person transformedPerson = new Person(firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}
