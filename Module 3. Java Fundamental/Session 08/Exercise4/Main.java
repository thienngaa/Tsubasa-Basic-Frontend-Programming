package exercise04;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo tài khoản A và B
        BankAccount accountA = new BankAccount("A001", "Nguyễn Văn A", "0123456789");
        BankAccount accountB = new BankAccount("B001", "Nguyễn Văn B", "0987654321");

        // Nạp tiền vào tài khoản A
        accountA.deposit(1000);

        // Chuyển tiền từ tài khoản A đến tài khoản B
        double transferAmount = 300;
        accountA.withdraw(transferAmount); // Rút tiền từ tài khoản A
        accountB.deposit(transferAmount);   // Nạp tiền vào tài khoản B

        // Hiển thị số dư các tài khoản
        accountA.displayBalance();
        accountB.displayBalance();
    }
}
