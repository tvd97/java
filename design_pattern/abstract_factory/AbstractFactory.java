package design_pattern.abstract_factory;

abstract class AbstractFactory {
    private static AbstractFactory factory = null;
    private static final EmberToolkit emberToolkit = new EmberToolkit();
    private static final EnigolaToolkit enigolaToolkit = new EnigolaToolkit();

    public static AbstractFactory getFactory(Architecture architecture) {

        switch (architecture) {
            case EMBER:
                factory = emberToolkit;
                break;
            case ENIGOLA:
                factory = enigolaToolkit;
                break;
            default:
                factory = null;
        }
        return factory;
    }

    public abstract CPU createCPU();

    public abstract MMU createMMU();

}
