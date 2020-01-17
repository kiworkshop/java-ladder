import java.util.Scanner;

public class InputScanner {

    private static final String MESSAGE_GET_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_GET_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String EMPTY_LINE = "";

    private Scanner scanner = new Scanner(System.in);

    public String getPlayerNamesFromUser() {
        System.out.println(MESSAGE_GET_PLAYER_NAMES);
        return scanner.nextLine();
    }

    public int getLadderHeightFromUser() {
        System.out.println(MESSAGE_GET_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void printSeparationLine() {
        System.out.println(EMPTY_LINE);
    }
}
