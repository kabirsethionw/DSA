package JavaFiddle;

import java.util.Arrays;
import java.util.Scanner;

public class DriverCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int len = sc.nextInt();
            String nums[] = new String[len];
            for(int j = 0; j < len; j++){
                nums[j] = sc.next();
            }
            for(String elem: nums) System.out.print(elem + " ");
        }
        System.out.println(" ");
        sc.nextLine();
        System.out.println(sc.nextLine());
    }
}
