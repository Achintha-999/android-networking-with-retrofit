package lk.acx.networkpractical.interceptor;

import android.content.Context;

import androidx.annotation.NonNull;

import java.io.IOException;

import lk.acx.networkpractical.api.AuthApi;
import lk.acx.networkpractical.client.RetrofitClient;
import lk.acx.networkpractical.dto.TokenDTO;
import lk.acx.networkpractical.manager.TokenManager;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthInterceptor implements Interceptor {
    private Context context;

    private static final String AUTHORIZATION = "Authorization";
    private static final int UNAUTHORIZED = 401;
    private AuthApi authApi;

    public AuthInterceptor(Context context) {
        this.context = context.getApplicationContext();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        authApi = retrofit.create(AuthApi.class);
    }


    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        String url = originalRequest.url().encodedPath();
        if (url.contains("/auth/login") || url.contains("/auth/refresh")) {
            return chain.proceed(originalRequest);
        }

        ///  attach request header ==> Authorization
        String accessToken = TokenManager.retrieveAccessToken(context);
        Request request = originalRequest.newBuilder()
                .header(AuthInterceptor.AUTHORIZATION, "Bearer " + accessToken)
                .build();
        Response response = chain.proceed(request);

        /// token refresh
        if (response.code() == AuthInterceptor.UNAUTHORIZED) {
            /// refresh logic
            response.close();
            synchronized (this) {
                String newAccess = fetchRefreshToken();
                if (newAccess != null) {
                    Request newRequest = originalRequest.newBuilder()
                            .header(AuthInterceptor.AUTHORIZATION, "Bearer " + newAccess)
                            .build();
                    return chain.proceed(newRequest);
                }
            }
        }

        return response;
    }

    private String fetchRefreshToken() {
        try {
            String refreshToken = TokenManager.retrieveRefreshToken(context); /// get refresh token from shared preference
            TokenDTO dto = new TokenDTO(); /// TokenDTO new instance
            dto.setRefreshToken(refreshToken); /// attach refresh taken for renew access token (auth/ refresh API calling)
            Call<TokenDTO> tokenDTOCall = authApi.refreshAccessToken(dto); /// make call event
            retrofit2.Response<TokenDTO> response = tokenDTOCall.execute(); /// synchronized call ==> stop other execution

            if (response.isSuccessful()) {
                TokenDTO tokenDTO = response.body();
                if (tokenDTO != null) {
                    TokenManager.saveTokens(context, tokenDTO);  /// save tokens again -> shared preference
                    return tokenDTO.getAccessToken();  /// return new access token
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ///when failed -> logout
        TokenManager.clearToken(context);  /// clear all tokens from shared preference
        return null;
    }
}
