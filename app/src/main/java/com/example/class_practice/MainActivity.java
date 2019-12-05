package com.example.class_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText meditText;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ho:
                Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.co:
                copyToClipBoard();

                return true;
            case R.id.open_id:
                Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show();
                return true;



            default:
                return super.onOptionsItemSelected(item);

        }


    }

    private void copyToClipBoard() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("usersname", meditText.getText().toString());
        clipboard.setPrimaryClip(clip);

    }
    private void pastClipBoard(){
        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        android.content.ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
        if (item.getText() != null) {
            meditText.setText(item.getText());
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meditText = findViewById(R.id.editText2);
 registerForContextMenu(findViewById(R.id.editText2));
        }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

      getMenuInflater().inflate(R.menu.context_mmm,menu);
      switch (v.getId()){
          case R.id.username:
              copyToClipBoard();

          case R.id.password:
              pastClipBoard();

      }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.background, menu);
        return true;



    }



}
