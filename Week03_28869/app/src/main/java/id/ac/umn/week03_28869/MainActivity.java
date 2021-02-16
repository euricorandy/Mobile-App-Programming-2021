package id.ac.umn.week03_28869;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.LinkedList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mDaftarKata = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private DaftarKataAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int jumlahKata = mDaftarKata.size() ;
                mDaftarKata.addLast("Kata " + (jumlahKata + 1) + " telah ditambahkan");
                Objects.requireNonNull
                        (mRecyclerView.getAdapter()).notifyItemInserted(jumlahKata);
                mRecyclerView.smoothScrollToPosition(jumlahKata);
            }
        });

        for (int i = 1; i < 21; i++){
            mDaftarKata.add("Kata " +i);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new DaftarKataAdapter(this, mDaftarKata);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
