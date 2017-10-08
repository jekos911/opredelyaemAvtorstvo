package textcorrector;

public class TextCorrector {
	
	public static String correct(String uncorrect)
	{
		return uncorrect
				.toLowerCase()
				.replaceAll("[^à-ÿ]", "");
				//.replaceAll("[0-9]|[_]| ", "")
				//.toLowerCase()
				//.replaceAll("a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|Q|X|Y|Z|¸|¨", "");
	}
	
	
	public static String correct1(String uncorrect)
	{
		StringBuilder builder = new StringBuilder();
		String[] words = uncorrect.split(" ");
		for (String string : words) {
			string.replaceAll("[^à-ÿ]|[^À-ß]", " ");
			if (!string.isEmpty())
			{
				char[] kek = string.toCharArray();
				boolean isup = false;
				for (char c : kek) {
					if (Character.isUpperCase(c))
					{
						isup = true;
					}
				}
				if (!isup)
				builder.append(string);
			}
		}
		String string = builder.toString();
		
		return TextCorrector.correct(string);
	}
}
