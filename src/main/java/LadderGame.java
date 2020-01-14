import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGame {
    private List<String> users = new ArrayList<>();

    public List<String> getUsers() {
        return users;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    private int ladderHeight;

    void run(){

    }
    public LadderGame() {
        sInUserNames();
        sInLadderHeight();
    }

    private void sInLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scan = new Scanner(System.in);
        ladderHeight = scan.nextInt();
    }

    private void sInUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scan = new Scanner(System.in);
        String userNameInput = scan.nextLine();
        String[] userNameArr = userNameInput.split(",");
        users.addAll(Arrays.asList(userNameArr));
    }

}
