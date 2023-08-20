
public class Main {

    public static void main(String[] args) {

        double moneyTotal;
        moneyTotal = 100.00;

        double snackCost;
        snackCost = 10.00;

        double purchasableSnacks;

        System.out.print("You currently have ");
        System.out.print(moneyTotal);
        System.out.print(" dollars in your account.");

        purchasableSnacks = moneyTotal / snackCost;

        System.out.print("\nYou are able to buy a total of ");
        System.out.print(purchasableSnacks);
        System.out.print(" snacks.");

        System.out.println("\nYou'll love java");
    }
}


