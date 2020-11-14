package com.shippit.challenge.ft.cli.cmd;

import com.shippit.challenge.ft.cli.ICmd;
import com.shippit.challenge.ft.cli.TerminalSession;
import com.shippit.challenge.ft.model.Person;
import com.shippit.challenge.ft.model.PersonNotFoundException;
import org.jline.reader.ParsedLine;

import java.util.List;
import java.util.StringJoiner;

class GetRelationshipCmd implements ICmd {

    @Override
    public String getName() {
        return "GET_RELATIONSHIP";
    }

    @Override
    public String getHelp() {
        return "TODO";
    }

    @Override
    public String getUsage() {
        return "TODO";
    }

    @Override
    public void execute(ParsedLine parsedLine, TerminalSession session) {
        try {
            final List<Person> result = session.familyTree()
                                               .list(parsedLine.words().get(1),
                                                     parsedLine.words().get(2));

            if (result.isEmpty()) {
                session.println("NONE");

            } else {
                final StringJoiner stringJoiner = new StringJoiner(" ");

                result.forEach(person -> stringJoiner.add(person.name));

                session.println(stringJoiner.toString());
            }

        } catch (PersonNotFoundException exc) {
            session.println(exc.getMessage());
        }
    }
}
