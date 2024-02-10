package com.example.todoworkmanager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.AndroidViewModel;

import com.example.todoworkmanager.databinding.ActivityAddNotesBinding;

public class AddNotesBtnHandler{

    WorkModel notes;
    Context context;
    MyViewModel viewModel;
    ActivityAddNotesBinding binding;
    String  btnName;
    Repository repository;
    int NotesId;

    public AddNotesBtnHandler(WorkModel notes, Context context,
                              MyViewModel viewModel, String btnName, ActivityAddNotesBinding binding, int NotesId) {
        this.notes = notes;
        this.context = context;
        this.viewModel = viewModel;
        this.btnName=btnName;
        this.binding=binding;
        this.NotesId=NotesId;
    }


    public void addNewNotes(View view){

        if(btnName.equals("Add Notes")){
            if(binding.notesTitle.getText().toString().trim().isEmpty() || binding.notesDisc.getText().toString().trim().isEmpty()){
                Toast.makeText(context, "Please enter in both fields", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent=new Intent(view.getContext(), MainActivity.class);
                WorkModel workModel=new WorkModel(binding.notesTitle.getText().toString(), binding.notesDisc.getText().toString());
                viewModel.addNewNotes(workModel);
                context.startActivity(intent);
                Toast.makeText(context, "Note added Succesfully", Toast.LENGTH_SHORT).show();
            }
        }
        else if(btnName.equals("Update Notes")){
            String updatedTitle = binding.notesTitle.getText().toString();
            String updatedDescription = binding.notesDisc.getText().toString();
            // Assume you have a method to retrieve a WorkModel object by its ID in your repository


            if (updatedTitle.trim().isEmpty() || updatedDescription.trim().isEmpty()) {
                Toast.makeText(context, "Please enter in both fields", Toast.LENGTH_SHORT).show();
            } else {

                WorkModel workModel=new WorkModel(updatedTitle, updatedDescription);
                workModel.setId(NotesId);
               viewModel.updateNewNodes(workModel);
                Toast.makeText(context, "Note updated", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                context.startActivity(intent);

            }
        }


    }
}
