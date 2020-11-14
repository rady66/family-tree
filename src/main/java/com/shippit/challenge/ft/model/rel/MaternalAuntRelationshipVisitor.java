package com.shippit.challenge.ft.model.rel;

import com.shippit.challenge.ft.model.Person;
import com.shippit.challenge.ft.model.RelationshipVisitor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class MaternalAuntRelationshipVisitor implements RelationshipVisitor {

    @Override
    public List<Person> visit(Person person) {
        final Person mother = person.mother;
        if (mother == null) {
            return Collections.emptyList();
        }

        final Person grandMother = mother.mother;
        if (grandMother == null) {
            return Collections.emptyList();
        }

        return grandMother.children.stream()
                .filter(child -> !child.equals(mother))
                .filter(child -> Person.Gender.Female.equals(child.gender))
                .collect(Collectors.toList());
    }
}
