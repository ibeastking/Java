class Reverse1 {
    public static void main(String[] args) {
        int n;
        int r = 0;
        n = (int) (Math.random() * 100);

        System.out.println("Original Number: " + n);

        while (n > 0) {
            r = r * 10 + (n % 10);
            n = n / 10;
        }

        System.out.print("Reversed Number: " + r);
    }
}
