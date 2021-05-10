package com.example.connectiiest.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.connectiiest.Models.Users;
import com.example.connectiiest.R;
import com.example.connectiiest.UserProfileActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    ArrayList<Users> list;
    Context context;

    public UsersAdapter(Context context, ArrayList<Users> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_show_user, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users users = list.get(position);
        holder.userName.setText(users.getUserName());
        Picasso.get().load(users.getProfilePic()).placeholder(R.drawable.ic_user).into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList(ArrayList<Users> filteredList){
        list = filteredList;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView userImage;
        TextView userName;
        public ViewHolder(View itemView){
            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            userName = itemView.findViewById(R.id.userName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
//            Toast.makeText(context, "Hello World" + position, Toast.LENGTH_SHORT).show();
            Users user = list.get(position);
            String name = user.getUserName();
            String status = user.getStatus();
            String profile_pic = user.getProfilePic();
            Intent myIntent = new Intent(context, UserProfileActivity.class);
            myIntent.putExtra("NAME", name);
            myIntent.putExtra("STATUS", status);
            myIntent.putExtra("PROFILE_PIC", profile_pic);
            context.startActivity(myIntent);
        }
    }
}
