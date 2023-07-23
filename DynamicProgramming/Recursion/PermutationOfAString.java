package DynamicProgramming.Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PermutationOfAString {
    static List<String> resultList = new ArrayList<>();

    private static void swap(char strArr[], int index1, int index2) {
        char temp = strArr[index1];
        strArr[index1] = strArr[index2];
        strArr[index2] = temp;
    }

    private static void permute(char strArr[], int left, int right) {
        if(left == right) {
            String str = new String(strArr);
            resultList.add(str);
            return;
        }

        for(int i = left; i <= right; i++) {
            swap(strArr, left, i);
            permute(strArr, left + 1, right);
            swap(strArr, left, i);
        }
    }

    public static void main (String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        char strArr[] = str.toCharArray();

        permute(strArr, 0, strArr.length - 1);

        Collections.sort(resultList);
        for(String result : resultList) {
            System.out.print(result + " ");
        }
    }
}
