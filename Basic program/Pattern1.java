class Pattern1 {
    public static void main(String[] args) {
        int n = 5, i = 1, j = 1;

        String s = "Pattern\n";

        while (i <= n) {
            for (j = 1; j <= i; j++) {
                s = s + " *";
            }
            s = s + "\n";
            i++;
        }

        System.out.println(s);
    }
}
