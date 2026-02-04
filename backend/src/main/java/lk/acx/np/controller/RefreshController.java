package lk.acx.np.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lk.acx.np.dto.TokenDTO;
import lk.acx.np.util.JwtUtil;

@Path("/auth/refresh")
public class RefreshController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response reNewAccessToken(TokenDTO dto) {
        try {
            String email = JwtUtil.validateToken(dto.getRefreshToken()); /// subject
            String accessToken = JwtUtil.generateToken(email);
            TokenDTO tokenDTO = new TokenDTO();
            tokenDTO.setAccessToken(accessToken);
            tokenDTO.setRefreshToken(dto.getRefreshToken());
            return Response.ok().entity(tokenDTO).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
