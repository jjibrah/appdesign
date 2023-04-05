package com.example.morningintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.morningintents.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

// Add a marker in Sydney and move the camera
        val nairobi = LatLng(-1.2664725, 36.8008932)
        mMap.addMarker(MarkerOptions().position(nairobi).title("Marker in Nairobi"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nairobi))

        val mombasa = LatLng(-4.0348342, 39.5261735)
        mMap.addMarker(MarkerOptions().position(mombasa).title("Marker in mombasa"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mombasa))

        val kisumu = LatLng(-0.0746293, 34.5980788)
        mMap.addMarker(MarkerOptions().position(kisumu).title("Marker in kisumu"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kisumu))
    }
}