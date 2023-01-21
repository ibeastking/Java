class OddEvenCount {
    public static void main(String[] args) {
        int i = 1, n = 0, oc = 0, ec = 0;

        while (i <= 10) {
            n = (int) (Math.random() * 100);

            System.out.println("Number: " + n);

            if (n % 2 == 0) {
                ec++;
            } else {
                oc++;
            }
            i++;
        }
        System.out.println("Odd Numbers: " + oc + "\nEven Numbers: " + ec);
    }
}
