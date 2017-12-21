package com.example.abdallah.chatdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.abdallah.chatdemo.Adapters.ClientsAdapter;
import com.example.abdallah.chatdemo.Models.Clients.Clients;
import com.example.abdallah.chatdemo.Models.Clients.ClientsDatum;
import com.example.abdallah.chatdemo.Utils.Callbacks;
import com.example.abdallah.chatdemo.Utils.FetchClientsData;
import com.example.abdallah.chatdemo.Utils.NetworkState;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


public class ClientsActivity extends AppCompatActivity implements Callbacks , ClientsAdapter.RecyclerViewClickListener {

   // private RecyclerView recyclerView;
    private Clients clients;
    private FeatureCoverFlow mCoverFlow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(NetworkState.ConnectionAvailable(this)) {
            FetchClientsData fetchClientsData = new FetchClientsData();
            fetchClientsData.setCallbacks(this);
            fetchClientsData.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }

     /*   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        /*StaggeredGridLayoutManager sglm =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(sglm);*/



    }

    @Override
    public void OnSuccess(Object object) {

        clients=new Clients();
        List<ClientsDatum> list=new ArrayList<>();
        Gson gson = new Gson();
        String JsonData = (String) object;
        try {
            JSONObject jsonObject=new JSONObject(JsonData);
            JSONArray jsonArray=jsonObject.getJSONArray("data");
            for (int i = 0; i <jsonArray.length() ; i++) {
                JSONObject obj=(JSONObject)jsonArray.get(i);
                String arabicName=obj.getString("ar_name");
                String logo=obj.getString("logo");
                ClientsDatum clientData=new ClientsDatum();
                clientData.setArName(arabicName);
                clientData.setLogo(logo);
                list.add(clientData);
                list.add(clientData);
                list.add(clientData);
                list.add(clientData);
                list.add(clientData);
                list.add(clientData);list.add(clientData);
                list.add(clientData);list.add(clientData);
            }
            clients.setClientsData(list);

            /*ClientsAdapter adapter = new ClientsAdapter(clients, this);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);*/

            mCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
            Adapter adapter=null;
            mCoverFlow.setAdapter(adapter);

            mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //TODO CoverFlow item clicked
                }
            });

            mCoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
                @Override
                public void onScrolledToPosition(int position) {
                    //TODO CoverFlow stopped to position
                }

                @Override
                public void onScrolling() {
                    //TODO CoverFlow began scrolling
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
       /* clients = gson.fromJson(JsonData, Clients.class);
        if (clients != null) {
            // progressBar.setVisibility(View.GONE);

            ClientsAdapter adapter = new ClientsAdapter(clients, this);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);
        }*/
    }

    @Override
    public void OnFailure(String errorMsg) {

    }

    @Override
    public void ItemClicked(View v, int position) {
        Toast.makeText(this,clients.getClientsData().get(position).getArName(),Toast.LENGTH_SHORT).show();
    }

}
