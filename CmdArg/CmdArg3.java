class CmdArg3 {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Invalid Arguments");
            return;
        }

        int n;

        try {
            n = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Invalid Input");
            return;
        }

        String s = "Table\n";

        for (int i = 1; i <= 10; i++) {
            s = s + " " + (n * i);
        }
        System.out.println(s);
    }
}
