package design_pattern.abstract_factory;

public class EmberToolkit extends AbstractFactory{

    @Override
    public CPU createCPU() {
        return new EmberCPU();
    }

    @Override
    public MMU createMMU() {
       return new EmberMMU();
    }
    
}
