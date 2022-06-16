import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sw = new Solution();
        sw.solution(new int[] {10, 200, 1200, 90, 96136}, 2);
    }
}

class Solution{
    public void solution(int[]A, int K){
        int max = (Arrays.stream(A).max().getAsInt() + "").length();
        int setIndex = 0;
        K = K > A.length ? A.length : K;

        for (int row = 0; row < 3; row++) {
            if (setIndex < A.length) {
                System.out.print(row % 2 == 0 ? "+" : "");
                for (int i = 0; i < K; i++) {
                    if(row % 2 == 0){
                        for (int j = 0; j < max + 1; j++) {
                            if (j == max)
                                System.out.print("+");
                            if (j < max)
                                System.out.print("-");
                        }
                    }if (row == 1) {
                        if (setIndex < A.length) {
                            System.out.print(i > 0 ? "" : "|");
                            for (int j = 0; j < max - (A[setIndex]+"").length() + 1; j++) {
                                if (j > 0)
                                    System.out.print(" ");
                                if (j == max - (A[setIndex]+"").length()) {
                                    System.out.print(A[setIndex]);
                                    System.out.print("|");
                                }
                            }
                            if (setIndex == A.length - 1) {
                                System.out.println();
                                System.out.print("+");
                                for (int l = 0; l < (A.length % K == 0 ? K : A.length % K); l++) {
                                    for (int j = 0; j < max + 1; j++) {
                                        if (j == max)
                                            System.out.print("+");
                                        if (j < max)
                                            System.out.print("-");
                                    }
                                }
                            }
                        }
                        setIndex++;
                    }
                    if (i == (K-1) && row == 2) {
                        row = 0;
                    }
                }
                System.out.println();
            }
        }
    }
}