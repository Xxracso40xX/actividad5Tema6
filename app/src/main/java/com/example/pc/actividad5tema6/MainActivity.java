package com.example.pc.actividad5tema6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;

import static android.Manifest.permission.CALL_PHONE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }


    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i42 = new Intent(Intent.ACTION_CALL);
        String cadena="";
        switch (item.getItemId())
        {
            case R.id.opcion1: cadena="tel:626789709"; break;
            case R.id.opcion2: cadena="tel:626789776"; break;
            case R.id.opcion3: cadena="tel:626789706"; break;
        }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
        {
            i42.setData(Uri.parse(cadena));
            startActivity(i42);
        }
        else
            {
            requestPermissions(new String[]{CALL_PHONE}, 1);
        }

        return false;
    }
}
