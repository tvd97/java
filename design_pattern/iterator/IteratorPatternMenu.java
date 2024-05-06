package design_pattern.iterator;

public class IteratorPatternMenu {
    public static void main(String[] args) {
        Menu menuIterator = new Menu();

        for (Iterator iter = menuIterator.getIterator(); iter.hasNext();) {
            String menuItem = (String) iter.next();
            System.out.println("Menu item : " + menuItem);
        }
    }
}
