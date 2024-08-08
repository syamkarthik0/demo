import java.util.Scanner;

public class Armstrong {

    public static void main(String[] args) {

        int originalNum, digit, Sum = 0,num;
        
        System.out.print("Enter the number:");
        Scanner sc = new Scanner(System. in );
        num = sc.nextInt();
        int temp = num;
        int digitNum=0;

        while (temp != 0) {
            temp /= 10;
            digitNum++;
        }
        originalNum=num;
        while (num!= 0)
        {
            digit = num % 10;
            Sum += Math.pow(digit,digitNum);
            num /= 10;
        }

        if(Sum == originalNum){
            System.out.println(originalNum+ " is an Armstrong number");
        }
        else{
            System.out.println(originalNum+ " is not an Armstrong number");
        }
    }
}