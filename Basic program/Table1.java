//! Program printing output in normal form

class Table1 {
    public static void main(String[] args) {
        int n;
        int i = 1;
        n = (int) (Math.random() * 100);

        System.out.println("Table");

        while (i < 10) {
            System.out.print(" " + n * i);
            i++;
        }
    }
}
