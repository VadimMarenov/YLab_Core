package task2;
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 3, 2, 5, 1, 4, 9};
        Sort sort = new Sort();
        sort.bubbleSort(array);
        SortTest.bubbleSortTest(array);

        for (int el : array) {
            System.out.print(el + " ");
        }
    }

    public static class Sort {
        public int[] bubbleSort(int[] array) {
            boolean sorted = false;
            int temp;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        sorted = false;
                    }
                }
            }
            return array;
        }
    }

    public static class SortTest {
        static Sort sut = new Sort();

        public static void bubbleSortTest(int[] array) {
            int[] expected = new int[]{1, 2, 3, 4, 5, 5, 6, 9, 2};
            int[] actual = sut.bubbleSort(array);

            assert expected.length == actual.length : "Compared arrays have different length";

            for (int i = 0; i < array.length; i++) {
                assert expected[i] == actual[i] : "Something wrong with bubble sort method";
            }
        }

    }
}