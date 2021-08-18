package com.example.googlemaps

import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Build.VERSION_CODES.LOLLIPOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.googlemaps.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition

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

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val LATLNG = LatLng(37.566418,126.977943)  //LATLNG 는 하나의 위경도 좌표를 나타내는 클래스임.


        val cameraPosition = CameraPosition.Builder()
            .target(LATLNG)
            .zoom(15.0f)
            .build()
        val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
        mMap.moveCamera(cameraUpdate)


        var bitmapDrawable : BitmapDrawable
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            bitmapDrawable = getDrawable(R.drawable.marker) as BitmapDrawable
        }else{
            bitmapDrawable = resources.getDrawable(R.drawable.marker) as BitmapDrawable
        }
        var discriptor = BitmapDescriptorFactory.fromBitmap(bitmapDrawable.bitmap)

        val markerOptions = MarkerOptions()
            .position(LATLNG)
            .icon(discriptor)
        mMap.addMarker(markerOptions)
    }
}