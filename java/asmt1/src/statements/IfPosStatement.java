package statements;

import java.util.List;
import java.util.Map;

import expressions.Expression;
import mini_splat.RunException;

public class IfPosStatement extends Statement{
    private Expression expression;
    private List<Statement> statements;
    public IfPosStatement(Expression e, List<Statement> statements){
        expression = e;
        this.statements = statements;
    }
    public void execute(Map<String, Integer> varMap, List<Integer> output) throws RunException{
        if(expression.computeValue(varMap) > 0){
            for(Statement statement: statements){
                statement.execute(varMap, output);
            }
        }
    }
    public String toString(){
        StringBuilder text = new StringBuilder("if_pos " + expression.toString() + " \n");
        for (Statement statement : statements) {
            text.append(statement.toString());
        }
        text.append("end");
        return text.toString() + "\n";
    }
}
