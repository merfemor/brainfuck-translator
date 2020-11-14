package translator.printer;

import translator.syntax.Syntax;

import java.util.Objects;

public class ToStringPrinter implements Printer {
    private final Syntax syntax;
    private int indents = 0;
    private StringBuilder sb = new StringBuilder();

    public ToStringPrinter(Syntax syntax) {
        this.syntax = syntax;
    }

    @Override
    public void increaseIndent() {
        indents++;
    }

    @Override
    public void decreaseIndent() {
        indents--;
    }

    public void setIndent(int indent) {
        this.indents = indent;
    }

    @Override
    public void printLine(String line) {
        printLine(line, true);
    }

    @Override
    public void printLineWithoutLineEnding(String line) {
        printLine(line, false);
    }

    private void printLine(String str, boolean needLineEnding) {
        Objects.requireNonNull(str);
        for (int i = 0; i < indents; i++) {
            sb.append(syntax.indent());
        }
        sb.append(str);
        if (needLineEnding) {
            sb.append(syntax.lineEnding());
        }
        sb.append('\n');
    }

    public String getResult() {
        return sb.toString();
    }
}
