package model;

import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//모델내부에서 컨트롤러나 뷰에 관한 코드가 있으면 안된다.
public class GameRuleLogic {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private int strikeCount;
    private int ballCount;
    private static final int INIT_ZERO = 0;
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String SPACE_MESSAGE = " ";
    private static final String NULL_MESSAGE ="";
    private static final int BASEBALL_SUCCESS_STRIKE_NUMBER = 3;

   private List<Integer> userNumber; // [263]
    private List<Integer> computerNumber;

    public List<Integer> bringComputerNumber() {
        this.computerNumber = ComputerNumberGeneratorUtil.getnerateComputerNumber(); // [257] //우테코에서 List<Integer> 로 받아와서
        return computerNumber;
    }
    OutputView outputView = new OutputView();

    public void gameProgressByRule(List<Integer> userNumber, List<Integer> computerNumber){
        this.userNumber = userNumber;
        this.computerNumber =computerNumber;

        initCount();
        checkBallAndStrike();
        provideTotalMessage();
    }

    private void initCount(){
        strikeCount = INIT_ZERO;
        ballCount = INIT_ZERO;

    }

    public void checkBallAndStrike(){
        for(int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH;i++){

            ball(userNumber.get(i), computerNumber,i);
            strike(userNumber.get(i), computerNumber.get(i));
        }
    }
    public void ball( int userNumber,  List<Integer> computerNumber, int numberIndex) {
        if(computerNumber.contains(userNumber) && userNumber != computerNumber.get(numberIndex)){
            ballCount++;
        }

    }

    public void strike(int userNumber, int computerNumber){
        if(userNumber == computerNumber){
            strikeCount++;
        }
    }


    
    public void provideTotalMessage(){
        String totalMessage = "";
        totalMessage += getBallMessage();
        totalMessage += getStrikeMessage();
        totalMessage += getNothingMessage();
        outputView.printBallStrikeNothing(totalMessage);
    }
    public String getBallMessage(){
        if(ballCount > 0){
            return ballCount + BALL_MESSAGE +SPACE_MESSAGE;
        }
        return NULL_MESSAGE;
    }

    public String getStrikeMessage(){
        if(strikeCount > 0){
            return  strikeCount + STRIKE_MESSAGE + SPACE_MESSAGE;
        }
        return NULL_MESSAGE;
    }
    public String getNothingMessage(){
        if ( ballCount == 0 && strikeCount == 0){ // 오우 미쳤땅
            return NOTHING_MESSAGE + SPACE_MESSAGE;
        }
        return NULL_MESSAGE;
    }

    public boolean threeStrike(){

        return strikeCount == BASEBALL_SUCCESS_STRIKE_NUMBER;
    }


}
