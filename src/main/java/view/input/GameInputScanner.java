package view.input;

import java.util.Scanner;

public class GameInputScanner {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. 이름은 쉼표(,) 단위로 구분됩니다.");
        return scanner.nextLine();
    }

    public static String getResults() {
        System.out.println("사다리 게임 상품을 입력하세요. 상품은 쉼표(,) 단위로 구분됩니다.");
        return scanner.nextLine();
    }

    public static String getHeight() {
        System.out.println("사다리 높이를 입력하세요.");
        return scanner.nextLine();
    }

    public static String getUserNameForResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
