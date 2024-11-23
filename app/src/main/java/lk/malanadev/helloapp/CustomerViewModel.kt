package lk.malanadev.helloapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomerViewModel: ViewModel() {

    private val _customerData = MutableLiveData<Customer>()
    val customerData: LiveData<Customer> = _customerData



    fun getCustomerData() {
        //set customer data from API
        //_customerData.value = customer;
    }


    fun filterCustomerData(paramter:String){

    }

}