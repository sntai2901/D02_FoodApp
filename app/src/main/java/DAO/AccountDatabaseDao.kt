package DAO

import Data.Account
import androidx.room.*

@Dao
interface AccountDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(acc:Account)
    @Update
    fun update(acc: Account)
    @Query("SELECT * FROM account_table WHERE email_acc = :email and password_acc = :password")
    fun getAcc(email:String,password:String):Account?
    @Query("DELETE FROM account_table")
    fun clear()
    @Query("SELECT * FROM account_table ORDER BY id DESC")
    fun getAllAcc():List<Account>
}