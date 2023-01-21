class Reverse3 {
    public static void main(String[] args) {
        int n;
        n = (int) (Math.random() * 100);

        System.out.println("Original: " + n);

        StringBuffer a = new StringBuffer("" + n);
        System.out.println("Reversed: " + a.reverse());
    }
}
