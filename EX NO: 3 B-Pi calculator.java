import java.util.Scanner;

public class Main{
    private int numberOfTerms;
    private double computedPi;

    public static final double EXACT_PI = Math.PI;

    public Main(int terms) {
        this.numberOfTerms = terms;
        this.computedPi = calculateLeibnizPi();
    }

    public double calculateLeibnizPi() {
        double pi = 0.0;
        double denominator = 1.0;
        int sign = 1;

        for (int i = 0; i < numberOfTerms; i++) {
            pi += sign * (4.0 / denominator);
            denominator += 2.0;
            sign *= -1;
        }
        return pi;
    }

    public double getComputedPi() {
        return computedPi;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        if (scanner.hasNextInt()) {
            int terms = scanner.nextInt();

            Main calculator = new Main(terms);

            System.out.println("Calculated Pi : " + calculator.getComputedPi());
            System.out.println("Exact Pi (Math.PI) : " + EXACT_PI);
            System.out.println("Difference        : " + Math.abs(EXACT_PI - calculator.getComputedPi()));
        } else {
            System.out.println("Please enter a valid integer.");
        }

        scanner.close();
    }
}
