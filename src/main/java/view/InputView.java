package view;

import camp.nextstep.edu.missionutils.Console;

//입력하는 기능
public class InputView {
    private static final String INPUT_USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_RETRY_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputUserNumber(){
        System.out.println(INPUT_USER_NUMBER_MESSAGE);
        return Console.readLine(); // 우테코 요구사항
    }

    public String askRetryGame(){
        System.out.println(ASK_RETRY_GAME_MESSAGE);
        return Console.readLine();
    }


}
