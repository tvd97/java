package design_pattern.factory_method;

public class TPBank implements Bank{

    @Override
    public String getBankName() {
      return "TP Bank";
    }
    
}
class VietcomBank implements Bank {
 
    @Override
    public String getBankName() {
        return "VietcomBank";
    }
 
}
