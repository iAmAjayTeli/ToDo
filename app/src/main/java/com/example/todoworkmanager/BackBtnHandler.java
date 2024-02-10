package com.example.todoworkmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class BackBtnHandler {

    Context context;

    public BackBtnHandler(Context context) {
        this.context = context;
    }

    public void backBtnClick(View view){
        Intent intent=new Intent(context.getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

}
