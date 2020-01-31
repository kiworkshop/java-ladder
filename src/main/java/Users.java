import java.util.ArrayList;
import java.util.List;

public class Users {
    List<String> users = new ArrayList<>();

    public void rightAndLeftReversal(int leftIndex){
        int rightIndex = leftIndex + 1;
        String leftUser = users.get(leftIndex);
        users.remove(leftIndex);
        users.add(rightIndex, leftUser);
    }

    public void addAll(List<String> asList) {
        users.addAll(asList);
    }

    public void printUsers() {
        users.forEach(user -> printUser(user));
    }
    private void printUser(String user) {
        System.out.format("%6s",user);
    }


    public int getSize() {
        return users.size();
    }

    public String getUserByIndex(int index) {
        return users.get(index);
    }

    public boolean contains(String userNameInput) {
        return users.contains(userNameInput);
    }

    public int getIndexByUsername(String userNameInput) {
        return users.indexOf(userNameInput);
    }
}
