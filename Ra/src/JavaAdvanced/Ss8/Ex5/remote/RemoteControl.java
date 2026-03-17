package JavaAdvanced.Ss8.Ex5.remote;

import JavaAdvanced.Ss8.Ex5.command.Command;
import java.util.Stack;

public class RemoteControl {
    private Command[] buttons;
    private Stack<Command> history;
    private Stack<Command> redoStack;

    public RemoteControl(int numButtons) {
        buttons = new Command[numButtons];
        history = new Stack<>();
        redoStack = new Stack<>();
    }

    public void setCommand(int slot, Command command) {
        buttons[slot] = command;
        System.out.println("🔘 Đã gán: " + command.getDescription() + " vào nút " + (slot + 1));
    }

    public void pressButton(int slot) {
        if (slot >= 0 && slot < buttons.length && buttons[slot] != null) {
            System.out.println("\n👉 NHẤN NÚT " + (slot + 1) + ": " + buttons[slot].getDescription());
            buttons[slot].execute();
            history.push(buttons[slot]);
            redoStack.clear(); // Clear redo stack when new command is executed
        } else {
            System.out.println("⚠️ Nút " + (slot + 1) + " chưa được gán chức năng!");
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            System.out.println("\n↩️ UNDO: " + lastCommand.getDescription());
            lastCommand.undo();
            redoStack.push(lastCommand);
        } else {
            System.out.println("⚠️ Không có lệnh nào để UNDO!");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            System.out.println("\n↪️ REDO: " + command.getDescription());
            command.execute();
            history.push(command);
        } else {
            System.out.println("⚠️ Không có lệnh nào để REDO!");
        }
    }

    public void showConfig() {
        System.out.println("\n=== CẤU HÌNH REMOTE ===");
        for (int i = 0; i < buttons.length; i++) {
            String desc = (buttons[i] != null) ? buttons[i].getDescription() : "Chưa gán";
            System.out.println("Nút " + (i + 1) + ": " + desc);
        }
        System.out.println("========================\n");
    }
}