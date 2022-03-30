package org.apache.cordova.plugin.Volume;

import android.content.Context;
import android.media.AudioManager;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class VolumePlugin extends CordovaPlugin {

  private Context mContext;

  public enum Action {
    adjustRaise,
    adjustLower,
    getVolume,
    setVolume,
    mute4AudioSetting
  }

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    boolean result = false;

    switch (Action.valueOf(action)) {
      case adjustRaise:
        result = true;
        adjustRaise(callbackContext);
        break;
      case adjustLower:
        result = true;
        adjustLower(callbackContext);
        break;
      case getVolume:
        result = true;
        getVolume(callbackContext);
        break;
      case setVolume:
        result = true;
        setVolume(args, callbackContext);
        break;
      case mute4AudioSetting:
        result = true;
        mute4AudioSetting(callbackContext);
        break;
    }
    return result;
  }


  private void adjustRaise(CallbackContext callbackContext) {

    try {
      AudioManager audio = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
      audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
      callbackContext.success("OK");

    } catch (NullPointerException e) {
      callbackContext.error(e.getMessage());
      return;
    }
  }

  private void adjustLower(CallbackContext callbackContext) {

    try {
      AudioManager audio = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
      audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
      callbackContext.success("OK");

    } catch (NullPointerException e) {
      callbackContext.error(e.getMessage());
      return;
    }
  }


  private void setVolume(JSONArray args, CallbackContext callbackContext) {

    try {
      String value = args.getString(0);
      float percent = Float.parseFloat(value);
      AudioManager audio = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
      int maxVolume = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
      int seventyVolume = (int) (maxVolume * percent);
      audio.setStreamVolume(AudioManager.STREAM_MUSIC, seventyVolume, 0);
      callbackContext.success("OK");

    } catch (NullPointerException e) {
      callbackContext.error(e.getMessage());
      return;
    } catch (JSONException e) {
      callbackContext.error(e.getMessage());
      return;
    }
  }

  private void getVolume(CallbackContext callbackContext) {
    
    try {
      AudioManager audio = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
      int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
      callbackContext.success(currentVolume);

    } catch (NullPointerException e) {
      callbackContext.error(e.getMessage());
      return;
    }
  }

  private void mute4AudioSetting(CallbackContext callbackContext) {

    try {
      AudioManager audio = (AudioManager) cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
      audio.adjustStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, 0);
      audio.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_MUTE, 0);
      audio.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, 0);
      audio.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_MUTE, 0);
      callbackContext.success("OK");

    } catch (NullPointerException e) {
      callbackContext.error(e.getMessage());
      return;
    }
  }
}


