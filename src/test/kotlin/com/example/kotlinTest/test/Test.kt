package com.example.kotlinTest.test
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class Test(
    // // // """
// // // DB 구조
// // // DESCRIBE TAGGER_M;
// // // +---------+--------------+------+-----+---------+-------+
// // // |  Field  |     Type     | Null | Key | Default | Extra |
// // // +---------+--------------+------+-----+---------+-------+
// // // |   ID    |     int      |  NO  | PRI |  NULL   |       | <-----+
// // // | NAME_EN | varchar(255) | YES  |     |  NULL   |       |     | |
// // // | NAME_KO | varchar(255) | YES  |     |  NULL   |       |     | |
// // // | NAME_ZH | varchar(255) | YES  |     |  NULL   |       |     | |
// // // | NAME_JA | varchar(255) | YES  |     |  NULL   |       |     | |
// // // +---------+--------------+------+-----+---------+-------+     | |
// // //                                                               | |
// // // DESCRIBE TAGGER_R;                                            | |
// // // +-------------+------+------+-----+---------+-------+         | |
// // // |    Field    | Type | Null | Key | Default | Extra |         | |
// // // +-------------+------+------+-----+---------+-------+         | |
// // // | CATEGORY_ID | int  | YES  | MUL |   NULL  |       |---------+ |
// // // | ITEM_ID     | int  | YES  | MUL |   NULL  |       |-----------+
// // // +-------------+------+------+-----+---------+-------+
// // // """


 ) {

    fun main() {
        listOf(TaggerR())


    }

    data class TaggerM(
        val categoryId: Long = 0,
        val itemId: String? = null,

        )

    data class TaggerR(
        val id: Long = 0,
        val nameEn: String? = null,
        val nameKo: String? = null,
        val nameZh: String? = null,
        val nameJa: String? = null,
    )

}


