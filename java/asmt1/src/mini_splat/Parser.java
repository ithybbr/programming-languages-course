package mini_splat;

import expressions.*;
import statements.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    private final File progFile;

    public Parser(File progFile) {
        this.progFile = progFile;
    }

    public Program parse() throws ParseException, FileNotFoundException {

        Scanner scanner = new Scanner(progFile);

        Scanner linescanner = new Scanner(scanner.nextLine());

        if (!linescanner.hasNext()) {
            throw new ParseException("programs cannot have empty lines");
        }

        if (!linescanner.next().equals("program")) {
            throw new ParseException("program must start with keyword 'program'");
        }

        if (linescanner.hasNext()) {
            throw new ParseException("cannot have additional stuff after 'program' keyword " +
                    "on the same line");
        }

        List<Statement> progBody = parseBody(scanner);

        return new Program(progBody);
    }



    private List<Statement> parseBody(Scanner scanner) throws ParseException {

        List<Statement> body = new ArrayList<>();

        while(scanner.hasNextLine()) {

            Scanner linescanner = new Scanner(scanner.nextLine());

            if (linescanner.hasNextInt()) {
                throw new ParseException("cannot start a line with an integer");
            }

            if (!linescanner.hasNext()) {
                throw new ParseException("programs cannot have empty lines");
            }

            String token1 = linescanner.next();

            if (token1.equals("end")) {
                if (linescanner.hasNext()) {
                    throw new ParseException("cannot have additional stuff after 'end' keyword " +
                            "on the same line");
                }
                return body;
            } else if (token1.equals("while_pos")) {
                Expression condExpr = parseExpression(linescanner);
                List<Statement> whilebody = parseBody(scanner);
                body.add(new WhilePosLoop(condExpr, whilebody));
            } else if (token1.equals("if_pos")) {
                Expression condExpr = parseExpression(linescanner);
                List<Statement> ifbody = parseBody(scanner);
                body.add(new IfPosStatement(condExpr, ifbody));
            } else if (token1.equals("output")) {
                Expression outputExpr = parseExpression(linescanner);
                body.add(new OutputStatement(outputExpr));
            } else if (token1.matches("[a-zA-Z]+")) {

                String asmtOp = linescanner.next();

                if (!asmtOp.equals(":=")) {
                    throw new ParseException("missing ':=' operator after variable name");
                }

                Expression rhsExpr = parseExpression(linescanner);
                body.add(new Assignment(token1, rhsExpr));
            } else {
                throw new ParseException("starting line with illegal variable name");
            }

        }

        throw new ParseException("body block is not terminated with 'end' keyword");
    }

    private Expression parseExpression(Scanner linescanner) throws ParseException {

        if (!linescanner.hasNext()) {
            throw new ParseException("expression missing / improperly ended");
        }

        Expression expr = parseSimpleExpression(linescanner);

        while (linescanner.hasNext()) {

            String op = linescanner.next();
            if (op.equals("+") | op.equals("-") | op.equals("*") | op.equals("/")) {

                Expression next = parseSimpleExpression(linescanner);
                expr = new BinaryOperation(expr, op.charAt(0), next);
            }
        }

        return expr;
    }

    private Expression parseSimpleExpression(Scanner linescanner) throws ParseException {

        if (linescanner.hasNextInt()) {
            int val = linescanner.nextInt();
            return new IntegerConstant(val);
        } else {
            String var = linescanner.next();

            if (!var.matches("[a-zA-Z]+")) {
                throw new ParseException("Illegal variable name");
            }
            return new VariableExpr(var);
        }
    }
}
