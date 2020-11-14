package com.shippit.challenge.ft.cli.cmd;

import com.shippit.challenge.ft.cli.ICmd;
import com.shippit.challenge.ft.cli.TerminalSession;
import org.jline.reader.ParsedLine;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Commands registry.
 */
public class CmdRegistry {

    private static final Map<String, ICmd> commands = new LinkedHashMap<String, ICmd>() {

        private static final long serialVersionUID = 1L;

        @Override
        public ICmd get(Object key) {
            ICmd cmd = super.get(key);
            if (cmd == null) {
                cmd = new ICmd() {

                    @Override
                    public String getName() {
                        return "not-found";
                    }

                    @Override
                    public String getHelp() {
                        return "";
                    }

                    @Override
                    public String getUsage() {
                        return "usage: not-found";
                    }

                    @Override
                    public void execute(ParsedLine parsedLine, TerminalSession session) {
                        session.println("\nNo command found");
                    }
                };
            }
            return cmd;
        }

        @Override
        public ICmd put(String key, ICmd value) {
            if (super.containsKey(key)) {
                throw new IllegalArgumentException("Command with name already registered: " + key);
            }

            return super.put(key, value);
        }
    };

    static {
        final GetRelationshipCmd getRelationshipCmd = new GetRelationshipCmd();
        commands.put(getRelationshipCmd.getName(), getRelationshipCmd);
    }

    private CmdRegistry() {}

    /**
     * Map command name to a command object.
     * @param cmdName command name
     * @return command object
     */
    public static ICmd from(String cmdName) {
        return commands.get(cmdName);
    }

}
