package com.shippit.challenge.ft.cli.cmd;

import com.shippit.challenge.ft.cli.ICmd;
import com.shippit.challenge.ft.cli.TerminalSession;
import com.shippit.challenge.ft.model.Person;
import com.shippit.challenge.ft.model.PersonAdditionFailedException;
import com.shippit.challenge.ft.model.PersonNotFoundException;
import org.jline.reader.ParsedLine;

import java.util.List;
import java.util.StringJoiner;

class AddChildCmd implements ICmd {

    @Override
    public String getName() {
        return "ADD_CHILD";
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
            final Person person = session.familyTree()
                                         .addMember(Person.Gender.valueOf(parsedLine.words().get(3)),
                                                    parsedLine.words().get(1),
                                                    parsedLine.words().get(2));

            session.println("CHILD_ADDED");

        } catch (PersonNotFoundException | PersonAdditionFailedException exc) {
            session.println(exc.getMessage());
        }
    }
}
