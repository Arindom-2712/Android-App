package org.caretogether.ServiceProvider;

import android.content.Context;
import org.caretogether.Common.Utils.GoogleMapUtils;
import org.caretogether.Common.Utils.JSONUtils;
import org.caretogether.Common.Utils.REST_Utils;

/**
 * Created by Admin on 9/29/2018.
 */

public class ServiceProviderUtils {

    private Context mContext;

    private ServiceProviderUtils ( Context context, AmbulanceLocation src, AmbulanceLocation dst){
        mContext = context;
        WayPoints[] currWayPoints = GoogleMapUtils.getWaypoints(src,dst);
    }

    public class WayPoints {

        double latitude  = 0.0;
        double longitude = 0.0;
        String placeName = "default";
        long ETA_dst     = 0;
    }

    public class AmbulanceLocation {


    }
    public class SosInfo {
        private AmbulanceLocation loc_source = null;
        private AmbulanceLocation loc_dest   = null;
        private long ETA = 0;
        private WayPoints[] listWayPoints = new WayPoints[]{};

    }

    public boolean publishSosinfo( SosInfo sosinfo) {
        boolean bPublish = false;

        REST_Utils.POST(sosinfo);

        return bPublish;
    }
}
