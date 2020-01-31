package laddergame.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE_GET_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_GET_GAME_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_GET_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public String getPlayerNamesFromConsole() {
        System.out.println(MESSAGE_GET_PLAYER_NAMES);
        return SCANNER.nextLine();
    }

    public String getGameResultFromConsole() {
        System.out.println(MESSAGE_GET_GAME_RESULTS);
        return SCANNER.nextLine();
    }

    public int getLadderHeightFromConsole() {
        System.out.println(MESSAGE_GET_LADDER_HEIGHT);
        return SCANNER.nextInt();
    }
}
