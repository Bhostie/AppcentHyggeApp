import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.hyggeapp.barisgokmen.R
import com.hyggeapp.barisgokmen.databinding.FragmentLocationBinding
import com.hyggeapp.barisgokmen.ui.fragments.base.BaseFragment

class LocationFragment : BaseFragment<FragmentLocationBinding>(), OnMapReadyCallback {
    private lateinit var mapView: MapView
    private lateinit var mMap: GoogleMap

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLocationBinding {
        return FragmentLocationBinding.inflate(inflater, container, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = setBinding(inflater, container, savedInstanceState).root
        mapView = rootView.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        mapView.getMapAsync(this)
        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        serMarkers()
    }
    override fun initialize() {
        // Nothing to do here
    }

    private fun serMarkers() {
        val locations = getLocations()

        for (location in locations) {
            val marker = MarkerOptions()
            marker.position(location)
            marker.title("Location")
            marker.snippet("This is location ${location.latitude}")
            marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
            mMap.addMarker(marker)
        }
    }

    /**
     * Getting location information is normally done by the repository, but
     * since we don't have an actual dataset for the locations, I replicated
     * and gave dummy data here.
     */
    private fun getLocations(): List<LatLng> {
        val locations = mutableListOf<LatLng>()
        locations.add(LatLng(56.3245, 23.2345))
        locations.add(LatLng(56.3255, 23.2345))
        locations.add(LatLng(56.3265, 23.2355))
        locations.add(LatLng(56.3275, 23.2355))
        locations.add(LatLng(56.3285, 23.2355))
        return locations
    }

}