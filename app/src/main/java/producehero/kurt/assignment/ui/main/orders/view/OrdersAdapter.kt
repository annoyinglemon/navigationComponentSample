package producehero.kurt.assignment.ui.main.orders.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import producehero.kurt.assignment.R
import producehero.kurt.assignment.databinding.ItemOrderBinding
import producehero.kurt.assignment.model.entity.OrderItem


class OrdersAdapter: RecyclerView.Adapter<OrdersAdapter.EstablishmentsViewHolder>() {

    var orderItems: List<OrderItem>? = null
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstablishmentsViewHolder {
        val itemRouteBinding = DataBindingUtil.inflate<ItemOrderBinding>(LayoutInflater.from(parent.context), R.layout.item_order, parent, false)
        return EstablishmentsViewHolder(itemRouteBinding)
    }

    override fun getItemCount(): Int {
        return orderItems?.size ?: 0
    }

    override fun onBindViewHolder(holder: EstablishmentsViewHolder, position: Int) {
        val orderItem = orderItems!![position]
        holder.orderBinding.item = orderItem

        holder.orderBinding.buttonItemOrderAdjust.setOnClickListener {
            val direction = OrdersFragmentDirections
                .actionOrdersFragmentToAdjustOrdersFragment(orderItem)
            holder.itemView.findNavController().navigate(direction)
        }

    }

    data class EstablishmentsViewHolder(val orderBinding: ItemOrderBinding): RecyclerView.ViewHolder(orderBinding.root)

}