package calculator;
public class SubtractExpression extends BinaryExpression
   implements Expression
{

   public SubtractExpression(final Expression lft, final Expression rht)
   {
      super(lft, rht, "-");
   }

   @Override
   protected double applyOperator(double left, double right) {
      return left - right;
   }
}

