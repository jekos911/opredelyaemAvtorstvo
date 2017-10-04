import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import models.BigrammCounter;
import models.DistanceMethodManager;
import models.FileExtended;
import models.Matrix;


public class AuthorIdentefierBegin {
	
	static List<FileExtended> textInfo;
	public static final int MIN = 1;
	public static final int STRING_SIZE_MIN = 200000;


	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));		
		List<String> resultsAuthor = new ArrayList<>();
		
		System.out.println("Put your file into the folder C:\\text1\\ (file name shoud be \"anon\")");
		
		
		////TODO: �������� ���������� ���������� ����� ������ �� ����� ��� ������ ������ ���
		File fileAnon = new File("C:\\text1\\anon");                       //
		FileExtended anonFileExtended = new FileExtended(fileAnon);        //  ���������� ���������� ������
		Matrix anonText = new Matrix();                                    //  � ����������� ��� �������
		BigrammCounter.count(anonFileExtended.text,anonText);              //
		
		
		File file = new File("C:\\text");               //����� � �������� �������
		File[] folderEntries = file.listFiles();        //�����, ����������� � �����
		for (File file2 : folderEntries) {              //
			textInfo.add(new FileExtended(file2));      //�������� ���� � ������ ����� 
		}
		
		System.out.println("Enter analyse block size:");     //
		String analyseSizeString;							 //  ���� ������� �������������� �����
		analyseSizeString = reader.readLine();				 //  (� ��������)
		int analyseSize;									 //
		analyseSize = Integer.valueOf(analyseSizeString);    //
		
		System.out.println("Choose method: (khmeleva(mod)/xi2/divKulbaka(mod))");
		
		
		//TODO �������� ���� , ��� ������������ ���� �� ������� (���� ����) 
		
		String method = reader.readLine();
		while (!method.equals("esc"))
		{	
			resultsAuthor = new ArrayList<String>();
		for (int j = 0; j < 20; j++)
		{
			
			double distance1 = Integer.MAX_VALUE;
			String authorName = "";
			for (FileExtended fAuthor:textInfo)
			{
				Matrix littleBit = new Matrix();
				int beg = (int)(Math.random()*fAuthor.text.length()-analyseSize);
				if (beg<0)
					beg = 0;
				String textBit = fAuthor.text
						.substring(beg,beg + analyseSize);
				BigrammCounter.count(textBit, littleBit);
				double distance = Integer.MAX_VALUE;
				switch (method)
				{
					case "khmeleva":
						distance = DistanceMethodManager.methodKhmeleva(anonText, littleBit);
						break;
					case "khmelevamod":
						distance = DistanceMethodManager.methodKhmelevaMod(anonText, littleBit);
						break;
					case "xi2":
						distance = DistanceMethodManager.xtwoMera(anonText, littleBit);
						break;
					case "divKulbaka":
						distance = DistanceMethodManager.methodDivergenciyaKulbaka(anonText, littleBit);
						break;
					case "divKulbakamod":
						distance = DistanceMethodManager.methodDivergenciyaKulbakaMod(anonText, littleBit);
						break;
				}
				if (distance < distance1)
				{
					distance1 = distance;
					authorName = fAuthor.author;
				}
			}
			resultsAuthor.add(authorName + " " + distance1);
		}
		
		//TODO ������� ����� ���������� (������)
		for (String res : resultsAuthor) {
			System.out.println(res);
		}
		method = reader.readLine();
	}
	}
}
