package translator.expression;

import translator.printer.Printer;
import translator.syntax.Syntax;

public class ValueDiff implements Expression {
    private final int diff;

    public ValueDiff(int diff) {
        this.diff = diff;
    }

    @Override
    public void print(Printer printer, Syntax syntax) {
        printer.printLine(syntax.changeValueBy(diff));
    }

    @Override
    public String toString() {
        return "ValueDiff{offset=" + diff + "}";
    }
}
