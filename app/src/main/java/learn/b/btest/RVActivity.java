package learn.b.btest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Bilal on 017, 17-March-18.
 */

public class RVActivity extends Activity {

    RecyclerView rvTest;
    RecyclerView.Adapter mAdapter;
    String[] mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rvTest = (RecyclerView) findViewById(R.id.rvTest);

        rvTest.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvTest.setLayoutManager(layoutManager);

        mData = new String[]{"One","Two"};



    }
}
