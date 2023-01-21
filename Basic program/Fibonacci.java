class Fibonacci {
    public static void main(String[] args) {
        int a = -1;
        int b = 1;
        int i = 0;
        int sum = 0;
        String s = ("\nFibonacci\n"); // * Declaring string to print series

        System.out.print("Fibonacci Series:\n");

        while (i < 10) {
            sum = a + b;
            a = b;
            b = sum;
            System.out.print(sum + " ");
            s = s + " " + sum; // * adding the new sum in the string
            i++;
        }

        System.out.println(s);
    }
}
