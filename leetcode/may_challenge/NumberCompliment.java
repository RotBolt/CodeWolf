package leetcode.may_challenge;

public class NumberCompliment {
    public static void main(String[] args) {
        System.out.println(findCompliment(8));
    }

    public static int findCompliment(int num){
        int power = 0;
        int np = 1<<0;
        while(np<=num){
            power++;
            np = 1<<power;
        }
        power--;
        while(power>=0){
            int mask = 1<<power;
            num = num^mask;
            power--;
        }
        return num;
    }

    public static int findCompliment32Bit(int num){
        boolean startIndexFound = false;
		for(int i = 31; i >= 0; i --){
            int mask = 1 << i;
			if((num & mask) == 0 && !startIndexFound){
				continue;
			}else{
				num = num ^ mask;
				startIndexFound = true;
			}

		}

		return num;
    }
}