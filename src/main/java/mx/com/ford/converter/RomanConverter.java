package mx.com.ford.converter;

public class RomanConverter {

    public static void main (String [] args) {
        RomanConverter rc = new RomanConverter();
        String result = rc.converter(3000);
        System.out.println("Result: " + result);
    }

    public String converter(int n) {

        String result;

        if (n > 0 && n <= 3000) {
            result = covertNumber(n);
        } else {
            result = "ERROR";
        }

        return result;
    }

    private String covertNumber(int n) {

        StringBuilder text = new StringBuilder();
        int r = n;
        int div;

        for (int d = 1000; d > 0; d/=10) {
            div = divide(r, d);
            r = getResidue(r, d);
            text.append(findText(d, div));
        }
        return text.toString();
    }

    private String findText(int divider, int number) {

        String text = "";

        switch (divider) {
            case 1000 -> text = thousands(number);
            case 100 -> text = hundreds(number);
            case 10 -> text = tens(number);
            case 1 -> text = units(number);
            default -> text = "ERROR - not found";
        }

        return text;
    }

    private String units(int n) {

        return switch (n) {
            case 0 -> "";
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            default -> "ERROR - units";
        };
    }

    private String tens(int n) {

        return switch (n) {
            case 0 -> "";
            case 1 -> "X";
            case 2 -> "XX";
            case 3 -> "XXX";
            case 4 -> "XL";
            case 5 -> "L";
            case 6 -> "LX";
            case 7 -> "LXX";
            case 8 -> "LXXX";
            case 9 -> "XC";
            default -> "ERROR - tens";
        };
    }

    private String hundreds(int n) {

        return switch (n) {
            case 0 -> "";
            case 1 -> "C";
            case 2 -> "CC";
            case 3 -> "CCC";
            case 4 -> "CD";
            case 5 -> "D";
            case 6 -> "DC";
            case 7 -> "DCC";
            case 8 -> "DCCC";
            case 9 -> "CM";
            default -> "ERROR - hundreds";
        };
    }

    private String thousands(int n) {

        return switch (n) {
            case 0 -> "";
            case 1 -> "M";
            case 2 -> "MM";
            case 3 -> "MMM";
            default -> "ERROR - thousands";
        };
    }


    private int divide (int n, int divider) {
        return n / divider;
    }

    private int getResidue (int n, int divider) {
        return n % divider;
    }

}

