package edu.ntudp.polisnichenko;

import java.util.Random;
import java.util.Scanner;

public class App
{
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Hello!");
        System.out.println("Here you can create an array matrix");
        System.out.println();

        System.out.print("Set size (less or equal to 20) Y: ");
        var x = getInputPositiveInt(1, 20);
        System.out.println();

        System.out.print("Set size (less or equal to 20) X: ");
        var y = getInputPositiveInt(1, 20);

        System.out.println("Do you want to create matrix automatically(1) or manually(2)?");
        var createType = getInputPositiveInt(1, 2);


        var matrix = CreateMatrix(x, y, createType);
        PrintMatrix(matrix);

        var min = FindMatrixMinValue(matrix);
        System.out.println("Min value: " + min);

        var max = FindMatrixMaxValue(matrix);
        System.out.println("Max value: " + max);

        var average = FindMatrixAverageValue(matrix);
        System.out.println("Average value: " + average);
    }

    private static int[][] CreateMatrix(int x, int y, int createType) {

        int[][] matrix = new int[x][y];

        if (createType == 1) {
            FillMatrixAutomatically(matrix);
        } else if (createType == 2) {
            FillMatrixManually(matrix);
        }

        return matrix;
    }

    private static void FillMatrixAutomatically(int[][] matrix) {
        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(50);
            }
        }
    }

    private static void FillMatrixManually(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter matrix[" + (i + 1) + "][" + (j + 1) +"]: ");
                matrix[i][j] = getInputPositiveInt();
            }
        }
    }

    private static int FindMatrixMinValue(int[][] matrix){
        var minValue = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] < minValue){
                    minValue = matrix[i][j];
                }
            }
        }

        return minValue;
    }

    private static int FindMatrixMaxValue(int[][] matrix){
        var maxValue = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] > maxValue){
                    maxValue = matrix[i][j];
                }
            }
        }

        return maxValue;
    }

    private static double FindMatrixAverageValue(int[][] matrix){
        var totalSum = 0;
        var count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                totalSum += matrix[i][j];
                count++;
            }
        }

        return (double) totalSum / count;
    }

    private static void PrintMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }


    private static int getInputPositiveInt() {
        return getInputPositiveInt(-1, -1);
    }

    private static int getInputPositiveInt(int lowerInclusiveBound, int upperInclusiveBound) {
        var succeeded = false;
        var parsedValue = 0;

        while (!succeeded) {
            try {
                parsedValue = input.nextInt();
                if ((upperInclusiveBound != -1 && parsedValue > upperInclusiveBound)
                        || (lowerInclusiveBound != -1 && parsedValue < lowerInclusiveBound)) {
                    throw new Exception();
                }
                succeeded = true;
            } catch (Exception e) {
                System.out.println("Wrong number");
                input.next();
            }
        }

        return parsedValue;
    }
}
