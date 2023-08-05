package view;

//출력하는 기능
public class
OutputView {
    private static final String GAME_START_MESSAGE ="숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStartGame(){
        System.out.println(GAME_START_MESSAGE);
    }
    public void printEndGame(){
        System.out.println(GAME_END_MESSAGE);
    }

    //볼 스트라이크 낫띵을 합친 출력함수 기능 넣기~!~!~!
    public void printBallStrikeNothing(String totalMessage){
        System.out.println(totalMessage);
    }
}
