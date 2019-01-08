package id.inharmonia.app.Main.Pages.Home.Adapter;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
import id.inharmonia.app.Main.Pages.Home.List.MoniTransList;
import id.inharmonia.app.R;

public class MoniTransListAdapter extends RecyclerView.Adapter<MoniTransListAdapter.Holder> {

    final Context adapter_context;
    private List<MoniTransList> list_monitrans;
    private int layout_type;

    public MoniTransListAdapter(Context adapter_context, List<MoniTransList> list_monitrans, int layout_type) {
        this.adapter_context = adapter_context;
        this.list_monitrans = list_monitrans;
        this.layout_type = layout_type;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_type, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tv_title.setText(list_monitrans.get(position).get_name());
        holder.iv_icon.setImageResource(list_monitrans.get(position).get_icon());
        holder.cv_item_menu.setEnabled(list_monitrans.get(position).get_is_enabled());
        if (!holder.cv_item_menu.isEnabled()) {
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);
            holder.iv_icon.setColorFilter(new ColorMatrixColorFilter(matrix));
            holder.tv_title.setTextColor(adapter_context.getResources().getColor(R.color.colorGrey));
            holder.iv_label_corner.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return list_monitrans.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tv_title;

        @BindView(R.id.iv_icon)
        ImageView iv_icon;

        @BindView(R.id.cv_item)
        CardView cv_item_menu;

        @BindView(R.id.iv_label_corner)
        ImageView iv_label_corner;

        Holder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cv_item)
        public void go_to() {
            switch (getAdapterPosition()){
                default:
                    break;
            }
        }

    }

}
