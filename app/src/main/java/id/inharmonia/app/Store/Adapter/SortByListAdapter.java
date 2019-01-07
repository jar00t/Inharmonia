package id.inharmonia.app.Store.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;
import id.inharmonia.app.Store.List.SortByList;
import id.inharmonia.app.Store.Popup.StoreFinderSortByPopup;

public class SortByListAdapter extends RecyclerView.Adapter<SortByListAdapter.Holder> {

    final Context adapter_context;
    private List<SortByList> list_sort_by;
    private int layout_type;
    StoreFinderSortByPopup popup_store_finder_sort_by;

    public SortByListAdapter(Context adapter_context, List<SortByList> list_sort_by, int layout_type, StoreFinderSortByPopup popup_store_finder_sort_by) {
        this.adapter_context = adapter_context;
        this.list_sort_by = list_sort_by;
        this.layout_type = layout_type;
        this.popup_store_finder_sort_by = popup_store_finder_sort_by;
    }

    @NonNull
    @Override
    public SortByListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_type, parent, false);
        return new SortByListAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SortByListAdapter.Holder holder, int position) {
        holder.tv_title.setText(list_sort_by.get(position).get_name());
        holder.iv_icon.setImageResource(list_sort_by.get(position).get_icon());
        holder.iv_sign.setImageResource(R.drawable.ic_check_black_24dp);
        holder.iv_sign.setVisibility((list_sort_by.get(position).get_is_selected())? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return list_sort_by.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tv_title;

        @BindView(R.id.iv_icon)
        ImageView iv_icon;

        @BindView(R.id.iv_sign)
        ImageView iv_sign;

        @BindView(R.id.cv_item)
        CardView cv_item;

        Holder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cv_item)
        public void select_it() {
            popup_store_finder_sort_by.set_selected_sort_by(list_sort_by.get(getAdapterPosition()).get_name());
            popup_store_finder_sort_by.dismiss();
        }

    }

}


