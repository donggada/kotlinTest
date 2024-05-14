package com.example.kotlinTest.프로그래머스_탐욕법;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaTest1 {

    @Test
    void test() {
        Solution solution = new Solution();

        Assertions.assertThat(
            solution.solution("JEROEN")
        ).isEqualTo(
            56
        );

        Assertions.assertThat(
                solution.solution("JAN")
        ).isEqualTo(
                23
        );

        Assertions.assertThat(
                solution.solution("JAZ")
        ).isEqualTo(
                11
        );


    }

    class Solution {
        public int solution(String name) {
            int answer = 0;
            int abs = 'Z' - 'A';
            int len = name.length();
            int move = len - 1;

            for (int i = 0; i < len; i++) {
                int gap = name.charAt(i) - 'A';

                int count = Math.min(gap, abs - gap + 1);

                answer += count;

                // 이로직은 아직 이해 불가
                int index = i + 1;
                // 연속되는 A 갯수 확인
                while (index < len && name.charAt(index) == 'A') {
                    index++;
                }
                // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
                move = Math.min(move, i * 2 + len - index);
                // 2022년 이전 테스트 케이스만 확인하면 여기까지해도 정답처리가 되기 때문에, 이전 정답들에는 여기까지만 정리되어 있지만,
                // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
                move = Math.min(move, (len - index) * 2 + i);

            }

            return answer + move;
        }
    }

}
