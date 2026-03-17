package JavaAdvanced.Ss8.Ex3.remote;

import JavaAdvanced.Ss8.Ex3.command.Command;

public class RemoteControl {
    private static final int MAX_SLOTS = 10;
    private Command[] onCommands;
    private Command[] offCommands;
    private UndoManager undoManager;

    public RemoteControl() {
        onCommands = new Command[MAX_SLOTS];
        offCommands = new Command[MAX_SLOTS];
        undoManager = new UndoManager();

        // Khởi tạo các slot với NoCommand (null object pattern)
        for (int i = 0; i < MAX_SLOTS; i++) {
            onCommands[i] = null;
            offCommands[i] = null;
        }
    }

    // Gán command cho nút On tại slot
    public void setOnCommand(int slot, Command onCommand) {
        onCommands[slot] = onCommand;
    }

    // Gán command cho nút Off tại slot
    public void setOffCommand(int slot, Command offCommand) {
        offCommands[slot] = offCommand;
    }

    // Nhấn nút On tại slot
    public void pressOnButton(int slot) {
        if (slot >= 0 && slot < MAX_SLOTS && onCommands[slot] != null) {
            System.out.println("\n[Nhấn nút On " + (slot + 1) + "]");
            onCommands[slot].execute();
            undoManager.addCommand(onCommands[slot]);
        } else {
            System.out.println("\n[Nhấn nút On " + (slot + 1) + "] Chưa được gán chức năng!");
        }
    }

    // Nhấn nút Off tại slot
    public void pressOffButton(int slot) {
        if (slot >= 0 && slot < MAX_SLOTS && offCommands[slot] != null) {
            System.out.println("\n[Nhấn nút Off " + (slot + 1) + "]");
            offCommands[slot].execute();
            undoManager.addCommand(offCommands[slot]);
        } else {
            System.out.println("\n[Nhấn nút Off " + (slot + 1) + "] Chưa được gán chức năng!");
        }
    }

    // Undo lệnh gần nhất
    public void undo() {
        System.out.println("\n=== NHẤN UNDO ===");
        Command lastCommand = undoManager.undo();
        if (lastCommand != null) {
            System.out.println("Undo: " + lastCommand.getDescription());
        } else {
            System.out.println("Không có lệnh nào để undo!");
        }
    }

    // Redo lệnh vừa undo
    public void redo() {
        System.out.println("\n=== NHẤN REDO ===");
        Command redoCommand = undoManager.redo();
        if (redoCommand != null) {
            System.out.println("Redo: " + redoCommand.getDescription());
        } else {
            System.out.println("Không có lệnh nào để redo!");
        }
    }

    // Hiển thị cấu hình remote
    public void showConfig() {
        System.out.println("\n=== CẤU HÌNH REMOTE ===");
        for (int i = 0; i < MAX_SLOTS; i++) {
            String onDesc = (onCommands[i] != null) ? onCommands[i].getDescription() : "Chưa gán";
            String offDesc = (offCommands[i] != null) ? offCommands[i].getDescription() : "Chưa gán";
            System.out.printf("Slot %2d: [On] %-25s | [Off] %-25s%n",
                    (i + 1), onDesc, offDesc);
        }
        System.out.println("========================\n");
    }
}