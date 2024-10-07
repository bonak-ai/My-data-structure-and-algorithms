import java.util.Scanner;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == target) {
                return a; 
            }
        }
        return -1;  
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int a = 0; a < n; a++) {
            arr[a] = scanner.nextInt();
        }
        
        System.out.print("Enter the target value to search : ");
        int target = scanner.nextInt();
        
      
        int result = linearSearch(arr, target);
        
        if (result == -1) {
            System.out.println("Target value not found in the array.");
        } else {
            System.out.println("Target value found at index: " + result);
        }
        
        scanner.close();
    }
                                  }
