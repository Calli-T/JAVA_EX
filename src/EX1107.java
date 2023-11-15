import java.util.Vector;
import java.util.Scanner;
import java.util.InputMismatchException;

public class EX1107 {
    public static void print_sum(Vector<Integer> vector){
        int sum = 0;
        var it = vector.iterator();
        while(it.hasNext()){
            int n = it.next();
            //System.out.print(n + " ");
            sum+= n;
        }

        System.out.println("Current Sum: : " + sum/vector.size());
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int rain_drop = 0;
        Vector<Integer> vector = new Vector<Integer>();

        while(true){
            try {
                System.out.print("Now rain_drop: ");
                rain_drop = scanner.nextInt();
                if(rain_drop == 0)
                    break;

                vector.add(rain_drop);
                print_sum(vector);
            } catch (InputMismatchException e) {
                System.out.println("똑바로 써라");
            }
        }

        for(int i = 0; i < vector.size(); i++){
            System.out.println(vector.get(i));
        }
    }
}
