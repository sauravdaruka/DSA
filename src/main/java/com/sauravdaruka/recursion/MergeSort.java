package com.sauravdaruka.recursion;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Array Before Sorting: ");
        printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Array After Sorting: ");
        printArray(arr);
    }
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = (middle - left) + 1;
        int n2 = (right - middle - 1) + 1;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];

        for (int i = 0; i < n2; i++)
            rightArray[i] = arr[middle + 1 + i];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j])
                arr[k++] = leftArray[i++];
            else
                arr[k++] = rightArray[j++];
        }

        while (i < n1)
            arr[k++] = leftArray[i++];

        while (j < n2)
            arr[k++] = rightArray[j++];

    }
    public static void printArray(int[] array) {
        for (int i : array)
            System.out.print(i + " ");
        System.out.println();
    }

}
