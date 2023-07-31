package s22018.myhellocustomer;

import  android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
public class ConfirmDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        //ダイアログログビルダーを生成。
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        //ダイアログのタイトル設定
        builder.setTitle(R.string.dialog_title);
        //ダイアログのメッセージを設定
        builder.setMessage(R.string.dialog_msg);
        //Positive Buttonを設定
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        //Negative Buttonを設定
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());
        //ダイアログオブジェクトを生成し、リターン
        AlertDialog dialog = builder.create();
        return dialog;

    }

    //ダイアログのアクションボタンがタップされた時の処理が記載された処理
    private class DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which){
            //トーストメッセージ用文字列変数を用意
            String msg="";
            //タップされたアクションボタンで分岐
            switch (which){
                //Positive Button ならば
                case DialogInterface.BUTTON_POSITIVE:
                    //注文用のメッセージを格納
                    msg=getString(R.string.dialog_ok_toast);

                    break;
                //Negative Buttonならば
                case DialogInterface.BUTTON_NEGATIVE:
                    //キャンセル用のメッセージを格納
                    msg=getString(R.string.dialog_ng_toast);
                    break;
            }
            //トーストの表示
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}