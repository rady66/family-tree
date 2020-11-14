package com.shippit.challenge.ft.model;

import com.shippit.challenge.ft.model.rel.RelationshipVisitorMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Family Tree Model.
 */
public class FamilyTree {

    private final Map<String, Person> nameTofamilyMemberMap;

    public FamilyTree() {
        this.nameTofamilyMemberMap = new HashMap<>();
    }

    public Person addMember(Person.Gender gender, String name) {
        return addMember(gender, (Person) null, name);
    }

    /**
     * Add new family member as a child through a mother.
     * @param gender new member gender
     * @param motherName new member mother's name
     * @param name new member name
     * @return new family member object
     * @throws PersonNotFoundException if mother is not found
     * @throws PersonAdditionFailedException if not added through mother
     */
    public Person addMember(Person.Gender gender, String motherName, String name) throws PersonNotFoundException,
            PersonAdditionFailedException {

        final Person mother = nameTofamilyMemberMap.get(motherName);
        validateMother(mother);

        return addMember(gender, mother, name);
    }

    public List<Person> list(String name, String relationship) throws PersonNotFoundException {
        Person person = nameTofamilyMemberMap.get(name);
        if (person == null) {
            throw new PersonNotFoundException("PERSON_NOT_FOUND");
        }
        return person.accept(RelationshipVisitorMapper.map(Relationship.from(relationship)));
    }

    // Private methods --------------------------------

    private void validateMother(Person mother) {
        if (mother == null) {
            throw new PersonNotFoundException("PERSON_NOT_FOUND");
        }

        if (!Person.Gender.Female.equals(mother.gender)) {
            throw new PersonAdditionFailedException("CHILD_ADDITION_FAILED");
        }
    }

    private Person addMember(Person.Gender gender, Person mother, String name) {
        final Person familyMember = new Person(mother, name, gender);

        if (mother != null) {
            mother.children.add(familyMember);
        }

        nameTofamilyMemberMap.put(name, familyMember);

        return familyMember;
    }
}
