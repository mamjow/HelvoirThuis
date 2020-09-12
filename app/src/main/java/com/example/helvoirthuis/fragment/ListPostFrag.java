package com.example.helvoirthuis.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.helvoirthuis.Post;
import com.example.helvoirthuis.adapter.PostAdapter;
import com.example.helvoirthuis.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListPostFrag extends Fragment {

    RecyclerView mRecyclerView;
    PostAdapter mAdapter;



    private ArrayList<Post> mPostsLists;
    private RequestQueue mRequestQueue;

    RecyclerView.LayoutManager layoutManager;
    View view;
    public ListPostFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_post, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView = view.findViewById(R.id.mRVPostList);
        mRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(layoutManager);


        mPostsLists = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(getActivity());
        String URL_DATA = "http://10.0.2.2:8000/api/blog/post-list";
        JsonArrayRequest arrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL_DATA,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            Log.e("Array response", String.valueOf(response));

//                            JSONObject jsonObject = new JSONObject(response);
                            for(int i=0; i<response.length(); i++){
                                JSONObject o = response.getJSONObject(i);
                                Log.e("Rest array", String.valueOf(o));
                                Post item = new Post(
                                        o.getString("post_id"),
                                        o.getString("post_title"),
                                        o.getString("post_header"),
                                        o.getString("post_body"),
                                        o.getString("post_expire_date"),
                                        o.getString("post_available_date"),
                                        o.getString("post_image"),
                                        o.getString("post_section"),
                                        o.getString("post_type"),
                                        o.getString("post_author"),
                                        o.getString("slug")
                                );
                                mPostsLists.add(item);
                            }
                            mAdapter = new PostAdapter(getActivity()
                                    , mPostsLists);
                            mRecyclerView.setAdapter(mAdapter);

                            mAdapter.setOnItemClickListener(new PostAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    String test = mPostsLists.get(position).getPost_title();
                                    System.out.println(test + "-riiiiidiiiiiiiiiiiiii");
                                }
                            });

                        } catch (JSONException e){e.printStackTrace();}
                    }


                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest response", error.toString());
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        mRequestQueue.add(arrayRequest);


    }

}
