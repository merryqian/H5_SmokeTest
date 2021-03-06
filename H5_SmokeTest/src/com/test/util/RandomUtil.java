package com.test.util;

public class RandomUtil {
	
	/**
	 * 
	 * @param count
	 * @return
	 */
	public int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }
	
	private String string = "0123456789abcdefghijklmnopqrstuvwxyz";
	

	public String getRandomString(int length){
		StringBuffer sb = new StringBuffer();
		int len = string.length();
		for (int i = 0; i < length; i++) {
			sb.append(string.charAt(this.getRandom(len-1)));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		RandomUtil ru = new RandomUtil();
		for (int i = 0; i < 10; i++) {
			Log.logInfo(ru.getRandomString(6));
		}
		
	}	
}
