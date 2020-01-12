public class QuickSort {
    private int Partition(int[] array, int left, int right) {
        int low = left + 1;
        int high = right;
        int value = array[left];
        while (low<=high) {
            while (value > array[low] && low <= right)
                low++;
            while (value < array[high] && high >= (left + 1))
                high--;

            if (low <= high)
                Swap(array, low , high);
        }
        Swap(array, left, high);
        return high;
    }

    public void sort(int[] array, int left, int right) {
        int middle;
        if (left <= right) {
            middle = Partition(array, left, right);
            sort(array, left, middle - 1);
            sort(array, middle + 1, right);
        }
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
