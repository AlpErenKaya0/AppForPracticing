package com.alperen.appforpracticing.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dbtable")
data class LocalDBTable (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    val dummyData:String,
    val dummyDataTwo:String,
    val dummyDataThree:Int)