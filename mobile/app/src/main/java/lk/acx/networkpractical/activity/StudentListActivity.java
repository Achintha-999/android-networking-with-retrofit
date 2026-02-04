package lk.acx.networkpractical.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import lk.acx.networkpractical.R;
import lk.acx.networkpractical.adapter.StudentAdapter;
import lk.acx.networkpractical.api.StudentApi;
import lk.acx.networkpractical.client.RetrofitClient;
import lk.acx.networkpractical.dto.StudentDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StudentListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<StudentDTO> studentDTOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        this.recyclerView = findViewById(R.id.studentRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadAllStudents();

    }

    private void loadAllStudents() {
        Retrofit retrofit = RetrofitClient.getInstance(this);
        StudentApi studentApi = retrofit.create(StudentApi.class);
        Call<List<StudentDTO>> listCall = studentApi.getAllStudents();
        listCall.enqueue(new Callback<List<StudentDTO>>() {
            @Override
            public void onResponse(Call<List<StudentDTO>> call, Response<List<StudentDTO>> response) {
                if (response.isSuccessful()) {
                    studentDTOS = response.body();
                    if (studentDTOS != null && !studentDTOS.isEmpty()) {
                        StudentAdapter studentAdapter = new StudentAdapter(studentDTOS);
                        recyclerView.setAdapter(studentAdapter);
                        setDataForSearchBar();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<StudentDTO>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setDataForSearchBar() {
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.searchInput);
        if (studentDTOS != null && !studentDTOS.isEmpty()) {
            List<String> names = new ArrayList<>();
            for (StudentDTO dto:studentDTOS){
                names.add(dto.getName());
            }
//            String[] namesArray = names.toArray(new String[0]);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, names);
            autoCompleteTextView.setAdapter(arrayAdapter);
        }
    }
}