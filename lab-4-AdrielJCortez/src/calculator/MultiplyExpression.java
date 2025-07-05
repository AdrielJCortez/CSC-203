package calculator;
public class MultiplyExpression extends BinaryExpression
   implements Expression {

   public MultiplyExpression(final Expression lft, final Expression rht) {
      super(lft, rht, "*");
   }

   @Override
   protected double applyOperator(double left, double right) {
      return left * right;
   }
}

