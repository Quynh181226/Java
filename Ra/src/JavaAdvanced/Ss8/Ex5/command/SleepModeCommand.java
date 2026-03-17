package JavaAdvanced.Ss8.Ex5.command;

import java.util.ArrayList;
import java.util.List;

public class SleepModeCommand implements Command {
    private List<Command> commands;
    private String description;

    public SleepModeCommand(String description) {
        this.commands = new ArrayList<>();
        this.description = description;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        System.out.println("\n🌙=== KÍCH HOẠT CHẾ ĐỘ NGỦ THÔNG MINH ===");
        for (Command command : commands) {
            command.execute();
        }
        System.out.println("=== CHẾ ĐỘ NGỦ ĐÃ SẴN SÀNG ===\n");
    }

    @Override
    public void undo() {
        System.out.println("\n↩️=== UNDO CHẾ ĐỘ NGỦ ===");
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
        System.out.println("=== ĐÃ HOÀN TÁC ===\n");
    }

    @Override
    public String getDescription() {
        return description;
    }
}