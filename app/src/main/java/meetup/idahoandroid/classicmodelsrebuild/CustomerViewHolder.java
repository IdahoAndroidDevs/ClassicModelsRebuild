package meetup.idahoandroid.classicmodelsrebuild;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.nameTextView)
    TextView nameTextView;
    @BindView(R.id.numberTextView)
    TextView numberTextView;

    private OnModelClickedListener clickedListener;
    private Customer currentCustomer;

    public CustomerViewHolder(View itemView, OnModelClickedListener onModelClickedListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.clickedListener = onModelClickedListener;

        itemView.setOnClickListener(this);
    }

    public void bindData(Customer customer) {
        this.currentCustomer = customer;
        nameTextView.setText(customer.getCustomerName());
        numberTextView.setText(String.valueOf(customer.getCustomerNumber()));
    }

    @Override
    public void onClick(View view) {
        clickedListener.onModelClicked(currentCustomer);
    }

    public interface OnModelClickedListener {
        public void onModelClicked(Customer customer);
    }
}
