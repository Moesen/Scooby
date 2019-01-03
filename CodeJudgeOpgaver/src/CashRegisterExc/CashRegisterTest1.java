package CashRegisterExc;

public class CashRegisterTest1 {

    public static void main(String[] args) {
        int num = 3;

        String pathPrices = "/home/snooze/Git/Scooby/CodeJudgeOpgaver/src/CashRegisterExc/input/prices.txt";
        String pathDiscounts = "/home/snooze/Git/Scooby/CodeJudgeOpgaver/src/CashRegisterExc/input/discounts.txt";
        CashRegister test1 = new CashRegister(pathPrices, pathDiscounts);
        test1.printReceipt("/home/snooze/Git/Scooby/CodeJudgeOpgaver/src/CashRegisterExc/input/bar" + num + ".txt");

    }

}
