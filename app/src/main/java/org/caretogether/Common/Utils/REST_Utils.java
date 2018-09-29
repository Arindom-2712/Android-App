package org.caretogether.Common.Utils;

import org.caretogether.Consumer.ConsumerUtils;
import org.caretogether.ServiceProvider.ServiceProviderUtils;
import org.json.JSONObject;

/**
 * Created by Admin on 9/29/2018.
 */

public class REST_Utils {

    public static boolean POST(ServiceProviderUtils.SosInfo sosInfo){

        boolean bPOST = false;
        JSONObject jsonObject = JSONUtils.Encode(sosInfo);

        //POST REST

        return bPOST;
    }

    public static boolean POST(ConsumerUtils.CommuterInfo commuterInfo ) {
        boolean bPOST = false;
        JSONObject jsonObject = JSONUtils.Encode(commuterInfo);

        //POST REST

        return bPOST;
    }

    public static boolean GET () {

        return true;
    }
}
