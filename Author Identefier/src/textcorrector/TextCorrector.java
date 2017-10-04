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
}
