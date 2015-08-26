import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by rsaikia on 7/31/2015.
 */
public class ARMY2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        boolean first=true;
        while(tt>0){
            int ng=sc.nextInt();
            int nm=sc.nextInt();

            PriorityQueue<Integer> arrNGPQ=new PriorityQueue<Integer>(ng,new Intcomparator());
            PriorityQueue<Integer> arrNMPQ=new PriorityQueue<Integer>(nm,new Intcomparator());

            for(int i=0;i<ng;i++){
                arrNGPQ.offer(sc.nextInt());
            }
            for(int i=0;i<nm;i++){
                arrNMPQ.offer(sc.nextInt());
            }

            while(arrNGPQ.size()>0 && arrNMPQ.size()>0){
                int ngVal=arrNGPQ.peek();
                int nmVal=arrNMPQ.peek();
                if(ngVal<nmVal){
                    arrNGPQ.poll();
                }
                else{
                    arrNMPQ.poll();
                }
            }
            if(!first) System.out.println("");
            first=false;
            if(arrNGPQ.size()==arrNMPQ.size()){
                System.out.println("uncertain");
            }
            else{
                if(arrNGPQ.size()>0){
                    System.out.print("Godzilla");
                }else if(arrNMPQ.size()>0){
                    System.out.print("MechaGodzilla");
                }
            }
            tt--;
        }
    }

}
class Intcomparator implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b){
        return a-b;
    }
}