package translator.expression;

public interface ExpressionList {
    default boolean isRoot() {
        return getParent() == null;
    }

    ExpressionList getParent();

    void addExpression(Expression expression);

    Iterable<Expression> getExpressions();

    boolean isEmpty();
}
