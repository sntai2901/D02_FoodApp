package Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="account_table")
data class Account (
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,
    @ColumnInfo(name = "email_acc")
    var email:String = "",
    @ColumnInfo(name = "password_acc")
    var password:String ="",
    @ColumnInfo(name = "first_name_acc")
    var fname:String ="",
    @ColumnInfo(name = "last_name_acc")
    var lname:String ="",
    @ColumnInfo(name = "time_reg_acc")
    var time:Long = System.currentTimeMillis())