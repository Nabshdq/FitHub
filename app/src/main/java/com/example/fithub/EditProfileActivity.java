package com.example.fithub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView ivProfilePicture;
    private EditText etUsername, etBio;
    private Button btnSave, btnChangeProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        ivProfilePicture = findViewById(R.id.ivProfilePicture);
        etUsername = findViewById(R.id.etUsername);
        etBio = findViewById(R.id.etBio);
        btnSave = findViewById(R.id.btnSave);
        btnChangeProfilePicture = findViewById(R.id.btnChangeProfilePicture);

        btnChangeProfilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement logic to save changes
                String username = etUsername.getText().toString().trim();
                String bio = etBio.getText().toString().trim();

                // Example validation
                if (username.isEmpty()) {
                    etUsername.setError("Username cannot be empty");
                    etUsername.requestFocus();
                    return;
                }

                // Example logic to save changes
                saveChanges(username, bio, selectedImageUri);
            }
        });
    }

    private Uri selectedImageUri;

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Handle image selected from gallery
            selectedImageUri = data.getData();
            ivProfilePicture.setImageURI(selectedImageUri);
            Toast.makeText(this, "Image selected from gallery", Toast.LENGTH_SHORT).show();
        } else if (resultCode == RESULT_OK) {
            // If the result is from saving changes
            setResult(resultCode, data);
            finish();
        }
    }

    private void saveChanges(String username, String bio, Uri imageUri) {
        // Create an Intent to pass data back to ProfileFragment
        Intent resultIntent = new Intent();
        resultIntent.putExtra("username", username);
        resultIntent.putExtra("bio", bio);
        if (imageUri != null) {
            resultIntent.putExtra("imageUri", imageUri.toString());
        }
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
