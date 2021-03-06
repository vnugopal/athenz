//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zms;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yahoo.rdl.*;

//
// UserToken - A user token generated based on user's credentials
//
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserToken {
    public String token;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String header;

    public UserToken setToken(String token) {
        this.token = token;
        return this;
    }
    public String getToken() {
        return token;
    }
    public UserToken setHeader(String header) {
        this.header = header;
        return this;
    }
    public String getHeader() {
        return header;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != UserToken.class) {
                return false;
            }
            UserToken a = (UserToken) another;
            if (token == null ? a.token != null : !token.equals(a.token)) {
                return false;
            }
            if (header == null ? a.header != null : !header.equals(a.header)) {
                return false;
            }
        }
        return true;
    }
}
