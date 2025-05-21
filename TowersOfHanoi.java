public class Towersofhanoi{

    public static int hanoi (int n , int start  , int end){
        int step=0;

        if (n==1 ){
            System.out.println("move disk 1 from peg "+start+" to "+end);
            step ++;
            return step;
        }
        else{

        int other = 6 -(start +end );
        //move the n-1 disk from pig start to auxilary pig
        step +=hanoi (n-1 , start ,  other);
        
        //move nth disk from start to end 
       // System.out.println("move disk "+n+" form "+start+"  to"+end );
       System.out.println(String.format("move disk %d from %d to %d ",n,start,end)); //use this
       step++;

       //move n-1 disk from auxilary pig to end 
       step +=hanoi (n-1, other, end);
        }
        return step;

    }

    public static void main(String[] args) {
        
        System.out.println("towers of hanoi ");

       int step=  hanoi (3, 1,3);
       System.out.println("\ntotal steps "+step);


    }
}