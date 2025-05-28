import java.util.function.Function;

public class NewtonRaphson {

    // Function to implement Newton-Raphson method
    public static double findRoot(Function<Double, Double> f, Function<Double, Double> df, double x0, double tol, int maxIter) {
        double x = x0;
        int iter = 0;

        while (iter < maxIter) {
            double fx = f.apply(x);
            double dfx = df.apply(x);

            if (Math.abs(dfx) < 1e-10) {
                throw new ArithmeticException("Derivative is too close to zero; Newton-Raphson method fails.");
            }

            double x1 = x - fx / dfx;

            if (Math.abs(x1 - x) < tol) {
                return x1;
            }

            x = x1;
            iter++;
        }

        throw new ArithmeticException("Maximum iterations reached; root not found within tolerance.");
    }

    // Example usage
    public static void main(String[] args) {
        // Example: f(x) = x^2 - 2, root at sqrt(2)
        Function<Double, Double> f = x -> x * x - 2;
        Function<Double, Double> df = x -> 2 * x;

        double initialGuess = 1.0;
        double tolerance = 1e-7;
        int maxIterations = 100;

        try {
            double root = findRoot(f, df, initialGuess, tolerance, maxIterations);
            System.out.println("Root found: " + root);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
