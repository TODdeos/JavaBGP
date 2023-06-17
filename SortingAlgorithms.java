import java.util.Arrays;

public class SortingAlgorithms {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Обмен элементов
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Если внутренний цикл не производил обменов, то массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        // Небольшой массив
        int[] smallArray = {5, 2, 8, 12, 1};
        System.out.println("Исходный массив (небольшой): " + Arrays.toString(smallArray));

        int[] smallArrayBubbleSort = Arrays.copyOf(smallArray, smallArray.length);
        long startTimeBubbleSortSmall = System.nanoTime();
        bubbleSort(smallArrayBubbleSort);
        long endTimeBubbleSortSmall = System.nanoTime();
        System.out.println("Массив после сортировки пузырьком (небольшой): " + Arrays.toString(smallArrayBubbleSort));
        System.out.println("Время выполнения сортировки пузырьком (небольшой): " + (endTimeBubbleSortSmall - startTimeBubbleSortSmall) + " ns");

        int[] smallArrayMergeSort = Arrays.copyOf(smallArray, smallArray.length);
        long startTimeMergeSortSmall = System.nanoTime();
        mergeSort(smallArrayMergeSort);
        long endTimeMergeSortSmall = System.nanoTime();
        System.out.println("Массив после сортировки слиянием (небольшой): " + Arrays.toString(smallArrayMergeSort));
        System.out.println("Время выполнения сортировки слиянием (небольшой): " + (endTimeMergeSortSmall - startTimeMergeSortSmall) + " ns");

        // Крупный массив
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int) (Math.random() * 10000);
        }
        System.out.println("\nИсходный массив (крупный): " + Arrays.toString(largeArray));

        int[] largeArrayBubbleSort = Arrays.copyOf(largeArray, largeArray.length);
        long startTimeBubbleSortLarge = System.nanoTime();
        bubbleSort(largeArrayBubbleSort);
        long endTimeBubbleSortLarge = System.nanoTime();
        System.out.println("Массив после сортировки пузырьком (крупный): " + Arrays.toString(largeArrayBubbleSort));
        System.out.println("Время выполнения сортировки пузырьком (крупный): " + (endTimeBubbleSortLarge - startTimeBubbleSortLarge) + " ns");

        int[] largeArrayMergeSort = Arrays.copyOf(largeArray, largeArray.length);
        long startTimeMergeSortLarge = System.nanoTime();
        mergeSort(largeArrayMergeSort);
        long endTimeMergeSortLarge = System.nanoTime();
        System.out.println("Массив после сортировки слиянием (крупный): " + Arrays.toString(largeArrayMergeSort));
        System.out.println("Время выполнения сортировки слиянием (крупный): " + (endTimeMergeSortLarge - startTimeMergeSortLarge) + " ns");
    }
}





