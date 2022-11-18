package org.example;

/**
 * App Class
 * Simulates regular main class
 */
public class App {

    /**
     * This method gets arguments through CMD, converts them into string,
     * and implements method evaluate from Expression Evaluator Class to determine the result of Dijkstra Algorithm
     *
     * @param args We are entering values through Command line and process them as an array of strings
     *             We convert args to the form of string, where we separate each args[i] with space
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No inserted elements");
        } else if (args.length == 1) {

            System.out.println(args[0]);
            Double result = ExpressionEvaluator.evaluate(args[0]);
            System.out.println(result);

        } else throw new IllegalArgumentException("Invalid input!");

    }
}