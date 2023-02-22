package com.if4a.cobalogin;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.lang.ref.PhantomReference;

public class KendaliLogin {
    private SharedPreferences SP ;
    private SharedPreferences.Editor SPE;

    public void setPref(Context ctx , String Key , String Value) {
        SP = PreferenceManager.getDefaultSharedPreferences(ctx);
        SPE = SP.edit();
        SPE.putString(Key, Value);
        SPE.commit();
    }

    public String getPref(Context ctx , String Key){
        SP = PreferenceManager.getDefaultSharedPreferences(ctx);
        return SP.getString(Key, null);
    }
    public boolean isLogin(Context ctx , String Key) {
        SP = PreferenceManager.getDefaultSharedPreferences(ctx);
        if(this.getPref(ctx, Key) != null){
        return true;
        }
        else{
            return false;
        }

    }
}

