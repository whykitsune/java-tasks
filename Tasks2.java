
import java.util.Arrays;

public class Tasks2 {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Barack", "Obama"));
        System.out.println(dividedByThree(new int[]{3, 12, 7, 81, 52}));
        System.out.println(getInitials("simonov sergei evgenievich"));
        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));
        System.out.println(Arrays.toString(normalizator(new double[] {3.5, 7.0, 1.5, 9.0, 5.5})));
        System.out.println(Arrays.toString(normalizator(new double[] {10.0, 10.0, 10.0, 10.0})));
        System.out.println(Arrays.toString(compressedNums(new double[] {1.6, 0, 212.3, 34.8, 0, 27.5})));
        System.out.println(camelToSnake("helloWorld"));
        System.out.println(secondBiggest(new int[] {3, 5, 8, 1, 2, 4}));
        System.out.println(localReverse("Hello, I'm under the water, please help me", "e"));
        System.out.println(localReverse("baobab", "b"));
        System.out.println(equal(8, 1, 8));
        System.out.println(equal(5, 5, 5));
        System.out.println(equal(4, 9, 6));
        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println(isAnagram("hello", "world"));
    }
    public static String duplicateChars(String word1, String word2) {
        String total = "";
        char[] word1Chars = word1.toLowerCase().toCharArray();
        for (int i = 0; i < word1Chars.length; i++) {
            if (word2.indexOf(word1Chars[i]) == -1) {
                total = total + word1Chars[i];
            }
        }
        return total;
    }
    public static int dividedByThree(int[] numArray) {
        int count = 0;
        for (int i = 0; i < numArray.length; i++) {
            if ((numArray[i] % 2 == 1) && (numArray[i] % 3 == 0)) {
                count++;
            }
        }
        return count;
    }
    public static String getInitials(String fullName) {
        String[] fullNameArray = fullName.split(" ");
        String name = fullNameArray[1].substring(0, 1).toUpperCase() + ".";
        String patronymic = fullNameArray[2].substring(0, 1).toUpperCase() + ". ";
        String surname = fullNameArray[0].substring(0, 1).toUpperCase() + fullNameArray[0].substring(1);
        return (name + patronymic + surname);
    }
    public static double[] normalizator(double[] numArray) {
        double minimum = numArray[0];
        double maximum = numArray[0];
        for (double num : numArray) {
            minimum = (num < minimum) ? num : minimum;
            maximum = (num > maximum) ? num : maximum;
        }
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = (numArray[i] - minimum) / (maximum - minimum);
            if (Double.isNaN(numArray[i])) {
                numArray[i] = 0;
            }
        }
        return numArray;
    }
    public static int[] compressedNums(double[] numArray) {
        int countZeros = 0;
        for (double num: numArray) {
            if (num == 0) {
                countZeros++;
            }
        }
        int[] totalArray = new int[numArray.length - countZeros];
        int zerosC = 0;
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == 0) {
                zerosC++;
            }
            else {
                totalArray[i-zerosC] = (int) numArray[i];
            }
        }
        Arrays.sort(totalArray);
        return totalArray;
    }
    public static String camelToSnake(String str) {
        String totalStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str.toUpperCase().charAt(i)) {
                totalStr = totalStr + "_" + str.toLowerCase().charAt(i);
            }
            else {
                totalStr = totalStr + str.charAt(i);
            }
        }
        return totalStr;
    }
    public static int secondBiggest(int[] numArray) {
        int maximum = numArray[0];
        int secMaximum = numArray[0];
        for (int i = 1; i < numArray.length; i++) {
            if (numArray[i] > maximum) {
                secMaximum = maximum;
                maximum = numArray[i];
            }
        }
        return secMaximum;        
    }
    public static String localReverse(String str, String marker) {
        String totalStr = "";
        String remainStr = "";
        String[] strArray;
        int countMarkers = str.length() - str.replace(marker, "").length();
        if (countMarkers % 2 == 0) {
            strArray = str.split(marker);
        } else {
            strArray = str.substring(0, str.lastIndexOf(marker)).split(marker);
            remainStr = str.substring(str.lastIndexOf(marker));
        }
        for (int i = 0; i < strArray.length; i++) {
            if (i % 2 == 1) {
                String reversed_s = "";
                for (int j = 0; j < strArray[i].length(); j++) {
                    reversed_s = strArray[i].charAt(j) + reversed_s;
                }
                totalStr = totalStr + marker + reversed_s + marker;
            } else {
                totalStr = totalStr + strArray[i];
            }
        }
        return totalStr + remainStr;
    }
    public static int equal(int a, int b, int c) {
        if ((a == b) && (b == c)) {
            return 3;
        } else if ((a == b) || (b == c) || (a == c)) {
            return 2;
        } else {
            return 0;
        }
    }
    public static boolean isAnagram(String str1, String str2) {
        String str1New = "";
        String str2New = "";
        for (int i = 0; i < str1.length(); i++) {
            if (Character.isLetterOrDigit(str1.charAt(i))) {
                str1New = str1New + str1.charAt(i);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (Character.isLetterOrDigit(str2.charAt(i))) {
                str2New = str2New + str2.charAt(i);
            }
        }
        char[] str1Chars = str1New.toLowerCase().toCharArray();
        str2New = str2New.toLowerCase();
        for (char ch : str1Chars) {
            if (str2New.indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }
}
