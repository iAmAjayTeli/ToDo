package com.example.todoworkmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.todoworkmanager.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Data source
    private WorkDatabase workDatabase;
    private ArrayList<WorkModel> notelist;

    //Adapter
   private Adapter adapter;

    //Data binding
   private ActivityMainBinding binding;


    private AddNewNotesBtnClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        handler=new AddNewNotesBtnClickHandler(this);
        binding.setAddNewNotesBtnClickHandler(handler);

        notelist=new ArrayList<>();
        RecyclerView recyclerView=binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        workDatabase=WorkDatabase.getInstace(this);

        //ViewModel
        MyViewModel viewModel=new ViewModelProvider(this).get(MyViewModel.class);



       viewModel.getAllNotes().observe(this, new Observer<List<WorkModel>>() {
           @Override
           public void onChanged(List<WorkModel> notesList) {
               notelist.clear();
              for(WorkModel workModel : notesList){
                  notelist.add(workModel);
              }
              adapter.notifyDataSetChanged();
           }
       });

        adapter=new Adapter(notelist);

        recyclerView.setAdapter(adapter);



       new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
           @Override
           public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
               return false;
           }

           @Override
           public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
               if(direction==ItemTouchHelper.LEFT){
                   WorkModel notes= notelist.get(viewHolder.getAdapterPosition());
                   viewModel.deleteNewNotes(notes);
                   Toast.makeText(MainActivity.this, ""+notes.getTitle()+" is deleted successfully", Toast.LENGTH_SHORT).show();
               }

               else{
                   Intent intent=new Intent(MainActivity.this, AddNotes.class);
                   intent.putExtra("type", "UpdateMode");
                   WorkModel notes= notelist.get(viewHolder.getAdapterPosition());
                   intent.putExtra("Title", notes.getTitle());
                   intent.putExtra("Discription", notes.getDiscription());
                   intent.putExtra("id", notes.getId());
                   startActivity(intent);
               }


           }
       }).attachToRecyclerView(recyclerView);

    }
}