package com.exam.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class EasyService extends Service {

    private static final String TAG = "EasyService";
    public EasyService() {
    }

    IEasyService.Stub mIBinder=new IEasyService.Stub() {
        @Override
        public void connect(String mes) throws RemoteException {
//            LogUtil.i(TAG,"connect:   mes =" + mes);
            Log.d(TAG, mes);

        }

        @Override
        public void disConnect(String mes) throws RemoteException {
//            LogUtil.i(TAG, "disConnect:  mes =" +mes);
            Log.d(TAG, mes);
        }
    };

    @Override
    public IBinder onBind(Intent intent) {

        return mIBinder;
    }



    @Override
    public boolean onUnbind(Intent intent) {

        return super.onUnbind(intent);

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }
}
