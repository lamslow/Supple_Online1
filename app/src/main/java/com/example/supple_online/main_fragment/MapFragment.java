package com.example.supple_online.main_fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.example.supple_online.R;
import com.example.supple_online.helper.LocationUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MapFragment extends Fragment implements OnMapReadyCallback, android.location.LocationListener {
    private GoogleMap mMap;
    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;
    private static final int REQUEST_CODE_ENABLE_LOCATION_SERVICE = 2;
    private FloatingActionButton fbFind_my_location;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_maps, container, false);
        initView(view);
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        tryGetCurrentLocation();
        fbFind_my_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }


    private void initView(View view) {
        fbFind_my_location = (FloatingActionButton) view.findViewById(R.id.fbFind_my_location);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ENABLE_LOCATION_SERVICE) {
            if (LocationUtils.getInstance().isEnableLocationService(getContext())) {
                getCurrentLocation();
            } else {
                Toast.makeText(getContext(), "Cannot get current location!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (REQUEST_CODE_LOCATION_PERMISSION == requestCode) {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission was granted, yay!
                // Check location service.
                if (checkLocationService()) getCurrentLocation();
            } else {
                // permission denied, boo!
                Toast.makeText(getContext(), "Cannot get current location!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            getContext(), R.raw.google_map_style));

            if (!success) {
                Log.e("MapsActivity", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MapsActivity", "Can't find style. Error: ", e);
        }
        mMap = googleMap;

    }

    @Override
    public void onLocationChanged(Location location) {
        if (location == null || mMap == null) return;
        setCurrentLocationOnMap(location.getLatitude(), location.getLongitude());
        LocationUtils.getInstance().removeUpdateLocation(getContext());
    }

    private boolean checkLocationService() {
        boolean isEnable;
        if (!LocationUtils.getInstance().isEnableLocationService(getContext())) { // Location service not enable, request it.
            isEnable = false;
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Yêu cầu quyền vị trí");
            builder.setMessage("Bật vị trí trên thiết bị để lấy tọa độ hiện tại của bạn");
            builder.setPositiveButton(Html.fromHtml("<font color='#0000FF'>OK</font>"), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    startActivityForResult(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), REQUEST_CODE_ENABLE_LOCATION_SERVICE);
                }
            });
            AlertDialog dialog = builder.create();
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } else {
            isEnable = true;
        }
        return isEnable;
    }

    private void requestLocationPermission(ArrayList<String> permissionsArrayList) {
        String[] stringPermissionArray = new String[permissionsArrayList.size()];
        ActivityCompat.requestPermissions(getActivity(), permissionsArrayList.toArray(stringPermissionArray), REQUEST_CODE_LOCATION_PERMISSION);
    }

    private void tryGetCurrentLocation() {
        // ask for the permission in android M
        ArrayList<String> permissionsArrayList = new ArrayList<>();
        int permissionLocationGPS = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionLocationNetwork = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION);

        if (permissionLocationGPS != PackageManager.PERMISSION_GRANTED && permissionLocationNetwork != PackageManager.PERMISSION_GRANTED) {
            permissionsArrayList.add(Manifest.permission.ACCESS_FINE_LOCATION);
            permissionsArrayList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            requestLocationPermission(permissionsArrayList);
        } else { // Already has at least ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION
            // Check location service.
            if (checkLocationService()) getCurrentLocation();
        }
    }

    private void getCurrentLocation() {
        if (!LocationUtils.getInstance().isEnableLocationService(getContext())) return;
        LocationUtils.getInstance().requestUpdateLocation(getContext(), this);
    }

    private View locationButton;

    @SuppressLint("ResourceType")
    private void setCurrentLocationOnMap(final double lat, final double lng) {
        final LatLng defaultLocation = new LatLng(lat, lng);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 18));
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        // Extract My Location View from maps fragment
        locationButton = mapFragment.getView().findViewById(0x2);
        mMap.setMyLocationEnabled(true);
        if (locationButton != null)
            locationButton.setVisibility(View.GONE);
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(defaultLocation);
                markerOptions.title("Bạn đang ở đây");
                markerOptions.snippet("Vượng đẹp trai biết điều đó");
                markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
                mMap.clear();
                mMap.addMarker(markerOptions);
            }
        });

        fbFind_my_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMap != null) {
                    if (locationButton != null)
                        locationButton.callOnClick();
                }
            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(getContext(), "Đã lưu tọa độ vào khay nhớ tạm", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
//    private BitmapDescriptor bitmapDescriptorFromVector(Context context, @DrawableRes int vectorDrawableResourceId) {
//        Drawable background = ContextCompat.getDrawable(context, R.drawable.ic_baseline_location_on_24);
//        background.setBounds(0, 0, background.getIntrinsicWidth(), background.getIntrinsicHeight());
//        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorDrawableResourceId);
//        vectorDrawable.setBounds(40, 20, vectorDrawable.getIntrinsicWidth() + 40, vectorDrawable.getIntrinsicHeight() + 20);
//        Bitmap bitmap = Bitmap.createBitmap(background.getIntrinsicWidth(), background.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        background.draw(canvas);
//        vectorDrawable.draw(canvas);
//        return BitmapDescriptorFactory.fromBitmap(bitmap);
//    }
}
