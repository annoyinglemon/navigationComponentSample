package producehero.kurt.assignment.ui.main.establishments.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import producehero.kurt.assignment.ui.main.establishments.viewmodel.EstablishmentsViewModel


class EstablishmentsFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewBinding = DataBindingUtil.inflate<FragmentListBinding>(inflater, R.layout.fragment_list, container, false)
        viewBinding.recyclerViewList.layoutManager = LinearLayoutManager(activity)
        viewBinding.recyclerViewList.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))

        val interactor = (activity as MainActivity).createEstablishmentsInteractor()
        val viewModelFactory = EstablishmentsViewModel.Factory(interactor)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(EstablishmentsViewModel::class.java)

        val adapter = EstablishmentsAdapter()
        viewBinding.recyclerViewList.adapter = adapter

        viewModel.establishments.observe(viewLifecycleOwner, Observer {
            adapter.establishments = it
        })

        val cityNameArgs: EstablishmentsFragmentArgs by navArgs()
        viewModel.getEstablishments(cityNameArgs.cityName)

        return viewBinding.root
    }

}