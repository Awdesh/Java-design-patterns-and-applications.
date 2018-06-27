public class SearchInRotatedArray {

    public static boolean findNumber(int[] ip, int num)
    {
        int low = 0;
        int high = ip.length - 1;
        int start = ip[0];
        while(low < high)
        {
            int mid = (low + high) / 2;
            if(ip[mid] == num)
                return true;

            if(ip[mid] > num){
                if(start < num){
                    // rotation doesn't happen yet.
                    high = mid;
                } else {
                    // rotation happened
                    low = mid;
                }
            }

            if(ip[mid] < num) {
                if(start < num){
                    // rotation doesn't happen yet.
                    high = mid;
                } else {
                    // rotation happened
                    low = mid;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,1,2,3};
        System.out.println(findNumber(nums, 5));

        int[] nums1 = new int[]{4,5,6,7, 1,2,3};
        System.out.print(findNumber(nums, 1));

        int[] nums2 = new int[]{4,5,6,7, 1,2,3};
        System.out.print(findNumber(nums, 3));

    }

}

