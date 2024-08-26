package com.sauravdaruka.recursion;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};

        System.out.println("Array Before Sorting : ");
        printArray(array);

        quickSort(array, 0, array.length - 1); // Time Complexity : O(nlogn) in Average Case && O(n ^ 2) in Worst Case  Space Complexity : O(1) Auxiliary Space

        System.out.println("Array After Sorting :");
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int value : array)
            System.out.print(value + " ");
        System.out.println();
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) // Sorting is not required if there is only one element (for '=' condition)
            return;
        int partitionIndex = findPivotIndex(arr, low, high);
        quickSort(arr, low, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, high);
    }
    private static int findPivotIndex(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pivotIndex = low;
        for (int i = low; i < high; i++) {    // Last element is not considered as it is a pivot element
            if (arr[i] <= pivot) {
                swap(arr, pivotIndex, i);     // Moving smaller elements to left side
                pivotIndex++;
            }
        }
        swap(arr, high, pivotIndex);         // Swap last element with pivot index to get exact pivot position
        return pivotIndex;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
