import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IKnowWhatYouSay {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));		
		while (true)
		{
			System.out.println("Enter your message");
			String kek = "";
			kek = reader.readLine();
			if (kek.contains(" "))
				System.out.println("DA");
			else
				System.out.println("NET");
		}
	}
}
