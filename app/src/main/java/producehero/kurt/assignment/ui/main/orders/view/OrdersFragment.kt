package producehero.kurt.assignment.ui.main.orders.view

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import producehero.kurt.assignment.R
import producehero.kurt.assignment.databinding.FragmentListBinding
import producehero.kurt.assignment.ui.main.MainActivity
import producehero.kurt.assignment.ui.main.orders.viewmodel.OrdersViewModel
import producehero.kurt.assignment.ui.sign.view.SignatureActivity

class OrdersFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewBinding = DataBindingUtil.inflate<FragmentListBinding>(inflater, R.layout.fragment_list, container, false)
        viewBinding.recyclerViewList.layoutManager = LinearLayoutManager(activity)
        viewBinding.recyclerViewList.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))

        val interactor = (activity as MainActivity).createOrdersInteractor()
        val viewModelFactory = OrdersViewModel.Factory(interactor)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(OrdersViewModel::class.java)

        val adapter = OrdersAdapter()
        viewBinding.recyclerViewList.adapter = adapter

        viewModel.orderItems.observe(viewLifecycleOwner, Observer {
            adapter.orderItems = it
        })

        val estabNameArgs: OrdersFragmentArgs by navArgs()
        viewModel.getOrders(estabNameArgs.establishmentName)

        setHasOptionsMenu(true)

        return viewBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_orders, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_orders_sign){
            startActivity(Intent(activity, SignatureActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}