
import mini_splat.Parser;
import mini_splat.Program;
import mini_splat.RunException;

import java.io.File;
import java.util.List;

public class BasicTester {

    public static void main(String[] args) throws Exception {

        runProgram("factorials.msplat");
        // Expected output:
        // 1 2 6 24 120 720 5040

        runProgram("euclid.msplat");
        // Expected output:
        // 189 210 189 21 168 21 147 21 126 21 105 21 84 21 63 21 42 21 21 21

        runProgram("binaryrep.msplat");
        // Expected output:
        // 0 0 0 0 1 0 0 0 1 1 1 0 0 1

        try {
            runProgram("divzero.msplat");
            System.out.println("Should have thrown a RunException!");
        } catch (RunException re) {
            System.out.println("Test successful... RunException thrown");
        }
    }

    public static void runProgram(String filename) throws Exception {

        File file = new File("tests", filename);

        Parser parser = new Parser(file);

        Program program = parser.parse();

        System.out.println(" *** Program " + file.getName() + " ***");
        System.out.println(program.toString());

        List<Integer> output = program.runProgram();

        System.out.println(" *** Output ***");
        for (Integer out : output) {
            System.out.print(out + " ");
        }
        System.out.println("\n");
    }
}
