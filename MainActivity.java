package com.example.jrz.android_shixun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        private EditText name,pwd;
        private Button login;
        private String status;
        private String user;
        private String name2;
        private String TAG = "Login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.et_name);
        pwd = findViewById(R.id.et_pwd);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String username = name.getText().toString().trim();
        String password = pwd.getText().toString().trim();
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"账号不能为空!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"密码不能为空!",Toast.LENGTH_SHORT).show();
            return;
        }
        Utils.postLogin(username, password, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                showData(data);
                JsonSteam(data);
                if (status.equals("登陆成功")){
                    ShowSuccessView();

                }else {
                    ShowUnSuccessView();
                }
            }
        });

    }

    private void ShowUnSuccessView() {
        Log.e(TAG, "失败");
    }

    private void ShowSuccessView() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                Toast.makeText(this,"cg",Toast.LENGTH_SHORT).show();
                name.setText("");
                pwd.setText("");
                Intent intent = new Intent(MainActivity.this,main2.class);
                startActivity(intent);
            }
        });
    }

    private void JsonSteam(String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            status  = jsonObject.getString("status");
            user  = jsonObject.getString("user");
            name2  = jsonObject.getString("name");

            Log.e(TAG, "JsonSteam: "+status+"\n"+user+"\n"+name2+"\n" );

        } catch (JSONException e) {
            e.printStackTrace( );
            Log.e(TAG, "JsonSteam:unOk "+status+"\n"+user+"\n"+name2+"\n" );

        }

    }



    private void showData(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "11 "+data );
//                getText();
            }
        });
    }

//    private void getText() {
//        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
//    }
}
