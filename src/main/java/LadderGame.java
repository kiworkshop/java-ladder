import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGame {

    private List<String> users = new ArrayList<>();
    private int ladderHeight;
    private Lines lines;

    private static final String LINE_SAMPLE  = "-----|";
    private static final String SPACE_SAMPLE = "     |";


    public LadderGame() {
        sInUserNames();
        sInLadderHeight();
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

    void run(){
        constructRandomLines();
        printResult();
    }

    private void printResult() {
        System.out.println("\n실행결과\n");
        users.forEach(user -> printUser(user));
        System.out.println();
        lines.getLines()
        .forEach(line-> oneLineProcess(line));
    }
    private void oneLineProcess(Line line) {

        printLine(SPACE_SAMPLE);
        int ladderWidth = users.size() - 1;

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

    private void printUser(String user) {
        System.out.format("%6s",user);
    }


    private void constructRandomLines() {
        lines = new Lines(users.size(),ladderHeight);
    }

    public List<String> getUsers() {
        return users;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

}
