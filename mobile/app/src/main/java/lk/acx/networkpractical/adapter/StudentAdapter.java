package lk.acx.networkpractical.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lk.acx.networkpractical.R;
import lk.acx.networkpractical.dto.StudentDTO;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private final List<StudentDTO> list;

    public StudentAdapter(List<StudentDTO> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentDTO studentDTO = list.get(position);

        holder.studentName.setText(studentDTO.getName());
        holder.studentAge.setText(String.valueOf(studentDTO.getAge()));
        holder.studentCourse.setText(studentDTO.getCourse());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView studentName, studentAge, studentCourse;

        public ViewHolder(@NonNull View item) {
            super(item);
            this.studentName = item.findViewById(R.id.studentName);
            this.studentAge = item.findViewById(R.id.studentAge);
            this.studentCourse = item.findViewById(R.id.studentCourse);
        }

        public TextView getStudentName() {
            return studentName;
        }

        public TextView getStudentAge() {
            return studentAge;
        }

        public TextView getStudentCourse() {
            return studentCourse;
        }
    }
}
