package learn.b.btest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bilal on 023, 23-March-18.
 */

public class ExpamdableLVActivity extends Activity {

    ExpandableListView expListView;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_lv);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        List<ExpandableLVModel>  expandableLVModels = new ArrayList<>();
        List<String> childs = new ArrayList<>();
        childs.add("One");
        childs.add("Two");
        childs.add("Three");
        ExpandableLVModel expandableLVModel = new ExpandableLVModel();
        expandableLVModel.setChilds(childs);
        expandableLVModel.setGroupName("Multi Selection");
        expandableLVModel.setId(1);
        expandableLVModel.setType(0);
        expandableLVModels.add(expandableLVModel);
        expandableLVModel= new ExpandableLVModel();
        expandableLVModel.setId(2);
        expandableLVModel.setType(1);
        expandableLVModel.setGroupName("Check");
        expandableLVModel.setChilds(childs);
        expandableLVModels.add(expandableLVModel);

        expandableListAdapter = new ExpandableListAdapter(ExpamdableLVActivity.this,expandableLVModels);
        expListView.setAdapter(expandableListAdapter);
    }
}
