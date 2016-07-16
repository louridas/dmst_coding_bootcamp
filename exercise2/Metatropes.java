package stathoula.exercise2;

public class Metatropes {
	public int index_of_operator(String ar_expression)
	{
		int operator=0;
		for(int i=0;i<ar_expression.length();i++)
		{
			if(ar_expression.charAt(i)=='+' || ar_expression.charAt(i)=='-' || ar_expression.charAt(i)=='*' || ar_expression.charAt(i)=='/')
			   {
				   operator=i;
			       break;
			   }
		}
		return operator;
    }
    
	public int latin_to_arabic(String expression) 
	{
		int sum=0;
		for(int i=0;i<expression.length();i++)
		{
			switch(expression.charAt(i))
			{
				case 'I':
				  sum = sum + 1;
				  break;
				case 'V':
				  sum = sum + 5;
				  break;
				case 'X':
				  sum = sum + 10;
				  break;
				case 'L':
				  sum = sum + 50;
				  break;
				case 'D':
				  sum = sum + 100;
				  break;
				case 'C':
				  sum = sum + 500;
				  break;
				default:
				  sum = sum + 1000;
			}
		
		}
		
		return sum;
		
	}
	public int greek_to_arabic(String expression) 
	{
		/*char[] el1={'-','Α','B','Γ','Δ','Ε','ς','Ζ','Η','Θ'};
		char[] el2={'-','Ι','Κ','Λ','Μ','Ν','Ξ','Ο','Π','Q'}; 
		char[] el3={'-','Ρ','Σ','Τ','Υ','Φ','Χ','Ψ','Ω','W'}; 

		επειδη δεν τρεχει με τους ελληνικους χαρακτηρες, τους αντιστοιχω στους ξενους*/
		char[][] el = {{'-','a','b','g','d','e','c','z','h','v'}, // TO 'c' θα αντιστοιχει στο ΣΤ, to 'v' αντιστοιχει στο 'θ'
	                   {'-','i','k','l','m','n','j','o','p','Q'}, //το Q ειναι το αντίστοιχο σύμβολο του 90, το j αντιστοιχει στο ελληνικο Ξ
		               {'-','r','s','t','u','f','x','y','w','W'}}; //το  W ειναι το αντίστοιχο σύμβολο του 900
     
		double sum=0;
		for(int z=0;z<expression.length();z++)
		{
			for(int i=0;i<3;i++)
			{
				for(int y=1;y<el[i].length;y++)
				{
					if(expression.charAt(z)==el[i][y])
					{
						sum = sum + y*Math.pow(10, i);
						break;
					}
				}
				
				
			}	
		}
		
        return (int)sum;

	}


	public String arabic_to_latin(double sum) //it converts the arabic numeral to roman
	{
		double x1,x2,x3;
		StringBuilder st = new StringBuilder();

		x1=(int)sum%10;
		x2=(int)(sum/10)%10;
		x3=(int)sum/100;

		if(sum==1000)
		  st.append("M");
		else
		{
			if((int)x3/5==1)
			{
				st.append("C");
		       for(int i=1;i<=x3%5;i++)
		    	   st.append("D");
			}
		    else
		    {   for(int i=1;i<=x3;i++)
		    	st.append("D");
		    }

		    if((int)x2/5==1)
			{
		    	st.append("L");
			   for(int i=1;i<=x2%5;i++)
				   st.append("X");
			}
			else
			{   for(int i=1;i<=x2;i++)
				 st.append("X");
		    }

		    if((int)x1/5==1)
			{
		    	st.append("V");
			   for(int i=1;i<=x1%5;i++)
				   st.append("I");
			}
			else
			{   for(int i=1;i<=x1;i++)
				st.append("I");
		    }

		}
		String st2 = new String(st);
		return st2;
    }
    public String arabic_to_greek(double sum) //it converts the arabic numeral to greek
    {
		int[] x = new int[3];
		char[] result = new char[4];
        int k=0;
        
		x[0]=(int)sum%10;
		x[1]=(int)(sum/10)%10;
		x[2]=(int)sum/100;

		char[][] el = {{'-','a','b','g','d','e','c','z','h','v'}, 
                       {'-','i','k','l','m','n','j','o','p','Q'}, 
	                   {'-','r','s','t','u','f','x','y','w','W'}};

		if(sum==1000)
		   System.out.print(",A");
		
		for(int i=2;i>=0;i--)
		{
			for(int y=1;y<el[i].length;y++)
			{
				if(x[i]==y)
				{
					result[k]=el[i][y];
					k=k+1;
				}
			}
		}
		
		String resultstr=(new String(result)).trim();
		return resultstr;
    }

}
