package meetup.idahoandroid.classicmodelsrebuild;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModelListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.nameTextView)
    TextView nameTextView;
    @BindView(R.id.numberTextView)
    TextView numberTextView;

    public ModelListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Customer customer) {
        nameTextView.setText(customer.getCustomerName());
        numberTextView.setText(String.valueOf(customer.getCustomerNumber()));
    }
}
