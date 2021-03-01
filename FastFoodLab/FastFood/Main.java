package FastFoodLab.FastFood;

import FastFoodLab.Day.Day;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FastFood.order(sc);
        Day.getDayStats();
    }
}
