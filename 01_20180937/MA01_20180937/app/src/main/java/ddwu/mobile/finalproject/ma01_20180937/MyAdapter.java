package ddwu.mobile.finalproject.ma01_20180937;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Diary> myDataList;
    private LayoutInflater inflater;

    public MyAdapter(Context context, int layout, ArrayList<Diary> myDataList) {
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return myDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myDataList.get(position).get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;

        if(convertView == null){
            convertView = inflater.inflate(layout, parent, false);
        }


        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvDate = convertView.findViewById(R.id.tv_date);
        TextView tvFeeling = convertView.findViewById(R.id.tv_feeling);


        tvTitle.setText(myDataList.get(position).getTitle());
        tvDate.setText(myDataList.get(position).getDate());
        tvFeeling.setText(myDataList.get(position).getFeeling());


        return convertView;
    }
}
