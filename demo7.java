import java.util.Scanner;
public class demo7{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int temp,rev=0,r;
        temp=num;
        while(num>0){
            r=num%10;
            rev=(rev*10)+r;
            num=num/10;
        } 
        if(temp==rev){
            System.out.println(temp+" is a palindrome number");
        } 
        else{
            System.out.println(temp+" is not a palindrome number");
        }
    }
}