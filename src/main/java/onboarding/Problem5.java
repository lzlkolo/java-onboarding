package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static void isCheck(int money) {
        if(money < 1 || money > 1000000) {
            System.out.println("입력이 잘못되었습니다.");
        }
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(9);
        isCheck(money);

        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i=0; i<unit.length; i++) {
            if(money/unit[i] >=1) {
                answer.add(i, money/unit[i]);
            } else {
                answer.add(i, 0);
            }
            money = money % unit[i];
        }
        return answer;
    }
}