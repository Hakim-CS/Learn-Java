import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class CollatzChaining {
    
    public static  void countCollatz(int n){

        List<Integer> list = new ArrayList<>(); 
        int count =0;
        while (n !=1){
            list.add(n);
            if (n%2 ==0){
                n = n/2;
                count ++;

            }
                
            else{
                n = 3*n +1;
                count ++;
            }
        }  
        System.out.println("The number of steps: " + count); 
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        } 
        
    }



    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = scan.nextInt();

         countCollatz(n);
       

    }
}
