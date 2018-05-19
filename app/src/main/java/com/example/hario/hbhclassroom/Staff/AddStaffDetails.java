package com.example.hario.hbhclassroom.Staff;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hario.hbhclassroom.MainActivity;
import com.example.hario.hbhclassroom.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.io.InputStream;

public class AddStaffDetails extends AppCompatActivity {

    String Choice="";
    private EditText name,aadharID,contactNumber,staffID,age,gender;
    private ImageView image;
    private Button addDetails;
    private Spinner StaffOccupationList;

    private static int GALLARY_REQUEST = 1;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    private Uri ImageUrl;

    public AddStaffDetails(){}


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_staff_details_layout);
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        progressDialog = new ProgressDialog(this);

        aadharID=(EditText)findViewById(R.id.Staff_Enter_AadharID);
        name = (EditText) findViewById(R.id.Staff_Enter_Name);
        name.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        staffID = (EditText)findViewById(R.id.Staff_ID);
        contactNumber = (EditText)findViewById(R.id.Staff_Enter_ContactNo);
        image = (ImageView)findViewById(R.id.Staff_add_image);
        age=(EditText) findViewById(R.id.Staff_enter_age);
        gender=(EditText)findViewById(R.id.Staff_Gender);
        gender.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        addDetails=(Button)findViewById(R.id.Staff_add_details);
        StaffOccupationList = findViewById(R.id.Staff_Occupation_SpinnerID);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Staff_Occupation_List,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        StaffOccupationList.setAdapter(adapter);

        StaffOccupationList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Choice = StaffOccupationList.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Choice = "Snacks";
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery =
                        new Intent(Intent.ACTION_PICK,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery, GALLARY_REQUEST);
            }
        });
        addDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadImageFileToFirebaseStorage(Choice);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            ImageUrl = data.getData();
            final InputStream imageStream = getContentResolver().openInputStream(ImageUrl);
            final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);

            image.setImageBitmap(selectedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void UploadImageFileToFirebaseStorage(final String Choice) {

        // Checking whether FilePathUri Is empty or not.
        final String stname = name.getText().toString().trim();
        final String stgender = gender.getText().toString();
        final String contact = contactNumber.getText().toString();
        final String staffAadhar = aadharID.getText().toString();

        String stage = age.getText().toString();
        final int stdage = Integer.parseInt(stage);
        String stfID = staffID.getText().toString();
        final int staffID = Integer.parseInt(stfID);


        if (ImageUrl != null && !TextUtils.isEmpty(stname) && !TextUtils.isEmpty(stgender)
                && !TextUtils.isEmpty(contact)&& !TextUtils.isEmpty(staffAadhar)&& !TextUtils.isEmpty(stfID)
                && !TextUtils.isEmpty(Choice)&& !TextUtils.isEmpty(stage)) {
            progressDialog.setMessage("Uploading...");
            progressDialog.show();

            //
            // Creating second StorageReference.
            StorageReference storageReference2nd = storageReference.child("StaffImage").child(ImageUrl.getLastPathSegment());

            // Adding addOnSuccessListener to second StorageReference.
            storageReference2nd.putFile(ImageUrl)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            //progressDialog.dismiss();
                            @SuppressWarnings("VisibleForTests")
                            StaffINFO studentINFO = new StaffINFO(stname, stgender,staffAadhar,contact,Choice,
                                    taskSnapshot.getDownloadUrl().toString(),stdage,staffID);

                            // Getting image upload ID.
                            String StaffUploadKeyID = databaseReference.push().getKey();

                            // Adding image upload id s child element into databaseReference.
                            String uuid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            databaseReference.child("staff").child("staffdetails").child(StaffUploadKeyID).setValue(studentINFO);
                            // Toast.makeText(getApplicationContext(), "Items Will Be Uploaded Shortly", Toast.LENGTH_LONG).show();
                            progressDialog.hide();
                            Toast.makeText(getApplicationContext(), "Staff's Details Added Successfully", Toast.LENGTH_LONG).show();

                            startActivity(new Intent(AddStaffDetails.this, MainActivity.class));
                            finish();
                        }
                    })
                    // If something goes wrong .
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {

                            // Hiding the progressDialog.
                            //  progressDialog.dismiss();

                            // Showing exception erro message.
                            Toast.makeText(AddStaffDetails.this,"Something is going wrong", Toast.LENGTH_LONG).show();
                        }
                    })

                    // On progress change upload time.
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                            // Setting progressDialog Title.
                            //  progressDialog.setTitle("Image is Uploading...");

                        }
                    });
        } else {

            Toast.makeText(AddStaffDetails.this, "Please Insert All Details ", Toast.LENGTH_LONG).show();

        }
    }
}
