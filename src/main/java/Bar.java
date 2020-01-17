public class Bar {

    public static final String BAR_EXIST = "-----";
    public static final String BAR_NOT_EXIST = "     ";
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
            return BAR_EXIST;
        }
        return BAR_NOT_EXIST;
    }
}
