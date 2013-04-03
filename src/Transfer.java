/**
 * A transaction that moves money between accounts.
 * Observers should not be able to see a state with missing money.
 */
public class Transfer implements Runnable {
    
    final Account from;
    final Account to;
    final int val;
    
    public Transfer(Account from, Account to, int val) {
        this.from = from;
        this.to = to;
        this.val = val;
    }
    
    public void run() {
        synchronized (from) {
            synchronized (to) {
                if (from.getBalance() > val) {
                    from.addMoney(-val);
                    to.addMoney(val);
                } else {
                    throw new RuntimeException("Balance below transfer amount");
                }
            }
        }
    }
}
