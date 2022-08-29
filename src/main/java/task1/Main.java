package task1;

public class Main {
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        RandomArray array = new RandomArray(7, 100);    // Creating a random array.
        array.printArrayWithColors();
        array.printInfo();  // Printing information about the maximum, minimum and average values of the array elements.
    }

    public static class RandomArray {
        private final int[][] array;
        private final int arraySize; // Size of a two-dimensional array as int[arraySize][arraySize]
        private final int maxValue; // The maximum value of an array element with a
        // range of -MAX_VALUE to +MAX_VALUE

        public RandomArray(int arraySize, int maxValue) {
            this.arraySize = arraySize;
            this.maxValue = maxValue;
            this.array = createArray();
        }

        public int[][] createArray() {
            Random random = new Random(maxValue);

            int[][] array = new int[arraySize][arraySize];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = random.nextInt();
                }
            }
            return array;
        }

        public int getMax() {
            int max = array[0][0];
            for (int[] line : array) {
                for (int element : line) {
                    if (element > max) {
                        max = element;
                    }
                }
            }
            return max;
        }

        public int getMin() {
            int min = array[0][0];
            for (int[] line : array) {
                for (int element : line) {
                    if (element < min) {
                        min = element;
                    }
                }
            }
            return min;
        }

        public double getAverage() {
            int sum = 0;
            int count = 0;
            for (int[] line : array) {
                for (int element : line) {
                    sum += element;
                    count += 1;
                }
            }
            return sum / (double) count;
        }

        public void printArrayWithColors() {
            int max = getMax();
            int min = getMin();
            for (int[] line : array) {
                for (int element : line) {
                    if (element == max) {
                        System.out.print(GREEN + element + " " + RESET);
                    } else if (element == min) {
                        System.out.print(RED + element + " " + RESET);
                    } else {
                        System.out.print(element + " ");
                    }
                }
                System.out.println();
            }
        }

        public void printInfo() {
            System.out.println(GREEN + "Max " + getMax() + RESET);
            System.out.println(RED + "Min " + getMin() + RESET);
            System.out.println(BLUE + "Average " + getAverage() + RESET);
        }
    }

    public static class Random {
        private final int max;
        private static int last;

        public Random(int max) {
            this.max = max;
            last = (int) (System.currentTimeMillis() % max);
        }

        public int nextInt() {
            last = (last * 48529 + 3) % 48559;
            return last % max;
        }
    }
}