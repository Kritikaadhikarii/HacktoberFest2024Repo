public class Move_Zeroes_To_End_Array {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void moveZeroes(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0) {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 12, 0, 0, 23, 24 };

        System.err.println("Original Array");
        printArray(arr);

        System.out.println("Array after moving zeroes to end");
        moveZeroes(arr);
        printArray(arr);
    }

}
