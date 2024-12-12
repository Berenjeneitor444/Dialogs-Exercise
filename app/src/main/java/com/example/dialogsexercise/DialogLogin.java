package com.example.dialogsexercise;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DialogLogin extends DialogFragment {
    private EditText usuario;
    private EditText password;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        usuario = new EditText(requireContext());
        password = new EditText(requireContext());
        usuario.setHint("Usuario");
        password.setHint("Contraseña");
        LinearLayout layout = new LinearLayout(requireContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(usuario);
        layout.addView(password);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(R.string.login_dialog)
                .setPositiveButton("Select", (dialog, which) -> {
                    String user = usuario.getText().toString();
                    String pass = password.getText().toString();
                    ((DialogActivity)requireActivity()).setTextViewText("Bienvenido " + user +
                            ". Tu contraseña es " + pass);
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .setView(layout);
        return builder.create();
    }
}