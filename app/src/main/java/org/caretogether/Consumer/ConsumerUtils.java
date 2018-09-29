package org.caretogether.Consumer;

import android.content.Context;

import org.caretogether.Common.Utils.GoogleMapUtils;

/**
 * Created by Admin on 9/29/2018.
 */

public class ConsumerUtils  {

    private ConsumerUtils( Context context){
        CommuterInfo commuterInfo = GoogleMapUtils.getCommuterInfo();

    }

    public static class CommuterLocation {
        public double latitude;
        public double longitude;
        public CommuterLocation destination;
    }
    public class CommuterInfo {
        CommuterLocation commuterLocationCURRENT;
        CommuterLocation commuterLocation;
    }

    public boolean publish(CommuterInfo commuterInfo) {return true;}
}
