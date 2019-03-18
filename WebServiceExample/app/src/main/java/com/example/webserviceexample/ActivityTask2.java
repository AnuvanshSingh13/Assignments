package com.example.webserviceexample;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.webserviceexample.httpURL.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ActivityTask2 extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Modal> list;
    MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        recyclerView = findViewById(R.id.recyclerview);
        list = new ArrayList<>();
                                                //globally setting the manager and adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityTask2.this));
        adapter = new MyRecyclerAdapter(list, ActivityTask2.this);
        recyclerView.setAdapter(adapter);
    }

    public void mRetrofitConnection(View view) {    //onclick method for retrofit
        ApiInterface apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<Posts> modalCall = apiInterface.getPosts();
        modalCall.enqueue(new ResponseHandler<Posts>(new SuccessAPICallback<Posts>() {
            @Override
            public void onResponse(Posts posts) {
                list.clear();
                list.addAll(posts.getList());
                adapter.notifyDataSetChanged();
            }
        }, new FailureAPICallback() {
            @Override
            public void onFailure(Object errorCode, Object errorMessage) {
                Toast.makeText(ActivityTask2.this, "error Occured", Toast.LENGTH_SHORT).show();
            }
        }, ActivityTask2.this));
    }


    //common recyclerView for retrofit and both retrofit and HttpUrl connection
    private class MyRecyclerviewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewMessage;

        public MyRecyclerviewHolder(@NonNull View itemView) {   //recyclerView Holder
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textViewName = itemView.findViewById(R.id.textView_name);
            textViewMessage = itemView.findViewById(R.id.textView_message);
        }
    }

                    //RecycleViewAdapter
    private class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerviewHolder> {
        List<Modal> list;
        Context context;

        public MyRecyclerAdapter(List<Modal> list, Context context) {
            this.list = list;
            this.context = context;
        }

        //viewHolder for recycler view
        @NonNull
        @Override
        public MyRecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new MyRecyclerviewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyRecyclerviewHolder myRecyclerviewHolder, int i) {
            Modal modal = list.get(i);
            Glide.with(context)
                    .load(modal.getProfileImage())
                    .into(myRecyclerviewHolder.imageView);
            myRecyclerviewHolder.textViewName.setText(modal.getName());
            myRecyclerviewHolder.textViewMessage.setText(modal.getMessage());

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    //onclick for HttpUrl Connection
    public void mhttpConnection(View view) {
        String requestUrl = "https://storage.googleapis.com/network-security-conf-codelab.appspot.com/v2/posts.json";
        GetPostsData asyncTask = new GetPostsData();
        asyncTask.execute(requestUrl);
    }

    //AsyncTask to execute the Url Over HttpUrl Connection
    private class GetPostsData extends AsyncTask<String, Void, List<Modal>> {
        @Override
        protected List<Modal> doInBackground(String... objects) {
            HttpHandler httpHandler = new HttpHandler();
            String json = httpHandler.getJSONString(objects[0]);
            List<Modal> list = new ArrayList<>();
            if (json != null) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray jsonArray = jsonObject.getJSONArray("posts");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject post = jsonArray.getJSONObject(i);
                        Modal modal = new Modal(
                                post.getString("name"),
                                post.getString("message"),
                                post.getString("profileImage"));
                        list.add(modal);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return list;
        }

        @Override
        protected void onPostExecute(List<Modal> modals) {
            super.onPostExecute(modals);
            list.clear();
            list.addAll(modals);
            adapter.notifyDataSetChanged();
        }
    }
}
