package expressions;

import java.util.Map;

import mini_splat.RunException;

public class VariableExpr extends Expression{
    private String variable;
    public VariableExpr(String var){
        variable = var;
    }
    public int computeValue(Map<String, Integer> varMap) throws RunException{
        if (varMap.containsKey(variable)) {
            return varMap.get(variable);
        } else {
            throw new RunException("Variable" + variable + " does not have a value");
        }
    }
    public String toString(){
        return variable;
    }
}
