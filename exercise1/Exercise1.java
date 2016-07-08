import java.util.Scanner;
import java.util.ArrayList;

public class Exercise1
{
	public static void main(String args[])
	{
		int sumvolo; //metavliti pou deixnei se poia thesi vrisketai o telesths
		double sum_arabic,sum1=0,sum2=0;
		char first_char,first_char2;

		System.out.println("πληκτρολόγησε την αριθμιτική έκφραση\nσημείωση:η ελληνικη αριθμιτική ειναι στα greeklish");
	    Scanner sc = new Scanner(System.in);
        String ekfrasi = sc.nextLine();


        while(ekfrasi.length()!=0)
        {
			first_char=ekfrasi.charAt(0);
            sumvolo=thesi_sumvolou(ekfrasi);

			if(Character.isDigit(first_char))
			{
				sum1=0;
				for(int i=sumvolo-1;i>=0;i--)
				  sum1=sum1+(ekfrasi.charAt(i)-48)*Math.pow(10,(sumvolo-1-i));
			}
			else if(first_char=='I'||first_char=='V'||first_char=='X'||first_char=='L'||first_char=='C'||first_char=='D'||first_char=='M')
			{
				sum1=0;
				for(int i=0;i<sumvolo;i++)
				{
					sum1=sum1+metatropi_latin(ekfrasi.charAt(i));
					//sugkrish(latin,ekfrasi,i);
				}
			}
			else
			{
				sum1=0;
				for(int i=0;i<sumvolo;i++)
				{
					sum1=sum1+metatropi_elliniko(ekfrasi.charAt(i));
				}

			}

            first_char2=ekfrasi.charAt(sumvolo+1);
			if(Character.isDigit(first_char2))
			{
				sum2=0;
				for(int i=ekfrasi.length()-1;i>sumvolo;i--)
				  sum2=sum2+(ekfrasi.charAt(i)-48)*Math.pow(10,(ekfrasi.length()-1-i));
			}
			else if(first_char2=='I'||first_char2=='V'||first_char2=='X'||first_char2=='L'||first_char2=='C'||first_char2=='D'||first_char2=='M')
			{
				sum2=0;
				for(int i=sumvolo+1;i<ekfrasi.length();i++)
				{
					sum2=sum2+metatropi_latin(ekfrasi.charAt(i));
					//sugkrish(latin,ekfrasi,i);
				}
			}
			else
			{
				sum2=0;
				for(int i=sumvolo+1;i<ekfrasi.length();i++)
				{
					sum2=sum2+metatropi_elliniko(ekfrasi.charAt(i));
				}

			}

			switch(ekfrasi.charAt(sumvolo))
			{
				case '+': sum_arabic=sum1+sum2;break;
				case '-': sum_arabic=sum1-sum2;break;
				case '*': sum_arabic=sum1*sum2;break;
				default: sum_arabic=sum1/sum2;
			}
			System.out.print("arabic numerals: ");
			System.out.println(sum_arabic);
			System.out.print("Roman numerals: ");
			sum_latin(sum_arabic);
			System.out.println();
			System.out.print("greek numerals: ");
			sum_elliniko(sum_arabic);
			System.out.println();

			System.out.println("πληκτρολόγησε αριθμιτική έκφραση ");
            ekfrasi = sc.nextLine();

		}

	}


	public static int thesi_sumvolou(String ekfrasi)
	{
		int sumvolo=0;
		for(int i=0;i<ekfrasi.length();i++)
		{
			if(ekfrasi.charAt(i)=='+' || ekfrasi.charAt(i)=='-' || ekfrasi.charAt(i)=='*' || ekfrasi.charAt(i)=='/')
			   {
				   sumvolo=i;
			       break;
			   }
		}
		return sumvolo;
    }
    /*public static int sugkrish(String ekfrasi,int i)
    {
		char[] latin = {'I','V','X','L','C','D','M'};
		int m=0;
		for(int y=0;y<latin.length;y++)
	    {
			if(ekfrasi.charAt(i)== latin[y])
			   m=y;
		}
		return m;
	}*/
	public static int metatropi_latin(char ch) //metatrepei ton latiniko ari8mo se arabic
	{
		switch(ch)
		{
			case 'I':
			  return 1;
			case 'V':
			  return 5;
			case 'X':
			  return 10;
			case 'L':
			  return 50;
			case 'C':
			  return 100;
			case 'D':
			  return 500;
			default:
			  return 1000;
		}
	}
	public static int metatropi_elliniko(char st) //metatrepei ton elliniko ari8mo se arabic
	{
		/*char[] el1={'-','Α','B','Γ','Δ','Ε','ς','Ζ','Η','Θ'};
		char[] el2={'-','Ι','Κ','Λ','Μ','Ν','Ξ','Ο','Π','Q'};
		char[] el3={'-','Ρ','Σ','Τ','Υ','Φ','Χ','Ψ','Ω','W'};
		επειδη δεν τρεχει με τους ελληνικους χαρακτηρες, τους αντιστοιχω στους ξενους*/

		char[] el1={'-','a','b','g','d','e','c','z','h','v'}; // TO 'c' θα αντιστοιχει στο ΣΤ, to 'v' αντιστοιχει στο 'θ'
	    char[] el2={'-','i','k','l','m','n','j','o','p','Q'}; //το Q ειναι το αντίστοιχο σύμβολο του 90, το j αντιστοιχει στο ελληνικο Ξ
		char[] el3={'-','r','s','t','u','f','x','y','w','W'}; //το  W ειναι το αντίστοιχο σύμβολο του 900

		int x = 0 ;
		for(int i=1;i<el1.length;i++)
		{
			if(st==el1[i])
			{
				x=i;
				break;
			}
		}
		for(int i=1;i<el2.length;i++)
		{
			if(st==el2[i])
			{
			   x=i*10;
			   break;
		   }
		}
		for(int i=1;i<el3.length;i++)
		{
			if(st==el3[i])
			{
			   x=i*100;
			   break;
		   }
		}

        return x;

	}


	public static void sum_latin(double sum) //metatrepei ton arabic se latiniko
	{
		double x1,x2,x3,x4;

		x1=(int)sum%10;
		x2=(int)(sum/10)%10;
		x3=(int)sum/100;

		if(sum==1000)
		   System.out.print("M");

		if((int)x3/5==1)
		{
		   System.out.print("D");
	       for(int i=1;i<=x3%5;i++)
		     System.out.print("C");
		}
	    else
	    {   for(int i=1;i<=x3;i++)
	          System.out.print("C");
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
    public static void sum_elliniko(double sum) //metatrepei to elliniko a8roisma se arabic
    {
		double x1,x2,x3;

		x1=(int)sum%10;
		x2=(int)(sum/10)%10;
		x3=(int)sum/100;

		char[] el1={'-','a','b','g','d','e','c','z','h','v'};
		char[] el2={'-','i','k','l','m','n','j','o','p','Q'};
		char[] el3={'-','r','s','t','u','f','x','y','w','W'};

		if(sum==1000)
		   System.out.println("1000");
		for(int i=1;i<=el3.length-1;i++)
		{
			if(x3==i)
			   System.out.print(el3[i]);
		}
		for(int i=1;i<=el2.length-1;i++)
		{
			if(x2==i)
			   System.out.print(el2[i]);
		}
		for(int i=1;i<=el1.length-1;i++)
		{
			if(x1==i)
			   System.out.print(el1[i]);
		}
    }

 //shmeiwsh: den elava upopsin tis eidikes periptwseiw tou laitnikou alfavitou
}