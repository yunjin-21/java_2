package controller;

import model.GameRuleLogic;
import view.InputView;
import view.OutputView;

import java.util.List;

//게임을 계속 진행하는지 여부 기능
// 3스트라이크가 아닌경우 계속 숫자입력하기 , 3스트라이크일경우 게임종료 , 게임을 진행하는지 여부 확인
public class GameController {
    private static final String BASEBASLL_GAME_RESTART_ANSWER = "1";
    private static final String BASEBASLL_GAME_STOP_ANSWER = "2";
    private static final String BASEBALL_WRONG_ANSWER = "1 혹은 2만 입력 가능합니다.";
    GameRuleLogic gameRuleLogic = new GameRuleLogic();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    UserNumberValidator userNumberValidator = new UserNumberValidator();


    public void gameProgress(){
        outputView.printStartGame(); //게임 시작

        boolean findNumber = true;
        List<Integer> computer = gameRuleLogic.bringComputerNumber();//컴퓨터 숫자 가져오기
        while(findNumber){
                List<Integer> realUserNumber = userNumberValidator.userNumberIsValid(); // 입력된 숫자 유효성 검증
                gameRuleLogic.gameProgressByRule(realUserNumber, computer);// 게임룰로직 가져오기
                findNumber = isNotThreeStrike();       // 3스트라이크가아닌 모든 경우 true
            } // while문을 나왔다 -> 반드시 3스트라이크
        bestThreeStrike();
    }
    private boolean isNotThreeStrike(){
        if(!gameRuleLogic.threeStrike()){
            return true;
        }else{
            return false;
        }
    }

    public void bestThreeStrike(){
        // 오직 3스트라이크 & 1을 입력할 경우만 true
        String userinput = inputView.askRetryGame();

        if(userinput.equals("1")){
            gameProgress();
        } else if (userinput.equals("2")){
            outputView.printEndGame();
            return;
        } else{
            throw new IllegalArgumentException(BASEBALL_WRONG_ANSWER);
        }
    }






}
