package MyCustomArrayList;

import java.util.Comparator;

public class QuickSort<E> {
    public void quickSort(Object[] arr, int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pi = partition(arr, low, high, comparator);
            quickSort(arr, low, pi - 1, comparator);
            quickSort(arr, pi + 1, high, comparator);
        }
    }
    private int partition(Object[] arr, int low, int high, Comparator<? super E> comparator) {
        Object pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare((E) arr[j], (E) pivot) < 0) {
                i++;
                Object temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Object temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
