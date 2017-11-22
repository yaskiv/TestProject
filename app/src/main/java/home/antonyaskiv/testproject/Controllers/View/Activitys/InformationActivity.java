package home.antonyaskiv.testproject.Controllers.View.Activitys;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import home.antonyaskiv.testproject.Controllers.View.DataTransmission.FromMainToInformation;
import home.antonyaskiv.testproject.R;

public class InformationActivity extends AppCompatActivity {
   // MapView mapView_for_address;
    private GoogleMap mgoogleMap;
    private FromMainToInformation fromMainToInformation;
    private TextView textView_for_name;
    private TextView textView_for_address;
    public SimpleDraweeView image_for_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
      fromMainToInformation=  this.getIntent().getParcelableExtra("FromMainToInformation");
      textView_for_name=findViewById(R.id.name_of_result_info);
      textView_for_address=findViewById(R.id.address_of_result_info);
      image_for_result=findViewById(R.id.image_for_result_info);
      textView_for_name.setText(fromMainToInformation.getName());
      textView_for_address.setText(fromMainToInformation.getAddress());
        Uri uri = Uri.parse(fromMainToInformation.getUri());
        image_for_result.setImageURI(uri);

  final MapView  mapView_for_address=findViewById(R.id.maps_for_address);
  mapView_for_address.onCreate(savedInstanceState);


        mapView_for_address.getMapAsync(googleMap -> {

            LatLng address = new LatLng(fromMainToInformation.getLat(),fromMainToInformation.getLng());
            CameraPosition cameraPosition = new CameraPosition.Builder().target(address).zoom(18).build();
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            googleMap.addMarker(new MarkerOptions().position(address).title(fromMainToInformation.getAddress()));
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            mapView_for_address.onResume();
        });

    }
}
