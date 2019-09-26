package producehero.kurt.assignment.ui.main.routes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import producehero.kurt.assignment.R
import producehero.kurt.assignment.databinding.FragmentListBinding
import producehero.kurt.assignment.ui.main.MainActivity
import producehero.kurt.assignment.ui.main.routes.viewmodel.RoutesViewModel


class RoutesFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewBinding = DataBindingUtil.inflate<FragmentListBinding>(inflater, R.layout.fragment_list, container, false)
        viewBinding.recyclerViewList.layoutManager = LinearLayoutManager(activity)
        viewBinding.recyclerViewList.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))

        val interactor = (activity as MainActivity).createRoutesInteractor()
        val viewModelFactory = RoutesViewModel.Factory(interactor)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(RoutesViewModel::class.java)

        val adapter = RoutesAdapter()
        viewBinding.recyclerViewList.adapter = adapter

        viewModel.routesList.observe(viewLifecycleOwner, Observer {
            adapter.routes = it
        })

        viewModel.getRoutes()


        return viewBinding.root
    }

}