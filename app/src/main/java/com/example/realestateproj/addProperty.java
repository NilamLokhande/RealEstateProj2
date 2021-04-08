package com.example.realestateproj;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class addProperty extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Button mButtonChooseImage;
    private Button mButtonUpload;
    private TextView mTextViewShowUploads;
    private EditText mEditTextPropertyName;
    private EditText mEditTextPropertyDesc;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private Uri mImageUri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);

        mButtonChooseImage =findViewById(R.id.button_choose_image);
        mButtonUpload= findViewById(R.id.button_upload);
        mTextViewShowUploads=findViewById(R.id.textView26);
        mEditTextPropertyName=findViewById(R.id.editTextTextPersonName4);
        mEditTextPropertyDesc=findViewById(R.id.editTextTextPersonName5);
        mImageView=findViewById(R.id.image_view);
        mProgressBar=findViewById(R.id.progress_bar);

        mStorageRef= FirebaseStorage.getInstance().getReference("Sales");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Sales");


        mButtonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();

            }
        });
        mButtonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              uploadFile();
            }
        });
        mTextViewShowUploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void openFileChooser(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
          mImageUri = data.getData();
          Picasso.get().load(mImageUri).into(mImageView);
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime= MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile(){
         if(mImageUri != null){
             StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()+"."+getFileExtension(mImageUri));
             fileReference.putFile(mImageUri)
                     .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                         @Override
                         public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                             Handler handler= new Handler();
                             handler.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {
                                     mProgressBar.setProgress(0);
                                 }
                             },500);

                             Toast.makeText(addProperty.this,"Upload successful",Toast.LENGTH_LONG).show();

                             Upload upload=new Upload(mEditTextPropertyName.getText().toString().trim(),
                                     taskSnapshot.getStorage().getDownloadUrl().toString());
                             String uploadId= mDatabaseRef.push().getKey();
                             mDatabaseRef.child(uploadId).setValue(upload);

                         }
                     })
                     .addOnFailureListener(new OnFailureListener() {
                         @Override
                         public void onFailure(@NonNull Exception e) {
                            Toast.makeText(addProperty.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                         }
                     })
                     .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                         @Override
                         public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                           double progress=(100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());{
                               mProgressBar.setProgress((int)progress);
                             }
                         }
                     });

         }else {
             Toast.makeText(this,"No file selected",Toast.LENGTH_SHORT).show();
         }
    }
}