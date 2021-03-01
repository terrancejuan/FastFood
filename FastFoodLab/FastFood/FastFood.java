package FastFoodLab.FastFood;

import java.util.Scanner;
import FastFoodLab.Utilities.Utilities;
import FastFoodLab.Day.Day;

public class FastFood {
    private static final float TAX_AMOUNT = 0.05f;
    private static final float HAMBURGER_PRICE = 1.19f;
    private static final float CHEESEBURGER_PRICE = 1.39f;

    public static void order(Scanner sc) {
        int[] countBurgers = takeOrder(sc);
        float cost = getCost(countBurgers);
        takePayment(sc, cost);
        Day.addCustomers();
        Day.addPrice(cost);
    }

    private static int[] takeOrder(Scanner sc) {
        System.out.print("How many hamburgers do you want? ");
        int numHamburgers = sc.nextInt();
        System.out.print("How many cheeseburgers do you want? ");
        int numCheeseburgers = sc.nextInt();
        return new int[]{numHamburgers, numCheeseburgers};
    }

    private static float getCost(int[] countBurgers) {
        int numHamburgers = countBurgers[0];
        int numCheeseburgers = countBurgers[1];
        float price = numHamburgers * HAMBURGER_PRICE + numCheeseburgers * CHEESEBURGER_PRICE;
        float grossPrice = price * (1 + TAX_AMOUNT);
        grossPrice = Utilities.round2DecimalPlaces(grossPrice);
        return grossPrice;
    }

    private static void takePayment(Scanner sc, float cost) {
        System.out.printf("Total cost is $%.2f\n", cost);
        System.out.println("Pay up");
        System.out.print("$");
        float amountPaid = Utilities.round2DecimalPlaces(sc.nextFloat());
        while (amountPaid < cost) {
            cost -= amountPaid;
            System.out.printf("Not enough. You still owe $%.2f\n", cost);
            System.out.print("$");
            amountPaid = Utilities.round2DecimalPlaces(sc.nextFloat());
        }
        sc.nextLine();
        if (amountPaid > cost) {
            float change = Utilities.round2DecimalPlaces(amountPaid - cost);
            System.out.printf("Your change is $%.2f.\n", change);
        }
        System.out.println("Thank you.");
        System.out.print("Is there a next customer? ");
        if (Character.toLowerCase(sc.nextLine().charAt(0)) == 'y') {
            order(sc);
        }
    }
}
