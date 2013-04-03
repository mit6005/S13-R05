public class TransferMain {
    public static void main(String[] args) {
        Account accountA = new Account(500, 0);
        Account accountB = new Account(300, 1);
        
        Transfer trans1 = new Transfer(accountA, accountB, 50); // A-50, B+50
        Transfer trans2 = new Transfer(accountB, accountA, 100); // A+100, B-100
        Thread t1 = new Thread(trans1);
        t1.start();
        Thread t2 = new Thread(trans2);
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ie) {
            System.err.println("Interrupted!");
        }
        
        System.out.println("Account A has $" + accountA.getBalance());
        System.out.println("Account B has $" + accountB.getBalance());
    }
}
