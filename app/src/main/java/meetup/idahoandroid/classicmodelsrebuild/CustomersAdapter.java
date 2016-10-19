package meetup.idahoandroid.classicmodelsrebuild;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class CustomersAdapter extends RecyclerView.Adapter<ModelListViewHolder> {

    private List<Customer> data;
    private ModelListViewHolder.OnModelClickedListener onModelClickedListener;

    public CustomersAdapter(ModelListViewHolder.OnModelClickedListener onModelClickedListener) {
        this.onModelClickedListener = onModelClickedListener;
    }

    @Override
    public ModelListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ModelListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_model_list, parent, false), onModelClickedListener);
    }

    @Override
    public void onBindViewHolder(ModelListViewHolder holder, int position) {
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
