//! Function to calculate number of upppercase, lowercase, digits and other character

class CountChar {
    public static void main(String[] args) {
        int i = 1;
        int uc = 0, lc = 0, dc = 0, oc = 0;
        int val = 0;

        while (i <= 10) {
            System.out.println("Type chatacter: ");

            try {
                val = System.in.read();
                System.in.skip(5);
            } catch (Exception e) {

            }

            if (val >= 48 && val <= 57) {
                dc++;
            } else {
                if (val >= 65 && val <= 90) {
                    uc++;
                } else {
                    if (val >= 97 && val <= 122) {
                        lc++;
                    } else {
                        oc++;
                    }
                }
            }
            i++;
        }

        System.out.println("\nUpper: " + uc + "\nLower: " + lc + "\nDigit: " + dc + "\nOther: " + oc);
    }
}
