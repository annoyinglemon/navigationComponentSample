package producehero.kurt.assignment.ui.main.routes.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import producehero.kurt.assignment.R
import producehero.kurt.assignment.databinding.ItemRouteBinding
import producehero.kurt.assignment.model.entity.Route

class RoutesAdapter: RecyclerView.Adapter<RoutesAdapter.RouteViewHolder>() {

    var routes: List<Route>? = null
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        val itemRouteBinding = DataBindingUtil.inflate<ItemRouteBinding>(LayoutInflater.from(parent.context), R.layout.item_route, parent, false)
        return RouteViewHolder(itemRouteBinding)
    }

    override fun getItemCount(): Int {
       return routes?.size ?: 0
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        val route = routes!![position]

        holder.itemRouteBinding.route = route
        holder.itemView.setOnClickListener {
            val direction = RoutesFragmentDirections
                .actionRoutesFragmentToEstablishmentsFragment(route.cityName)
            it.findNavController().navigate(direction)
        }
    }

    data class RouteViewHolder(val itemRouteBinding: ItemRouteBinding): RecyclerView.ViewHolder(itemRouteBinding.root)

}