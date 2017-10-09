package models;

public class Matrix1 {
	public int[][][] stat;
	public int countBigramms;
	public int[] statLetters;
	public int countLetters;
	
	public Matrix1() 
	{
		stat = new int[32][32][32];
		statLetters = new int[32];
	}
}
