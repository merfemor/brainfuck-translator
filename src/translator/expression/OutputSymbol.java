package translator.expression;

import translator.printer.Printer;
import translator.syntax.Syntax;

public class OutputSymbol implements Expression {
    @Override
    public void print(Printer printer, Syntax syntax) {
        printer.printLine(syntax.printValue());
    }
}
