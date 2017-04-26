// 1,3,5,2,4,8

public class FindSwitchIndex{

    public int Find(int[] ip){
        int len = ip.length;

        if(len <= 0){
            return -1;
        }

        if(len == 1 && ip[0] % 2 == 0){
            return 1;
        }

        if(len == 1 && ip[0] % 2 != 0){
            return -1;
        }

        if(len == 2 && ip[0] % 2 != 0 && ip[1] % 2 == 0){
            return 1;
        }

        int i = 0;
        int j = len - 1;
        while(i < j){
            int mid = (i + j) / 2;
            if(ip[mid] % 2 == 0) {
                if(ip[mid - 1] % 2 != 0)
                    return mid - 1;
                else
                    j = mid -1;
            }
            else{
                if(ip[mid + 1] % 2 == 0)
                    return mid + 1;
                else
                    i = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 5;
        arr[3] = 6;
        arr[4] = 8;

        FindSwitchIndex f = new FindSwitchIndex();
        int index = f.Find(arr);
        System.out.println("Switch index for happy path case is-:" + index);

        int[] arr1 = new int[1];
        arr1[0] = 1;
        FindSwitchIndex f1 = new FindSwitchIndex();
        int index1 = f1.Find(arr1);
        System.out.println("Switch index for only 1 odd item is-:" + index1);

        int[] arr2 = new int[1];
        arr2[0] = 2;
        FindSwitchIndex f2 = new FindSwitchIndex();
        int index2 = f2.Find(arr2);
        System.out.println("Switch index for only 1 even item is-:" + index2);

        int[] arr3 = new int[2];
        arr3[0] = 1;
        arr3[1] = 6;
        FindSwitchIndex f3 = new FindSwitchIndex();
        int index3 = f3.Find(arr3);
        System.out.println("Switch index for 1 odd and 1 even item is-:" + index3);
    }
}
