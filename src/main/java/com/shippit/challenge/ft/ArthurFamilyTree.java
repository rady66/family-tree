package com.shippit.challenge.ft;

import com.shippit.challenge.ft.model.FamilyTree;
import com.shippit.challenge.ft.model.Person;

public class ArthurFamilyTree extends FamilyTree {

    public ArthurFamilyTree() {
        init();
    }

    private void init() {
        //level 0
        Person arthur = addMember(Person.Gender.Male, "Arthur");
        Person margaret = addMember(Person.Gender.Female, "Margaret");
        arthur.setPartner(margaret);

        //level 1
        Person bill = addMember(Person.Gender.Male, "Margaret","Bill");
        Person charlie = addMember(Person.Gender.Male, "Margaret","Charlie");
        Person percy = addMember(Person.Gender.Male, "Margaret","Percy");
        Person ronald = addMember(Person.Gender.Male, "Margaret","Ronald");
        Person ginerva = addMember(Person.Gender.Female, "Margaret","Ginerva");

        Person flora = addMember(Person.Gender.Female, "Flora");
        Person audrey = addMember(Person.Gender.Female, "Audrey");
        Person helen = addMember(Person.Gender.Female, "Helen");
        Person harry = addMember(Person.Gender.Male, "Harry");
        bill.setPartner(flora);
        percy.setPartner(audrey);
        ronald.setPartner(helen);
        ginerva.setPartner(harry);

        //level 2
        Person victoire = addMember(Person.Gender.Female, "Flora","Victoire");
        Person dominique = addMember(Person.Gender.Female, "Flora","Dominique");
        Person louis = addMember(Person.Gender.Male, "Flora","Louis");

        Person molly = addMember(Person.Gender.Female, "Audrey","Molly");
        Person lucy = addMember(Person.Gender.Female, "Audrey","Lucy");

        Person rose = addMember(Person.Gender.Female, "Helen","Rose");
        Person hugo = addMember(Person.Gender.Male, "Helen","Hugo");

        Person james = addMember(Person.Gender.Male, "Ginerva","James");
        Person albus = addMember(Person.Gender.Male, "Ginerva","Albus");
        Person lily = addMember(Person.Gender.Female, "Ginerva","Lily");

        Person ted = addMember(Person.Gender.Male, "Ted");
        Person malfoy = addMember(Person.Gender.Male, "Malfoy");
        Person darcy = addMember(Person.Gender.Female, "Darcy");
        Person alice = addMember(Person.Gender.Female, "Alice");
        victoire.setPartner(ted);
        malfoy.setPartner(rose);
        darcy.setPartner(james);
        alice.setPartner(albus);

        //level 3
        Person remus = addMember(Person.Gender.Male, "Victoire","Remus");

        Person draco = addMember(Person.Gender.Male, "Rose","Draco");
        Person aster = addMember(Person.Gender.Female, "Rose","Aster");

        Person william = addMember(Person.Gender.Male, "Darcy","William");

        Person ron = addMember(Person.Gender.Male, "Alice","Ron");
        Person ginny = addMember(Person.Gender.Female, "Alice","Ginny");
    }
}
