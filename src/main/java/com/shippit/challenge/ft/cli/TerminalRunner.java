package com.shippit.challenge.ft.cli;

import com.shippit.challenge.ft.ArthurFamilyTree;
import org.jline.reader.EndOfFileException;
import org.jline.reader.UserInterruptException;

import java.io.IOException;

/**
 * Terminal Runner main class.
 */
public class TerminalRunner {

    public static void main(String[] args) throws IOException {

        final CmdProcessor cmdProcessor = CmdProcessor.getInstance();
        final TerminalSession session = new TerminalSession(new ArthurFamilyTree());

        while (true) {
            String line = "";

            try {
                line = session.reader().readLine();

            } catch (UserInterruptException e) {
                // Ignore
            } catch (EndOfFileException e) {
                return;
            }

            if (line.isEmpty()) {
                continue;
            }

            line = line.trim();

            if ("quit".equalsIgnoreCase(line) || "exit".equalsIgnoreCase(line)) {
                break;
            }

            try {
                cmdProcessor.process(line, session);

            } catch (CmdExecutionException cee) {
                cee.printStackTrace();
            }
        }
    }
}
