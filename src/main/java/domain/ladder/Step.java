package domain.ladder;

public class Step {

    private boolean exist;

    public static Step existingStep() {
        return new Step(true);
    }

    public static Step nonExistingStep() {
        return new Step(false);
    }

    private Step(boolean exist) {
        this.exist = exist;
    }

    public boolean exist() {
        return exist;
    }

}
