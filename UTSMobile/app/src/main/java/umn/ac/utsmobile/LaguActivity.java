package umn.ac.utsmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

public class LaguActivity extends AppCompatActivity {
    Dialog popupList;
    ListView rvDaftarLagu;
    String[] items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagu);

        popupList = new Dialog(this);
        rvDaftarLagu = (ListView) findViewById(R.id.listView);

        showPopup();
        runtimePermission();
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lagu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.item2:
                Intent halamanLogin = new Intent(LaguActivity.this, LoginActivity.class);
                startActivity(halamanLogin);
                return true;
            case R.id.item3:
                Intent halamanProfil = new Intent(LaguActivity.this, ProfileActivity.class);
                startActivity(halamanProfil);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showPopup(){
        Button cls_popup;
        popupList.setContentView(R.layout.list_popup);
        cls_popup = (Button) popupList.findViewById(R.id.cls_poplist);

        cls_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupList.dismiss();
            }
        });
        popupList.show();
    }

    public  void runtimePermission(){
        Dexter.withContext(this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        displaySongs();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();

                    }
                }).check();
    }

    public ArrayList<File> findSong(File file){
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();

        for(File singlefile: files){
            if(singlefile.isDirectory() && !singlefile.isHidden()){
                arrayList.addAll(findSong(singlefile));
            } else {
                if(singlefile.getName().endsWith(".mp3") || singlefile.getName().endsWith(".wav")){
                    arrayList.add(singlefile);
                }
            }
        }
        return arrayList;
    }

    void displaySongs(){
        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());
        items = new String[mySongs.size()];
        for (int i = 0; i<mySongs.size(); i++){
            items[i] = mySongs.get(i).getName().toString().replace(".mp3", "").replace(".wav", "");
        }

        customAdapter customAdapter = new customAdapter();
        rvDaftarLagu.setAdapter(customAdapter);

        rvDaftarLagu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String songName = (String) rvDaftarLagu.getItemAtPosition(position);
                startActivity(new Intent(getApplicationContext(), PlayActivity.class).putExtra("songs", mySongs)
                .putExtra("songname", songName)
                .putExtra("pos", position));
            }
        });
    }

    class customAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View myView = getLayoutInflater().inflate(R.layout.item_lagu, null);
            TextView textSong = myView.findViewById(R.id.laguJudul);
            textSong.setSelected(true);
            textSong.setText(items[position]);
            return  myView;
        }
    }
}