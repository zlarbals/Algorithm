public class SelectionSort {
    public void sort(int[] arr) {
        int minValueIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minValueIndex = i;
            for (int j = minValueIndex + 1; j < arr.length; j++) {
                if (arr[minValueIndex] > arr[j])
                    minValueIndex = j;
            }
            if (minValueIndex != i)
                Swap(arr, i, minValueIndex);
        }
    }

    private void Swap(int[] arr, int changeIndex1, int changeIndex2) {
        int temp = arr[changeIndex1];
        arr[changeIndex1] = arr[changeIndex2];
        arr[changeIndex2] = temp;
    }
}
