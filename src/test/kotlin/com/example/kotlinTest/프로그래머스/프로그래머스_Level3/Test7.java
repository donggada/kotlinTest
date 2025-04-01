package com.example.kotlinTest.프로그래머스.프로그래머스_Level3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Test7 {
    Solution solution = new Solution();

    @Test
    void case1() {
        Assertions.assertThat(
                solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"})
        ).isEqualTo(
              2
        );

    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"})
        ).isEqualTo(
                2
        );

    }

    @Test
    void case3() {
        Assertions.assertThat(
                solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"})
        ).isEqualTo(
                3
        );

    }


    class Solution {
        static HashSet<HashSet<String>> result;
        public int solution(String[] user_id, String[] banned_id) {
            result = new HashSet<>();
            dfs(0, new HashSet<>(), user_id, banned_id);
            return result.size();
        }

        private void dfs(int depth, HashSet<String> set, String[] user_id, String[] banned_id) {
            if (banned_id.length == depth) {
                result.add(set);
                return;
            }

            for (String id : user_id) {
                if (set.contains(id)) {
                    continue;
                }

                if (check(id, banned_id[depth])) {
                    set.add(id);
                    dfs(depth + 1, new HashSet<>(set), user_id, banned_id);
                    set.remove(id);
                }
            }
        }

        private boolean check (String userId, String bannedId) {
            if (userId.length() != bannedId.length()) {
                return false;
            }

            for (int i = 0; i <bannedId.length() ; i++) {
                char bannedIdChar = bannedId.charAt(i);
                char userIdChar = userId.charAt(i);
                if (bannedIdChar == '*') {
                    continue;
                }

                if (bannedIdChar != userIdChar) {
                    return false;
                }
            }

            return true;
        }
    }




}
