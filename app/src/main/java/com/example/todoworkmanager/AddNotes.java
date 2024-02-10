package com.example.todoworkmanager;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todoworkmanager.databinding.ActivityAddNotesBinding;

import java.util.ArrayList;
import java.util.Objects;

public class AddNotes extends AppCompatActivity {

ActivityAddNotesBinding binding;
WorkModel workModel;
MyViewModel viewModel;
AddNotesBtnHandler AddNoteshandler;

BackBtnHandler backBtnHandler;
int NotesId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_add_notes);



     String type= getIntent().getStringExtra("type");
        assert type != null;
        if(type.equals("addNoteMode")){
         binding.addNotesTxt.setText("Add New Notes");
         binding.btn.setText("Add Notes");
     }
     else if (type.equals("UpdateMode")){
         String title=getIntent().getStringExtra("Title");
         String discription= getIntent().getStringExtra("Discription");
          NotesId= getIntent().getIntExtra("id", 0);
         binding.notesTitle.setText(title);
         binding.notesDisc.setText(discription);
         binding.addNotesTxt.setText("Update the Notes");
         binding.btn.setText("Update Notes");
     }

        String btnName= binding.btn.getText().toString();
        workModel=new WorkModel();
        viewModel=new ViewModelProvider(this).get(MyViewModel.class);
        AddNoteshandler=new AddNotesBtnHandler(workModel, this, viewModel, btnName, binding, NotesId);
        binding.setAddNotesBtnHandler(AddNoteshandler);
        binding.setNotes(workModel);

        backBtnHandler=new BackBtnHandler(this);
        binding.setBtnBack(backBtnHandler);

    }
}