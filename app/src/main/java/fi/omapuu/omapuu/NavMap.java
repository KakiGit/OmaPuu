package fi.omapuu.omapuu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.mapboxsdk.utils.BitmapUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mapbox.mapboxsdk.style.expressions.Expression.get;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.textAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.textField;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.textIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.textOffset;

public class NavMap extends AppCompatActivity implements
        OnMapReadyCallback, MapboxMap.OnMapClickListener {
    private static final String ICON_SOURCE_ID = "ICON_SOURCE_ID";
    private static final String ICON_LAYER_ID = "ICON_LAYER_ID";
    private static final String PROFILE_NAME = "PROFILE_NAME";
    private static final String OULANKA = "Oulanka";
    private static final String RIOTTASKORPI = "Riuttaskorpi Forest";
    private static final String NUUKSIO = "Nuuksio National Park";
    private static final String MAN = "";
    private MapView mapView;
    private MapboxMap mapboxMap;
    ImageButton refreshBtn;
    List<String> uris = Arrays.asList(
            "mapbox://styles/kakik/ck3bac60a0er41cqhbtkwl2oj"
            ,"mapbox://styles/kakik/ck3bwzr7u2gto1cogz49693c5"
            ,"mapbox://styles/kakik/ck3byesja2gkr1cp7o5munfh6"
            ,"mapbox://styles/kakik/ck3byfccb1nnc1clknjecsk8p"
            ,"mapbox://styles/kakik/ck3byfn881nnj1clkichzhd0k"
            ,"mapbox://styles/kakik/ck3byg70o1sm31cpa5frkesqi"
    );
    int clickCount = 0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

// Mapbox access token is configured here. This needs to be called either in your application
// object or in the same activity which contains the mapview.


            Mapbox.getInstance(this,"pk.eyJ1Ijoia2FraWsiLCJhIjoiY2szYWZ3cTl6MGJtcTNkazNrMWVzdHhvYyJ9.2UsFQa8NnJzqcfVdFpRXpg");

// This contains the MapView in XML and needs to be called after the access token is configured.
            setContentView(R.layout.navigation_map);

            ImageView cameraBtn = findViewById(R.id.imageView5);
            cameraBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =  new Intent(v.getContext(),CameraActivity.class);
                    startActivity(intent);
                }
            });
            ImageView knowledge = findViewById(R.id.imageView4);
            knowledge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),KnowledgeActivity.class);
                    startActivity(intent);
                }
            });
            refreshBtn = findViewById(R.id.refresh);
            refreshBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickCount++;
                    setMapStyle(mapboxMap,uris.get(clickCount%uris.size()));
                }
            });

            mapView = findViewById(R.id.mapView);
            mapView.onCreate(savedInstanceState);
            mapView.getMapAsync(this);

// Use the listener to match the id with the appropriate person. The correct profile photo is
// given to the map during "runtime".
            mapView.addOnStyleImageMissingListener(new MapView.OnStyleImageMissingListener() {
                @Override
                public void onStyleImageMissing(@NonNull String id) {
                    switch (id) {
                        case OULANKA:
                            addImage(id, R.drawable.ic_tree);
                            break;
                        case RIOTTASKORPI:
                            addImage(id, R.drawable.ic_tree);
                            break;
                        case NUUKSIO:
                            addImage(id, R.drawable.ic_tree);
                            break;
                        case MAN:
                            addImage(id, R.drawable.user);
                            break;
                        default:
                            addImage(id, R.drawable.ic_tree);
                            break;
                    }
                }
            });
        }

        private void setMapStyle(@NonNull final  MapboxMap mapboxMap,String uri) {
            // Add Features which represent the location of each profile photo SymbolLayer icon
            Feature oulFeature = Feature.fromGeometry(Point.fromLngLat(29.322095,66.374677));
            oulFeature.addStringProperty(PROFILE_NAME, OULANKA);


            Feature sibFeature = Feature.fromGeometry(Point.fromLngLat(23.606703,61.964048));
            sibFeature.addStringProperty(PROFILE_NAME, RIOTTASKORPI);


            Feature parkFeature = Feature.fromGeometry(Point.fromLngLat(24.467478,60.294859));
            parkFeature.addStringProperty(PROFILE_NAME, NUUKSIO);

            Feature manFeature = Feature.fromGeometry(Point.fromLngLat(25.867478,59.894859));
            parkFeature.addStringProperty(PROFILE_NAME, MAN);

// Use a URL to build and add a Style object to the map. Then add a source to the Style.
            mapboxMap.setStyle(
                    new Style.Builder().fromUri(uri)
                            .withSource(new GeoJsonSource(ICON_SOURCE_ID,
                                    FeatureCollection.fromFeatures(new Feature[] {
                                            oulFeature,
                                            sibFeature,
                                            parkFeature}))),
                    new Style.OnStyleLoaded() {
                        @Override
                        public void onStyleLoaded(@NonNull Style style) {
                            NavMap.this.mapboxMap = mapboxMap;

// Add a SymbolLayer to the style. iconImage is set to a value that will
// be used later in the addOnStyleImageMissingListener below
                            style.addLayer(new SymbolLayer(ICON_LAYER_ID, ICON_SOURCE_ID).withProperties(
                                    iconImage(get(PROFILE_NAME)),
                                    iconIgnorePlacement(true),
                                    iconAllowOverlap(true),
                                    textField(get(PROFILE_NAME)),
                                    textIgnorePlacement(true),
                                    textAllowOverlap(true),
                                    textOffset(new Float[] {0f, 2f})
                            ));
                        }
                    });
        }

        @Override
        public void onMapReady(@NonNull final MapboxMap mapboxMap) {

            setMapStyle(mapboxMap,uris.get(clickCount%uris.size()));

            mapboxMap.addOnMapClickListener(NavMap.this);
        }

        @Override
        public boolean onMapClick(@NonNull LatLng point) {
            Log.d("OmaPuu","map tapped");
            return false;
        }

        private void addImage(String id, int drawableImage) {
            Style style = mapboxMap.getStyle();
            if (style != null) {
                style.addImageAsync(id, BitmapUtils.getBitmapFromDrawable(
                        getResources().getDrawable(drawableImage)));
            }
        }

        // Add the mapView lifecycle to the activity's lifecycle methods
        @Override
        public void onResume() {
            super.onResume();
            mapView.onResume();
        }

        @Override
        protected void onStart() {
            super.onStart();
            mapView.onStart();
        }

        @Override
        protected void onStop() {
            super.onStop();
            mapView.onStop();
        }

        @Override
        public void onPause() {
            super.onPause();
            mapView.onPause();
        }

        @Override
        public void onLowMemory() {
            super.onLowMemory();
            mapView.onLowMemory();
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            if (mapboxMap != null) {
                mapboxMap.removeOnMapClickListener(this);
            }
            mapView.onDestroy();
        }

        @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            mapView.onSaveInstanceState(outState);
        }

}
