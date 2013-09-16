package edu.grinnell.csc207.turneral1.utils;

public class StringUtils {
	/* 
	 * deLeet takes a string of "leet" text and produces the human-readable
	 * version.
	 */
	public static String deLeet(String leet){
		String normal = leet.replace("1","l");
		normal = normal.replace("3","e");
		normal = normal.replace("+","t");
		normal = normal.replace("0","o");
		normal = normal.replace("|3","b");
		normal = normal.replace("@","a");
		return normal.replace("|\\|","n");
	} // deLeet

    /*
     * nameGame takes a string as input, and returns Ms. Ellis's verse using
     * the name.
     */
	public static String nameGame(String input){
		// find the first vowel occurence's index.
		for (int i = 0; i < input.length() && (input(i) != 'a' &&
			       input(i) != 'e' && input(i) != 'o' && input(i) != 'u'; i++);
		String subName = input.substring(i);
		System.out.println(input + '!');
		System.out.print(input + ', ' + input + " bo ");
		System.out.print('B' + subName + " Bonana fanna fo F");
		System.out.println(subName);
		System.out.print("Fee fy mo M" + subName + ',');
		System.out.println(input.substring + '!');
	} // nameGame

	/*
	 * fewestCoins recursively searches to find the fewest number of coins that
	 * produces value, and returns the coins' values in an array.
	 */
    public static int[] fewestCoins(int value){
	int values[] = {2,7,11,54};
	int coinArr[] = fewestCoinsSearch(value, new int[] {0,0,0,0,Integer.MAX_VALUE}, values, 4);
	int coinTotal = coinArr[0]+coinArr[1]+coinArr[2]+coinArr[3];
	int valueArr[] = new int[coinTotal];
	
	// builds the array of coins used (by denomination)
	for(int i = 0, coins = 0; coins<coinTotal; i++)
	    while(coinArr[i] > 0){
		valueArr[coins] = values[i];
	    	coinArr[i]--;
	    	coins++;
	    } // while
	
	return valueArr;
    } // fewestCoins
    
    /* 
     * fewestCoinsSearch is a helper procedure for recursive tree search.
     * Pre-conditions: 
     *   value is a positive integer.
     *   counts[0:length-1], values contain only non-zero positive integers.
     *   length denotes the number of coin types.
     * Post-conditions:
     *   When value == 0, returns counts. 
     *   counts[length] contains how many coins are used.
     */  
    public static int[] fewestCoinsSearch(int value, int[] counts, int[] values, int length){
	for(int i = length-1; i >= 0; i--){
		if(value-values[i] == 0){
		    // the coin is currently being considered
		    int currentCoins = 1;
		    for (int j = 0; j < length; j++)
			currentCoins += counts[j];

		    if(currentCoins < counts[length]){
			counts[length] = currentCoins;
			counts[i]++;
			return counts;
		    } // if
		} // if
		
		if(value-values[i] > 0){
		    int newCounts[] = counts;
		    newCounts[i]++;
		    return fewestCoinsSearch(value-values[i], newCounts, values, length);
		} // if
	} // for
	
	return counts;
    } // fewestCoinsSearch
} // StringUtils
