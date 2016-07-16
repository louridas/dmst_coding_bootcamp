import java.util.Scanner;
import java.util.ArrayList;

public class Exercise1
{
	public static void main(String[] args) {

			int indexOp;
			int sum_arabic,sum1=0,sum2=0;
			char first_char,first_char2;
			String first_string,second_string;

			System.out.println("please type the numerical expression or enter to exit: ");
			System.out.println("(the greek alphabet is in greeklish) ");
		    Scanner sc = new Scanner(System.in);
	        String ar_expression = sc.nextLine();


	        while(ar_expression.length()!=0)
	        {
				first_char=ar_expression.charAt(0);
	            indexOp=index_of_operator(ar_expression);
	            first_string=ar_expression.substring(0, indexOp);


				if(Character.isDigit(first_char))
				{
					sum1=Integer.parseInt(first_string);
				}
				else if(first_char=='I'||first_char=='V'||first_char=='X'||first_char=='L'||first_char=='C'||first_char=='D'||first_char=='M')
				{
					sum1=latin_to_arabic(first_string);

				}
				else
				{

					sum1=greek_to_arabic(first_string);

				}

	            first_char2=ar_expression.charAt(indexOp+1);
	            second_string=ar_expression.substring(indexOp+1);

				if(Character.isDigit(first_char2))
				{
					sum2=Integer.parseInt(second_string);
				}
				else if(first_char2=='I'||first_char2=='V'||first_char2=='X'||first_char2=='L'||first_char2=='C'||first_char2=='D'||first_char2=='M')
				{
					sum2=latin_to_arabic(second_string);
				}
				else
				{
					sum2=greek_to_arabic(second_string);
				}

				switch(ar_expression.charAt(indexOp))
				{
					case '+': sum_arabic=sum1+sum2;break;
					case '-': sum_arabic=sum1-sum2;break;
					case '*': sum_arabic=sum1*sum2;break;
					default: sum_arabic=sum1/sum2;
				}
				System.out.print("the result in the arabic numeral is : ");
				System.out.println(sum_arabic);

				System.out.print("the result in the Roman numerals is : ");
				System.out.print(arabic_to_latin(sum_arabic));
				System.out.println();

				System.out.print("the result in the greek numerals is : ");
				System.out.print(arabic_to_greek(sum_arabic));
				System.out.println("'");

				System.out.println("please type the numerical expression ");
				ar_expression = sc.nextLine();

	        }
	        System.out.println("bye");

		}

	public static int index_of_operator(String ar_expression)
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

	public static int latin_to_arabic(String expression)
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
	public static int greek_to_arabic(String expression)
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


	public static String arabic_to_latin(double sum) //it converts the arabic numeral to roman
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
	public static String arabic_to_greek(double sum) //it converts the arabic numeral to greek
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
