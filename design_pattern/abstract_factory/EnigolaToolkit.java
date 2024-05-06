package design_pattern.abstract_factory;

public class EnigolaToolkit extends AbstractFactory{

    @Override
    public CPU createCPU() {
        
       return new EnginolaCPU();
    }

    @Override
    public MMU createMMU() {
        return new EnginolaMMU();
    }
    
}
