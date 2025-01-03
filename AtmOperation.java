package Atm;

import java.util.HashMap;
import java.util.Map;


public class AtmOperation implements Atminterface {

    private ATM atm = new ATM();
    private Map<String, String> ministmt = new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("Available Balance: " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                System.out.println("Collect the cash: " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                ministmt.put(String.valueOf(System.currentTimeMillis()), "Withdrawn: " + withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance");
            }
        } else {
            System.out.println("Please enter an amount in multiples of 500.");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        System.out.println("Deposited Amount: " + depositAmount);
        atm.setBalance(atm.getBalance() + depositAmount);
        ministmt.put(String.valueOf(System.currentTimeMillis()), "Deposited: " + depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        System.out.println("Mini Statement:");
        for (Map.Entry<String, String> entry : ministmt.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
