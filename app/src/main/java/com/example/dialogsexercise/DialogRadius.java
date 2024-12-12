package com.example.dialogsexercise;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogRadius extends DialogFragment {
    private String[] choiceList;
    private int selected = 0;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        choiceList = getResources().getStringArray(R.array.choice_list);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(R.string.radius_title)
                .setPositiveButton("Select", (dialog, which) -> {
                    ((DialogActivity)requireActivity()).setTextViewText("You selected " + choiceList[selected]);
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .setSingleChoiceItems(choiceList,0, (dialog, which) -> {selected = which;});
        return builder.create();
    }
}
