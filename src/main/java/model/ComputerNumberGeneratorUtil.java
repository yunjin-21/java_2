package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

//게임의 핵심로직 중 하나인 랜덤한 숫자 생성
//우테코에서 주어진 코드 사용해서 컴퓨터의 3자리수 생성하기
public class ComputerNumberGeneratorUtil {

    public static List<Integer> getnerateComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}







/*Set<Integer> computer = new HashSet<>();
		Random random = new Random();

		while(computer.size() < 3 ) {
			int number =  random.nextInt(9)+1; //1~9까지 랜덤 생성
			computer.add(number);
		}

		randomNumber = 0;
		for(int digit : computer) {
			randomNumber = randomNumber * 10 + digit;
		}

 */