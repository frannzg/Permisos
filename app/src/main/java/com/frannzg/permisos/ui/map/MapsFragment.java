package com.frannzg.permisos.ui.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frannzg.permisos.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng placaMercadal = new LatLng(41.78995923181629, 0.8052401111922499);
            googleMap.addMarker(new MarkerOptions().position(placaMercadal).title("Punt Plaça Mercadal"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(placaMercadal));

            LatLng placaSantSalvador = new LatLng(41.791864851809954, 0.8062842243953691);
            googleMap.addMarker(new MarkerOptions().position(placaSantSalvador).title("Punt Plaça Sant Salvador"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(placaSantSalvador));

            LatLng placaLluisCompanys = new LatLng(41.79189222009008, 0.8113954095619912);
            googleMap.addMarker(new MarkerOptions().position(placaLluisCompanys).title("Plaça Lluís Companys"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(placaLluisCompanys));

            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}