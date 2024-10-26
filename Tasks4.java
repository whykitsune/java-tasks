
import java.util.ArrayList;
import java.util.Arrays;

public class Tasks4 {
    public static void main(String[] args) {
        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));
        System.out.println(Arrays.toString(bruteForce(1, 5)));
        System.out.println(Arrays.toString(bruteForce(2, 2)));
        System.out.println(Arrays.toString(bruteForce(5, 3)));
        System.out.println(encode(new int[]{0, 31, 28, 10, 29}, "MKIIT"));
        System.out.println(Arrays.toString(decode("MTUCI", "MKIIT")));
    }

    public static String nonRepeat(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char[] strArray = str.toLowerCase().toCharArray();
        char ch = strArray[0];
        int count = str.length() - str.replace(String.valueOf(ch), "").length();
        if (count > 3) {
            str = str.replace(String.valueOf(ch), "");
            return nonRepeat(str);
        }
        return strArray[0] + nonRepeat(str.replaceFirst(String.valueOf(ch), ""));
    }

    public static String[] bruteForce(int n, int k) {
        if (n > k) {
            return new String[]{};
        }
        String[] alphabet = new String[k];
        for (int i = 0; i < k; i++) {
            alphabet[i] = String.valueOf(i);
        }
        if (n == 1){
            return alphabet;
        }
        ArrayList<String> total = new ArrayList<>();
        for (String alphabetChar : alphabet) {
            String[] endings = bruteForce(n - 1, k);
            for (String ending : endings) {
                if (!ending.contains(alphabetChar)) {
                    total.add(alphabetChar + ending);
                }
            }
        }
        String[] totalStr = new String[total.size()];
        return total.toArray(totalStr);
    }

    public static String encode(int[] codes, String str) {
        if (codes.length != str.length()) {
            return null;
        }
        char[] strChars = str.toCharArray();
        String total = "";
        for (int i = 0; i < codes.length; i++) {
            total += (char) (codes[i] ^ strChars[i]);
        } 
        return total;
    }

    public static int[] decode(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return null;
        }
        int[] total = new int[str1.length()];
        for (int i = 0; i < total.length; i++) {
            total[i] = str1.charAt(i) ^ str2.charAt(i);
        }
        return total;
    }
}