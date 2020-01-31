import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGame {

    private Users users = new Users();
    private int ladderHeight;
    private Ladder ladder;
    private List<String> ladderGameResult = new ArrayList<>();


    private static final String LINE_SAMPLE  = "-----|";
    private static final String SPACE_SAMPLE = "     |";

    void run(){
        constructRandomLines();
        printResult();
        ladder.getLadder()
                .forEach(line->rightAndLeftReversalLine(line));
    }

    private void constructRandomLines() {
        ladder = new Ladder(users.getSize(),ladderHeight);
    }

    private void printResult() {
        System.out.println("\n실행결과\n");
        users.printUsers();
        System.out.println();
        ladder.getLadder()
                .forEach(line-> oneLineProcess(line));
        printLadderGameResult();
    }

    public void printLadderGameResult() {
        ladderGameResult.forEach(result -> System.out.format("%6s",result));
    }

    private void rightAndLeftReversalLine(Line line) {
        line.getLinePositions()
                .forEach(index -> users.rightAndLeftReversal(index));
    }

    public void getResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        Scanner scan = new Scanner(System.in);
        String userNameInput = scan.nextLine();
        if(userNameInput.equals("all")) {
            System.out.println("실행 결과");
            for(int i = 0; i < users.getSize() ; i ++){
                System.out.println(users.getUserByIndex(i) + " : " + ladderGameResult.get(i));
            }
        }
        else if(users.contains(userNameInput)){
            System.out.println("\n실행 결과");
            System.out.println(ladderGameResult.get(users.getIndexByUsername(userNameInput)));
        }

    }

    public LadderGame() {
        sInUserNames();
        sInLadderGameResult();
        sInLadderHeight();
    }

    private void sInLadderGameResult() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scan = new Scanner(System.in);
        String userNameInput = scan.nextLine();
        String[] userNameArr = userNameInput.split(",");
        ladderGameResult.addAll(Arrays.asList(userNameArr));
    }

    private void sInUserNames() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scan = new Scanner(System.in);
        String userNameInput = scan.nextLine();
        String[] userNameArr = userNameInput.split(",");
        users.addAll(Arrays.asList(userNameArr));
    }

    private void sInLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        Scanner scan = new Scanner(System.in);
        ladderHeight = scan.nextInt();
    }

    private void oneLineProcess(Line line) {

        printLine(SPACE_SAMPLE);
        int ladderWidth = users.getSize() - 1;

        for(int i = 0; i < ladderWidth; i++){
            onePartOfLineProcess(line, i);
        }
        System.out.println();
    }

    private void onePartOfLineProcess(Line line, int i) {
        String newLine = SPACE_SAMPLE;
        if(line.getLinePositions().contains(i)){
            newLine = LINE_SAMPLE;
        }
        printLine(newLine);
    }

    private void printLine(String line){
        System.out.print(line);
    }
}
