package com.example.songpad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class add_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);

        ImageButton ibSizeJ = findViewById(R.id.ibTextSize);
        ImageButton ibBoldJ = findViewById(R.id.ibBold);
        ImageButton ibItalicsJ = findViewById(R.id.ibItalics);
        ImageButton ibCenterJ = findViewById(R.id.ibCenter);
        ImageButton ibLeftJ = findViewById(R.id.ibLeft);
        ImageButton ibVoiceJ = findViewById(R.id.ibVoice);
        EditText etTitleJ = findViewById(R.id.etTitle);
        EditText etDescriptionJ = findViewById(R.id.etDescription);

        ibSizeJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ibBoldJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spannable spannableString = new SpannableStringBuilder(etDescriptionJ.getText());
                spannableString.setSpan(new StyleSpan(Typeface.BOLD),
                        etDescriptionJ.getSelectionStart(),
                        etDescriptionJ.getSelectionEnd(), 0);

                etDescriptionJ.setText(spannableString);
            }
        });
        ibItalicsJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spannable spannableString = new SpannableStringBuilder(etDescriptionJ.getText());
                spannableString.setSpan(new StyleSpan(Typeface.ITALIC),
                        etDescriptionJ.getSelectionStart(),
                        etDescriptionJ.getSelectionEnd(), 0);
                etDescriptionJ.setText(spannableString);
            }
        });
        ibCenterJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDescriptionJ.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                Spannable spannableString = new SpannableStringBuilder(etDescriptionJ.getText());
                etDescriptionJ.setText(spannableString);
            }
        });
        ibLeftJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDescriptionJ.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                Spannable spannableString = new SpannableStringBuilder(etDescriptionJ.getText());
                etDescriptionJ.setText(spannableString);

            }
        });

        ibVoiceJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}