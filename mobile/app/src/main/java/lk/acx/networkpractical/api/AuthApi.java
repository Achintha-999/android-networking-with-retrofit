package lk.acx.networkpractical.api;

import lk.acx.networkpractical.dto.LoginRequestDTO;
import lk.acx.networkpractical.dto.TokenDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {
    @POST("auth/refresh")
    Call<TokenDTO> refreshAccessToken(@Body TokenDTO tokenDTO);

    @POST("auth/login")
    Call<TokenDTO> userLogin(@Body LoginRequestDTO requestDTO);
}
