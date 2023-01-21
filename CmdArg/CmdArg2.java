class CmdArg2 {
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
        System.out.println("Number: " + n);
    }
}
