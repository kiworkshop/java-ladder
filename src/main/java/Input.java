import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        System.out.println("참여할 사람의 이름을 입력하세요. 이름은 쉼표(,)로 구분합니다.");
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println("사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
