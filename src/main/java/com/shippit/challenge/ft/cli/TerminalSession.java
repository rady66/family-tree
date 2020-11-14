package com.shippit.challenge.ft.cli;

import com.shippit.challenge.ft.model.FamilyTree;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Terminal client session.
 */
public class TerminalSession {

    private final LineReader reader;
    private final Terminal terminal;
    private final FamilyTree familyTree;

    TerminalSession(FamilyTree familyTree) throws IOException {
        this.familyTree = familyTree;
        this.terminal = TerminalBuilder.builder()
                .build();

        this.reader = LineReaderBuilder.builder()
                .terminal(terminal)
                //.completer(completer)
                .build();
    }

    /**
     * Gets line reader.
     * @return the line reader
     */
    LineReader reader() {
        return this.reader;
    }

    /**
     * Gets the terminal.
     * @return the terminal
     */
    public Terminal terminal() {
        return this.terminal;
    }

    /**
     * Prints line.
     * @param value the line value to print
     * @return this terminal session
     */
    public PrintWriter println(String value) {
        terminal().writer().println(value);
        return terminal().writer();
    }

    /**
     * Gets family tree.
     * @return family tree
     */
    public FamilyTree familyTree() {
        return this.familyTree;
    }
}
