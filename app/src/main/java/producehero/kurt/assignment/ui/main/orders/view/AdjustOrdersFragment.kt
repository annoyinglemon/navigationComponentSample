package producehero.kurt.assignment.ui.main.orders.view

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import producehero.kurt.assignment.R
import producehero.kurt.assignment.databinding.FragmentOrderAdjustBinding

class AdjustOrdersFragment: Fragment() {

    private var quantity = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewBinding = DataBindingUtil.inflate<FragmentOrderAdjustBinding>(inflater, R.layout.fragment_order_adjust, container, false)
        viewBinding.lifecycleOwner = viewLifecycleOwner

        val adjustFragmentArgs: AdjustOrdersFragmentArgs by navArgs()
        val orderItem = adjustFragmentArgs.orderItem
        quantity = orderItem.quantity

        viewBinding.orderItem = orderItem
        viewBinding.quantity = quantity.toString()

        viewBinding.buttonAdjustAdd.setOnClickListener {
            quantity++
            viewBinding.quantity = quantity.toString()
        }

        viewBinding.buttonAdjustDeduct.setOnClickListener {
            if (quantity > 1) {
                quantity--
                viewBinding.quantity = quantity.toString()
            }
        }

        setHasOptionsMenu(true)

        return viewBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_adjust_order, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_item_order_save){
            findNavController().popBackStack()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}