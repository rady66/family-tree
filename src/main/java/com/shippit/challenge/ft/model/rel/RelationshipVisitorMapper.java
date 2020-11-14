package com.shippit.challenge.ft.model.rel;

import com.shippit.challenge.ft.model.Relationship;
import com.shippit.challenge.ft.model.RelationshipVisitor;

import java.util.EnumMap;

import static com.shippit.challenge.ft.model.Relationship.BrotherInLaw;
import static com.shippit.challenge.ft.model.Relationship.Daughter;
import static com.shippit.challenge.ft.model.Relationship.MaternalAunt;
import static com.shippit.challenge.ft.model.Relationship.MaternalUncle;
import static com.shippit.challenge.ft.model.Relationship.PaternalAunt;
import static com.shippit.challenge.ft.model.Relationship.PaternalUncle;
import static com.shippit.challenge.ft.model.Relationship.Siblings;
import static com.shippit.challenge.ft.model.Relationship.SisterInLaw;
import static com.shippit.challenge.ft.model.Relationship.Son;

public class RelationshipVisitorMapper {

    private static final EnumMap<Relationship, RelationshipVisitor> relationshipVisitorEnumMap = new EnumMap<>(Relationship.class);

    static {
        relationshipVisitorEnumMap.put(BrotherInLaw, new BrotherInLawRelationshipVisitor());
        relationshipVisitorEnumMap.put(Daughter, new DaughterRelationshipVisitor());
        relationshipVisitorEnumMap.put(PaternalAunt, new PaternalAuntRelationshipVisitor());
        relationshipVisitorEnumMap.put(PaternalUncle, new PaternalUncleRelationshipVisitor());
        relationshipVisitorEnumMap.put(MaternalAunt, new MaternalAuntRelationshipVisitor());
        relationshipVisitorEnumMap.put(MaternalUncle, new MaternalUncleRelationshipVisitor());
        relationshipVisitorEnumMap.put(Siblings, new SiblingsRelationshipVisitor());
        relationshipVisitorEnumMap.put(SisterInLaw, new SisterInLawRelationshipVisitor());
        relationshipVisitorEnumMap.put(Son, new SonRelationshipVisitor());
    }

    private RelationshipVisitorMapper() {}

    public static RelationshipVisitor map(Relationship from) {
        return relationshipVisitorEnumMap.get(from);
    }
}
