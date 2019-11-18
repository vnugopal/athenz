//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.zts;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import com.yahoo.rdl.*;

//
// InstanceRefreshInformation -
//
public class InstanceRefreshInformation {
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String attestationData;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String csr;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String ssh;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Boolean token;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Integer expiryTime;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String hostname;
    @RdlOptional
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> hostCnames;

    public InstanceRefreshInformation setAttestationData(String attestationData) {
        this.attestationData = attestationData;
        return this;
    }
    public String getAttestationData() {
        return attestationData;
    }
    public InstanceRefreshInformation setCsr(String csr) {
        this.csr = csr;
        return this;
    }
    public String getCsr() {
        return csr;
    }
    public InstanceRefreshInformation setSsh(String ssh) {
        this.ssh = ssh;
        return this;
    }
    public String getSsh() {
        return ssh;
    }
    public InstanceRefreshInformation setToken(Boolean token) {
        this.token = token;
        return this;
    }
    public Boolean getToken() {
        return token;
    }
    public InstanceRefreshInformation setExpiryTime(Integer expiryTime) {
        this.expiryTime = expiryTime;
        return this;
    }
    public Integer getExpiryTime() {
        return expiryTime;
    }
    public InstanceRefreshInformation setHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }
    public String getHostname() {
        return hostname;
    }
    public InstanceRefreshInformation setHostCnames(List<String> hostCnames) {
        this.hostCnames = hostCnames;
        return this;
    }
    public List<String> getHostCnames() {
        return hostCnames;
    }

    @Override
    public boolean equals(Object another) {
        if (this != another) {
            if (another == null || another.getClass() != InstanceRefreshInformation.class) {
                return false;
            }
            InstanceRefreshInformation a = (InstanceRefreshInformation) another;
            if (attestationData == null ? a.attestationData != null : !attestationData.equals(a.attestationData)) {
                return false;
            }
            if (csr == null ? a.csr != null : !csr.equals(a.csr)) {
                return false;
            }
            if (ssh == null ? a.ssh != null : !ssh.equals(a.ssh)) {
                return false;
            }
            if (token == null ? a.token != null : !token.equals(a.token)) {
                return false;
            }
            if (expiryTime == null ? a.expiryTime != null : !expiryTime.equals(a.expiryTime)) {
                return false;
            }
            if (hostname == null ? a.hostname != null : !hostname.equals(a.hostname)) {
                return false;
            }
            if (hostCnames == null ? a.hostCnames != null : !hostCnames.equals(a.hostCnames)) {
                return false;
            }
        }
        return true;
    }
}
