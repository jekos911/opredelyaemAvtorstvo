package languageidenteficator;

import java.util.ArrayList;
import java.util.List;

public class Grammar {
	private List<String> ruleArray;
	
	public Grammar()
	{
		ruleArray = new ArrayList<String>();
	}
	
	public void addRule(String string)
	{
		ruleArray.add(string);
	}
	
	public List<String> getRuleArray()
	{
		return ruleArray;
	}
}
