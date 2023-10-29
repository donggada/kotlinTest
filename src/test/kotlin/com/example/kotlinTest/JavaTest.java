package com.example.kotlinTest;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest {

  @Test
    void test() {
      Solution solution = new Solution();
      Assertions.assertThat(
          solution.solution(new int[]{1, 2, 3, 4, 5},7)
      ).isEqualTo(new int[]{2, 3});
//

      Assertions.assertThat(
          solution.solution(new int[]{1, 1, 1, 2, 3, 4, 5},5)
      ).isEqualTo(new int[]{6, 6});

      Assertions.assertThat(
          solution.solution(new int[]{2, 2, 2, 2, 2},6)
      ).isEqualTo(new int[]{0, 2});

  }

    class Solution {
        public int[] solution(int[] sequence, int k) {
            int left = 0;
            int sum = 0;
            int size = sequence.length;
            int ans1 = 0;
            int ans2 = 0;

            for(int right=0; right < sequence.length; right++) {
                sum += sequence[right];

                while(sum > k) {
                    sum -= sequence[left];
                    left++;
                }

                if(sum == k) {
                    if(size > right-left) {
                        size = right-left;
                        ans1 = left;
                        ans2 = right;
                    } else if(size == right-left) {
                        ans1 = Math.min(ans1, left);
                        ans2 = Math.min(ans2, right);
                    }
                }

            }

            return new int[] {ans1, ans2};
        }
    }

}
