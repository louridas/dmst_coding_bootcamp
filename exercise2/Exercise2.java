package exercise2;
import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		
		int indexOp; 
		int sum_arabic,sum1=0,sum2=0;
		char first_char,first_char2;
		String first_string,second_string;
		Metatropes met = new Metatropes();

		System.out.println("please type the numerical expression or enter to exit: ");
		System.out.println("(the greek alphabet is in greeklish) ");
	    Scanner sc = new Scanner(System.in);
        String ar_expression = sc.nextLine();


        while(ar_expression.length()!=0)
        {
			first_char=ar_expression.charAt(0);
            indexOp=met.index_of_operator(ar_expression);
            first_string=ar_expression.substring(0, indexOp);
            

			if(Character.isDigit(first_char))
			{
				sum1=Integer.parseInt(first_string);
			}
			else if(first_char=='I'||first_char=='V'||first_char=='X'||first_char=='L'||first_char=='C'||first_char=='D'||first_char=='M')
			{
				sum1=met.latin_to_arabic(first_string);
				
			}
			else
			{
				
				sum1=met.greek_to_arabic(first_string);

			}

            first_char2=ar_expression.charAt(indexOp+1);
            second_string=ar_expression.substring(indexOp+1);
            
			if(Character.isDigit(first_char2))
			{
				sum2=Integer.parseInt(second_string);
			}
			else if(first_char2=='I'||first_char2=='V'||first_char2=='X'||first_char2=='L'||first_char2=='C'||first_char2=='D'||first_char2=='M')
			{
				sum2=met.latin_to_arabic(second_string);
			}
			else
			{
				sum2=met.greek_to_arabic(second_string);
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
			met.arabic_to_latin(sum_arabic);
			System.out.println();
			
			System.out.print("the result in the greek numerals is : ");
			System.out.print(met.arabic_to_greek(sum_arabic));
			System.out.println();

			System.out.println("please type the numerical expression ");
			ar_expression = sc.nextLine();
            
        }
        System.out.println("bye");
        sc.close();

	}

}
