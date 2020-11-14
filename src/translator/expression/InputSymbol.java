package translator.expression;

import translator.printer.Printer;
import translator.syntax.Syntax;

public class InputSymbol implements Expression {
    @Override
    public void print(Printer printer, Syntax syntax) {
        printer.printLine(syntax.readValue());
    }
}
