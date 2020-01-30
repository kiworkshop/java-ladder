import java.util.Scanner;

public class Input {
    public static final String MESSAGE_INPUT_PERSON_NAME = "참여할 사람의 이름을 입력하세요. 이름은 쉼표(,)로 구분합니다.";
    public static final String MESSAGE_INPUT_RESULT_NAME = "참여할 실행결과를 입력하세요. 이름은 쉼표(,)로 구분합니다.";
    public static final String MESSAGE_INPUT_LADDER_HEIGHT = "사다리 높이는 몇 개인가요?";
    private static Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        System.out.println(MESSAGE_INPUT_PERSON_NAME);
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println(MESSAGE_INPUT_LADDER_HEIGHT);
        return scanner.nextInt();
    }

    public static String inputResults() {
        System.out.println(MESSAGE_INPUT_RESULT_NAME);
        return scanner.nextLine();
    }
}
