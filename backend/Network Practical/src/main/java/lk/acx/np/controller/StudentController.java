package lk.acx.np.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lk.acx.np.entity.Student;
import lk.acx.np.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

@Path("/students")
public class StudentController {
    @GET
    @Path("/get-all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStudents(){
        try(Session hibernateSession = HibernateUtil.getSessionFactory().openSession()){
            List<Student> studentList = hibernateSession.createQuery("FROM Student s", Student.class)
                    .getResultList();
            return Response.ok().entity(studentList).build();
        }
    }
}