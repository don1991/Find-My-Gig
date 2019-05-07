package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    private String[] contactNumbers = {"6516516565165", "26516131535", "131513542315313", "15383135438"};

    private String[] backgroundImages = {"","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        int height = 200;
        int width = 130;
        BitmapDrawable cameraImage=(BitmapDrawable)getResources().getDrawable(R.drawable.camera);
        Bitmap camera=cameraImage.getBitmap();
        Bitmap cameraIcon = Bitmap.createScaledBitmap(camera, width, height, false);

        BitmapDrawable carRepairImage = (BitmapDrawable)getResources().getDrawable(R.drawable.car_repair);
        Bitmap carRepair = carRepairImage.getBitmap();
        Bitmap carRepairIcon = Bitmap.createScaledBitmap(carRepair,width,height, false);

        BitmapDrawable computerImage = (BitmapDrawable)getResources().getDrawable(R.drawable.computer);
        Bitmap computercarRepair = computerImage.getBitmap();
        Bitmap computerRepairIcon = Bitmap.createScaledBitmap(computercarRepair,width,height, false);

        BitmapDrawable deliveryImage = (BitmapDrawable)getResources().getDrawable(R.drawable.delivery);
        Bitmap deliveryImageBitmap = deliveryImage.getBitmap();
        Bitmap deliveryIcon = Bitmap.createScaledBitmap(deliveryImageBitmap,width,height, false);

        BitmapDrawable fixImage=(BitmapDrawable)getResources().getDrawable(R.drawable.fix);
        Bitmap fix=fixImage.getBitmap();
        Bitmap fixIcon = Bitmap.createScaledBitmap(fix, width, height, false);

        BitmapDrawable lawnImage=(BitmapDrawable)getResources().getDrawable(R.drawable.lawn);
        Bitmap lawnImageBitmap=lawnImage.getBitmap();
        Bitmap lawnIcon = Bitmap.createScaledBitmap(lawnImageBitmap, width, height, false);

        BitmapDrawable tutorImage=(BitmapDrawable)getResources().getDrawable(R.drawable.tutor);
        Bitmap tutor=tutorImage.getBitmap();
        Bitmap tutorIcon = Bitmap.createScaledBitmap(tutor, width, height, false);

        long latitude = -35;
        // Add a marker in Bentely_University and move the camera
        LatLng Bentely_University = new LatLng(42.3868 , -71.2203);
        LatLng Babson_College = new LatLng(42.2964,-71.2203);
        LatLng Waltham_City = new LatLng(42.3765, -71.2356);
        LatLng ProsoectHillPark = new LatLng(42.3971, -71.2513);
        LatLng test = new LatLng(45, -79);



        MarkerOptions BentelyMarker = (MarkerOptions) new MarkerOptions().position(Bentely_University).title("Bentely University").icon(BitmapDescriptorFactory.fromBitmap(cameraIcon));

        MarkerOptions BabsonCollegeMarker = (MarkerOptions) new MarkerOptions().position(Babson_College).title("Babson College").icon(BitmapDescriptorFactory.fromBitmap(computerRepairIcon));

        MarkerOptions ProsectHillParkeMarker = (MarkerOptions) new MarkerOptions().position(ProsoectHillPark).title("Prospect Hill Park").icon(BitmapDescriptorFactory.fromBitmap(carRepairIcon));

        MarkerOptions WalthamMarker = (MarkerOptions) new MarkerOptions().position(Waltham_City).title("Waltham City").icon(BitmapDescriptorFactory.fromBitmap(lawnIcon));

//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.addMarker(new MarkerOptions().position(dfjd).title("New Marker"));

        float zoomLevel = 10.0f;//updating the level so that only required gigs are displayed
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ProsoectHillPark, zoomLevel));
        mMap.addMarker(BentelyMarker);
        mMap.addMarker(WalthamMarker);
        mMap.addMarker(ProsectHillParkeMarker);
        mMap.addMarker(BabsonCollegeMarker);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent loadGig = new Intent(MapsActivity.this, GigActivity.class);
                switch (marker.getTitle()){
                    case "Waltham City":
                        loadGig.putExtra("mobileNumber",contactNumbers[0]);
                        loadGig.putExtra("backGround" , "0");
                        loadGig.putExtra("providerIcon" , "");
                        loadGig.putExtra("gigName" , "Clean The Lawn");
                        loadGig.putExtra("providerName" , "Ashan Gamage");
                        loadGig.putExtra("description" , "Lawn cleaner need for some of our landscaping duties. We have some duties like such as trimming trees, applying pesticides, planting flowers and grass. If anyone interested please contact us and cost is negotiable.");
                        loadGig.putExtra("cost" , "250");
                        loadGig.putExtra("address" , "415 South St, Waltham, MA 02453, USA");
                        System.out.println();
                        break;
                    case "Bentely University":
                        loadGig.putExtra("mobileNumber",contactNumbers[1]);
                        loadGig.putExtra("backGround" , "1");
                        loadGig.putExtra("providerIcon" , "");
                        loadGig.putExtra("gigName" , "Looking for a Photographer");
                        loadGig.putExtra("providerName" , " Ivy Williams ");
                        loadGig.putExtra("description" , "Looking for a photographer to photoshoot our birthday party. We are having our sons 3 years birthday this Sunday. Looking for a photographer who has technical skills and has an artistic eye to take pictures of people, places, landscapes, food, you name it. ");
                        loadGig.putExtra("cost" , "60");
                        loadGig.putExtra("address" , "175 Forest St, Waltham, MA 02452, USA");
                        System.out.println();
                        break;
                    case "Babson College":
                        loadGig.putExtra("mobileNumber",contactNumbers[2]);
                        loadGig.putExtra("backGround" , "2");
                        loadGig.putExtra("providerIcon" , "");
                        loadGig.putExtra("gigName" , "Computer Repair");
                        loadGig.putExtra("providerName" , "Eric Jhonson");
                        loadGig.putExtra("description" , "I have my 2017 Dell XPS 15, having some small issues with the fan noise and the battery. Looking for a Computer Technician help me to fix my laptop.");
                        loadGig.putExtra("cost" , "80");
                        loadGig.putExtra("address" , "415 South St, Waltham, MA 02453, USA");
                        System.out.println();
                        break;
                    case "Prospect Hill Park":
                        loadGig.putExtra("mobileNumber",contactNumbers[3]);
                        loadGig.putExtra("backGround" , "3");
                        loadGig.putExtra("providerIcon" , "");
                        loadGig.putExtra("gigName" , "Looking for a mechanic ");
                        loadGig.putExtra("providerName" , "Lidiya Brown");
                        loadGig.putExtra("description" , "Looking for a mechanic to perform some small duties such as performing oil changes, flushing and replacing fluids, and replacing brakes.  Estimates for repairs and discussing options with clients.");
                        loadGig.putExtra("cost" , "100");
                        loadGig.putExtra("address" , " 19 Prospect Street, Watertown, MA, 02472");
                        System.out.println();
                        break;
                    default:
                       loadGig.putExtra("mobileNumber","+34773792885");
                            break;


                }



                startActivity(loadGig);
                return false;
            }
        });
    }
}
