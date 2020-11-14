package translator.expression;

import translator.printer.Printer;
import translator.syntax.Syntax;

public class Cycle implements Expression {
    private final Iterable<Expression> tokens;

    public Cycle(Iterable<Expression> tokens) {
        this.tokens = tokens;
    }

    @Override
    public void print(Printer printer, Syntax s) {
        String line = s.cycle(s.valueNotEqualToZero()) + s.blockStart();
        printer.printLineWithoutLineEnding(line);
        printer.increaseIndent();
        for (Expression expression : tokens) {
            expression.print(printer, s);
        }
        printer.decreaseIndent();
        String end = s.blockEnd();
        if (end != null) {
            printer.printLineWithoutLineEnding(end);
        }
    }
}
