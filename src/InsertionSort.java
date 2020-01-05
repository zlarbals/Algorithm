public class InsertionSort {
    public void sort(int[] arr){
        int value;
        for(int i=1;i<arr.length;i++){
            value=arr[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(arr[j]>value)
                    arr[j+1]=arr[j];
                else
                    break;
            }
            arr[j+1]=value;//j-- 한번 더 진행한 후에 break이 되므로, j+1에 value값
        }
    }
}
