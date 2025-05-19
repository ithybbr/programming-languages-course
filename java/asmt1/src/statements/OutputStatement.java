package statements;

import java.util.List;
import java.util.Map;

import expressions.Expression;
import mini_splat.RunException;

public class OutputStatement extends Statement{
    private Expression expression;
    public OutputStatement(Expression e){
        expression = e;
    }
    public void execute(Map<String, Integer> varMap, List<Integer> output) throws RunException{
        int value = expression.computeValue(varMap);
        output.add(value);
    }
    public String toString(){
        return "output " + expression.toString() + " \n";
    }
}
