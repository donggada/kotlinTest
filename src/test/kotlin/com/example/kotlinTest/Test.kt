package com.example.kotlinTest

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Test {


    @Test
    fun test() {
        Assertions.assertThat(
            Solution().solution(
                sequence =  intArrayOf(1, 2, 3, 4, 5),
                k = 7,
            )
        ).isEqualTo(intArrayOf(2, 3))

        Assertions.assertThat(
            Solution().solution(
                sequence =  intArrayOf(1, 1, 1, 2, 3, 4, 5),
                k = 5,
            )
        ).isEqualTo(intArrayOf(6, 6))

        Assertions.assertThat(
            Solution().solution(
                sequence =  intArrayOf(2, 2, 2, 2, 2),
                k = 6,
            )
        ).isEqualTo(intArrayOf(0, 2))
    }

    class Solution {
        fun solution(sequence: IntArray, k: Int): IntArray {
            var answer: IntArray = intArrayOf()
            val size : Int = sequence.size
            var temp : Array<IntArray> = Array(size) { IntArray(size) }

            for ((x) in sequence.withIndex()) {
                var sumValue = 0
                var intArray = IntArray(size)
                for (yValue in x..size) {
                    sumValue += yValue
                    intArray[x] = sumValue
                }
                temp[x] = intArray
            }

            println(temp)


            return answer
        }
    }
}


