package org.caretogether.ServiceProvider;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import org.caretogether.Common.Utils.GoogleMapUtils;
import org.caretogether.Common.Utils.JSONUtils;
import org.caretogether.Common.Utils.REST_Utils;

import java.util.ArrayList;

/**
 * Created by Admin on 9/29/2018.
 */

public class ServiceProviderUtils {

    private Context mContext;
    LatLng lsrc = null; LatLng des;
    GoogleMap gmap;


    private ServiceProviderUtils ( Context context, LatLng src, LatLng dst){
        mContext = context;
        ArrayList<WayPoints> currWayPoints = GoogleMapUtils.getWaypoints( lsrc, des);
    }

    public static class WayPoints {

        double latitude  = 0.0;
        double longitude = 0.0;
        String placeName = "default";
        String ETA_dst     = "0";
        public WayPoints ( double lat, double lng, String pname, String eta) {

            this.latitude = lat;
            this.longitude = lng;
            this.placeName = pname;
            this.ETA_dst = eta;
        }

    }


    public class SosInfo {
        private LatLng loc_source = null;
        private LatLng loc_dest   = null;
        private long ETA = 0;
        private WayPoints[] listWayPoints = new WayPoints[]{};

    }

    public boolean publishSosinfo( SosInfo sosinfo) {
        boolean bPublish = false;

        REST_Utils.POST(sosinfo);

        return bPublish;
    }
}
