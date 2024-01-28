import java.util.HashMap;
import java.util.Map;

// Denomination enum to represent available currency denominations
enum Denomination {
    NOTE_1000(1000),
    NOTE_500(500),
    NOTE_100(100),
    NOTE_50(50);

    private final int value;

    Denomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

// Handler interface for handling withdrawal requests
interface WithdrawalHandler {
    void setNextHandler(WithdrawalHandler nextHandler);
    void handleWithdrawal(int amount);
}

// Concrete handler responsible for handling withdrawal requests for a specific denomination
class DenominationHandler implements WithdrawalHandler {
    private WithdrawalHandler nextHandler;
    private Denomination denomination;
    private Map<Denomination, Integer> notesCount;

    public DenominationHandler(Denomination denomination) {
        this.denomination = denomination;
        notesCount = new HashMap<>();
        // Initialize available notes count for the denomination
        notesCount.put(Denomination.NOTE_1000, 10);
        notesCount.put(Denomination.NOTE_500, 20);
        notesCount.put(Denomination.NOTE_100, 50);
        notesCount.put(Denomination.NOTE_50, 100);
    }

    @Override
    public void setNextHandler(WithdrawalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleWithdrawal(int amount) {
        if (amount >= denomination.getValue()) {
            int notesNeeded = amount / denomination.getValue();
            if (notesNeeded <= notesCount.get(denomination)) {
                System.out.println("Dispensing " + notesNeeded + " x " + denomination.getValue());
                notesCount.put(denomination, notesCount.get(denomination) - notesNeeded);
                int remainingAmount = amount % denomination.getValue();
                if (remainingAmount > 0) {
                    nextHandler.handleWithdrawal(remainingAmount);
                }
            } else {
                System.out.println("Insufficient notes of denomination " + denomination.getValue() + ". Trying next...");
                nextHandler.handleWithdrawal(amount);
            }
        } else {
            nextHandler.handleWithdrawal(amount);
        }
    }
}

// ATM class with Chain of Responsibility pattern
class ATM {
    private WithdrawalHandler withdrawalHandler;

    public ATM() {
        // Create the withdrawal handlers for each denomination
        WithdrawalHandler note1000Handler = new DenominationHandler(Denomination.NOTE_1000);
        WithdrawalHandler note500Handler = new DenominationHandler(Denomination.NOTE_500);
        WithdrawalHandler note100Handler = new DenominationHandler(Denomination.NOTE_100);
        WithdrawalHandler note50Handler = new DenominationHandler(Denomination.NOTE_50);

        // Set the chain of responsibility
        note1000Handler.setNextHandler(note500Handler);
        note500Handler.setNextHandler(note100Handler);
        note100Handler.setNextHandler(note50Handler);

        withdrawalHandler = note1000Handler;
    }

    public void withdrawAmount(int amount) {
        System.out.println("Withdrawal Request: " + amount);
        withdrawalHandler.handleWithdrawal(amount);
    }
}

// Example usage:
class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.withdrawAmount(6500);
    }
}
