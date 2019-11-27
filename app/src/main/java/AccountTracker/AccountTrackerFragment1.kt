package AccountTracker

import DAO.AccountDatabaseDao
import Data.AccountDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.d02_foodapp.R
import com.example.d02_foodapp.databinding.FragmentAccountTrackerBinding

class AccountTrackerFragment1 : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentAccountTrackerBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_account_tracker,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = AccountDatabase.getInstance(application).accountDatabaseDao
        val viewModelFactory = AccountTrackerViewModelFactory(dataSource,application)
        val accountTrackerViewModel = ViewModelProviders.of(this,viewModelFactory).get(AccountTrackerViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.accountTrackerViewModel = accountTrackerViewModel
        return binding.root



    }
}