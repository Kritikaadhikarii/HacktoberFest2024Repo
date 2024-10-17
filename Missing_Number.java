public class Missing_Number {
    public int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = (n * (n + 1) / 2);
        for (int num : arr) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 6, 3, 9, 8, 7 };
        Missing_Number mn = new Missing_Number();

        System.out.print("Missing number is: ");
        System.out.println(mn.findMissingNumber(arr));

    }

}
