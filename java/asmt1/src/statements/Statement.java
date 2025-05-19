package statements;

import mini_splat.RunException;

import java.util.List;
import java.util.Map;

public abstract class Statement {

    /**
     * Execute the given statement.  Assignments will update the given variable value in the
     * varMap, and output statements will update the output list.
     *
     * @param varMap stores the current values of the variables in the running program
     * @param output stores the outputs of the running program, in order of execution
     * @throws RunException in the cases of division by zero, or attempting to access a
     * variable that has not been assigned a value yet
     */
    public abstract void execute(Map<String, Integer> varMap, List<Integer> output) throws RunException;

    /**
     * @return a string representation of the given statement, terminated by a newline
     */
    public abstract String toString();
}
