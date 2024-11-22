package edu.uoc.pac1;

public class PAC1Ex2 {

    public static int divsSum(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum = sum + i;
        }

        return sum<=0?-1:sum;
    }

    public static boolean isAbundant(int number) {
        return divsSum(number) > number;
    }

    public static boolean isPerfect(int number) {
        return divsSum(number) == number;
    }

    public static boolean isDeficient(int number) {
        return divsSum(number) < number;
    }

    public static void categorize(int[] numbers) {
        int perfectNumbers = 0;
        int abundantNumbers = 0;
        int deficientNumbers = 0;
        for (int number : numbers) {
            if (isAbundant(number)) {
                abundantNumbers++;
            } else if (isDeficient(number)) {
                deficientNumbers++;
            } else if (isPerfect(number)) {
                perfectNumbers++;
            }
        }
        System.out.println("There are: " + perfectNumbers + " perfect numbers.");
        System.out.println("There are: " + abundantNumbers + " abundant numbers.");
        System.out.println("There are: " + deficientNumbers + " deficient numbers.");
    }
}
