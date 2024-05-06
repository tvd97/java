package algorithm;

public class QuickSort {
    private int arr[];
    private int length;

    public void sort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        arr = input;
        length = input.length;
        quickSort(0, length - 1);
    }

    private void quickSort(int lowerPosition, int higherPosition) {
        int i = lowerPosition;
        int j = higherPosition;
        // tính toán số trục, lấy trục làm số chỉ số ở giữa
        int pivot = arr[lowerPosition + (higherPosition - lowerPosition) / 2];
        while (i <= j) {
            /**
             * Trong mỗi vòng lặp , sẽ xác định một số từ bên trái mà
             * lớn hơn giá trị trục và cũng sẽ xác định một số
             * từ phía bên phải nhỏ hơn giá trị trục. Sau khi tìm kiếm
             * xong, sau đó thay đổi cả hai số.
             */
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumber(i, j);
                // di chuyển đến vị trí tiếp theo trên cả hai bên
                i++;
                j--;

            }
        }
        if (lowerPosition < j) {
            quickSort(lowerPosition, j);
        }
        if (i < higherPosition) {
            quickSort(i, higherPosition);
        }
    }

    private void exchangeNumber(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] agrs) {
        QuickSort sorter = new QuickSort();

        int[] input = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
        sorter.sort(input);
        for (int i : input) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
