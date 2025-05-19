package statements;

import java.util.List;
import java.util.Map;

import expressions.Expression;
import mini_splat.RunException;

public class WhilePosLoop extends Statement{
    private Expression expression;
    private List<Statement> statements;
    public WhilePosLoop(Expression e, List<Statement> statements){
        expression = e;
        this.statements = statements;
    }
    public void execute(Map<String, Integer> varMap, List<Integer> output) throws RunException{
        while(expression.computeValue(varMap) > 0){
            for(Statement statement: statements){
                statement.execute(varMap, output);
            }
        }
    }
    public String toString(){
        StringBuilder text = new StringBuilder("while_pos " + expression.toString() + " \n");
        for(Statement statement: statements){
            text.append(statement.toString());
        }
        text.append("end");
        return text.toString() + " \n";
    }
}
