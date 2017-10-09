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
				double m2ij= second.stat[i][j];
				double n1i = first.statLetters[i];
				double n2i = second.statLetters[i];
				if (n1i!=0 && m2ij!=0 && n2i!=0 && m1ij!=0)
				{
					resultat+= m1ij*Math.log((m1ij/n1i)/(m2ij/n2i));
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
				double m1ij = first.stat[i][j];
				double m2ij= second.stat[i][j];
				double n1i = first.statLetters[i];
				double n2i = second.statLetters[i];
				if (n1i!=0 && m2ij!=0 && n2i!=0 && m1ij != 0)
				{
					resultat+= Math.abs(m1ij*Math.log((m1ij/n1i)/(m2ij/n2i)));
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
				if (m2ij!=0 && m1ij !=0)
				resultat+= m1ij/n1*Math.log((m1ij/n1)/(m2ij/n2));
			}
		return 2*resultat;
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
				
			
				if (m2ij!=0 && m1ij != 0)
				resultat+= Math.abs(m1ij/n1*Math.log((m1ij/n1)/(m2ij/n2)));
			}
		return 2*resultat;
	}
	
	public static double xi2tri(Matrix1 first, Matrix1 second)
	{
		double resultat = 0.0d;
		
		double n1 = first.countLetters;
		double n2 = second.countLetters;
		for (int i = 0; i < 32; i++)
			for (int j = 0; j < 32; j++)
				for (int k=0; k<32; k++)
			{
				double m1ijk = first.stat[i][j][k];
				double m2ijk= second.stat[i][j][k];
				
			
				if (m2ijk !=0 && m1ijk != 0 && n1!= 0 && n2!=0)
				resultat+= Math.abs(m1ijk/n1*Math.log((m1ijk/n1)/(m2ijk/n2)));
			}
		return resultat;
	}
}
