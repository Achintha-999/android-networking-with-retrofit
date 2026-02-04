package lk.acx.np.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lk.acx.np.entity.Student;
import lk.acx.np.util.HibernateUtil;
import lk.acx.np.util.JwtUtil;
import org.hibernate.Session;


import java.util.List;

@Path("/test")
public class Test {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(){
        return  Response.ok(JwtUtil.generateToken("admin@gmail.com")).build();
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStudents(){
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        List<Student> fromStudentS = hibernateSession.createQuery("FROM Student s", Student.class)
                .getResultList();
        hibernateSession.close();
        return Response.ok().entity(fromStudentS).build();
    }
}

