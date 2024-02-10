package com.example.todoworkmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class AddNewNotesBtnClickHandler {

    Context context;

    public AddNewNotesBtnClickHandler(Context context) {
        this.context = context;
    }

    public void btnClickHandler(View view){
        Intent intent=new Intent(view.getContext(), AddNotes.class);
        intent.putExtra("type", "addNoteMode");
        context.startActivity(intent);
    }
}
