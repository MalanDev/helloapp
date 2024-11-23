package lk.malanadev.helloapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import lk.malanadev.helloapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val customerViewModel: CustomerViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: FragmentStateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        customerViewModel.getCustomerData()


        customerViewModel.customerData.observe(this, Observer<Customer> {data->{
            var name = data.name

        }  })

        adapter = CustomerPageAdapter(supportFragmentManager,lifecycle)



        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Book"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Music"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Audio"))

        binding.viewPager.adapter = adapter

        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())

        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position->
            tab.text = "Tab ${position + 1}"
        }.attach()



    }


}