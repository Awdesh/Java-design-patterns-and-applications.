import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Before\n");
        Matrix matrix = new Matrix();
        int[][] arr = matrix.CreateArray();
        System.out.println("\n");
        System.out.println("After\n");

        for(int i = 0; i <arr.length; i++)
        {
            int[] sub = arr[i];
            for(int j = 0; j<sub.length;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nfibonacci\n");

//        fibonacci fib = new fibonacci();
//        int res = fib.CreateSeries(6);
//        System.out.println(res);
//
//        System.out.println("\nfibonacci\n");
//
//        String s = fib.firstRepeatedWord("He Had quite");
//
//        System.out.println(s);
//
//        int[] A = new int[]{80,100,120,110,46,35,23,5,8976,52,1,34,-87,55,6,77,88};
//
//        BucketSort bs = new BucketSort();
//        int[] op = bs.bucketsort(A);
//
//        for(int i : op)
//        {
//            System.out.println(i);
//        }
//
//        CarSorting car1 = new CarSorting("Ford", 80);
//        CarSorting car2 = new CarSorting("Chevy", 74);
//        CarSorting car3 = new CarSorting("Toyota", 56);
//
//        CarSorting[] carArray = new CarSorting[] {car1,car2,car3};
//        // Arrays.sort(object[]) requires object type to implement comparable interface.
//        // because comparable interface determines the natural ordering of the objects.
//        Arrays.sort(carArray);
//
//        for(CarSorting car:  carArray)
//        {
//            System.out.println(car.toString());
//        }
//
//        String[] words1 = {"Fred", "bob", "Tom", "Mark", "john"};
//        // new comp1 is a functor.
//        Arrays.sort(words1, new comp1());
//
//        String[] words2 = {"Fred", "Bob", "Tom", "Mark", "John"};
//        Arrays.sort(words2, new comp2());
//
//        String[] words3 = {"Fred@cmu.edu", "bob@yahoo.com", "Tom@gmail.com",
//                "Mark@gmail.com", "john@syr.edu"};
//        Arrays.sort(words3, new comp3());
//
//        List<List<RecursiveList>> items = new ArrayList<List<RecursiveList>>();
//        List item1 = new ArrayList();
//        item1.add("orange");
//        List item2 = new ArrayList();
//        item2.add("butter");
//        item2.add("jam");
//        List item3 = new ArrayList();
//        item3.add("apple");
//        item3.add("jam");
//        item3.add("mango");
//
//
//        items.add(item1);
//        items.add(item2);
//        items.add(item3);
//
//        int index = 0;
//        for(List item : items)
//        {
//            if(item.contains("jam"))
//            {
//                break;
//            }
//            index++;
//        }
//
//        HashTableFromArray ht = new HashTableFromArray(3);
//        ht.insert("coffee", 50);
//        ht.insert("tea", 100);
//        ht.insert("orange", 80);
//
//        int val = ht.get("orange");
    }
}
