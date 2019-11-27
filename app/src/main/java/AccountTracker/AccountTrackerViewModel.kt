package AccountTracker

import DAO.AccountDatabaseDao
import Data.Account
import Data.AccountDatabase
import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import okhttp3.Dispatcher


class AccountTrackerViewModel (val database : AccountDatabaseDao, application: Application):AndroidViewModel(application){
    private var viewModelJob = Job()
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    private val uiScope = CoroutineScope(Dispatchers.Main+viewModelJob)
    private var thisAcc = MutableLiveData<Account?>()
    init{
        initializeThisAcc()
    }
    private fun initializeThisAcc(){
        uiScope.launch { thisAcc.value = getThisAccFromDatabase() }
    }
    private suspend fun getThisAccFromDatabase(email:String,password:String): Account?{
        return withContext(Dispatchers.IO){
            var acc = database.getAcc(email,password)?
            acc
        }
    }
    fun onStartTracking(){
        uiScope.launch {
            val newAcc =Account()
            insert(newAcc)
            thisAcc.value = getThisAccFromDatabase()
        }
    }
}