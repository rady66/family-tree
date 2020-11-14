package com.shippit.challenge.ft.model.rel;

import com.shippit.challenge.ft.model.Person;
import com.shippit.challenge.ft.model.RelationshipVisitor;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class SisterInLawRelationshipVisitor implements RelationshipVisitor {

    @Override
    public List<Person> visit(Person person) {
        List<Person> result = new LinkedList<>();

        if (person.partner != null && person.partner.mother != null) {
            result.addAll(person.partner.mother.children.stream()
                    .filter(p -> !p.equals(person.partner))
                    .filter(p -> Person.Gender.Female.equals(p.gender))
                    .collect(Collectors.toList()));
        }

        if (person.mother != null) {
            result.addAll(person.mother.children.stream()
                    .filter(p -> !p.equals(person))
                    .filter(p -> Person.Gender.Male.equals(p.gender))
                    .filter(p -> p.partner != null)
                    .map(p -> p.partner)
                    .collect(Collectors.toList()));
        }

        return result;
    }

}
