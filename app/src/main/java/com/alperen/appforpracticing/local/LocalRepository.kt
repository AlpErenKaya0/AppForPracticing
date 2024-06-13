package com.alperen.appforpracticing.local

import androidx.lifecycle.LiveData
//aşağıda users ismini değiştirebiliriz
class LocalRepository (private val LocalDBDao:LocalDBDao) {
    val readAllDummy : LiveData<List<LocalDBTable>> = LocalDBDao.readAllData()
    suspend fun addDummy(localdbtable:LocalDBTable)
    {
        LocalDBDao.addUser(localdbtable)
    }
    suspend fun deleteUser(localdbtable:LocalDBTable){
        LocalDBDao.deleteUser(localdbtable)
    }
    fun getUsersBetween30And40(): LiveData<List<LocalDBTable>> {
        return LocalDBDao.getUsersBetween30And40()
    }
    fun getUsersByName(name: String): LiveData<List<LocalDBTable>> {
        return LocalDBDao.getUsersByName(name)
    }
    suspend fun deleteAllUsers() {
        LocalDBDao.deleteAllUsers()
    }
}