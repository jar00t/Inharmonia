package id.inharmonia.app.Store.Tool;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;

public class StoreFinderFilterActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    @BindView(R.id.ib_button_back)
    ImageButton ib_button_back;

    GoogleMap mMap;
    PlaceAutocompleteFragment autocompleteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_finder_filter);

        ButterKnife.bind(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.getView().findViewById(R.id.place_autocomplete_search_button).setVisibility(View.GONE);
        ((EditText)autocompleteFragment.getView().findViewById(R.id.place_autocomplete_search_input)).setTextSize(14.0f);
        ((EditText)autocompleteFragment.getView().findViewById(R.id.place_autocomplete_search_input)).setHint("Cari Area Lokasi Percetakan...");
        ((EditText)autocompleteFragment.getView().findViewById(R.id.place_autocomplete_search_input)).setTypeface(ResourcesCompat.getFont(this, R.font.comfortaa_regular));

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                LatLng selected_location = place.getLatLng();
                mMap.addMarker(new MarkerOptions().position(selected_location));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(selected_location));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(selected_location, 16));
            }

            @Override
            public void onError(Status status) {

            }
        });

        autocompleteFragment.setFilter(new AutocompleteFilter.Builder().setCountry("ID").build());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLongClickListener(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            FusedLocationProviderClient mFusedLocation = LocationServices.getFusedLocationProviderClient(this);
            mFusedLocation.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null){
                        LatLng user_location = new LatLng(location.getLatitude(), location.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(user_location));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(user_location));
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(user_location, 16));
                    }
                }
            });
        }
    }

    @Override
    public void onMapLongClick(LatLng position) {
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(position));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position, 16));

        autocompleteFragment.setText("Bandung");
    }

    @OnClick(R.id.ib_button_back)
    public void exit() {
        finish();
    }

}
