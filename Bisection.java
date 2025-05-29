public class BisectionMethod {

    // Define the function for which we want to find the root
    // Example: f(x) = x^3 - x - 2
    public static double f(double x) {
        return x * x * x - x - 2;
    }

    /**
     * Bisection method to find the root of a function
     * @param a - start of interval
     * @param b - end of interval
     * @param tol - tolerance (acceptable error)
     * @param maxIter - maximum number of iterations
     * @return root of f(x) in [a, b] or NaN if not found
     */
    public static double bisection(double a, double b, double tol, int maxIter) {
        if (f(a) * f(b) >= 0) {
            System.out.println("Bisection method fails: f(a) and f(b) should have opposite signs.");
            return Double.NaN;
        }

        double c = a;
        for (int i = 0; i < maxIter; i++) {
            c = (a + b) / 2.0;
            double fc = f(c);

            System.out.printf("Iteration %d: a=%.6f, b=%.6f, c=%.6f, f(c)=%.6f%n", i+1, a, b, c, fc);

            if (Math.abs(fc) < tol || (b - a) / 2.0 < tol) {
                // Root found or interval is small enough
                return c;
            }

            // Decide the side to repeat the steps
            if (f(a) * fc < 0) {
                b = c;
            } else {
                a = c;
            }
        }

        // If the root was not found within maxIter iterations
        System.out.println("Maximum iterations reached without convergence.");
        return c;
    }

    public static void main(String[] args) {
        double a = 1, b = 2; // interval [a, b]
        double tol = 1e-6;   // tolerance
        int maxIter = 100;   // max iterations

        double root = bisection(a, b, tol, maxIter);
        if (!Double.isNaN(root)) {
            System.out.printf("Approximate root: %.6f%n", root);
        }
    }
}
