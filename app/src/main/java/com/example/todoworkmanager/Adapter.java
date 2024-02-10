package com.example.todoworkmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoworkmanager.databinding.ListSampleBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    private ArrayList<WorkModel> notes;

    public void setNotes(ArrayList<WorkModel> notes) {
        this.notes = notes;

        notifyDataSetChanged();
    }

    public Adapter(ArrayList<WorkModel> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ListSampleBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.list_sample, parent, false);
       return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    holder.binding.setWorkModel(notes.get(position));

    }

    @Override
    public int getItemCount() {
        if(notes!=null){
            return notes.size();
        }
        else{
            return 0;
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ListSampleBinding binding;
        public viewHolder(@NonNull ListSampleBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }


    }

}
