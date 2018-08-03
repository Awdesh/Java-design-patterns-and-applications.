class SinglePivotQS {
    
    public void quickSort(int[] arr, int low, int high) {

        if ( low < high){
            
            // create a new pivot based on the new paritition.
            int pivot = parition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    /*
    partition function is the key function inside quick sort algorithm.

    What paritition function essentially does is-:
    Overwrite array elements from the starting with the elements that are lesser than the pivot.
    i= 0, j = 1
    if element at j is lesser than pivot then replace element at i with element at j.
    */
    public int parition(int[] arr, int low, int high) {
        // taking last element as the pivot element.
        int pivot = arr[high];
        int i = low - 1;
        // decrease index on the array.
        for(int j = low; j < high; j++) {
            // if current element is smaller or equal to pivot
            if(arr[j] <= pivot) {
                i++; // increment index of smaller element.
                 // we are putting elements inside the array from beginning.
                 // putting element at index j will be at ith index.
                swap(arr, i, j);
            } 
        }

        // when we are out of loop that means we have reached to the 
        // second last element in the array as last element is the pivot.
        swap(arr, i+1, high); // swap pivot with next available ith index.
        return (i+1);
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
    
    public static void main(String[] args) {
        
        int[] arr = {10, 7, 8, 9, 1, 5};
        SinglePivotQS s = new SinglePivotQS();
        s.quickSort(arr, 0, arr.length - 1);

        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+ ",");
    }
}

