package design_pattern.factory_method;

public class BankFactory {
    private BankFactory() {
    }

    public static final Bank getBank(BankType type) {
        switch (type) {
            case TPBANK:
                return new TPBank();
            case VIETCOMBANK:
                return new VietcomBank();
            default:
                throw new IllegalArgumentException("This bank type is unsupported");
        }
    }
}
