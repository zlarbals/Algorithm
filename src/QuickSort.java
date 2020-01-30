public class QuickSort {
    public void sort(int[] array, int l, int r) {
        int left=l;
        int right=r;
        int pivot = array[(left+right)/2];

       do{
           while(array[left]<pivot)left++;
           while(array[right]>pivot)right--;
           if(left<=right){
               Swap(array,left,right);
               left++;
               right--;
           }
       }while(left<=right);

        //return left,right 할 경우
        //right pivotindex left 순으로 나열되어 있다면 left or right 중 하나를 리턴할 경우
        //이미 정렬된 pivotindex부분도 다시 정렬 범위안에 들어가게 된다. 이것을 방지하고 싶다.
        //따라서 일반적인 quick sort의 구조인 sort와 partiton으로 나누지 않고 sort에 재귀적으로 구현한다.
        if(l<right) sort(array,l,right);
        if(r>left) sort(array,left,r);
    }

    private void Swap(int[] arr, int changeIndex1, int changeIndex2) {
        int temp = arr[changeIndex1];
        arr[changeIndex1] = arr[changeIndex2];
        arr[changeIndex2] = temp;
    }
}

//test.
//    QuickSort quickSort = new QuickSort();
//        quickSort.sort(arr,0,arrayNumber-1);
