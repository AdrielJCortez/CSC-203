package calculator;

public class DivideExpression extends BinaryExpression
        implements Expression {

   public DivideExpression(final Expression lft, final Expression rht) {
      super(lft, rht, "/");
   }

   @Override
   protected double applyOperator(double left, double right) {
      return left / right;
   }

}

