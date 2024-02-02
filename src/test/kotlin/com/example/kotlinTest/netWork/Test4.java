package com.example.kotlinTest.netWork;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test4 {

    @Test
    void test() {
        Solution solution = new Solution();
        Assertions.assertThat(
            solution.solution(7)
        ).isEqualTo(3);


    }

    class Solution {
        public int solution(int n) {
            int nOneCount = 0;
            String nToBinaryString = Integer.toBinaryString(n);
            for (int i = 0; i <nToBinaryString.length() ; i++) {
                if (nToBinaryString.charAt(i) == '1') {
                    nOneCount++;
                }
            }
            int size = nToBinaryString.length();

            if (nOneCount == size) {
                return 0;
            }

            return combination(size-1, nOneCount);
        }
        public static int combination(int n, int r) {
            if(n == r || r == 0) {
                return 1;
            }

            return combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }
}
