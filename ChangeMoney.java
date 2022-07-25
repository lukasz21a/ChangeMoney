import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class ChangeMoney {
    private static int change(int money) {
    	int[] coins = {1, 2, 5, 10, 20, 50};
    	int local_min = 0;
    	Map<Integer, Integer> all_mins = new HashMap<Integer, Integer>();
    	
    	for(int i = 0; i <= money; i++) {
    		Map<Integer, Integer> prev_min = new HashMap<Integer, Integer>();
    		
    		for(int coin: coins) {
    			
    			if(i >= coin) {
    				prev_min.put(Integer.valueOf(i - coin), all_mins.get(i - coin));
    				//System.out.println("i: " + i);
    				//System.out.println("coin: " + coin);
    				int min = Collections.min(prev_min.values());
    				local_min = min + 1;
    			}
    		}
    		// saves the minimums in the form: 0=0, 1=1, 2=1, 3=2 ...
    		// meaning that for value 3 the minimum number of coins is 2
    		
    		//even if the above if is not executed, the i is put into all_mins
    		//local_min is incremented only if(i>=coin) above
    		all_mins.put(Integer.valueOf(i), Integer.valueOf(local_min));
    		//System.out.println(all_mins);
    	}
        return local_min;
    }

    public static void main(String[] args) {
    	
    	int amount = 2;
    	System.out.println(change(amount));
    	
    }
}