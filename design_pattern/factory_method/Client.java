package design_pattern.factory_method;

public class Client {
    public static void main(String[] args) {
        Bank bank = BankFactory.getBank(BankType.TPBANK);
        System.out.println(bank.getBankName()); 
    }
}
