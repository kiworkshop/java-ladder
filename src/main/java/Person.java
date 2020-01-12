public class Person {

    private String name;

    public Person(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException("5글자 이상 이름을 짓는 것은 불가능합니다.");
        }
    }
}
