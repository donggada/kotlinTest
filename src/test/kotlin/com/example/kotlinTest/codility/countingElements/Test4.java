package com.example.kotlinTest.codility.countingElements;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

public class Test4 {
    private final Solution solution = new Solution();
    
    @Test
    void case1() {
        Assertions.assertThat(solution.solution(new int[]{1, 3, 6, 4, 1, 2})).isEqualTo(5);
    }

    @Test
    void case2() {
        Assertions.assertThat(solution.solution(new int[]{1, 2, 3})).isEqualTo(4);
    }

    @Test
    void case3() {
        Assertions.assertThat(solution.solution(new int[]{-1, -3})).isEqualTo(1);
    }

    static class Solution {
        public int solution(int[] numbers) {
            Set<Integer> positiveNumbers = collectPositiveNumbers(numbers);
            
            if (positiveNumbers.isEmpty()) {
                return 1;
            }
            
            return findSmallestMissingPositive(positiveNumbers, numbers.length);
        }
        
        private Set<Integer> collectPositiveNumbers(int[] numbers) {
            Set<Integer> positiveNumbers = new HashSet<>();
            for (int number : numbers) {
                if (number > 0) {
                    positiveNumbers.add(number);
                }
            }
            return positiveNumbers;
        }
        
        private int findSmallestMissingPositive(Set<Integer> positiveNumbers, int arrayLength) {
            for (int i = 1; i <= arrayLength; i++) {
                if (!positiveNumbers.contains(i)) {
                    return i;
                }
            }
            return arrayLength + 1;
        }
    }
}
