package learn.b.btest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Bilal on 020, 20-February-18.
 */

public class ListAdaptor extends BaseAdapter {

    String[] s = {"TEst","Test2","Test3","Test4"};

    LayoutInflater inflater;

    public ListAdaptor(Context context){

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return s.length-1;
    }

    @Override
    public Object getItem(int position) {
        return s[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.row_list,parent,false);
        TextView tvHead = convertView.findViewById(R.id.tvHead);

        tvHead.setText("Test "+s[position]);


        return convertView;
    }
}
