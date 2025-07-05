package calculator;

public class AddExpression extends BinaryExpression
   implements Expression
{

   public AddExpression(final Expression lft, final Expression rht)
   {
       super(lft, rht, "+");
   }

   @Override
   protected double applyOperator(double left, double right) {
      return left + right;
   }

}

