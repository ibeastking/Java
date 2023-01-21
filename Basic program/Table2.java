class Table2 {
    public static void main(String[] args) {
        int i = 1;
        int n;
        n = (int) (Math.random() * 1000);

        String a = "Table:\n";

        while (i <= 10) {
            a = a + " " + n * i;
            i++;
        }

        System.out.print(a);
    }

}
