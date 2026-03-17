package JavaAdvanced.Ss8.Ex3.command;

public interface Command {
    void execute();
    void undo();
    String getDescription();
}