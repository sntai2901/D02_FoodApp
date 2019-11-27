package AccountTracker

import DAO.AccountDatabaseDao
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException


class AccountTrackerViewModelFactory(
    private val dataSource: AccountDatabaseDao,
    private val application: Application):ViewModelProvider.Factory{
    @Suppress("uncheck_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AccountTrackerViewModel::class.java)){
            return (AccountTrackerViewModel(dataSource,application)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
