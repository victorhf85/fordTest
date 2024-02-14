package mx.com.ford.converter;

public class RomanConverter {

    public static void main (String [] args) {

        RomanConverter rc = new RomanConverter();
        String result = rc.converter(88);
        System.out.println("Result: " + result);
    }



    private String converter(int n) {

        String result;

        if (n > 0 && n <= 3000) {
            result = covertNumber(n);
        } else {
            result = "ERROR";
        }

        return result;
    }



    private String covertNumber(int n) {

        String tens = "";
        String s = "";

        int t = divide(n, 10);
        System.out.println("Tens: " + t);
        int tr = residue(n, 10);

        if (t >= 1) {

            tens = tens(t);
            if (tr > 0) {
                s = oneToTen(tr);
            }

        } else {
            s = oneToTen(tr);
        }

        return tens + s;

    }

    private String oneToTen(int n) {

        return switch (n) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            default -> "ERROR - S";
        };
    }

    private String tens(int n) {

        return switch (n) {
            case 1 -> "X";
            case 2 -> "XX";
            case 3 -> "XXX";
            case 4 -> "XL";
            case 5 -> "L";
            case 6 -> "LX";
            case 7 -> "LXX";
            case 8 -> "LXXX";
            case 9 -> "XC";
            case 10 -> "C";
            default -> "ERROR - T";
        };
    }


    private int divide (int n, int divider) {
        return n / divider;
    }

    private int residue (int n, int divider) {
        return n % divider;
    }

}
