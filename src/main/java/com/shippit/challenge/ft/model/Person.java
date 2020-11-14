package com.shippit.challenge.ft.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Person model.
 */
public class Person {

    public enum Gender {Male, Female}

    public final String name;
    public final Gender gender;

    public final Person mother;

    public Person partner;
    public List<Person> children = new LinkedList<>();

    // Constructors -----------------------------------------------------------------------

    public Person(Person mother, String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.mother = mother;
    }

    // Public methods ---------------------------------------------------------------------

    /**
     * Sets this persons partner (and visa versa).
     * @param partner partner person
     */
    public void setPartner(Person partner) {
        assert !this.gender.equals(partner.gender);
        this.partner = partner;
        partner.partner = this;
    }

    /**
     * Accepts relationship visitor and related persons according to the relationship visitor and this person.
     * @param relationshipVisitor relationship visitor
     * @return related persons according to the relationship visitor and this person
     */
    public List<Person> accept(RelationshipVisitor relationshipVisitor) {
        return relationshipVisitor.visit(this);
    }
}
