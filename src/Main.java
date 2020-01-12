public class Main {
    public static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = (int) (Math.random() * arr.length);
            int k = (int) (Math.random() * arr.length);

            int temp = arr[j];
            arr[j] = arr[k];
            arr[k] = temp;
        }
    }

    public static void main(String[] args) {
        final int arrayNumber = 20000;
        int[] arr = new int[arrayNumber];

        for (int i = 0; i < arrayNumber; i++) {
            arr[i] = i + 1;
        }
        shuffle(arr);//random sort.

        for(int i=0;i<10;i++)
            System.out.println(arr[i]);
        System.out.println("-------------------------");

        //test.
    }
}
