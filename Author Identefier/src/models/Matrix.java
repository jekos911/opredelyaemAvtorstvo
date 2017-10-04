package models;

public class Matrix {
	public int[][] stat;
	public int countBigramms;
	public int[] statLetters;
	public int countLetters;
	
	public Matrix() 
	{
		stat = new int[32][32];
		statLetters = new int[32];
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 32; i++)
			for (int j = 0; j < 32; j++) {
				builder.append(String.valueOf((char)(i+1072)) + String.valueOf((char)(j+1072)));
				builder.append(stat[i][j] + " ");
				if (j == 31)
					builder.append("\n");
			}
		return builder.toString();
	}
}
