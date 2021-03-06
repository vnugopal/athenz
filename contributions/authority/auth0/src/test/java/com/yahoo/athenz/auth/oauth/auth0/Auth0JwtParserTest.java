/*
 * Copyright 2020 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yahoo.athenz.auth.oauth.auth0;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import java.lang.reflect.Field;
import com.yahoo.athenz.auth.KeyStore;
import com.yahoo.athenz.auth.oauth.auth0.Auth0Jwt;
import com.yahoo.athenz.auth.oauth.token.OAuthJwtAccessToken;
import com.yahoo.athenz.auth.oauth.token.OAuthJwtAccessTokenException;
import org.mockito.Mockito;
import org.testng.annotations.Test;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtParser;

public class Auth0JwtParserTest {

    private final KeyStore baseKeyStore = new KeyStore() {
        @Override
        public String getPublicKey(String domain, String service, String keyId) {
            return null;
        }
    };

    @Test
    public void testAuth0JwtParser() {
        Auth0JwtParser parser = new Auth0JwtParser(baseKeyStore, "https://athenz-oauth-example.auth0.com/.well-known/jwks.json");
        assertNotNull(parser);
    }

    @Test
    @SuppressWarnings("rawtypes")
    public void testParse() throws Exception {
        // mock internal parser
        Auth0JwtParser parser = new Auth0JwtParser(baseKeyStore, "https://athenz-oauth-example.auth0.com/.well-known/jwks.json");
        JwtParser jwtParserMock = Mockito.mock(JwtParser.class);
        Field f = parser.getClass().getSuperclass().getDeclaredField("parser");
        f.setAccessible(true);
        f.set(parser, jwtParserMock);

        // parse error
        Mockito.when(jwtParserMock.parseClaimsJws(null)).thenThrow(new NullPointerException());
        assertThrows(OAuthJwtAccessTokenException.class, () -> parser.parse(null));

        // parse success
        String jwtString = "dummy-jwt-string";
        Jws<Claims> jws = new Jws<Claims>() {
            public JwsHeader getHeader() { return null; }
            public Claims getBody() { return null; }

            @Override
            public String getSignature() {
                return "dummy-jwt-signature";
            }
        };
        Mockito.when(jwtParserMock.parseClaimsJws(jwtString)).thenReturn(jws);
        OAuthJwtAccessToken token = parser.parse(jwtString);
        assertNotNull(token);
        assertTrue(token instanceof Auth0Jwt);
        assertEquals(token.getSignature(), "dummy-jwt-signature");
    }

}
