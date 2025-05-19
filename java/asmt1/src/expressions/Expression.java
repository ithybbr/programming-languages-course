package expressions;

import mini_splat.RunException;

import java.util.Map;

public abstract class Expression {

    /**
     * Evaluate the current integer expression, and return its value
     *
     * @param varMap stores the current values of the variables in the running program
     * @return the value of the given expression
     * @throws RunException in the cases of division by zero, or attempting to access a
     * variable that has not been assigned a value yet
     */
    public abstract int computeValue(Map<String, Integer> varMap) throws RunException;

    /**
     * @return a string representation of the given expression
     */
    public abstract String toString();
}
