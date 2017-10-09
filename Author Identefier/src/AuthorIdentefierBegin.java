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
import models.Matrix1;


public class AuthorIdentefierBegin {
	
	static List<FileExtended> textInfo = new ArrayList<FileExtended>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));		
		List<String> resultsAuthor2;
		List<String> resultsAuthor3;
		
		System.out.println("Put your file into the folder C:\\text1\\ (file name shoud be \"anon\")");
		
		
		////TODO: �������� ���������� ���������� ����� ������ �� ����� ��� ������ ������ ���
		File fileAnon = new File("C:\\text1\\anon");                       //
		FileExtended anonFileExtended = new FileExtended(fileAnon);        //  ���������� ���������� ������
		//Matrix anonText = new Matrix();          						   //  � ����������� ��� �������
		Matrix1 anonText3 = new Matrix1();
		Matrix anonText2 = new Matrix();
		BigrammCounter.count1(anonFileExtended.text,anonText3);              //
		BigrammCounter.count(anonFileExtended.text,anonText2);
		
		
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
		
		//System.out.println("Choose method: (khmeleva(mod)/xi2/divKulbaka(mod))");
		System.out.println("Press enter to continue");
		
		//TODO �������� ���� , ��� ������������ ���� �� ������� (���� ����) 
		
		String method = reader.readLine();
		while (!method.equals("esc"))
		{	
			resultsAuthor2 = new ArrayList<String>();
			resultsAuthor3 = new ArrayList<String>();
		for (int j = 0; j < 20; j++)
		{
			double distance1 = Integer.MAX_VALUE;
			double distance0 = Integer.MAX_VALUE;
			String authorName2 = "";
			String authorName3 = "";

			for (FileExtended fAuthor:textInfo)
			{
				Matrix1 littleBit = new Matrix1();
				Matrix litBit = new Matrix();
				int beg = (int)(Math.random()*fAuthor.text.length()-analyseSize);
				if (beg<0)
					beg = 0;
				String textBit = fAuthor.text
						.substring(beg,beg + analyseSize);
				BigrammCounter.count1(textBit, littleBit);
				BigrammCounter.count(textBit, litBit);
				double distance2 = Integer.MAX_VALUE;
				double distance3 = Integer.MAX_VALUE;
				distance3 = DistanceMethodManager.xi2tri(anonText3, littleBit);
				distance2 = DistanceMethodManager.xtwoMera(anonText2, litBit);
			/*	switch (method)
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
				}  */
				if (distance3 < distance1)
				{
					distance1 = distance3;
					authorName3 = fAuthor.author;
				}
				if (distance2 < distance0)
				{
					distance0 = distance2;
					authorName2 = fAuthor.author;
				}
			}
			resultsAuthor2.add(authorName2 + " " + distance0);
			resultsAuthor3.add(authorName3 + " " + distance1);
		}
		System.out.println("��� �������");
		//TODO ������� ����� ���������� (������)
		for (String res : resultsAuthor3) {
			System.out.println(res);
		}
		
		System.out.println("\n\n\n��� ������");
		for (String res : resultsAuthor2) {
			System.out.println(res);
		}
			method = reader.readLine();
		}
	}
}
