package edu.uoc.pac1;

public class PAC1Ex3 {

    static double[] dailyServiceCharges = {4.52, 5.05, 4.84, 5.27, 4.78, 5.39, 4.99};

    static double[][] unitRatesPerDay = {
            { 0.234, 0.456, 0.789, 0.101, 0.123, 0.567, 0.890 },
            { 0.234, 0.567, 0.890, 0.112, 0.345, 0.678, 0.901 },
            { 0.345, 0.678, 0.901, 0.223, 0.456, 0.789, 0.012 },
            { 0.456, 0.789, 0.012, 0.334, 0.567, 0.890, 0.123 },
    };

    public static double twoDecimals(double number) {
        return Math.round(number * 100d) / 100d;
    }

    public static double calculateTotalBill(int[][] unitsPerMonth) {
        double totalBill = 0;

        for (int week = 0; week < unitsPerMonth.length; week++) {
            for (int day = 0; day < unitsPerMonth[week].length; day++) {

                int dayUnits = unitsPerMonth[week][day];
                double serviceCharge = dailyServiceCharges[day];
                double billForDay = 0;

                billForDay += dayUnits * unitRatesPerDay[week][day];
                billForDay += calculateAdditionalCharges(dayUnits);
                billForDay += calculateTieredPricing(dayUnits);

                totalBill += billForDay + serviceCharge;
            }
        }

        return twoDecimals(totalBill);
    }

    public static double calculateDiscount(int daysUnderFiftyUnits, double totalBill) {
        double discount = 0;

        if (daysUnderFiftyUnits > 10) {
            discount = totalBill * 0.2;
        } else if (daysUnderFiftyUnits > 5) {
            discount = totalBill * 0.1;
        }
        return twoDecimals(discount);
    }

    public static double calculateAdditionalCharges(int units) {
        double additionalCharges = 0;

        if (units > 300) {
            additionalCharges = units * 0.02;
        }

        return twoDecimals(additionalCharges);
    }

    public static double calculateTieredPricing(int units) {
        double tieredPrice = 0;

        if (units <= 300) {
            tieredPrice = units * 0.04;
        } else if (units <= 600) {
            tieredPrice = 300 * 0.04 + (units - 300) * 0.06;
        } else {
            tieredPrice = 300 * 0.04 + 300 * 0.06 + (units - 600) * 0.014;
        }

        return twoDecimals(tieredPrice);
    }
}
