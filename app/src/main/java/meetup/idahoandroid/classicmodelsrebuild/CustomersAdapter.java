package meetup.idahoandroid.classicmodelsrebuild;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class CustomersAdapter extends RecyclerView.Adapter<CustomerViewHolder> {

    private List<Customer> data;
    private CustomerViewHolder.OnModelClickedListener onModelClickedListener;

    public CustomersAdapter(CustomerViewHolder.OnModelClickedListener onModelClickedListener) {
        this.onModelClickedListener = onModelClickedListener;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_model_list, parent, false), onModelClickedListener);
    }

    @Override
    public void onBindViewHolder(CustomerViewHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(List<Customer> data) {
        this.data = data;
    }
}
