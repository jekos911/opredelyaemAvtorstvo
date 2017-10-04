import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Replace {

	public static final char[] kek = new char[] {'à','á','â','ã','ä','å','æ','ç','è','é','ê','ë','ì','í','î','ï','ð','ñ','ò','ó','ô','õ','ö','÷','ø','ù','ú','û','ü','ý','þ','ÿ'};
	public static final char[] ker = new char[] {'á','é','ê','ë','è','å','í','î','ï','â','ã','ç','ð','ñ','ä','ò','ó','ô','õ','ö','å','÷','ø','à','æ','ù','ú','û','ü','ý','þ','ÿ'};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));
		String tmp = reader.readLine();
		char[] tmp1 = tmp.toCharArray();
		for (int i = 0; i < tmp.length(); i++)
		{
			if(tmp1[i]=='¸')
			{
				tmp1[i]='ì';
				continue;
			}
			if (tmp1[i]!=' ')
			tmp1[i] = ker[(int)tmp1[i]- 1072];
		}
		System.out.println(tmp1);
	}

}
