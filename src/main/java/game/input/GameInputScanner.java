package game.input;

import java.util.Scanner;

public class GameInputScanner {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. 이름은 쉼표(,) 단위로 구분됩니다.");
        return scanner.nextLine();
    }

    public static String getHeight() {
        System.out.println("사다리 높이를 입력하세요.");
        return scanner.nextLine();
    }
}
