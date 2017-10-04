package languageidenteficator;

import java.util.List;

public class Identeficator {
	public static int getGrammarType(Grammar grammar)
	{
		int type = 100;
		List<String> ruleArray = grammar.getRuleArray();
		for (String string : ruleArray) {
			int tmp = getRuleType(string);
			if (tmp == -1)
				return tmp;
			if (tmp < type)
				type = tmp;
		}
		return type;
	}
	
	private static int getRuleType(String string)
	{
		if (string.contains("->"))
		{
			String s[] = string.split("->");
			if (s.length != 2)
				return -1;
			int size1,size2;
			size1 = s[0].length(); size2 = s[1].length();
			char[] first = s[0].toCharArray();
			char[] second = s[1].toCharArray();
			//3 категория
			if ((size1 == 1) && (size2 == 1 || size2 == 2 ))
				{	
				if (size2 == 2)
				if (Character.isUpperCase(first[0]))
					{
						if (  (Character.isUpperCase(second[0]) && Character.isLowerCase(second[1])) ||
								(Character.isUpperCase(second[1]) && Character.isLowerCase(second[0])))
								return 4;
					}
				}
			else
				if( Character.isLowerCase(second[0]) && Character.isUpperCase(first[0]))
					if ((size1 == 1) && (size2 == 1 || size2 == 2 ))
					return 3;
			//2 категория
			if (size1 == 1)
			{
				if (Character.isUpperCase(first[0]))
				{
					return 2;
				}
			}
			//1 категория
			if (size1 <= size2)
				return 1;
			return 0;			
		}
		else return -1;
	}
}
