package lk.acx.networkpractical.api;

import java.util.List;

import lk.acx.networkpractical.dto.StudentDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface StudentApi {

    @GET("students/get-all")
    Call<List<StudentDTO>> getAllStudents();


}
