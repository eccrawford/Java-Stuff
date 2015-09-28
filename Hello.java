import java.util.Scanner;
public class Hello{
    public static void main(String[] args) {
        int[] num = new int[]{3,2,5,4,7,6,8,9};
        bubbleSort(num);
        printArray(num);
        //System.out.println("Hello World!");
    }

    public static void practice(String[] args) {
        int x = 2;
        int y = 3;
        int z = 4;
        if (x > z)
            System.out.println("A");
        else if (y < 2*x)
            System.out.println("B");
        else if (z > y)
            System.out.println("C");
        else
            System.out.println("D");
    }

    public static void reverse(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type in a number: ");
        int num = input.nextInt();
        int rev = 0;
        while (num != 0)
        {
            rev = rev*10 + num % 10;
            num /= 10;
        }
        System.out.println(rev);
    }

    public static boolean orderList(int numbers[]) {
        int i = 0;
        while (i < numbers.length-1) {
            if (numbers[i] <= numbers[i+1]) {
                i++;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static int[] bubbleSort(int[] nums) {
        for (int i= (nums.length - 1); i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (nums[j-1] > nums[j]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i =0; i <array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print("]");
    }
    
    public static int factorial(int n) {
        int factorial = 1;
        while (n >=1) {
            factorial *= n;
            n -= 1;
        }
        return factorial;
    }
}