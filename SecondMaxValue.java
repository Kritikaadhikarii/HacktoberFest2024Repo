public class SecondMaxValue {

    public int secondMax(int[] arr){
        int max = arr[0];
        int secondMax = arr[0];

        for(int i = 0; i<arr.length;i++){
            if(arr[i]>max){
                secondMax = max;
                max= arr[i];
            }
            else if(arr[i]<max && arr[i]>secondMax){
                secondMax = arr[i];
            }       
        }
        return secondMax;
}

    public static void main(String[] args){
        int[] num = {1, 2, 3, 4, 5,23,13};
        SecondMaxValue value = new SecondMaxValue();

        System.out.println("Second Maximum value of an Array is: "+ value.secondMax(num));

    }
    
}
