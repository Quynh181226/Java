package JavaAdvanced.Ss8.Ex5.command;

public interface Command {
    void execute();
    void undo();
    String getDescription();
}