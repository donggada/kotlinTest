package com.example.kotlinTest.kakao2019;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 후보키 {

    @Test
    void test() {
        Solution solution = new Solution();
        Assertions.assertThat(
                solution.solution(
                        new String[][]{
                                {"100","ryan","music","2"}, {"200","apeach","math","2"},
                                {"300","tube","computer","3"}, {"400","con","computer","4"},
                                {"500","muzi","music","3"}, {"600","apeach","music","2"}}
                )
        ).isEqualTo(
                2
        );
    }

    class Solution {
        static int len;
        static HashSet<String> keySet;
        static boolean[] noKey;
        static boolean[] visit;
        public int solution(String[][] relation) {
            len = relation.length;
            noKey = new boolean[4];
            visit = new boolean[4];

            keySet = new HashSet<>();

            for (int i = 0; i < len ; i++) {
                for (int j = 0; j <relation[i].length ; j++) {
                    dfs(relation[i], "", 0);
                }
            }

            System.out.println(Arrays.toString(noKey));

            return 0;
        }

        private void dfs(String[] relation, String key, int depth) {
            if (depth > 4) {
                return;
            }

            for (int i = depth; i < 4 ; i++) {
                if (!visit[i]) {
                    visit[i] = true;

                    String creatKey = key + relation[i];
                    keySet.add(creatKey);

                    dfs(relation , creatKey, depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
