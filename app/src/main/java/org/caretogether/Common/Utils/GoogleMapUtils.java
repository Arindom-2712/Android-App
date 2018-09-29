package org.caretogether.Common.Utils;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.caretogether.Consumer.ConsumerUtils;
import org.caretogether.ServiceProvider.ServiceProviderUtils;
import org.caretogether.ServiceProvider.ServiceProviderUtils.WayPoints;

import java.util.ArrayList;
import java.util.List;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.EncodedPolyline;


/**
 * Common Util File for MAp functionalities
 * Created by Admin on 9/29/2018.
 */

public class GoogleMapUtils {

    private static final String TAG = "GoogleMapUtils";

    public static ArrayList<WayPoints> getWaypoints(  LatLng ltlngSRC, LatLng ltlngDEST) {

        ArrayList<WayPoints>  lstWayPoints = new ArrayList<>();

        String SRC = ltlngSRC.latitude+","+ltlngSRC.longitude;
        String DES = ltlngDEST.latitude+","+ltlngDEST.longitude;

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("YOUR_API_KEY") //TODO
                .build();
        DirectionsApiRequest req = DirectionsApi.getDirections(context, SRC, DES);
        try {
            DirectionsResult res = req.await();

            //Loop through legs and steps to get encoded polylines of each step
            if (res.routes != null && res.routes.length > 0) {
                DirectionsRoute route = res.routes[0];

                if (route.legs !=null) {
                    for(int i=0; i<route.legs.length; i++) {
                        DirectionsLeg leg = route.legs[i];
                        if (leg.steps != null) {
                            for (int j=0; j<leg.steps.length;j++){
                                DirectionsStep step = leg.steps[j];
                                if (step.steps != null && step.steps.length >0) {
                                    for (int k=0; k<step.steps.length;k++){
                                        DirectionsStep step1 = step.steps[k];
                                        EncodedPolyline points1 = step1.polyline;
                                        if (points1 != null) {
                                            //Decode polyline and add points to list of route coordinates
                                            List<com.google.maps.model.LatLng> coords1 = points1.decodePath();
                                            for (com.google.maps.model.LatLng coord1 : coords1) {
                                                WayPoints  wayPoint= new ServiceProviderUtils.WayPoints(coord1.lat, coord1.lng,"","");
                                                lstWayPoints.add(wayPoint);
                                            }
                                        }
                                    }
                                } else {
                                    EncodedPolyline points = step.polyline;
                                    if (points != null) {
                                        //Decode polyline and add points to list of route coordinates
                                        List<com.google.maps.model.LatLng> coords = points.decodePath();
                                        for (com.google.maps.model.LatLng coord : coords) {
                                            WayPoints  wayPoint= new ServiceProviderUtils.WayPoints(coord.lat, coord.lng,"","");
                                            lstWayPoints.add(wayPoint);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch(Exception ex) {
            Log.e(TAG, ex.getLocalizedMessage());
        }

        return lstWayPoints;
    }

    public static ConsumerUtils.CommuterInfo getCommuterInfo() {
        return null;
    }

}
