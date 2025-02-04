package com.example.kotlinTest.잡다;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test2 {
    Solution solution = new Solution();

//    @Test
//    void case1() {
//        Assertions.assertThat(
//                solution.solution(new String[]{"A", "B", "C"},
//                        new String[][]{
//                                {"A", "ARTICLE"},
//                                {"A", "ALARM"},
//                                {"B", "ARTICLE"},
//                                {"C", "ALARM"},
//                                {"B", "ARTICLE"}
//                        })
//        ).isEqualTo(
//                new int[]{0,1,2}
//        );
//    }

//    @Test
//    void case2() {
//        Assertions.assertThat(
//                solution.solution(new String[]{"A", "B", "C"},
//                        new String[][]{
//                                {"A", "ARTICLE", "1"}, {"A", "ALARM"},
//                                {"B", "ARTICLE", "2"}, {"C", "ALARM"},
//                                {"B", "ARTICLE", "3"},
//                                {"B", "COMMENT", "4", "2"},{"A", "ALARM"},
//                                {"B", "COMMENT", "5", "1"}
//                        })
//        ).isEqualTo(
//                new int[]{1,1,2}
//        );
//    }

    @Test
    void case2() {
        Assertions.assertThat(
                solution.solution(new String[]{"A", "B", "C"},
                        new String[][]{
                                {"A", "ARTICLE", "1"}, {"A", "ALARM", "ARTICLE"},
                                {"B", "ARTICLE", "2"}, {"C", "ALARM", "ARTICLE"},
                                {"B", "ARTICLE", "3"},
                                {"B", "COMMENT", "4", "1"},{"A", "ALARM", "COMMENT"},
                                {"B", "COMMENT", "5", "1"}
                        })
        ).isEqualTo(
                new int[]{1,1,2}
        );
    }

    class Solution {
        static HashMap<String, Integer> countMap;
        static HashMap<String, Map<String, Boolean>> alarmMap;
        static HashMap<String, Set<String>> articleMap;
        public int[] solution(String[] Members, String[][] Logs) {
            int len = Members.length;
            int[] answer = new int[len];
            countMap = new HashMap<>();
            alarmMap = new HashMap<>();
            articleMap = new HashMap<>();
            for (String m : Members) {
                countMap.put(m,0);
                alarmMap.put(m,new HashMap<>());
            }

            for (String[] log :Logs) {
                String member = log[0];
                String action = log[1];

                switch (action) {
                    case "ALARM" -> {
                        addAlarm(log[2], member);
                    }
                    case "ARTICLE" -> {
                        addArticle(log[2], member);
                        noticeArticle(member);
                    }
                    case "COMMENT" -> {
                        String articleId = log[3];
                        addArticle(articleId, member);
                        noticeComment(articleId, member);
                    }
                }

                switch (action) {
                    case "ALARM" -> {
                        addAlarm(log[2], member);
                    }
                    case "ARTICLE" -> {
                        addArticle(log[2], member);
                        noticeArticle(member);
                    }
                    case "COMMENT" -> {
                        String articleId = log[3];
                        addArticle(articleId, member);
                        noticeComment(articleId, member);
                    }

                }

            }

            for (int i = 0; i < len ; i++) {
                answer[i] = countMap.get(Members[i]);
            }

            return answer;
        }

        private void noticeArticle(String member) {
            for (String m :countMap.keySet()) {
                if (!m.equals(member)) {
                    if (alarmMap.get(m).getOrDefault("ARTICLE", true)) {
                        countMap.put(m, countMap.get(m)+1);
                    }
                }
            }
        }

        private void noticeComment(String articleId ,String member) {
            for (String m : articleMap.get(articleId)) {
                if (!m.equals(member)) {
                    if (alarmMap.get(m).getOrDefault("COMMENT", true)) {
                        countMap.put(m, countMap.get(m)+1);
                    }
                }
            }
        }

        private void addArticle(String articleId, String member) {
            Set<String> set = articleMap.getOrDefault(articleId, new HashSet<>());
            set.add(member);
            articleMap.put(articleId, set);
        }

        private void addAlarm(String target, String member) {
            Map<String, Boolean> map = alarmMap.get(member);
            map.put(target, map.getOrDefault(target, false));
            alarmMap.put(member, map);
        }
    }
}


