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
        int cols = inArray[0].length;

        boolean swap = false;

        for (int i = 0; i < rows - 1; i++)
        {
            for (int j = 0; j < (rows - i - 1); j++)
            {
                if (inArray[j][0] > inArray[j + 1][0])
                {
                    int temp = inArray[j][i];
                    inArray[j][i] = inArray[j + 1][i];
                    inArray[j + 1][i] = temp;
                }
            }
        }

        printArray(inArray);
    }






    public static void main(String[] args)
    {
        int[][] array = {{5, 3, 2, 16}, {9, 8 ,10, 17}, {4, 7, 11, 18}, {2, 5, 9, 12}, {7, 9, 4, 10}};

        printArray(array);

        System.out.println();

        System.out.println("After bubble sort based on first column: ");
        bubbleSort(array);
    }
}