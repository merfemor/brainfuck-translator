package translator.expression;

import translator.printer.Printer;
import translator.syntax.Syntax;

public class IndexOffset implements Expression {
    private final int offset;

    public IndexOffset(int offset) {
        if (offset == 0) {
            throw new IllegalArgumentException("offset == 0");
        }
        this.offset = offset;
    }

    @Override
    public void print(Printer printer, Syntax syntax) {
        printer.printLine(syntax.changeIndexBy(offset));
    }

    @Override
    public String toString() {
        return "IndexOffset{offset=" + offset + "}";
    }
}
