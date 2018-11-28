package service;

import authentication.Account;
import authentication.util.UserCredentials;
import com.google.gson.Gson;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import exceptions.TokenGenerationException;
import exceptions.UserNotAuthenticatedException;
import factory.DAOFactory;

import java.util.Date;

public class SessionManager {

    public String authenticateUser(UserCredentials userCredentials) throws UserNotAuthenticatedException, TokenGenerationException {
        Account authenticatedAccount = validateUserCredentials(userCredentials);
        if(authenticatedAccount == null) throw new UserNotAuthenticatedException();

        return generateNewToken(authenticatedAccount);
    }

    private Account validateUserCredentials(UserCredentials userCredentials) {
        Account account = new Account(userCredentials.getUsername(), userCredentials.getPassword(), null);

        return DAOFactory.getAccountDAO().validateUserCredentials(account);
    }

    private String generateNewToken(Account account) throws TokenGenerationException {
        try {
            // RSA signatures require a public and private RSA key pair, the public key
            // must be made known to the JWS recipient in order to verify the signatures
            RSAKey rsaJWK = new RSAKeyGenerator(2048)
                    .keyID("123")
                    .generate();
            RSAKey rsaPublicJWK = rsaJWK.toPublicJWK();


            // Create RSA-signer with the private key
            JWSSigner signer = new RSASSASigner(rsaJWK);

            // Prepare JWT with claims set
            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
//                    .subject(account.getUsername())
//                    .issuer("https://anyassistance.com")
                    .expirationTime(new Date(new Date().getTime() + 60 * 1000))
                    .claim("userId", account.getId())
                    .claim("username", account.getUsername())
                    .claim("roles", new Gson().toJson(account.getRoles()))
                    .build();

            SignedJWT signedJWT = new SignedJWT(
                    new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build(),
                    claimsSet);

            // Compute the RSA signature
            signedJWT.sign(signer);

            return signedJWT.serialize();

        } catch (JOSEException exception) {
            throw new TokenGenerationException();
        }
    }
}
