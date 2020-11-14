package com.shippit.challenge.ft.model.rel;

import com.shippit.challenge.ft.model.Person;
import com.shippit.challenge.ft.model.RelationshipVisitor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class SiblingsRelationshipVisitor implements RelationshipVisitor {

    @Override
    public List<Person> visit(Person person) {
        Person mother = person.mother;

        if (mother == null) {
            return Collections.emptyList();
        }

        return mother.children.stream()
                .filter(child -> !person.equals(child))
                .collect(Collectors.toList());
    }
}
