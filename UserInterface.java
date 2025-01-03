package Atm;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        AtmOperation A = new AtmOperation();
        Scanner sc = new Scanner(System.in);

        int atmnumber = 123456;
        int atmpin = 123;

        System.out.println("Welcome to ATM Machine");
        System.out.println("Enter the ATM Number:");
        int atmnum2 = sc.nextInt();
        System.out.println("Enter the ATM PIN:");
        int atmpin2 = sc.nextInt();

        if (atmnumber == atmnum2 && atmpin == atmpin2) {
            while (true) {
                System.out.println("1. View Balance");
                System.out.println("2. Withdraw Amount");
                System.out.println("3. Deposit Amount");
                System.out.println("4. View Mini Statement");
                System.out.println("5. Exit");
                System.out.println("Enter your choice:");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        A.viewBalance();
                        break;
                    case 2:
                        System.out.println("Enter the amount to withdraw:");
                        double withdrawAmount = sc.nextDouble();
                        A.withdrawAmount(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Enter the amount to deposit:");
                        double depositAmount = sc.nextDouble();
                        A.depositAmount(depositAmount);
                        break;
                    case 4:
                        A.viewMiniStatement();
                        break;
                    case 5:
                        System.out.println("Collect your ATM card. Thank you!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Incorrect ATM number or PIN.");
        }
        sc.close();
    }
}
