package com.shippit.challenge.ft.cli;

import com.shippit.challenge.ft.cli.cmd.CmdRegistry;
import org.jline.reader.ParsedLine;

class CmdProcessor {

    private static final CmdProcessor INSTANCE = new CmdProcessor();

    private CmdProcessor() {}

    /**
     * Get instance of this object.
     * @return instance of this object
     */
    static CmdProcessor getInstance() {
        return INSTANCE;
    }

    /**
     * Process command line.
     * @param line command line
     * @param session session object
     * @throws CmdExecutionException in case of command failure
     */
    void process(String line, TerminalSession session) throws CmdExecutionException {
        try {
            ParsedLine parsedLine = session.reader().getParser().parse(line, 0);

            String cmdName = parsedLine.word();

            CmdRegistry.from(cmdName).execute(parsedLine, session);

            session.terminal().writer().flush();

        } catch (Exception e) {
            throw new CmdExecutionException(e);
        }
    }

}
