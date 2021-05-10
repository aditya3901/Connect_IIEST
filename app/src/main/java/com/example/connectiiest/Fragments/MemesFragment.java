package com.example.connectiiest.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.connectiiest.R;
import com.example.connectiiest.databinding.FragmentMemesBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.Objects;

public class MemesFragment extends Fragment {
    String url;

    public MemesFragment() {
        // Required empty public constructor
    }

    FragmentMemesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMemesBinding.inflate(inflater, container, false);

        loadMeme();
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMeme();
            }
        });

        return binding.getRoot();
    }

    private void loadMeme(){
        // Instantiate the RequestQueue.
        binding.progressBar.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
        url ="https://meme-api.herokuapp.com/gimme";

        // Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String url = response.getString("url");
                            Picasso.get().load(url).into(binding.memeImage, new Callback() {
                                @Override
                                public void onSuccess() {
                                    binding.progressBar.setVisibility(View.GONE);
                                }
                                @Override
                                public void onError(Exception e) {
                                    binding.progressBar.setVisibility(View.GONE);
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
    }

}