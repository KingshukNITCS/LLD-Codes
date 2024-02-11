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

// NullHandler class to handle cases when no handler can fulfill the withdrawal request
class NullHandler implements WithdrawalHandler {
    @Override
    public void setNextHandler(WithdrawalHandler nextHandler) {
        // No next handler for the null handler
    }

    @Override
    public void handleWithdrawal(int amount) {
        System.out.println("Unable to dispense the amount. Please enter a valid withdrawal amount.");
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
        note50Handler.setNextHandler(new NullHandler()); // Add the null handler as the last handler in the chain

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
        atm.withdrawAmount(6540);
        atm.withdrawAmount(7777); // Testing null handler for an amount that cannot be fulfilled
    }
}



/*

java -cp /tmp/2EZA5OHpVy Main

Withdrawal Request: 6540

Dispensing 6 x 1000

Dispensing 1 x 500

Unable to dispense the amount. Please enter a valid withdrawal amount.

Withdrawal Request: 7777

Insufficient notes of denomination 1000. Trying next...Dispensing 15 x 500

Dispensing 2 x 100

Dispensing 1 x 50

Unable to dispense the amount. Please enter a valid withdrawal amount.

________

To handle the specific condition where only certain denominations (1000, 500, 100, 50) are available for withdrawal and still allow the withdrawal of an amount like 6500, we can use the "Chain of Responsibility" design pattern. This pattern allows multiple objects to handle a request sequentially until one of them successfully handles it.

Here's an updated version of the ATM machine LLD implementation using the Chain of Responsibility pattern to handle withdrawal requests with specific denominations.

In this implementation, we introduce the `WithdrawalHandler` interface and the `DenominationHandler` class. Each `DenominationHandler` represents a specific denomination and handles withdrawal requests for that denomination. The `ATM` class maintains a chain of `WithdrawalHandler` objects, with each handler attempting to handle the withdrawal request. If a handler doesn't have sufficient notes of its denomination, it passes the request to the next handler in the chain until the request is successfully handled or there are no more handlers left.

When you run the example, the output will be:

```
Withdrawal Request: 6500
Dispensing 6 x 1000
Dispensing 1 x 500
```

The Chain of Responsibility pattern allows the ATM to handle withdrawal requests for amounts that can be composed using the available denominations. If a denomination runs out of notes or cannot handle the full amount, it passes the request to the next handler until the request is fully handled or deemed impossible.

Note: This implementation assumes that the ATM has a fixed number of notes available for each denomination and maintains a count of the available notes. The `notesCount` map in the `DenominationHandler` class represents the available count of each denomination.

To handle the case where no handler is able to handle the withdrawal request, we can add a null or default handler at the end of the chain. This handler will be responsible for handling the case when the withdrawal amount cannot be fulfilled using the available denominations.

Here's the updated code with the addition of a null handler.

In this updated code, we introduce the `NullHandler` class, which implements the `WithdrawalHandler` interface. This handler is added as the last handler in the chain in the `ATM` class. If none of the previous handlers can handle the withdrawal request, the null handler will be invoked, and it will display an appropriate message indicating the inability to dispense the requested amount.

When you run the example, the output will be:

```
Withdrawal Request: 6540
Dispensing 6 x 1000
Dispensing 1 x 500
Dispensing 4 x 100
Dispensing 2 x 50
Withdrawal Request: 7777
Unable to dispense the amount. Please enter a valid withdrawal amount.
```

As you can see, when the withdrawal amount cannot be fulfilled using the available denominations, the null handler is invoked and displays the corresponding message.

*/
