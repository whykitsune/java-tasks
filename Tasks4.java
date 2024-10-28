
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Tasks4 {
    public static void main(String[] args) {
        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));
        System.out.println(Arrays.toString(bruteForce(1, 5)));
        System.out.println(Arrays.toString(bruteForce(2, 2)));
        System.out.println(Arrays.toString(bruteForce(5, 3)));
        System.out.println(encode(new int[]{0, 31, 28, 10, 29}, "MKIIT"));
        System.out.println(Arrays.toString(decode("MTUCI", "MKIIT")));
        System.out.println(Arrays.toString(split("()()()")));
        System.out.println(Arrays.toString(split("((()))")));
        System.out.println(Arrays.toString(split("((()))(())()()(()())")));
        System.out.println(Arrays.toString(split("((())())(()(()()))")));
        System.out.println(shortHand("abbccc"));
        System.out.println(shortHand("vvvvaajaaaaa"));

        System.out.println(uniqueSubstring("31312131"));
        System.out.println(uniqueSubstring("1111111"));
        System.out.println(uniqueSubstring("12223234333"));

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println(fibString("CCCABDD"));
        System.out.println(fibString("ABC"));
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
    
    public static String[] split(String str) {
        ArrayList<String> list = new ArrayList<>();
        int countOpen = 0;
        String temp = "";
        for (char ch : str.toCharArray()) {
            temp += ch;
            if (ch == ')') {
                countOpen--;
                if (countOpen == 0) {
                    list.add(temp);
                    temp = "";
                }
            } else if (ch == '(') {
                countOpen++;
            }
        }
        String[] total = new String[list.size()];
        list.toArray(total);
        return total;
    }

    public static String shortHand(String str) {
        String total = String.valueOf(str.charAt(0));
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                if (count > 1) {
                    total += "*" + count;
                }
                total += str.charAt(i);
                count = 1;
            }
        }
        if (count > 1) {
            total += "*" + count;
        }
        return total;
    }

    // public static void roma(String[] args) {
        
    // }

    public static String uniqueSubstring(String str) {
        int[] array = new int[2];
        for (int i = 0; i < str.length(); i++) {
            int count = str.length() - str.replace(String.valueOf(str.charAt(i)), "").length();
            if (count > array[1]) {
                array[1] = count;
                array[0] = i;
            }
        }
        if (array[0] % 2 == 0) {
            return "чет";
        }
        return "нечет";
    }

    public static String numericOrder(String str) {
        String total = "";
        String[] array = str.split(" ");
        HashMap<Integer, String> table = new HashMap<>();
        for (String temp : array) {
            table.put(Integer.valueOf(temp.replaceAll("\\D", "")), temp.replaceAll("\\d", ""));
        }
        for (int i = 1; i < array.length; i++) {
            if (i == array.length - 1) {
                total += table.get(i);
                break;
            }
            total += table.get(i) + " ";
        }
        return total;
    }

    public static boolean fibString(String str) {
        ArrayList<Integer> list = new ArrayList<>();
        while (!str.isEmpty()) {
            list.add(str.length() - str.replace(String.valueOf(str.charAt(0)), "").length());
            str = str.replace(String.valueOf(str.charAt(0)), "");
        }
        Collections.sort(list);
        ArrayList<Integer> listFib = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i <= 1) {
                listFib.add(1);
            } else {
                listFib.add(listFib.getLast() + listFib.get(listFib.size() - 2));
            }
            if (!listFib.get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }
}
