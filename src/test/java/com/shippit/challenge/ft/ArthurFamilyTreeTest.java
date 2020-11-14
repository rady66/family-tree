package com.shippit.challenge.ft;

import com.shippit.challenge.ft.model.FamilyTree;
import com.shippit.challenge.ft.model.Person;
import com.shippit.challenge.ft.model.PersonAdditionFailedException;
import com.shippit.challenge.ft.model.PersonNotFoundException;
import org.junit.Test;

import java.util.List;

import static com.shippit.challenge.ft.model.Person.Gender.Female;
import static org.junit.Assert.*;

public class ArthurFamilyTreeTest {

    @Test
    public void givenArthurFamily_init_passOk() {
        assertNotNull(new ArthurFamilyTree());
    }

    @Test
    public void givenArthurFamily_addChild_passOk() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final Person minerva = familyTree.addMember(Female,
                                        "Flora",
                                        "Minerva");
        assertNotNull(minerva);
        assertEquals(Female, minerva.gender);
        assertEquals("Minerva", minerva.name);
        assertEquals("Flora", minerva.mother.name);
    }

    @Test
    public void givenArthurFamily_getRelationship_maternalAunt_passOk() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final List<Person> maternalAunts = familyTree.list("Remus", "Maternal-Aunt");
        assertFalse(maternalAunts.isEmpty());
        assertEquals(1, maternalAunts.size());
        assertEquals("Dominique", maternalAunts.get(0).name);
    }

    @Test
    public void givenArthurFamily_addMaternalAunt_passOk() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final Person minerva = familyTree.addMember(Female,
                "Flora",
                "Minerva");

        final List<Person> maternalAunts = familyTree.list("Remus", "Maternal-Aunt");
        assertFalse(maternalAunts.isEmpty());
        assertEquals(2, maternalAunts.size());
        assertEquals("Dominique", maternalAunts.get(0).name);
        assertEquals("Minerva", maternalAunts.get(1).name);

        final List<Person> minervaSiblings = familyTree.list("Minerva", "Siblings");
        assertFalse(minervaSiblings.isEmpty());
        assertEquals(3, minervaSiblings.size());
        assertEquals("Victoire", minervaSiblings.get(0).name);
        assertEquals("Dominique", minervaSiblings.get(1).name);
        assertEquals("Louis", minervaSiblings.get(2).name);
    }

    @Test
    public void givenArthurFamily_daughterRel_passOk() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final List<Person> arthurDaughter = familyTree.list("Arthur", "Daughter");
        final List<Person> margaretDaughter = familyTree.list("Margaret", "Daughter");

        assertFalse(arthurDaughter.isEmpty());
        assertEquals(1, arthurDaughter.size());
        assertEquals(arthurDaughter.size(), margaretDaughter.size());
        assertEquals("Ginerva", arthurDaughter.get(0).name);
        assertEquals("Ginerva", margaretDaughter.get(0).name);

        final List<Person> harryDaughter = familyTree.list("Harry", "Daughter");
        assertFalse(harryDaughter.isEmpty());
        assertEquals(1, harryDaughter.size());
        assertEquals("Lily", harryDaughter.get(0).name);

        final List<Person> billDaughter = familyTree.list("Bill", "Daughter");
        assertFalse(billDaughter.isEmpty());
        assertEquals(2, billDaughter.size());
        assertEquals("Victoire", billDaughter.get(0).name);
        assertEquals("Dominique", billDaughter.get(1).name);

        final List<Person> lilyDaughter = familyTree.list("Lily", "Daughter");
        assertTrue(lilyDaughter.isEmpty());
    }

    @Test
    public void givenArthurFamily_sonRel_passOk() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final List<Person> arthurSon = familyTree.list("Arthur", "Son");
        final List<Person> margaretSon = familyTree.list("Margaret", "Son");

        assertFalse(arthurSon.isEmpty());
        assertEquals(4, arthurSon.size());
        assertEquals(arthurSon.size(), margaretSon.size());
        assertEquals("Bill", arthurSon.get(0).name);
        assertEquals("Charlie", arthurSon.get(1).name);
        assertEquals("Percy", arthurSon.get(2).name);
        assertEquals("Ronald", arthurSon.get(3).name);

        final List<Person> billSon = familyTree.list("Bill", "Son");
        assertFalse(billSon.isEmpty());
        assertEquals(1, billSon.size());
        assertEquals("Louis", billSon.get(0).name);

        final List<Person> hellenSon = familyTree.list("Helen", "Son");
        assertFalse(hellenSon.isEmpty());
        assertEquals(1, hellenSon.size());
        assertEquals("Hugo", hellenSon.get(0).name);

        final List<Person> lilyDaughter = familyTree.list("Lily", "Son");
        assertTrue(lilyDaughter.isEmpty());
    }

    @Test
    public void givenArthurFamily_paternalAuntRel_passOk() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final List<Person> ronPaternalAunt = familyTree.list("Ron", "Paternal-Aunt");

        assertFalse(ronPaternalAunt.isEmpty());
        assertEquals(1, ronPaternalAunt.size());
        assertEquals("Lily", ronPaternalAunt.get(0).name);

        final List<Person> ginnyPaternalAunt = familyTree.list("Ginny", "Paternal-Aunt");
        assertFalse(ginnyPaternalAunt.isEmpty());
        assertEquals(1, ginnyPaternalAunt.size());
        assertEquals("Lily", ginnyPaternalAunt.get(0).name);

        final List<Person> hugoPaternalAunt = familyTree.list("Hugo", "Paternal-Aunt");
        assertFalse(hugoPaternalAunt.isEmpty());
        assertEquals(1, hugoPaternalAunt.size());
        assertEquals("Ginerva", hugoPaternalAunt.get(0).name);

        final List<Person> asterPaternalAunt = familyTree.list("Aster", "Paternal-Aunt");
        assertTrue(asterPaternalAunt.isEmpty());

        final List<Person> malfoyPaternalAunt = familyTree.list("Malfoy", "Paternal-Aunt");
        assertTrue(malfoyPaternalAunt.isEmpty());
    }

    @Test
    public void givenArthurFamily_maternalAuntRel_passOk() {
        final FamilyTree familyTree = new ArthurFamilyTree();

        final List<Person> ronMaternalAunt = familyTree.list("Ron", "Maternal-Aunt");
        assertTrue(ronMaternalAunt.isEmpty());

        final List<Person> ginnyMaternalAunt = familyTree.list("Ginny", "Maternal-Aunt");
        assertTrue(ginnyMaternalAunt.isEmpty());

        final List<Person> hugoMaternalAunt = familyTree.list("Hugo", "Maternal-Aunt");
        assertTrue(hugoMaternalAunt.isEmpty());

        final List<Person> asterMaternalAunt = familyTree.list("Aster", "Maternal-Aunt");
        assertTrue(asterMaternalAunt.isEmpty());

        final List<Person> remusMaternalAunt = familyTree.list("Remus", "Maternal-Aunt");
        assertFalse(remusMaternalAunt.isEmpty());
        assertEquals(1, remusMaternalAunt.size());
        assertEquals("Dominique", remusMaternalAunt.get(0).name);
    }

    @Test
    public void givenArthurFamily_maternalUncleRel_passOk() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final List<Person> jamesMaternalUncle = familyTree.list("James", "Maternal-Uncle");

        assertFalse(jamesMaternalUncle.isEmpty());
        assertEquals(4, jamesMaternalUncle.size());
        assertEquals("Bill", jamesMaternalUncle.get(0).name);
        assertEquals("Charlie", jamesMaternalUncle.get(1).name);
        assertEquals("Percy", jamesMaternalUncle.get(2).name);
        assertEquals("Ronald", jamesMaternalUncle.get(3).name);

        final List<Person> lucyMaternalUncle = familyTree.list("Lucy", "Maternal-Uncle");
        assertTrue(lucyMaternalUncle.isEmpty());
    }

    @Test
    public void givenArthurFamily_paternalUncleRel_passOk() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final List<Person> hugoPaternalUncle = familyTree.list("Hugo", "Paternal-Uncle");

        assertFalse(hugoPaternalUncle.isEmpty());
        assertEquals(3, hugoPaternalUncle.size());
        assertEquals("Bill", hugoPaternalUncle.get(0).name);
        assertEquals("Charlie", hugoPaternalUncle.get(1).name);
        assertEquals("Percy", hugoPaternalUncle.get(2).name);

        final List<Person> lucyMaternalUncle = familyTree.list("Lucy", "Paternal-Uncle");
        assertFalse(lucyMaternalUncle.isEmpty());
        assertEquals(3, lucyMaternalUncle.size());
        assertEquals("Bill", lucyMaternalUncle.get(0).name);
        assertEquals("Charlie", lucyMaternalUncle.get(1).name);
        assertEquals("Ronald", lucyMaternalUncle.get(2).name);

        final List<Person> audreyMaternalUncle = familyTree.list("Audrey", "Paternal-Uncle");
        assertTrue(audreyMaternalUncle.isEmpty());
    }

    @Test
    public void givenArthurFamily_brotherInLawRel_passOk() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final List<Person> darcyBrotherInLaw = familyTree.list("Darcy", "Brother-In-Law");

        assertFalse(darcyBrotherInLaw.isEmpty());
        assertEquals(1, darcyBrotherInLaw.size());
        assertEquals("Albus", darcyBrotherInLaw.get(0).name);

        final List<Person> malfoyBrotherInLaw = familyTree.list("Malfoy", "Brother-In-Law");
        assertFalse(malfoyBrotherInLaw.isEmpty());
        assertEquals(1, malfoyBrotherInLaw.size());
        assertEquals("Hugo", malfoyBrotherInLaw.get(0).name);

        final List<Person> jamesBrotherInLaw = familyTree.list("James", "Brother-In-Law");
        assertTrue(jamesBrotherInLaw.isEmpty());
    }

    @Test
    public void givenArthurFamily_sisterInLawRel_passOk() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final List<Person> darcySisterInLaw = familyTree.list("Darcy", "Sister-In-Law");

        assertFalse(darcySisterInLaw.isEmpty());
        assertEquals(1, darcySisterInLaw.size());
        assertEquals("Lily", darcySisterInLaw.get(0).name);

        final List<Person> tedSisterInLaw = familyTree.list("Ted", "Sister-In-Law");
        assertFalse(tedSisterInLaw.isEmpty());
        assertEquals(1, tedSisterInLaw.size());
        assertEquals("Dominique", tedSisterInLaw.get(0).name);

        final List<Person> ginervaSisterInLaw = familyTree.list("Ginerva", "Sister-In-Law");
        assertFalse(ginervaSisterInLaw.isEmpty());
        assertEquals(3, ginervaSisterInLaw.size());
        assertEquals("Flora", ginervaSisterInLaw.get(0).name);
        assertEquals("Audrey", ginervaSisterInLaw.get(1).name);
        assertEquals("Helen", ginervaSisterInLaw.get(2).name);
    }

    @Test
    public void givenArthurFamily_addToNonExistingMother_throwPNF() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final PersonNotFoundException personNotFoundException = assertThrows(PersonNotFoundException.class,
                () -> familyTree.addMember(Female, "Luna", "Lola"));
        assertEquals("PERSON_NOT_FOUND", personNotFoundException.getMessage());
    }

    @Test
    public void givenArthurFamily_listToNonExistingPerson_throwPNF() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final PersonNotFoundException personNotFoundException = assertThrows(PersonNotFoundException.class,
                () -> familyTree.list("Luna", "Maternal-Aunt"));
        assertEquals("PERSON_NOT_FOUND", personNotFoundException.getMessage());
    }

    @Test
    public void givenArthurFamily_addChildToMale_throwCAF() {
        final FamilyTree familyTree = new ArthurFamilyTree();
        final PersonAdditionFailedException personAdditionFailedException = assertThrows(PersonAdditionFailedException.class,
                () -> familyTree.addMember(Female, "Ted", "Bella"));
        assertEquals("CHILD_ADDITION_FAILED", personAdditionFailedException.getMessage());
    }
}