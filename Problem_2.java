import java.util.*;

public class Problem_2 {
    public static long minOperations(int[] A, int K) {
        int n = A.length;
        
        int rem = A[0] % K;
        for (int i = 1; i < n; i++) {
            if (A[i] % K != rem) {
                return -1;
            }
        }
        
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = A[i] / K;
        }
        
        Arrays.sort(B);
        int median = B[n / 2];
        
        long operations = 0;
        for (int i = 0; i < n; i++) {
            operations += Math.abs(B[i] - median);
        }
        
        return operations;
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 6, 8, 10};
        int K = 2;
        
        System.out.println(minOperations(A, K)); 
    }
}