package edu.grinnell.csc207.turneral1.utils;

public class StringUtils {
    public static int[] fewestCoins(int value){
	// Builds an array to track the current coin combinations.
	// Uses recursive search to try all coin combinations at each juncture.
	// Returns the coins' values in an array.
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
	    }
	
	return valueArr;
    } // fewestCoins
    
    // value - remaining sum to be paid. 
    // counts - counts of how many times each coin is used.
    // values - values of each coin.
    // length = values.length = counts.length (how many coin denominations)
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
