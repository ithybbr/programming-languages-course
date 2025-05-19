package expressions;

import java.util.Map;

import mini_splat.RunException;

public class BinaryOperation extends Expression{
    private Expression expression1;
    private char op;
    private Expression expression2;
    public BinaryOperation(Expression e1, char c, Expression e2){
        expression1 = e1;
        op = c;
        expression2 = e2;
    }
    public int computeValue(Map<String, Integer> varMap) throws RunException{
        int value1 = expression1.computeValue(varMap);
        int value2 = expression2.computeValue(varMap);
        if(op == '+'){
            return value1 + value2;
        }
        if(op == '-'){
            return value1 - value2;
        }
        if(op == '*'){
            return value1 * value2;
        }
        if(op == '/'){
            if(value2 == 0){
                throw new RunException("Can't divide by zero");
            }
            return value1 / value2;
        }
        throw new RunException("unknown operation");
    }
    public String toString(){
        return expression1.toString() + " " + op + " " + expression2.toString();
    }
}
