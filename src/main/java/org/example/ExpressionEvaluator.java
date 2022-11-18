package org.example;

import java.util.*;

/**
 * @author Abdulhadi Velagic
 * initial version 1.0
 * Class ExpressionEvaluator
 * This class has one method evaluate, that calculates expression through Dijkstra Algorithm
 */
public class ExpressionEvaluator {
    /**
     * evaluate method that manipulates with string and calculates the result of Dijkstra Expression
     *
     * @param s entered string in Dijsktra form
     * @return value saved in stack vals that represents the result of the arithmetic operations
     */
    public static Double evaluate(String s) {
        int numOfOpenedBrackets = 0,
                numOfClosedBrackets = 0,
                numOfOps = 0;
        String[] str = s.split("\\s+");
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(str));
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        try {
            while (!q.isEmpty()) {
                String token = q.poll();
                if (token.equals("("))
                    numOfOpenedBrackets += 1;
                else if (token.equals("+")) {
                    ops.push(token);
                    numOfOps += 1;
                } else if (token.equals("-")) {
                    ops.push(token);
                    numOfOps += 1;
                } else if (token.equals("*")) {
                    ops.push(token);
                    numOfOps += 1;
                } else if (token.equals("/")) {
                    ops.push(token);
                    numOfOps += 1;
                } else if (token.equals("sqrt")) {
                    ops.push(token);
                    numOfOps += 1;
                } else if (token.equals(")")) {
                    numOfClosedBrackets += 1;
                    double v = vals.pop();
                    String op = ops.pop();
                    if (op.equals("+")) {
                        v = vals.pop() + v;
                    } else if (op.equals("-")) {
                        v = vals.pop() - v;
                    } else if (op.equals("*")) {
                        v = vals.pop() * v;
                    } else if (op.equals("/")) {
                        v = vals.pop() / v;
                    } else if (op.equals("sqrt")) {
                        v = Math.sqrt(v);
                    }
                    vals.push(v);
                } else {
                    try {
                        vals.push(Double.parseDouble(token));
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException("Invalid input!");
                    }
                }
            }
        } catch (EmptyStackException ex) {
            throw new RuntimeException(("Invalid input!"));
        }


        if (numOfOpenedBrackets != numOfOps)
            throw new RuntimeException("Invalid input!");
        else if ((numOfOpenedBrackets == numOfClosedBrackets) && (numOfOpenedBrackets == numOfOps))
            return vals.pop();
        else
            throw new RuntimeException("Invalid input!");
    }

}
