package com.shippit.challenge.ft.cli;

import org.jline.reader.ParsedLine;

/**
 * Command interface.
 */
public interface ICmd {

    /**
     * Get command name.
     * @return command name
     */
    String getName();

    /**
     * Get command help.
     * @return command help
     */
    String getHelp();

    /**
     * Get command usage.
     * @return command usage
     */
    String getUsage();

    /**
     * Execute parsed terminal line.
     * @param parsedLine parsed terminal line
     * @param session session object
     */
    void execute(ParsedLine parsedLine, TerminalSession session);
}