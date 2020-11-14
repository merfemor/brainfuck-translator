package translator.printer;

public interface Printer {
    void increaseIndent();

    void decreaseIndent();

    void printLine(String line);

    void printLineWithoutLineEnding(String line);
}
