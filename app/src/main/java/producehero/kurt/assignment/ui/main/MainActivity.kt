package producehero.kurt.assignment.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import producehero.kurt.assignment.R
import producehero.kurt.assignment.databinding.ActivityMainBinding
import producehero.kurt.assignment.datasource.DataSource
import producehero.kurt.assignment.model.interactor.EstablishmentsInteractor
import producehero.kurt.assignment.model.interactor.OrdersInteractor
import producehero.kurt.assignment.model.interactor.RoutesInteractor
import producehero.kurt.assignment.model.interactor_impl.EstablishmentsInteractorImpl
import producehero.kurt.assignment.model.interactor_impl.OrdersInteractorImpl
import producehero.kurt.assignment.model.interactor_impl.RoutesInteractorImpl

class MainActivity : AppCompatActivity() {

    private val dataSource: DataSource by lazy {
        DataSource()
    }

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        navController = findNavController(R.id.navFragment_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        setSupportActionBar(viewBinding.toolbarMain)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    fun createRoutesInteractor(): RoutesInteractor {
        return RoutesInteractorImpl(dataSource)
    }

    fun createEstablishmentsInteractor(): EstablishmentsInteractor {
        return EstablishmentsInteractorImpl(dataSource)
    }

    fun createOrdersInteractor(): OrdersInteractor {
        return OrdersInteractorImpl(dataSource)
    }

}
