package com.exam.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.exam.aidltest.IEasyService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_start = (Button) findViewById(R.id.start_service);
        Button btn_contact = (Button) findViewById(R.id.start_contact);
        btn_start.setOnClickListener(this);
        btn_contact.setOnClickListener(this);

    }


    //    private static final String ACTION = "xj.musicserver.easy.IEasyService";
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_service:
                Intent intent = new Intent();
                intent.setAction("123");
                // 注意在 Android 5.0以后，不能通过隐式 Intent 启动 service，必须制定包名
                intent.setPackage("com.exam.aidltest");
                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.start_contact:
                if (mIEasyService != null) {
                    try {
                        mIEasyService.connect(" Cilent connect");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;

        }

    }

    private IEasyService mIEasyService;


    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIEasyService = IEasyService.Stub.asInterface(service);


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIEasyService = null;
        }
    };


}
