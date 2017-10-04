import java.io.BufferedReader;
import java.io.InputStreamReader;

import languageidenteficator.Grammar;
import languageidenteficator.Identeficator;

public class LanduageDefiner {

	public static void main(String[] args) throws Exception {
		
		System.out.println("��������� ������ - S, ������������ - ��������� �����, �������������� - �� ���������");
		System.out.println("������� ������� ���� \"�������->�������\"\n�� ���������� ����� �������� \"esc\" � ����������");
		BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));
		String tmp = reader.readLine();
		
		Grammar grammar = new Grammar();
		while (!tmp.equals("esc"))
		{
			grammar.addRule(tmp);
			tmp = reader.readLine();
		}
		System.out.print("��������� ������� ���������� ���������� ���� ");
		System.out.println(Identeficator.getGrammarType(grammar));
		System.out.println("����������:\n��� ���������� -1 ��������������� � �������������� ��������� ������");
		System.out.println("��� 4 - R-����������, ����������� ������; ��� 3 - R-����������, ����������� �����");
	}

}
