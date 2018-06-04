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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

public class AddTeacherDetails extends AppCompatActivity {
    private EditText name,designation,contactNumber,id,gender,doj,age;
    private ImageView image;
    private Button addDetails;

    private static int GALLARY_REQUEST = 1;

    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    private Uri ImageUrl;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_teacher_details_layout);

        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        progressDialog = new ProgressDialog(this);

        id=(EditText)findViewById(R.id.teacher_id);
        name = (EditText) findViewById(R.id.teacher_Enter_Name);
        name.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        designation = (EditText)findViewById(R.id.teacher_Enter_Designation);
        designation.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        contactNumber = (EditText)findViewById(R.id.teacher_Enter_ContactNo);
        doj=(EditText)findViewById(R.id.teacher_Enter_DOJ);
        image = (ImageView)findViewById(R.id.teacher_add_image);
        age=(EditText) findViewById(R.id.Teacher_enter_age);
        gender=(EditText)findViewById(R.id.teacher_enter_Gender);
        gender.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        addDetails=(Button)findViewById(R.id.teacher_add_details);


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

                UploadImageFileToFirebaseStorage();
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

    public void UploadImageFileToFirebaseStorage() {

        // Checking whether FilePathUri Is empty or not.
        final String tcname = name.getText().toString().trim();
        final String tcgender = gender.getText().toString();
        final String tcdesignation = designation.getText().toString();
        final String dateofjoining = doj.getText().toString();
        final String contact = contactNumber.getText().toString();


        final String tcid = id.getText().toString();
        final int tchid = Integer.parseInt(tcid);
            String tcage = age.getText().toString();
        final int tchage = Integer.parseInt(tcage);


        if (ImageUrl != null && !TextUtils.isEmpty(tcname) && !TextUtils.isEmpty(tcgender)
                && !TextUtils.isEmpty(tcdesignation)&& !TextUtils.isEmpty(tcid)&& !TextUtils.isEmpty(tcage)&&
                !TextUtils.isEmpty(contact)&& !TextUtils.isEmpty(dateofjoining)) {
            progressDialog.setMessage("Uploading...");
            progressDialog.show();

              // Creating second StorageReference.
            StorageReference storageReference2nd = storageReference.child("TeacherImage").child(ImageUrl.getLastPathSegment());

            // Adding addOnSuccessListener to second StorageReference.
            storageReference2nd.putFile(ImageUrl)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            //progressDialog.dismiss();


                            @SuppressWarnings("VisibleForTests")
                            TeacherINFO teacherINFO = new TeacherINFO(tcname, tcdesignation,tcgender,
                                    taskSnapshot.getDownloadUrl().toString(),contact,tchid,tchage,dateofjoining);

                            String uuid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            databaseReference.child("teacher").child("teacherdetails").child(tcid).setValue(teacherINFO);
                            progressDialog.hide();
                            Toast.makeText(getApplicationContext(), "Teacher's Details Added Successfully", Toast.LENGTH_LONG).show();

                            startActivity(new Intent(AddTeacherDetails.this, MenuTeacherSection.class));
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
                            Toast.makeText(AddTeacherDetails.this,"Something is going wrong", Toast.LENGTH_LONG).show();
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

            Toast.makeText(AddTeacherDetails.this, "Please Insert All Details ", Toast.LENGTH_LONG).show();

        }
    }

}
