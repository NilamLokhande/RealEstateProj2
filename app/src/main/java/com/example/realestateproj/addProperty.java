package com.example.realestateproj;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class addProperty extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Button mButtonChooseImage;
    private Button mButtonUpload;
    private TextView mTextViewShowUploads;
    private EditText mEditTextPropertyName;
    private EditText mEditTextPropertyDesc;
    private EditText mEditTextPropertyAddress;
    private EditText mEditTextPropertyPrice;
    private EditText mEditTextCountryCode;
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
        mEditTextPropertyAddress= findViewById(R.id.propertyAddress);
        mEditTextPropertyPrice=findViewById(R.id.enterPrize);
        mEditTextCountryCode=findViewById(R.id.enterCountryCode);
        mProgressBar =findViewById(R.id.progress_bar);

        mImageView=findViewById(R.id.image_view);

        mStorageRef= FirebaseStorage.getInstance().getReference();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Properties").child("Sales");


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
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), mImageUri);
                mImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime= MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile(){
         if(mImageUri != null){
             StorageReference storageReference2 = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(mImageUri));
             storageReference2.putFile(mImageUri)
                     .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                         @Override
                         public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                             storageReference2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                 @Override
                                 public void onSuccess(Uri uri) {
                                    String url = uri.toString();
//                                    String key = mDatabaseRef.child("Sales").push().getKey();
                                     String PropName = mEditTextPropertyName.getText().toString().trim();
                                     String Description = mEditTextPropertyDesc.getText().toString().trim();
                                     String Address = mEditTextPropertyAddress.getText().toString().trim();
                                     String Price = mEditTextPropertyPrice.getText().toString().trim();
                                     String countryCode = mEditTextCountryCode.getText().toString().trim();

                                     Toast.makeText(getApplicationContext(), "Image Uploaded Successfully ", Toast.LENGTH_LONG).show();
                                     @SuppressWarnings("VisibleForTests")
                                     String ImageUploadId = mDatabaseRef.push().getKey();
                                     Upload imageUploadInfo = new Upload(PropName, url, Description, Address, Price, countryCode);
//                                     String ImageUploadId = mDatabaseRef.push().getKey();

                                     mDatabaseRef.child(ImageUploadId).setValue(imageUploadInfo);
                                     startActivity(new Intent(addProperty.this, home.class));
                                 }
                             });

                         }
                     });

         }else {
             Toast.makeText(this,"No file selected",Toast.LENGTH_SHORT).show();
         }
    }
}