package id.inharmonia.app;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ImageTextSubListAdapter extends ArrayAdapter<ImageTextSubList> {

    private Context mContext;
    private List<ImageTextSubList> mList = new ArrayList<>();

    public ImageTextSubListAdapter(@NonNull Context context, ArrayList<ImageTextSubList> list) {
        super(context, 0 , list);
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.lv_img_text_sub_item_row,parent,false);

        ImageTextSubList cList = mList.get(position);

        ImageView Icon = (ImageView)listItem.findViewById(R.id.ivIcon);
        TextView Title = (TextView) listItem.findViewById(R.id.tvTitle);
        TextView SubTitle = (TextView) listItem.findViewById(R.id.tvSubTitle);

        Icon.setImageResource(cList.getIcon());
        Title.setText(cList.getTitle());
        SubTitle.setText(cList.getSubTitle());

        return listItem;
    }
}