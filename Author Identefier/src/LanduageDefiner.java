import java.io.BufferedReader;
import java.io.InputStreamReader;

import languageidenteficator.Grammar;
import languageidenteficator.Identeficator;

public class LanduageDefiner {

	public static void main(String[] args) throws Exception {
		
		System.out.println("стартовый символ - S, терминальные - заглавные буквы, нетерминальные - всё остальное");
		System.out.println("введите правила вида \"цепочка->цепочка\"\nПо завершении ввода наберите \"esc\" с клавиатуры");
		BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));
		String tmp = reader.readLine();
		
		Grammar grammar = new Grammar();
		while (!tmp.equals("esc"))
		{
			grammar.addRule(tmp);
			tmp = reader.readLine();
		}
		System.out.print("Введенные правила определяют грамматику типа ");
		System.out.println(Identeficator.getGrammarType(grammar));
		System.out.println("Примечание:\nТип грамматики -1 свидетельствует о некорректности введенных данных");
		System.out.println("тип 4 - R-грамматика, выровненная вправо; тип 3 - R-грамматика, выровненная влево");
	}

}
