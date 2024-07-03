import java.util.Scanner;
public class demo4{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        if(num==1){
            System.out.println(num+" is a prime number");
            return;
        }
        for(int i=2;i<num;i++){
            if (num%i==0){
                System.out.println(num+" is not a prime number");
                return;
            }
        }
        System.out.println(num+" is a prime number");     
    }
}