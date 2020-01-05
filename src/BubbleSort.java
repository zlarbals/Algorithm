public class BubbleSort {
    public void sort(int[] arr){
        int endFlag;
        for(int i=0;i<arr.length-2;i++){
            endFlag=1;
            for(int j=0;j<(arr.length-1)-i;j++){
                if(arr[j]>arr[j+1]) {
                    Swap(arr, j, j + 1);
                    endFlag=0;
                }
            }
            if(endFlag==1)//if swap does not proceed, array is sorted.
                break;
        }
    }

    private void Swap(int[] arr, int changeIndex1, int changeIndex2) {
        int temp = arr[changeIndex1];
        arr[changeIndex1] = arr[changeIndex2];
        arr[changeIndex2] = temp;
    }
}
