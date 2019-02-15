package ir.sematec.sematectask6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static ir.sematec.sematectask6_1.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout elidrawerLayout;
    private Button btndrawer;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        elidrawerLayout = findViewById(R.id.drawer_layout);
        btndrawer = findViewById(R.id.btndrawer);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btndrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elidrawerLayout.openDrawer(GravityCompat.START);
                elidrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                    }

                    @Override
                    public void onDrawerOpened(@NonNull View drawerView) {
                        Toast.makeText(MainActivity.this,"Drawer Opend!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDrawerClosed(@NonNull View drawerView) {
                        Toast.makeText(MainActivity.this,"Drawer Closed!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {

                    }
                });
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToEditActivity = new Intent(MainActivity.this, IntentTaskFirstActivity.class);
                startActivityForResult(intentToEditActivity, Constant.EDIT_ACTIVITY_REQUEST_CODE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToRecyclerViewActivity = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intentToRecyclerViewActivity);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hawk.deleteAll();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToTimingsActivity = new Intent(MainActivity.this, ConnectingToTheInternetAcrivity.class);
                startActivity(intentToTimingsActivity);
            }
        });

    }
}
