
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Tasks3 {
    public static void main(String[] args) {
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));
        ArrayList<Object[]> data = new ArrayList<>();
        data.add(new Object[] {"Laptop", 124200});
        data.add(new Object[] {"Phone", 51450});
        data.add(new Object[] {"Headphones", 13800});
        ArrayList<Object[]> dataOut = sale(data, 25);
        for (Object[] elem : dataOut) {
            System.out.println(Arrays.toString(elem));
        }
        System.out.println(sucsessShoot(0, 0, 5, 2, 2));
        System.out.println(sucsessShoot(-2, -3, 4, 5, -6));
        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));
        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));
        System.out.println(mostExpensive(new Object[][] {new Object[] {"Скакалка", 550, 8}, new Object[] {"Шлем", 3750, 4}, new Object[] {"Мяч", 2900, 10}}));
        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
    }

    public static boolean isStrangePair(String str1, String str2) {
        if (str1.isEmpty()) {
            return str2.isEmpty();
        }
        return str1.charAt(0) == str2.charAt(str2.length() - 1) && str1.charAt(str1.length() - 1) == str2.charAt(0);
    }

    public static ArrayList<Object[]> sale(ArrayList<Object[]> list, double saleSize) {
        ArrayList<Object[]> totalList = new ArrayList<>();
        for (Object[] prod : list) {
            int cost = (int) prod[1];
            if (cost * ((100 - saleSize) / 100) < 1) {
                cost = 1;
            } else {
                cost = (int) Math.round(cost * ((100 - saleSize) / 100));
            }
            totalList.add(new Object[] {prod[0], cost});
        }
        return totalList;
    }

    public static boolean sucsessShoot(int x, int y, int r, int m, int n) {
        return Math.sqrt(Math.pow((m - x), 2) + Math.pow((n - y), 2)) < r;
    }

    public static boolean parityAnalysis(int num) {
        ArrayList<Integer> digits = new ArrayList<>();
        int temp = num;
        while (temp > 0) {
            digits.add(temp % 10);
            temp /= 10;
        }
        int s = 0;
        for (int n : digits) {
            s += n;
        }
        return s % 2 == num % 2;
    }

    public static String rps(String val1, String val2) {
        HashMap<String, String> table = new HashMap<>();
        table.put("rock", "scissors");
        table.put("scissors", "paper");
        table.put("paper", "rock");
        String total;
        if (table.get(val1).equals(val2)) {
            total = "Player 1 wins";
        } else if (val1.equals(val2)) {
            total = "Tie";
        } else {
            total = "Player 2 wins";
        }
        return total;
    }

    public static int bugger(int num) {
        int count = 0;
        while (num / 10 >= 1) {
            ArrayList<Integer> digits = new ArrayList<>();
            int temp = num;
            while (temp > 0) {
                digits.add(temp % 10);
                temp /= 10;
            }
            int s = 1;
            for (int n : digits) {
                s *= n;
            }
            num = s;
            count++;
        }
        return count;
    }

    public static String mostExpensive(Object[][] array) {
        String expItem = "";
        int expCost = 0;
        for (Object[] elem : array) {
            if (((int) elem[1]) * ((int) elem[2]) > expCost) {
                expCost = ((int) elem[1]) * ((int) elem[2]);
                expItem = (String) elem[0];
            }
        }
        return "Наиб. общ. стоимость у предмета " + expItem + " - " + expCost;
    }

    public static String longestUnique(String str) {
        char[] CharArray = str.toCharArray();
        int res = 0;
        String sub = "";
        String total = "";
        for (char ch : CharArray) {
            if (sub.indexOf(ch) == -1) {
                sub += ch;
                if (sub.length() > res) {
                    res = sub.length();
                    total = sub;
                }
            } else {
                int index = sub.indexOf(ch);
                sub = sub.substring(index + 1) + ch;
            }
        }
        return total;
    }

    public static boolean isPrefix(String word, String prefix) {
        prefix = prefix.replace("-", "");
        return word.startsWith(prefix);
    }

    public static boolean isSuffix(String word, String suffix) {
        suffix = suffix.replace("-", "");
        return word.endsWith(suffix);
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        int[] array = new int[] {a, b, c};
        Arrays.sort(array);
        int min1 = array[0];
        int min2 = array[1];
        return ((min1 <= w) && (min2 <= h)) || ((min1 <= h) && (min2 <= w));
    }
}
