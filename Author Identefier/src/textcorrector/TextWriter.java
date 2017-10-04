package textcorrector;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter {
	private FileWriter reader;
	private String fileName;
	private File file;
	private String fileText;
	

	public TextWriter(TextReader textFile) {
		fileName = textFile.getFilename();
		fileText = TextCorrector.correct(textFile.toString());
				
		try {
			file = new File(fileName + "mod");
			reader = new FileWriter(file);
		} catch (IOException e){
			reader = null;
			System.out.println("error");
			return;
		}
		
		try (BufferedWriter bw = new BufferedWriter(reader))
		{	
			bw.write(fileText);
		}
		catch (IOException e)
		{
			System.out.println("error");
		}
	}
	
	public String getText()
	{
		return fileText;
	}
}
