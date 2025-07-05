package calculator;

public abstract class BinaryExpression implements Expression {

    Expression lft;
    Expression rht;
    String operator;

    public BinaryExpression(Expression lft, Expression rht, String operator) {
        this.lft = lft;
        this.rht = rht;
        this.operator = operator;
    }

    public String toString()
    {
        return "(" + lft + " " +  operator + " " + rht + ")";
    }

    public double evaluate(final Bindings bindings)
    {
        double left = lft.evaluate(bindings);
        double right = rht.evaluate(bindings);
        return applyOperator(left, right);
    }

    protected abstract double applyOperator(double left, double right);
}

