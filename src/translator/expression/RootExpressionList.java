package translator.expression;

import java.util.ArrayList;
import java.util.Collection;

public class RootExpressionList implements ExpressionList {
    private final Collection<Expression> expressions = new ArrayList<>();

    @Override
    public ExpressionList getParent() {
        return null;
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
