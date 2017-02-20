package meetup.idahoandroid.classicmodelsrebuild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomerListActivity extends AppCompatActivity implements CustomerViewHolder.OnModelClickedListener {

    @BindView(R.id.customerListView)
    RecyclerView recyclerView;

    private CustomersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomersAdapter(this);
        recyclerView.setAdapter(adapter);

        getData();
    }

    private void getData() {
        // TODO: 10/18/16 Get data, pump it into the adapter

        Log.d("JAR", "getData");

        List<Customer> dummyList = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            Customer dummyCustomer = new Customer();
            dummyCustomer.setCustomerNumber(i + 100);
            dummyCustomer.setCustomerName("Customer Number " + i);

            dummyList.add(dummyCustomer);
        }

        adapter.setData(dummyList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onModelClicked(Customer customer) {
        Toast.makeText(this, customer.getCustomerName() + " Clicked", Toast.LENGTH_SHORT).show();
        // TODO: 10/18/16
    }

    @OnClick(R.id.buttonClearList)
    public void clearList() {

    }

    @OnClick(R.id.buttonCreateNewCustomer)
    public void createNewCustomer() {

    }

    @OnClick(R.id.buttonAddMore)
    public void addMore() {

    }
}
