package algorithm;

public class LinearSearch {
    /*
     * Linear Search ( Array A, Value x)
     * Step 1: Set i to 1
     * Step 2: if i > n then go to step 7
     * Step 3: if A[i] = x then go to step 6
     * Step 4: Set i to i + 1
     * Step 5: Go to Step 2
     * Step 6: Print Element x Found at index i and go to step 8
     * Step 7: Print element not found
     * Step 8: Exit
     */
    public static int linearSearch(int arr[], int key) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }
    public static void main(String a[]){
        int[] arr1= {23,45,21,55,234,1,34,90};
        int searchKey = 34;
        System.out.println("Key "+searchKey+" found at index: "+linearSearch(arr1,
        searchKey));
        int[] arr2= {123,445,421,595,2134,41,304,190};
        searchKey = 421;
        System.out.println("Key "+searchKey+" found at index: "+linearSearch(arr2,
        searchKey));
        }
}
