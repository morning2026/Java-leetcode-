import java.util.Scanner;

public class PalindromicNumber {
    public boolean isPalindrome(int x) {
         if((x<0)||(x%10==0 && x!=0)){
             return false;
         }
         int z = 0;
         while(x>z) {
             z *= 10;
             z += x % 10;
             x /= 10;
         }
         return x==z||x==z/10;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        PalindromicNumber pn = new PalindromicNumber();
        System.out.println(pn.isPalindrome(x));
    }
}

