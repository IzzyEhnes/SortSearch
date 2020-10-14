public class Main
{
    static void printArray(int[][] inArray)
    {
            int rows = inArray.length;
            int cols = inArray[0].length;

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    System.out.print(inArray[i][j]);
                    System.out.print("     ");
                }

                System.out.println();
            }
    }






    static void bubbleSort(int[][] inArray)
    {
        int rows = inArray.length;

        for (int i = 0; i < rows - 1; i++)
        {
            for (int j = 0; j < (rows - i - 1); j++)
            {
                if (inArray[j][0] > inArray[j + 1][0])
                {
                    inArray = swapRows(inArray, j, (j + 1));
                }
            }
        }

        printArray(inArray);
    }







    static void selectionSort(int[][] inArray)
    {
        int rows = inArray.length;

        for (int i = 0; i < rows - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < rows; j++)
            {
                if (inArray[j][1] > inArray[minIndex][1])
                {
                    minIndex = j;
                }
            }

            inArray = swapRows(inArray, i, minIndex);
        }

        printArray(inArray);
    }






    static void shellSort(int[][] inArray)
    {
        int rows = inArray.length;
        int temp;
        for (int gap = rows / 2; gap >= 1; gap /= 2)
        {
            for (int i = gap; i < rows; i++)
            {
                for (int j = i; j >= gap && inArray[j - gap][2] > inArray[j][2]; j -= gap)
                {
                    inArray = swapRows(inArray, (j - gap), j);
                }
            }
        }

        printArray(inArray);
    }






    static int[][] swapRows(int[][] inArray, int row1, int row2)
    {
        for (int i = 0; i < inArray.length - 1; i++)
        {
            int temp = inArray[row1][i];
            inArray[row1][i] = inArray[row2][i];
            inArray[row2][i] = temp;
        }

        return inArray;
    }






    public static void main(String[] args)
    {
        int[][] array = {{5, 3, 2, 16}, {9, 8 ,10, 17}, {4, 7, 11, 18}, {2, 5, 9, 12}, {7, 9, 4, 10}};

        printArray(array);

        System.out.println();

        System.out.println("After bubble sort based on first column: ");
        bubbleSort(array);

        System.out.println("\nAfter selection sort based on second column: ");
        selectionSort(array);

        System.out.println("\nAfter shell sort based on third column: ");
        shellSort(array);
    }
}