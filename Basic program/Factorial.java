class Factorial {
    public static void main(String[] args) {
        int n;
        n = (int) (Math.random() * 10);

        System.out.println("Number: " + n);

        int f = 1;

        while (n > 0) {
            f = f * n;
            n = n - 1;
        }

        System.out.println("Factorial: " + f);
    }
}
