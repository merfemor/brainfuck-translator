package translator.expression;

import java.util.ArrayList;
import java.util.Collection;

public class CycleExpressionList implements ExpressionList {
    private final ExpressionList parent;
    private final Collection<Expression> expressions = new ArrayList<>();

    public CycleExpressionList(ExpressionList parent) {
        this.parent = parent;
    }

    @Override
    public ExpressionList getParent() {
        return parent;
    }

    @Override
    public void addExpression(Expression expression) {
        expressions.add(expression);
    }

    @Override
    public Iterable<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public boolean isEmpty() {
        return expressions.isEmpty();
    }
}
