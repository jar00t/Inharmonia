package id.inharmonia.app.Main.Pages.Home.Lists.Size;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Main.Pages.Home.Popups.SizeQuantityPopup;
import id.inharmonia.app.R;

public class SizeListAdapter extends RecyclerView.Adapter<SizeListAdapter.SizeViewHolder> {

    final Context mContext;
    SizeQuantityPopup mSizeQuantityPopup;
    private List<SizeList> mSizeList;
    private int mLayoutType;

    public List<String[]> allData;
    public List<String[]> filteredData;

    int valueTotal;

    public SizeListAdapter(Context mContext, List<SizeList> mSizeList, int mLayoutType, SizeQuantityPopup mSizeQuantityPopup) {
        this.mContext = mContext;
        this.mSizeQuantityPopup = mSizeQuantityPopup;
        this.mSizeList = mSizeList;
        this.mLayoutType = mLayoutType;
    }

    public void setData(List<String[]> quantityData) {
        this.allData = quantityData;
    }

    public List<String[]> getData() {
        filteredData = new ArrayList<>();
        for(int i = 0; i < allData.size(); i++) {
            if (!allData.get(i)[1].equals("0")) {
                filteredData.add(new String[]{allData.get(i)[0], allData.get(i)[1]});
            }
        }
        return filteredData;
    }

    @NonNull
    @Override
    public SizeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(mLayoutType, parent, false);
        return new SizeViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull SizeViewHolder holder, int position) {
        holder.mIcon.setImageResource(mSizeList.get(position).getSizeIcon());
    }

    @Override
    public int getItemCount() {
        return mSizeList.size();
    }

    public class SizeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivIcon)
        ImageView mIcon;

        @BindView(R.id.ibDecreaseButton)
        ImageButton mDecreaseButton;

        @BindView(R.id.ibIncreaseButton)
        ImageButton mIncreaseButton;

        @BindView(R.id.btAddButton)
        Button mAddButton;

        @BindView(R.id.llQuantityCustomer)
        LinearLayout mQuantityCustomer;

        @BindView(R.id.etNumberValue)
        EditText mNumberValue;

        SizeViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            mNumberValue.setCursorVisible(false);
            mNumberValue.addTextChangedListener(new TextWatcher() {

                String value;
                int oldValue = 0;
                int newValue = 0;

                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    value = mNumberValue.getText().toString();
                    if (!value.isEmpty()) oldValue = Integer.parseInt(value);
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    value = mNumberValue.getText().toString();
                    if (!value.isEmpty()) {
                        newValue = Integer.parseInt(value);
                        if (newValue <= 0) newValue = 0;

                        if (oldValue < newValue) valueTotal = valueTotal + (newValue - oldValue);
                        if (oldValue > newValue) valueTotal = valueTotal - (oldValue - newValue);
                        if (oldValue == newValue && valueTotal == 0) valueTotal = newValue;

                        if (valueTotal <= 0) valueTotal = 0;

                        if (newValue == 0) {
                            SizeListAdapter.this.allData.get(getAdapterPosition())[1] = "0";
                        } else {
                            SizeListAdapter.this.allData.get(getAdapterPosition())[1] = String.valueOf(newValue);
                        }
                        checkButton(valueTotal);
                        mSizeQuantityPopup.updateTotal(valueTotal);
                    } else {
                        mNumberValue.setText("0");
                    }
                }

            });
        }

        @OnClick(R.id.btAddButton)
        public void showQuantityCustomer() {
            mAddButton.setVisibility(View.GONE);
            mQuantityCustomer.setVisibility(View.VISIBLE);
            mNumberValue.setText("1");
        }

        @OnClick(R.id.etNumberValue)
        public void focusMe() {
            mNumberValue.setCursorVisible(true);
        }

        @OnClick(R.id.ibDecreaseButton)
        public void decreaseValue() {
            int oldValue = 0;
            if (!mNumberValue.getText().toString().isEmpty()) oldValue = Integer.parseInt(mNumberValue.getText().toString());
            int newValue = oldValue - 1;
            if (newValue <= 0) newValue = 0;
            if (newValue == 0) {
                mNumberValue.setText("0");
                SizeListAdapter.this.allData.get(getAdapterPosition())[1] = "0";
            } else {
                mNumberValue.setText(String.valueOf(newValue));
                SizeListAdapter.this.allData.get(getAdapterPosition())[1] = String.valueOf(newValue);
            }
            checkButton(valueTotal);
            mSizeQuantityPopup.updateTotal(valueTotal);
        }

        @OnClick(R.id.ibIncreaseButton)
        public void increaseValue() {
            int oldValue = 0;
            if (!mNumberValue.getText().toString().isEmpty()) oldValue = Integer.parseInt(mNumberValue.getText().toString());
            int newValue = oldValue + 1;
            mNumberValue.setText(String.valueOf(newValue));
            SizeListAdapter.this.allData.get(getAdapterPosition())[1] = String.valueOf(newValue);
            mSizeQuantityPopup.enableButton();
            mSizeQuantityPopup.updateTotal(valueTotal);
        }

        private void checkButton(int valueTotal) {
            if (valueTotal == 0) {
                mSizeQuantityPopup.disableButton();
            } else {
                mSizeQuantityPopup.enableButton();
            }
        }

    }

}

