package mini_splat;

import statements.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    // The statements of the program's body
    private List<Statement> progBody;

    /**
     * Creates a new MiniSplat program object with the given body
     *
     * @param progBody the list of statements which make up the program's body
     */
    public Program(List<Statement> progBody) {
        this.progBody = progBody;
    }

    /**
     * Run the given program by sequentially executing the given statements of the program body.
     * The outputs of the program are returned as a list of integers, in the order in which the
     * output statements were executed.
     *
     * @return the outputs of the running program, in order of execution
     * @throws RunException in the cases of division by zero, or attempting to access a
     * variable that has not been assigned a value yet, during execution of the program
     */
    public List<Integer> runProgram() throws RunException {

        // Initialize the list of outputs
        List<Integer> output = new ArrayList<>();

        // Initialize the variable map, which starts out empty
        Map<String, Integer> varMap = new HashMap<>();

        // Execute the individual statements of the program's body
        for (Statement stmt : progBody) {
            stmt.execute(varMap, output);
        }

        // Return the output, which should be populated during the above statement executions
        return output;
    }

    /**
     * @return a string representation of the given program, where any original indenting
     * has been discarded
     */
    public String toString() {

        // This is more efficient than using Strings directly
        StringBuilder sb = new StringBuilder("program\n");

        for (Statement stmt: progBody) {
            sb.append(stmt.toString());
        }

        sb.append("end\n");

        return sb.toString();
    }
}
