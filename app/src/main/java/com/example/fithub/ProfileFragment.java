package com.example.fithub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private ImageView ivProfilePicture;
    private TextView tvUsername, tvBio, tvPosts, tvFollowers, tvFollowing;

    private static final int EDIT_PROFILE_REQUEST_CODE = 1001;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ivProfilePicture = view.findViewById(R.id.ivProfilePicture);
        tvUsername = view.findViewById(R.id.tvUsername);
        tvBio = view.findViewById(R.id.tvBio);
        tvPosts = view.findViewById(R.id.tvPosts);
        tvFollowers = view.findViewById(R.id.tvFollowers);
        tvFollowing = view.findViewById(R.id.tvFollowing);


        // Set data
        ivProfilePicture.setImageResource(R.drawable.icons8_customer_50); // Change to your profile picture resource
        tvUsername.setText("Your Username");
        tvBio.setText("Your bio goes here. It can be a few lines long.");
        tvPosts.setText("100");
        tvFollowers.setText("2000");
        tvFollowing.setText("150");


        // Set OnClickListener for "Edit Profile" button
        Button btnEditProfile = view.findViewById(R.id.btnEditProfile);
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start EditProfileActivity when "Edit Profile" button is clicked
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivityForResult(intent, EDIT_PROFILE_REQUEST_CODE);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDIT_PROFILE_REQUEST_CODE && resultCode == getActivity().RESULT_OK) {
            // Retrieve edited data
            String username = data.getStringExtra("username");
            String bio = data.getStringExtra("bio");
            String imageUriString = data.getStringExtra("imageUri");

            // Update UI with edited data
            tvUsername.setText(username);
            tvBio.setText(bio);

            // Check if image URI is provided
            if (imageUriString != null && !imageUriString.isEmpty()) {
                // Convert URI string back to URI
                Uri imageUri = Uri.parse(imageUriString);
                ivProfilePicture.setImageURI(imageUri);
            }
        }
    }
}
