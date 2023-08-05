package controller;

import view.InputView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//사용자가 입력한 정수가  문자가 아닌 3자리 정수이고  중복이 없는지 검증
// 추가적으로 구현해줘도 좋을 듯,,
// 숫자가 3자리가 아닌경우 , 1~9사이의 숫자가 아니경우, 서로다른 문자가 아닌경우
public class UserNumberValidator {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final String WRONG_LENGTH_MESSAGE = "3자리 숫자를 입력해주세요.";
    private  static final String WRONG_RANGE_NUMBER_MESSAGE = "1~9사이의 숫자만 입력해주세요.";
    private static final String DUPLICATE_NUMBER_MESSAGE = "서로 다른 3자리 숫자를 입력해주세요.";

    InputView inputView = new InputView();

    public List<Integer> userNumberIsValid(){
        String userNumber = inputView.inputUserNumber();

        if (!threeDigitInteger(userNumber)){
            throw new IllegalArgumentException(WRONG_LENGTH_MESSAGE);
        } else if(!isNumeric(userNumber)){
            throw new IllegalArgumentException(WRONG_RANGE_NUMBER_MESSAGE);
        } else if (!notDuplicate(userNumber)){
            throw  new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
        return convertStringToListInteger(userNumber);
    }

        public boolean threeDigitInteger(String userNumber){
            return (userNumber.length() == BASEBALL_GAME_NUMBER_LENGTH); //이렇게 쓰는 방법은 코드길이 줄인당

        }
        public boolean isNumeric(String userNumber){
            for(int i=0; i<userNumber.length();i++){
                if(!Between1And9(userNumber.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        public boolean Between1And9(char checkNumber){
            return checkNumber >= '1' && checkNumber <= '9';
        }

        public boolean notDuplicate(String userNumber){
        Set<Character> duplicateDistinction = new HashSet<>(); //중복없고 순서유지없는 해쉬셋 사용하기
            for(int i=0;i<userNumber.length();i++){
                char currentUserNumber = userNumber.charAt(i);
                if(duplicateDistinction.contains(currentUserNumber)){
                   return false;
                }
                duplicateDistinction.add(currentUserNumber);

            }
            return true;
        }

        public List<Integer> convertStringToListInteger(String userNumber){
        return userNumber.chars().map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());

        }


}
/*
* public boolean notDuplicate(String inputNumber) {
        String[] numbers = inputNumber.split("");
        Set<String> setNumbers = Arrays.stream(numbers).collect(Collectors.toSet());

        return setNumbers.size() == BASEBALL_GAME_NUMBER_LENGTH;
    } */
