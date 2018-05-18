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

public class AddStudentDetails extends AppCompatActivity {
    private EditText name,classs,section,semester,contactNumber,rollno,age,gender;
    private ImageView image;
    private Button addDetails;

    private static int GALLARY_REQUEST = 1;

    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;
    private Uri ImageUrl;

    public AddStudentDetails(){}


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student_details_layout);
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        progressDialog = new ProgressDialog(this);

        rollno=(EditText)findViewById(R.id.Student_RollNo);
        name = (EditText) findViewById(R.id.student_Enter_Name);
        name.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        classs = (EditText)findViewById(R.id.student_Enter_Class);
        classs.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        section=(EditText)findViewById(R.id.student_Enter_Section);
        semester=(EditText)findViewById(R.id.student_Enter_Semester);
        contactNumber = (EditText)findViewById(R.id.student_Enter_ContactNo);
        image = (ImageView)findViewById(R.id.student_add_image);
        age=(EditText) findViewById(R.id.Student_enter_age);
        gender=(EditText)findViewById(R.id.Student_Gender);
        gender.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        addDetails=(Button)findViewById(R.id.student_add_details);
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
        final String stname = name.getText().toString().trim();
        final String stgender = gender.getText().toString();
        final String stclass = classs.getText().toString();
        final String contact = contactNumber.getText().toString();

        String stroll = rollno.getText().toString();
        final int strollno = Integer.parseInt(stroll);
        String stsec = section.getText().toString();
        final int stsection = Integer.parseInt(stsec);

        String stsem = semester.getText().toString();
        final int stsemester = Integer.parseInt(stsem);


        String stage = age.getText().toString();
        final int stdage = Integer.parseInt(stage);


        if (ImageUrl != null && !TextUtils.isEmpty(stname) && !TextUtils.isEmpty(stgender)
                && !TextUtils.isEmpty(stclass)&& !TextUtils.isEmpty(stroll)&& !TextUtils.isEmpty(stsec)&&
                !TextUtils.isEmpty(contact)&& !TextUtils.isEmpty(stsem)&& !TextUtils.isEmpty(stage)) {
                  progressDialog.setMessage("Uploading...");
                  progressDialog.show();


            // Creating second StorageReference.
            StorageReference storageReference2nd = storageReference.child("StudentImage").child(ImageUrl.getLastPathSegment());

            // Adding addOnSuccessListener to second StorageReference.
            storageReference2nd.putFile(ImageUrl)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            //progressDialog.dismiss();
                            @SuppressWarnings("VisibleForTests")
                            StudentINFO studentINFO = new StudentINFO(stname, stclass,stgender,
                                    taskSnapshot.getDownloadUrl().toString(),strollno,stsection,stsemester,contact,stdage);

                            // Getting image upload ID.
                            String StudentUploadKeyID = databaseReference.push().getKey();

                            // Adding image upload id s child element into databaseReference.
                            String uuid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            databaseReference.child("student").child("studentdetails").child(StudentUploadKeyID).setValue(studentINFO);
                            // Toast.makeText(getApplicationContext(), "Items Will Be Uploaded Shortly", Toast.LENGTH_LONG).show();
                           progressDialog.hide();
                            Toast.makeText(getApplicationContext(), "Student's Details Added Successfully", Toast.LENGTH_LONG).show();

                            startActivity(new Intent(AddStudentDetails.this, MainActivity.class));
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
                            Toast.makeText(AddStudentDetails.this,"Something is going wrong", Toast.LENGTH_LONG).show();
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

            Toast.makeText(AddStudentDetails.this, "Please Insert All Details ", Toast.LENGTH_LONG).show();

        }
    }
}
