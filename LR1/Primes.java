public class Primes {
    public static void main(String[] args) {
        System.out.println("is Prime:");
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.printf(i + " ");
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
