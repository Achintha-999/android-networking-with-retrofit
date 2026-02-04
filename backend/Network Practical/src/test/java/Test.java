import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import lk.acx.np.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.crypto.SecretKey;

public class Test {
    public static void main(String[] args) {
        SecretKey Key = Jwts.SIG.HS256.key().build();
        String secretKey = Encoders.BASE64.encode(Key.getEncoded());
        System.out.println(secretKey);
    }
}
