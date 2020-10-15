import java.util.Scanner;


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






    static void printCol(int[][] inArray, int col)
    {
        for (int i = 0; i < inArray.length; i++)
        {
            System.out.println(inArray[i][col]);
        }
    }






    static int[][] copyArray(int[][] arrayCopy, int[][] inArray)
    {
        int rows = inArray.length;
        int cols = inArray[0].length;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                arrayCopy[i][j] = inArray[i][j];
            }
        }

        return arrayCopy;
    }






    static void bubbleSort(int[][] inArray)
    {
        int[][] newArray = new int[5][4];
        newArray = copyArray(newArray, inArray);

        int rows = newArray.length;

        for (int i = 0; i < rows - 1; i++)
        {
            for (int j = 0; j < (rows - i - 1); j++)
            {
                if (newArray[j][0] > newArray[j + 1][0])
                {
                    newArray = swapRows(newArray, j, (j + 1));
                }
            }
        }

        printArray(newArray);
    }







    static void selectionSort(int[][] inArray)
    {
        int[][] newArray = new int[5][4];
        newArray = copyArray(newArray, inArray);

        int rows = newArray.length;

        for (int i = 0; i < rows - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < rows; j++)
            {
                if (newArray[j][1] > newArray[minIndex][1])
                {
                    minIndex = j;
                }
            }

            inArray = swapRows(newArray, i, minIndex);
        }

        printArray(newArray);
    }






    static void shellSort(int[][] inArray)
    {
        int[][] newArray = new int[5][4];
        newArray = copyArray(newArray, inArray);

        int rows = newArray.length;

        for (int gap = rows / 2; gap >= 1; gap /= 2)
        {
            for (int i = gap; i < rows; i++)
            {
                for (int j = i; j >= gap && newArray[j - gap][2] > newArray[j][2]; j -= gap)
                {
                    newArray = swapRows(newArray, (j - gap), j);
                }
            }
        }

        printArray(newArray);
    }






    static void insertionSort(int[][] inArray)
    {
        int cols = inArray[0].length;

        for (int i = 1; i < cols; i++)
        {
            for (int j = i; j > 0 && inArray[4][j] < inArray[4][j - 1]; j--)
            {
                inArray = swapCols(inArray, j, (j - 1));
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






    static int[][] swapCols(int[][] inArray, int col1, int col2)
    {
        for (int i = inArray[0].length; i >= 0; i--)
        {
            int temp = inArray[i][col1];
            inArray[i][col1] = inArray[i][col2];
            inArray[i][col2] = temp;
        }

        return inArray;
    }






    static void binarySearch(int[][] inArray, int target)
    {
        int high = inArray.length - 1;
        int low = 0;
        int targetColIndex = 0;

        boolean found = false;

        while (high >= low && !found)
        {
            int mid = (high + low) / 2;

            if (target > inArray[4][mid])
            {
                low = mid + 1;
            }

            else if (target < inArray[4][mid])
            {
                high = mid - 1;
            }

            else
            {
                found = true;

                targetColIndex = mid;
            }
        }

        if (found)
        {
            printCol(inArray, targetColIndex);
        }

        else
        {
            System.out.println("That number was not found in row five of the array.");
        }
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

        System.out.println("\nAfter insertion sort based on fifth row: ");
        insertionSort(array);

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nWhat number are you searching for in the fifth row? ");
        int target = scanner.nextInt();

        binarySearch(array, target);
    }
}