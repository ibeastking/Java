class Reverse2 {
    public static void main(String[] args) {
        int n;
        n = (int) (Math.random() * 1000);

        System.out.println("Original: " + n);

        String a = new String("" + n);
        StringBuffer b = new StringBuffer(a);
        StringBuffer c = new StringBuffer(b.reverse());
        String d = new String(c);

        System.out.println("Reverse: " + d);
    }
}
