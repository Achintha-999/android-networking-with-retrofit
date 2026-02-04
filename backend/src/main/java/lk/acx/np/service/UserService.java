package lk.acx.np.service;

import jakarta.ws.rs.core.Response;
import lk.acx.np.dto.LoginRequestDTO;
import lk.acx.np.dto.TokenDTO;
import lk.acx.np.entity.User;
import lk.acx.np.util.HibernateUtil;
import lk.acx.np.util.JwtUtil;
import org.hibernate.Session;

public class UserService {
    public Response validateUser(LoginRequestDTO dto) {
        Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
        User user = hibernateSession.createQuery("FROM User u WHERE u.email=:email AND u.password =: password", User.class)
                .setParameter("email", dto.getEmail())
                .setParameter("password", dto.getPassword())
                .getSingleResultOrNull();
        hibernateSession.close();
        if (user == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setAccessToken(JwtUtil.generateToken(user.getEmail()));
        tokenDTO.setRefreshToken(JwtUtil.generateRefreshToken(user.getEmail()));
        return Response.status(Response.Status.OK).entity(tokenDTO).build();
    }
}
