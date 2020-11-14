package translator;

import translator.expression.*;
import translator.printer.ToStringPrinter;
import translator.syntax.Syntax;

import java.util.regex.Pattern;


public class BrainfuckTranslator {
    private final String uselessSymbolPairsPatternStr = "(<>|-\\+|\\+-|><|\\[\\])";
    private final Pattern uselessSymbolPairsPattern = Pattern.compile(uselessSymbolPairsPatternStr);
    private final Pattern unknownSymbolsPattern = Pattern.compile("[^+-<>\\[\\].,]");


    private String preprocess(String code) {
        code = unknownSymbolsPattern.matcher(code).replaceAll("");

        int length = -1;
        while (length != code.length()) {
            length = code.length();
            code = uselessSymbolPairsPattern.matcher(code).replaceAll("");
        }
        return code;
    }

    private Iterable<Expression> codeToExpression(String code) {
        final char[] chars = code.toCharArray();

        ExpressionList expressionList = new RootExpressionList();
        int indexOffset = 0;
        int valueDiff = 0;

        for (char ch : chars) {
            if (ch != '-' && ch != '+' && valueDiff != 0) {
                expressionList.addExpression(new ValueDiff(valueDiff));
                valueDiff = 0;
            }
            if (ch != '<' && ch != '>' && indexOffset != 0) {
                expressionList.addExpression(new IndexOffset(indexOffset));
                indexOffset = 0;
            }

            switch (ch) {
                case '<':
                    indexOffset--;
                    break;
                case '>':
                    indexOffset++;
                    break;
                case '+':
                    valueDiff++;
                    break;
                case '-':
                    valueDiff--;
                    break;
                case '[':
                    expressionList = new CycleExpressionList(expressionList);
                    break;
                case ']':
                    ExpressionList parent = expressionList.getParent();
                    if (parent == null) {
                        return null;
                    }
                    if (!expressionList.isEmpty()) {
                        Cycle cycle = new Cycle(expressionList.getExpressions());
                        parent.addExpression(cycle);
                    }
                    expressionList = parent;
                    break;
                case '.':
                    expressionList.addExpression(new OutputSymbol());
                    break;
                case ',':
                    expressionList.addExpression(new InputSymbol());
                    break;
                default:
                    throw new IllegalArgumentException("Not expected symbol: " + ch);
            }
        }

        if (valueDiff != 0) {
            expressionList.addExpression(new ValueDiff(valueDiff));
        }
        if (indexOffset != 0) {
            expressionList.addExpression(new IndexOffset(indexOffset));
        }
        if (!expressionList.isRoot()) {
            return null;
        }
        return expressionList.getExpressions();
    }

    public String translate(String code, Syntax syntax) {
        code = preprocess(code);
        Iterable<Expression> expressions = codeToExpression(code);
        if (expressions == null) {
            return null;
        }
        ToStringPrinter printer = new ToStringPrinter(syntax);
        printer.printLineWithoutLineEnding(syntax.intro());
        printer.setIndent(syntax.initialIndent());
        for (Expression expression : expressions) {
            expression.print(printer, syntax);
        }
        printer.setIndent(0);
        String conclusion = syntax.conclusion();
        if (conclusion != null) {
            printer.printLineWithoutLineEnding(conclusion);
        }
        return printer.getResult();
    }
}