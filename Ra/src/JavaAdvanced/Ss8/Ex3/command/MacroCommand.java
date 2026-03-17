package JavaAdvanced.Ss8.Ex3.command;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    private List<Command> commands;
    private String name;

    public MacroCommand(String name) {
        this.name = name;
        this.commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        System.out.println("=== Thực thi Macro: " + name + " ===");
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        System.out.println("=== Undo Macro: " + name + " ===");
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }

    @Override
    public String getDescription() {
        return "Macro: " + name;
    }
}