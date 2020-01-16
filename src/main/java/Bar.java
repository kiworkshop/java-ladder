public class Bar {

    private boolean barExist;

    public Bar(boolean barExist) {
        this.barExist = barExist;
    }

    public boolean isBarExist() {
        return barExist;
    }

    @Override
    public String toString() {
        if (barExist) {
            return "-----";
        }
        return "     ";
    }
}
