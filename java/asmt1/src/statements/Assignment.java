package statements;

import java.util.List;
import java.util.Map;

import expressions.Expression;
import mini_splat.RunException;

public class Assignment extends Statement{
    private String string;
    private Expression expression;
    public Assignment(String s, Expression expression){
        this.string = s;
        this.expression = expression;
    }
    public void execute(Map<String, Integer> varMap, List<Integer> output) throws RunException{
        int value = expression.computeValue(varMap);
        varMap.put(string, value);
    }
    public String toString(){
        return string + " := " + expression.toString() + " \n";
    }
}
