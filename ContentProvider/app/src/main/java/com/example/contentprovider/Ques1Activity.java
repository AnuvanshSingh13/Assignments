package com.example.contentprovider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ques1Activity extends AppCompatActivity {

    private static final int TASK1_PERMISSION_REQ_CODE = 101;
    private MyRecyclerAdapter adapter;
    List<Modal> list;
    //Root external dir in device
    String rootPath = Environment.getExternalStorageDirectory().getPath();
    //Variable to store parent directory of current showing directory in recyclerview
    String parentPath = Environment.getExternalStorageDirectory().getPath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques1);
        list = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerview_ques1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);

        //checking runtime permission for android 23 and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, TASK1_PERMISSION_REQ_CODE);
            } else {
                //permission granted
                populateList(list, rootPath);
            }
        } else {
            //permission statically granted for devices below android 23
            populateList(list, rootPath);
        }
    }

    //method to display content every time user interacts and select a directory
    private void populateList(List<Modal> list, String selectedParentPath) {
        File selectedDirectory = new File(selectedParentPath);
        //since we're browsing selectedParentPath, thus we must set it as new parentPath
        parentPath = selectedParentPath;
        if (selectedDirectory.listFiles() != null) {
            list.clear();
            //browsing all the sub directories insied selected directory and adding them to recyclerview
            for (File file : selectedDirectory.listFiles()) {
                if (file.isDirectory()) {
                    //if the file is directory
                    list.add(new Modal(file.getName(), file.getPath(), Modal.FILE_TYPE_DIRECTORY));
                } else {
                    //if the file is a real file
                    list.add(new Modal(file.getName(), file.getPath(), Modal.FILE_TYPE_FILE));
                }
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == TASK1_PERMISSION_REQ_CODE
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //permission granted
            //initailly adding root directory contents into the recyclerview
            populateList(list, rootPath);
        } else {
            //permission not granted
            Toast.makeText(this, "READ STORAGE PERMISSION REQUIRED", Toast.LENGTH_SHORT).show();
        }
    }

    //this method is used to move back to parent directory
    public void mMoveToParent(View view) {
        if (!parentPath.equals(rootPath)) {
            //obtaining parent directory
            File currentParent = new File(parentPath);
            populateList(list, currentParent.getParent());
        }
    }

    //recyclerview adapter
    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {
        private List<Modal> list;

        MyRecyclerAdapter(List<Modal> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_task1, viewGroup, false);
            return new MyRecyclerViewHolder(view);
        }

        //@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public void onBindViewHolder(@NonNull MyRecyclerViewHolder myRecyclerViewHolder, int i) {
            final Modal modal = list.get(i);
            myRecyclerViewHolder.textViewFileFolderName.setText(modal.getfName());
            myRecyclerViewHolder.textViewFileFolderPath.setText(modal.getfPath());
            if (modal.getFileType() == Modal.FILE_TYPE_DIRECTORY) {
                //if the clicked item correspond to a directory, we'll browse it
                myRecyclerViewHolder
                        .textViewFileFolderName
                        .setCompoundDrawablesRelativeWithIntrinsicBounds(
                                R.drawable.ic_folder_black_24dp, 0, 0, 0);
                myRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        populateList(list, modal.getfPath());
                    }
                });
            } else {
                //if the clicked item correspond to a file, we'll open it
                myRecyclerViewHolder
                        .textViewFileFolderName
                        .setCompoundDrawablesRelativeWithIntrinsicBounds(
                                R.drawable.ic_file_black_24dp, 0, 0, 0);
                myRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        File file = new File(modal.getfPath());
                        String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                                MimeTypeMap.getFileExtensionFromUrl(modal.getfPath())
                        );

                        //using content provider to open file
                        Uri uri = FileProvider.getUriForFile(Ques1Activity.this, BuildConfig.APPLICATION_ID + ".provider", file);
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                        intent.putExtra("PATH", modal.getfPath());
                        intent.putExtra("MIMETYPE", mimeType);
                        intent.setType(mimeType);
                        intent.setDataAndType(uri, mimeType);
                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        startActivity(Intent.createChooser(intent, "Open using"));
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }


    //recyclerview holder
    class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textViewFileFolderName;
        TextView textViewFileFolderPath;

        MyRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewFileFolderName = itemView.findViewById(R.id.text_disp_folder_file_name);
            textViewFileFolderPath = itemView.findViewById(R.id.text_disp_folder_file_path);
        }

    }

    //modal class to store file/dir name and their path along with their types
    class Modal {
        private String fName;
        private String fPath;
        private int fileType;
        static final int FILE_TYPE_DIRECTORY = 1;
        static final int FILE_TYPE_FILE = 2;

        Modal(String fName, String fPath, int fileType) {
            this.fName = fName;
            this.fPath = fPath;
            this.fileType = fileType;
        }

        String getfName() {
            return fName;
        }

        String getfPath() {
            return fPath;
        }

        int getFileType() {
            return fileType;
        }

    }
}



