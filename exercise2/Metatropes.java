package exercise2;
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
		/*char[] el1={'-','�','B','�','�','�','�','�','�','�'};
		char[] el2={'-','�','�','�','�','�','�','�','�','Q'}; 
		char[] el3={'-','�','�','�','�','�','�','�','�','W'}; 

		������ ��� ������ �� ���� ���������� ����������, ���� ���������� ����� ������*/
		char[][] el = {{'-','a','b','g','d','e','c','z','h','v'}, // TO 'c' �� ����������� ��� ��, to 'v' ����������� ��� '�'
	                   {'-','i','k','l','m','n','j','o','p','Q'}, //�� Q ����� �� ���������� ������� ��� 90, �� j ����������� ��� �������� �
		               {'-','r','s','t','u','f','x','y','w','W'}}; //��  W ����� �� ���������� ������� ��� 900
     
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


	public void arabic_to_latin(double sum) //it converts the arabic numeral to roman
	{
		double x1,x2,x3;

		x1=(int)sum%10;
		x2=(int)(sum/10)%10;
		x3=(int)sum/100;

		if(sum==1000)
		   System.out.print("M");
		else
		{
			if((int)x3/5==1)
			{
			   System.out.print("C");
		       for(int i=1;i<=x3%5;i++)
			     System.out.print("D");
			}
		    else
		    {   for(int i=1;i<=x3;i++)
		          System.out.print("D");
		    }

		    if((int)x2/5==1)
			{
			   System.out.print("L");
			   for(int i=1;i<=x2%5;i++)
				 System.out.print("X");
			}
			else
			{   for(int i=1;i<=x2;i++)
				  System.out.print("X");
		    }

		    if((int)x1/5==1)
			{
			   System.out.print("V");
			   for(int i=1;i<=x1%5;i++)
				 System.out.print("I");
			}
			else
			{   for(int i=1;i<=x1;i++)
				  System.out.print("I");
		    }

		}
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
		   System.out.println(",A");
		
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
		
		String resultstr=new String(result);
		return resultstr;
    }
    
}
