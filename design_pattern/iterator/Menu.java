package design_pattern.iterator;

public class Menu implements Container {
    public String menu[] = { "Cà phê", "Nước cam", "Bò Húc", "Sting" };

    @Override
    public Iterator getIterator() {
        return new MenuIterator();

    }

    private class MenuIterator implements Iterator {

        int index;

        // Return boolean.
        // True - Collection còn phần tử
        // False - Cuối collection
        @Override
        public boolean hasNext() {

            if (index < menu.length) {
                return true;
            }
            return false;
        }

        // Return object
        // Trả về phần tử kế tiếp
        @Override
        public Object next() {

            if (this.hasNext()) {
                return menu[index++];
            }
            return null;
        }
    }
}
