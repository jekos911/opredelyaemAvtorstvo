package models;

public class BigrammCounter {
	public static void count(String string, Matrix matrix)
	{
		for (int i = 0; i < string.length() - 1; i++)
		{
			matrix.stat[(int)string.charAt(i) - 1072][(int)string.charAt(i+1) - 1072]++;
			matrix.statLetters[(int) string.charAt(i) - 1072]++;
		}
		matrix.statLetters[ (int) string.charAt(string.length()-1) - 1072]++;
		matrix.countBigramms = string.length() - 1;
		matrix.countLetters = string.length();
	}
}
