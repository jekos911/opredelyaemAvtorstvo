package models;

public class DistanceMethodManager {
	public static double methodKhmeleva(Matrix first, Matrix second)
	{
		double resultat = 0.0d;
		for (int i = 0; i < 32; i++)
			for (int j = 0; j < 32; j++)
			{
				//first - anonymous text
				double m1ij = first.stat[i][j];
				double m2ji= second.stat[j][i];
				double n1j = first.statLetters[j];
				double n2i = second.statLetters[j];
				if (n1j!=0 && m2ji!=0 && n2i!=0)
				{
					resultat-= m1ij*Math.log((m1ij/n1j)/(m2ji/n2i));
				}
			}
		return resultat;
	}
	
	public static double methodKhmelevaMod(Matrix first, Matrix second)
	{
		double resultat = 0.0d;
		for (int i = 0; i < 32; i++)
			for (int j = 0; j < 32; j++)
			{
				//first - anonymous text
				double m1ij = first.stat[i][j];
				double m2ji= second.stat[j][i];
				//double countletters1 = first.countLetters;
				//double countletters2 = second.countLetters;
				double n1j = first.statLetters[j];
				double n2i = second.statLetters[j];
				if (n1j!=0 && m2ji!=0 && n2i!=0)
				{
					resultat+= Math.abs(m1ij*Math.log((m1ij/n1j)/(m2ji/n2i)));
				}
			}
		return resultat;
	}
	
	public static double xtwoMera(Matrix first, Matrix second)
	{
		double resultat = 0.0d;
		double n2 = first.countLetters;
		double n1 = second.countLetters;
		for (int i = 0; i < 32; i++)
			for (int j = 0; j < 32; j++)
			{
				double m1ij = first.stat[i][j];
				double m2ij= second.stat[i][j];
				
				if ((m1ij+m2ij)!=0)
				resultat+= 1/(m1ij+m2ij)*(m1ij/n1-m2ij/n2)*(m1ij/n1-m2ij/n2);
			}
		return resultat*n1*n2;
	}
	
	public static double methodDivergenciyaKulbaka(Matrix first, Matrix second)
	{
		double resultat = 0.0d;
		double n1 = first.countLetters;
		double n2 = second.countLetters;
		for (int i = 0; i < 32; i++)
			for (int j = 0; j < 32; j++)
			{
				double m1ij = first.stat[i][j];
				double m2ij= second.stat[i][j];
				
			
				if (m2ij!=0)
				resultat+= m1ij/n1*Math.log((m1ij/n1)/(m2ij/n2));
			}
		return resultat;
	}
	
	public static double methodDivergenciyaKulbakaMod(Matrix first, Matrix second)
	{
		double resultat = 0.0d;
		double n1 = first.countLetters;
		double n2 = second.countLetters;
		for (int i = 0; i < 32; i++)
			for (int j = 0; j < 32; j++)
			{
				double m1ij = first.stat[i][j];
				double m2ij= second.stat[i][j];
				
			
				if (m2ij!=0)
				resultat+= Math.abs(m1ij/n1*Math.log((m1ij/n1)/(m2ij/n2)));
			}
		return resultat;
	}
}
