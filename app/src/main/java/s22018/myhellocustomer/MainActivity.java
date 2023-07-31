package s22018.myhellocustomer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.LauncherActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン・オブジェクトの用意
        Button btConfirm = findViewById(R.id.btConfirm);

        //リスナオブジェクトの用意
        HellowListener listener = new HellowListener();
        btConfirm.setOnClickListener(listener);

        //homeクリアボタンであるButtonobjectを取得
        Button btHome = findViewById(R.id.btClear);
        //クリアボタンにリスナを追加
        btHome.setOnClickListener(listener);

        //nameクリアボタン2であるButtonobjectを取得
        Button btName = findViewById(R.id.btSend);

        //クリアボタン2にリスナを追加
        btName.setOnClickListener(listener);


    }


    private class HellowListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            EditText input = findViewById(R.id.editTextText2);//タイトル
            EditText input2 = findViewById(R.id.etName);//名前
            EditText input3 = findViewById(R.id.Email);//メアド
            EditText input4 = findViewById(R.id.etComment);//質問

            TextView output = findViewById(R.id.editTextText2);
            TextView output2 = findViewById(R.id.etName);
            TextView output3 = findViewById(R.id.Email);
            TextView output4 = findViewById(R.id.etComment);


            int id = v.getId();


            if (id == R.id.btSend) {

                String inputStr = input.getText().toString();

                String inputStr2 = input2.getText().toString();

                String inputStr3 = input3.getText().toString();
                String inputStr4 = input3.getText().toString();


                String inputText = "name: " + inputStr2 + "タイトル: " + inputStr2 + "mail: " + inputStr3 + "質問: " + inputStr4;
                Snackbar.make(v, inputText, Snackbar.LENGTH_LONG).show();

            } else if (id == R.id.btConfirm) {

                String inputStr = input.getText().toString();

                String inputStr2 = input2.getText().toString();

                String inputStr3 = input3.getText().toString();
                String inputStr4 = input3.getText().toString();
                String inputText = "name: " + inputStr2 + "タイトル: " + inputStr2 + "mail: " + inputStr3 + "質問: " + inputStr4;


                ConfirmDialog dialogFragment = new ConfirmDialog();
                dialogFragment.show(getSupportFragmentManager(), "ConfirmDialog");

                Snackbar.make(v, inputText, Snackbar.LENGTH_LONG).show();

            } else if (id == R.id.btClear) {
                input.setText("");
                output.setText("");
                input2.setText("");
                output2.setText("");
                input3.setText("");
                output3.setText("");
                input4.setText("");
                output4.setText("");

            }
        }
    }
}