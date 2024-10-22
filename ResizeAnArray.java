public class ResizeAnArray {

    public int[] resizeArray(int[] arr, int capacity){
        int [] temp = new int[capacity];
        for(int i = 0; i<arr.length;i++){
            temp[i] = arr[i];
        }
        return temp;
    }

    public static void main(String[] args) {
        ResizeAnArray obj = new ResizeAnArray();
        int[] original = {2,4,1,4,5,6};
        System.out.println("The size of original array is: "+ original.length);

         // obj.resizeArray(original, 12); //when you call 'obj.resizeArray(original, 12)', it creates a new array with a capacity of 12, copies the elements from the 'original' array to the new array, and returns the new array. But the 'original' array still remains the same, with its original size.

         original = obj.resizeArray(original, 12);
         System.out.println("The size of an array after resizing is: "+original.length);
    }
    
}
