class CmdArg4 {
    public static void main(String args[]) {
        int l = args.length;
        if (args.length == 0) {
            System.out.println("Invalid Arguments");
            return;
        }

        int n = 0, i = 0;

        int pc = 0, nc = 0, zc = 0, oc = 0;

        while (i < l) {
            try {
                n = Integer.parseInt(args[i]);
            } catch (Exception e) {
                oc++;
                i++;
                continue;
            }

            if (n == 0) {
                zc++;
            } else {
                if (n > 0) {
                    pc++;
                } else {
                    nc++;
                }
            }
            i++;
        }

        System.out.println("Positive: " + pc + "\nNegative: " + nc + "\nZero: " + zc + "\nOther: " + oc);
    }
}
