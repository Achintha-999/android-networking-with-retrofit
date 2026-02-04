package lk.acx.networkpractical.manager;

import android.content.Context;
import android.content.SharedPreferences;

import lk.acx.networkpractical.dto.TokenDTO;

public class TokenManager {
    private static final String PREFERENCE_NAME = "auth", ACCESS_TOKEN = "access_token", REFRESH_TOKEN = "refresh_token";

    public static void saveTokens(Context c, TokenDTO dto) {
        SharedPreferences sharedPreferences = c.getSharedPreferences(TokenManager.PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TokenManager.ACCESS_TOKEN, dto.getAccessToken());
        editor.putString(TokenManager.REFRESH_TOKEN, dto.getRefreshToken());
        editor.apply();
    }

    public static String retrieveAccessToken(Context c) {
        SharedPreferences sharedPreferences = c.getSharedPreferences(TokenManager.PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TokenManager.ACCESS_TOKEN, null);
    }

    public static String retrieveRefreshToken(Context c) {
        SharedPreferences sharedPreferences = c.getSharedPreferences(TokenManager.PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TokenManager.REFRESH_TOKEN, null);
    }

    public static void clearToken(Context c) {
        c.getSharedPreferences(TokenManager.PREFERENCE_NAME, Context.MODE_PRIVATE)
                .edit()
                .clear()
                .apply();
    }

}
