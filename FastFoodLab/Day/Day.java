package FastFoodLab.Day;

import FastFoodLab.Utilities.Utilities;

public class Day {
    private static int numOfCustomers = 0;
    private static float totalProfit = 0;

    public static void getDayStats() {
        System.out.printf("Total profit: $%.2f\n", Utilities.round2DecimalPlaces(totalProfit));
        System.out.println("Total number of customers: " + numOfCustomers);
        System.out.printf("Average price per person: $%.2f\n",
                Utilities.round2DecimalPlaces(totalProfit / numOfCustomers));
    }

    public static void addCustomers() {
        numOfCustomers++;
    }

    public static void addPrice(float price) {
        totalProfit += price;
    }
}
