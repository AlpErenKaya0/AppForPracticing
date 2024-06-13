package com.alperen.appforpracticing.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LocalDBDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(dbtable: LocalDBTable)
    //oluşturduğumuz entity tipinde bir livedata olması lazım
    //tüm veri çekiliyor, ilgili veri değil
    @Query(value="SELECT * FROM dbtable ORDER BY id ASC ")
    fun readAllData(): LiveData<List<LocalDBTable>>
    //Conflict strategy'si önemli! şu anlık ignore

    //delete update gibi işlemlerin yapılabilmesi için primary key lazım
    @Delete
    suspend fun deleteUser(dbtable: LocalDBTable)
    @Query("DELETE FROM dbtable")
    suspend fun deleteAllUsers()
    @Query("SELECT * FROM dbtable WHERE dummyDataThree BETWEEN 30 AND 40 ORDER BY id ASC")
    fun getUsersBetween30And40(): LiveData<List<LocalDBTable>>

    //alttakinde :name yazısına bak neymiş ne değilmiş
    @Query("SELECT * FROM dbtable WHERE dummyDataTwo = :name")
    //thread bloklamamak için livedata içinde dönecek
    fun getUsersByName(name: String): LiveData<List<LocalDBTable>>

}