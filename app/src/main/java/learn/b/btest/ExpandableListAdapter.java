package learn.b.btest;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bilal on 023, 23-March-18.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private List< ExpandableLVModel> expandableLVModel;
    private Context context;

    public ExpandableListAdapter(Context context,List< ExpandableLVModel> expandableLVModel) {
        this.expandableLVModel=expandableLVModel;
        this.context=context;
    }

    @Override
    public int getGroupCount() {
        return expandableLVModel.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return expandableLVModel.get(groupPosition).getChilds().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return expandableLVModel.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return expandableLVModel.get(groupPosition).getChilds().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return expandableLVModel.get(groupPosition).getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ExpandableLVModel rowGroup = (ExpandableLVModel) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(rowGroup.getType()==0)
                convertView = infalInflater.inflate(R.layout.row_group_explv, null);
            else if(rowGroup.getType()==1) convertView = infalInflater.inflate(R.layout.row_group_explv_check, null);
        }
        if(rowGroup.getType()==0) {
            String headerTitle = rowGroup.getGroupName();
            TextView lblListHeader = (TextView) convertView
                    .findViewById(R.id.lblListHeader);
            lblListHeader.setTypeface(null, Typeface.BOLD);
            lblListHeader.setText(headerTitle);
        }else  if(rowGroup.getType()==1){
            final RadioGroup radioGroup = (RadioGroup) convertView.findViewById(R.id.radioGroup);

            final View finalConvertView = convertView;
            radioGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int selectedId=radioGroup.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) finalConvertView.findViewById(selectedId);
                }
            });
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.row_child_explv, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
