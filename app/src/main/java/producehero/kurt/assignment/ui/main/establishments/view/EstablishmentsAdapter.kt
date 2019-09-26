package producehero.kurt.assignment.ui.main.establishments.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import producehero.kurt.assignment.R
import producehero.kurt.assignment.databinding.ItemEstablishmentBinding
import producehero.kurt.assignment.model.entity.Establishment
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri


class EstablishmentsAdapter: RecyclerView.Adapter<EstablishmentsAdapter.EstablishmentsViewHolder>() {

    var establishments: List<Establishment>? = null
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstablishmentsViewHolder {
        val itemEstablishmentBinding = DataBindingUtil.inflate<ItemEstablishmentBinding>(LayoutInflater.from(parent.context), R.layout.item_establishment, parent, false)
        return EstablishmentsViewHolder(itemEstablishmentBinding)
    }

    override fun getItemCount(): Int {
        return establishments?.size ?: 0
    }

    override fun onBindViewHolder(holder: EstablishmentsViewHolder, position: Int) {
        val establishment = establishments!![position]
        holder.itemEstablishmentBinding.establishment = establishment
        // todo implement item onclick here to open orders fragment
        holder.itemView.setOnClickListener {
            val direction = EstablishmentsFragmentDirections
                .actionEstablishmentsFragmentToOrdersFragment(establishment.name)
            it.findNavController().navigate(direction)
        }

        holder.itemEstablishmentBinding.buttonMap.setOnClickListener {
            val intentUri = Uri.parse("google.navigation:q=${establishment.coordinates.lat},${establishment.coordinates.long}")
            val mapIntent = Intent(Intent.ACTION_VIEW, intentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(it.context.packageManager) != null) {
                startActivity(it.context, mapIntent, null)
            }
        }
    }


    data class EstablishmentsViewHolder(val itemEstablishmentBinding: ItemEstablishmentBinding): RecyclerView.ViewHolder(itemEstablishmentBinding.root)

}