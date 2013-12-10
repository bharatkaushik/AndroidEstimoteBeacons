package org.bkaushik.estimotebeacons;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

import java.util.Collections;
import java.util.List;


public class EstimoteBeacons extends CordovaPlugin {
	
	private static final String ESTIMOTE_PROXIMITY_UUID = "B9407F30-F5F8-466E-AFF9-25556B57FE6D";
	private static final Region ALL_ESTIMOTE_BEACONS_REGION = new Region(ESTIMOTE_PROXIMITY_UUID, null, null);
	 public static final String START_RANGING = "startRangingBeaconsInRegion"; 
	 public static final String GET_BEACONS = "getBeacons";
	private BeaconManager beaconManager;
	private List<Beacon> beaconList;
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
 	    beaconManager = new BeaconManager(this);
	    beaconManager.setRangingListener(new BeaconManager.RangingListener(){
		    @Override
		     public void onBeaconsDiscovered(Region region, final List<Beacon> beacons) {
				this.beaconList = beacons;
		     	
		     }
	    });
	    
	    if(START_RANGING.equals(action)){
		    beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
		         @Override
		         public void onServiceReady() {
		           try {
		             beaconManager.startRanging(ALL_ESTIMOTE_BEACONS_REGION);
		           } catch (RemoteException e) {
		             Log.e(TAG, "Cannot start ranging", e);
		           }
		         }
		       });
	    }
	    if(GET_BEACONS) {
	    	
		    System.out.println("Get Beacons!");
		    while(beaconList.iterator().hasNext()) {
		               Beacon temp = iBeacons.iterator().next();
		               System.out.println("Temp: "+temp.major+"  "+temp.minor);
		    }
	    }
	}
}