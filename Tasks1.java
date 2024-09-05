public class Tasks1 {
    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }

    public static double convert(int gallon) {
        return gallon * 3.785;
    }

    public static int fitCalc(int time, int intensity) {
        return time * intensity;
    }

    public static int containers(int boxes, int bags, int barrels) {
        return 20 * boxes + 50 * bags + 100 * barrels;
    }

    public static String triangleType(int a, int b, int c) {

        if ((a + b < c) || (a + c < b) || (b + c < a)) {
            return "not a triangle";
        }
        else if ((a == b) && (b == c)) {
            return "isosceles";
        }
        else if ((a == b) || (a == c) || (b == c)) {
            return "equilateral";
        }

        return "different-sided";
    }

    public static int ternaryEvaluation(int a, int b) {
        return (a > b) ? a : b;        
    }

    public static int howManyItems(int n, double w, double h) {
        return (int) ((n / 2) / (w * h));
        
    }

    public static int factorial(int num) {
        int factorialNum = 1;
        for (int i = 2; i <= num; i++) {
            factorialNum = factorialNum * i;
        }
        return factorialNum;
    }

    public static int ticketSaler(int count, int price) {
        double commission = 0.28 * price * count;
        int clearPrice = count * price;
        return (int) (clearPrice - commission); 
    }

    public static int gcd(int a, int b) {
        if (a < b) {
            for (int i = a; i > 1; i--) {
                if ((a % i == 0) && (b % i == 0)) {
                    return i;
                }
            }
        }
        else {
            for (int i = b; i > 1; i--) {
                if ((a % i == 0) && (b % i == 0)) {
                    return i;
                }
            }
        }
        return 1;
    }

    public static int tables(int students, int desks) {
        if (students % 2 == 0) {
            int countDesks = students / 2;  //countDesks - нужное кол-во парт
            if (countDesks <= desks) {
                return 0;
            }
            else {
                return countDesks - desks;
            }
        }
        else {
            int countDesks = ((int) students / 2) + 1;  //countDesks - нужное кол-во парт
            if (countDesks <= desks) {
                return 0;
            }
            else {
                return countDesks - desks;
            }
        }
    }
}
