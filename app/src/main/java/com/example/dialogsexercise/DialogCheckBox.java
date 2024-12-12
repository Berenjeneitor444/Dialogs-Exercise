package com.example.dialogsexercise;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class DialogCheckBox extends DialogFragment {
    private String[] choiceList;
    private Integer[] selected = {null , null, null};
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        choiceList = getResources().getStringArray(R.array.choice_list);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(R.string.checkbox_dialog)
                .setPositiveButton("Select", (dialog, which) -> {

                    ArrayList<String> stringList = new ArrayList<>();
                    for (int i = 0; i < selected.length; i++) {
                        if (selected[i] != null) {
                            stringList.add(choiceList[selected[i]]);
                        }
                    }
                    ((DialogActivity)requireActivity()).setTextViewText(stringList.toArray(new String[0]));
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .setMultiChoiceItems(choiceList, null, (dialog, which, isChecked) -> {
                    if(isChecked){
                        selected[which] = which;
                    }
                    else{
                        selected[which] = null;
                    }
                });

        return builder.create();
    }
}
