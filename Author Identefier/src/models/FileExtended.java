package models;

import java.io.File;

import textcorrector.TextReader;

public class FileExtended {
	public TextReader reader;
	public String author;
	public String text;
	public int[] count = new int[33];
	
	public FileExtended(File file)
	{
		try
		{
			reader = new TextReader(file);
			author = file.getName();
			text = reader.toString();
			for (int i = 0; i < text.length(); i++)
			{
				count[text.charAt(i)-1072]++;
			}
		}
		catch (Exception e)
		{
			System.out.println("õç ÷¸ ýòî");
		}
	}
}
