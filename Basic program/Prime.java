class Prime {
    public static void main(String[] args) {
        int n;
        int cnt = 0;

        n = (int) (Math.random() * 1000);
        System.out.println("Original: " + n);

        int i = 2;
        while (i < n / 2) {
            if (n % i == 0) {
                cnt++;
                System.out.println("The number generated is Non-Prime Number.");
                break;
            }
            i++;
        }

        if (cnt == 0) {
            System.out.println("The number generated is Prime Number.");
        }
    }
}
