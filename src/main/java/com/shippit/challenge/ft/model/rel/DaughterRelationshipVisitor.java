package com.shippit.challenge.ft.model.rel;

import com.shippit.challenge.ft.model.Person;
import com.shippit.challenge.ft.model.RelationshipVisitor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class DaughterRelationshipVisitor implements RelationshipVisitor {

    @Override
    public List<Person> visit(Person person) {
        final Person mother = Person.Gender.Female.equals(person.gender) ? person : person.partner;

        if (mother == null) {
            return Collections.emptyList();
        }

        return mother.children.stream()
                .filter(child -> Person.Gender.Female.equals(child.gender))
                .collect(Collectors.toList());
    }
}
