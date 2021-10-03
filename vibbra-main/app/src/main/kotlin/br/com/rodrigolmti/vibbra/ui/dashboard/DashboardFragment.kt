package br.com.rodrigolmti.vibbra.ui.dashboard

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.rodrigolmti.vibbra.R
import br.com.rodrigolmti.vibbra.core.extensions.hide
import br.com.rodrigolmti.vibbra.core.extensions.show
import br.com.rodrigolmti.vibbra.core.view_binding_delegate.viewBinding
import br.com.rodrigolmti.vibbra.databinding.FragmentDashboardBinding
import br.com.rodrigolmti.vibbra.domain.model.Deal
import br.com.rodrigolmti.vibbra.ui.MainActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val tokenSource: CancellationTokenSource = CancellationTokenSource()
    var fusedLocationClient: FusedLocationProviderClient? = null

    private val viewModel: DashboardViewModel by viewModels()

    private val binding by viewBinding {
        FragmentDashboardBinding.inflate(layoutInflater)
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                getUserLocation()
            } else {
                dispatchAllDeals()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkLocationPermission()
        setupRecyclerView()
        observeChanges()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        fusedLocationClient = null
        tokenSource.cancel()
    }

    private fun checkLocationPermission() {
        (activity as? MainActivity)?.let {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(it)
            when {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED -> {
                    getUserLocation()
                }
                shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)
                -> {
                    dispatchAllDeals()
                }
                else -> {
                    requestPermissionLauncher.launch(
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun getUserLocation() {
        fusedLocationClient?.getCurrentLocation(
            LocationRequest.PRIORITY_HIGH_ACCURACY,
            tokenSource.token
        )
            ?.addOnSuccessListener {
                dispatchWithLatLong(it)
            }
            ?.addOnFailureListener {
                dispatchAllDeals()
            }
            ?.addOnFailureListener {
                dispatchAllDeals()
            }
            ?.addOnCanceledListener {
                dispatchAllDeals()
            }
    }

    private fun dispatchAllDeals() {
        viewModel.dispatchViewAction(
            DashboardAction.GetAllDeals
        )
    }

    private fun dispatchWithLatLong(it: Location?) {
        viewModel.dispatchViewAction(
            DashboardAction.GetDealsWithLatLong(
                longitude = it?.longitude ?: 0.0,
                latitude = it?.latitude ?: 0.0,
            )
        )
    }

    private fun observeChanges() {
        viewModel.viewState.state.observe(viewLifecycleOwner, { state ->
            when (state) {
                DashboardViewState.State.IDLE -> {
                    binding.progressBar.hide()
                    binding.recyclerView.show()
                }
                DashboardViewState.State.LOADING -> {
                    binding.progressBar.show()
                    binding.recyclerView.hide()
                }
            }
        })
        viewModel.viewState.action.observe(viewLifecycleOwner, { action ->
            when (action) {
                is DashboardViewState.Action.RenderDealsList -> {
                    setupAdapter(action.deals)
                }
                DashboardViewState.Action.ShowError -> {
                    //TODO: Implement error feedback
                }
            }
        })
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            val dividerItemDecoration = DividerItemDecoration(
                binding.recyclerView.context,
                LinearLayoutManager.VERTICAL
            )
            ContextCompat.getDrawable(requireContext(), R.drawable.item_divisor)?.let { drawable ->
                dividerItemDecoration.setDrawable(drawable)
            }
            binding.recyclerView.addItemDecoration(dividerItemDecoration)
        }
    }

    private fun setupAdapter(deals: List<Deal>) {
        binding.recyclerView.apply {
            adapter = DealsAdapter(
                deals = deals
            )
        }
    }
}