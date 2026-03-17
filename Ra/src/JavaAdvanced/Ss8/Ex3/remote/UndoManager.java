package JavaAdvanced.Ss8.Ex3.remote;

import JavaAdvanced.Ss8.Ex3.command.Command;
import java.util.Stack;

public class UndoManager {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public UndoManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    // Thêm command mới vào lịch sử
    public void addCommand(Command command) {
        undoStack.push(command);
        redoStack.clear(); // Xóa redo stack khi có command mới
    }

    // Undo command gần nhất
    public Command undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
            return command;
        }
        return null;
    }

    // Redo command vừa undo
    public Command redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
            return command;
        }
        return null;
    }

    // Kiểm tra có thể undo không
    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    // Kiểm tra có thể redo không
    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    // Xóa lịch sử
    public void clear() {
        undoStack.clear();
        redoStack.clear();
    }
}