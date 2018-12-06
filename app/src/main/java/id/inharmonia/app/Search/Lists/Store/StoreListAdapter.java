package id.inharmonia.app.Search.Lists.Store;

import android.content.Context;
import android.graphics.Typeface;
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

import id.inharmonia.app.R;


public class StoreListAdapter extends ArrayAdapter<StoreList> {

    private Context mContext;
    private List<StoreList> mList;

    public StoreListAdapter(@NonNull Context context, ArrayList<StoreList> list) {
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

        StoreList cList = mList.get(position);

        ImageView Icon = listItem.findViewById(R.id.ivIcon);
        TextView Title = listItem.findViewById(R.id.tvTitle);
        TextView SubTitle = listItem.findViewById(R.id.tvSubTitle);

        Icon.setImageResource(cList.getIcon());
        Title.setText(cList.getTitle());
        SubTitle.setText(cList.getSubTitle());

        Typeface harabara_mais_font = Typeface.createFromAsset(listItem.getContext().getApplicationContext().getAssets(),  "fonts/harabara-mais.ttf");
        Title.setTypeface(harabara_mais_font);

        return listItem;
    }
}