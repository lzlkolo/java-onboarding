package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int pageNumCheck(List<Integer> list) {
        if(list.get(1)!=list.get(0)+1) {
            return -1;
        }
        if(list.get(0)%2==0 || list.get(1)%2==1) {
            return -1;
        }
        if(list.get(0)<=1 || list.get(1)>=400) {
            return -1;
        }
        return 0;
    }

    public static int getMax(int num) {
        int max = Integer.MIN_VALUE;
        int add = 0;
        int mul = 1;
        int[] arrNum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<arrNum.length; i++) {
            add += arrNum[i];
            mul *= arrNum[i];
            max = Math.max(add, mul);
        }
        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pageNumCheck(pobi)==-1 || pageNumCheck(crong)==-1) return -1;

        int pobiScore = Math.max(getMax(pobi.get(0)), getMax(pobi.get(1)));
        int crongScore = Math.max(getMax(crong.get(0)), getMax(crong.get(1)));

        if(pobiScore > crongScore) {
            answer = 1;
        }
        if(pobiScore < crongScore) {
            answer = 2;
        }
        if(pobiScore == crongScore) {
            answer = 0;
        }
        return answer;
    }
}