package lk.acx.np.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lk.acx.np.dto.LoginRequestDTO;
import lk.acx.np.service.UserService;

@Path("/auth/login")
public class LoginController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON) ///  Frontend -> JSON Data
    @Produces(MediaType.APPLICATION_JSON) ///  Backend -> JSON Data
    public Response userLogin(LoginRequestDTO dto){
        return new UserService().validateUser(dto);
    }
}