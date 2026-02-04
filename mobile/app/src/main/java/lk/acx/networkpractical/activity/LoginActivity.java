package lk.acx.networkpractical.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


import lk.acx.networkpractical.R;
import lk.acx.networkpractical.api.AuthApi;
import lk.acx.networkpractical.client.RetrofitClient;
import lk.acx.networkpractical.dto.LoginRequestDTO;
import lk.acx.networkpractical.dto.TokenDTO;
import lk.acx.networkpractical.manager.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText emailInput = findViewById(R.id.emailInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                login(email, password);
            }
        });

    }

    private void login(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
        } else {
            Retrofit instance = RetrofitClient.getInstance(this);
            AuthApi authApi = instance.create(AuthApi.class);

            LoginRequestDTO dto = new LoginRequestDTO(email, password);
            Call<TokenDTO> tokenDTOCall = authApi.userLogin(dto);
            tokenDTOCall.enqueue(new Callback<TokenDTO>() {
                @Override
                public void onResponse(Call<TokenDTO> call, Response<TokenDTO> response) {
                    if(response.isSuccessful()){
                        TokenDTO tokenDTO = response.body();
                        if(tokenDTO != null){
                   //         Log.d("LoginActivity", "Token: " + tokenDTO.getAccessToken());
                            TokenManager.saveTokens(LoginActivity.this, tokenDTO);
                            Intent intent = new Intent(LoginActivity.this, StudentListActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }

                @Override
                public void onFailure(Call<TokenDTO> call, Throwable t) {
                    t.printStackTrace();
                }
            });


        }
    }
}