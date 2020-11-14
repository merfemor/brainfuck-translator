package translator.expression;

import translator.printer.Printer;
import translator.syntax.Syntax;

public interface Expression {
    void print(Printer printer, Syntax syntax);
}
