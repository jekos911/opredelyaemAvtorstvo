package textcorrector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;

public class TextReader  {
	
	private FileReader reader;
	private String text;
	private String fileName;
	private File file;
	
	public TextReader(File file) throws FileNotFoundException 
	{
		this.file = file;
		this.fileName = file.getName();
		reader = new FileReader(file);
		
		try
		{
		BufferedReader br = new BufferedReader(reader);
		StringBuilder buffer = new StringBuilder();
		String s;
		while ( (s = br.readLine()) != null) 
		buffer.append(s);
		br.close();
		text = TextCorrector.correct1(buffer.toString());
		
		} catch (IOException e)
		{
			System.out.println("error");
		}
	}

	
	public TextReader(String fileName) {
		
		this.fileName = fileName;
		try {
			file = new File(fileName);
			reader = new FileReader(file);
		} catch (FileNotFoundException e){
			reader = null;
			text = null;
			System.out.println("error");
			return;
		}
		
		try
		{
		BufferedReader br = new BufferedReader(reader);
		StringBuilder buffer = new StringBuilder();
		String s;
		while ( (s = br.readLine()) != null) 
		buffer.append(s);
		br.close();
		text = buffer.toString();
		
		} catch (IOException e)
		{
			System.out.println("error");
		}
		
	}
	
	public String toString()
	{
		return text;
	}
	
	public String getFilename()
	{
		return fileName;
	}

}
