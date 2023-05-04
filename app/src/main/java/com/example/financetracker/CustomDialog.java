package com.example.financetracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.View;
import android.widget.Button;

public class CustomDialog extends DialogFragment {

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Define your dialog here
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(R.layout.blurry_dial_asset);
        return builder.create();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button addButton = view.findViewById(R.id.add_button);
        addButton.setOnClickListener(view1 -> {
            CustomDialog customDialog = new CustomDialog();
            customDialog.show(getParentFragmentManager(), "custom_dialog");
        });
    }
}
