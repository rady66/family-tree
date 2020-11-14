package com.shippit.challenge.ft.model;

import java.util.List;

/**
 * Relationship Visitor class.
 */
public interface RelationshipVisitor {

    /**
     * Return list of persons with that relationship to the person specified.
     * @param person person
     * @return list of persons with that relationship
     */
    List<Person> visit(Person person);
}
