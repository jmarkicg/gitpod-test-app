package hr.markic.rest.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiErrorResponse {

    @JsonProperty("error-code")
    private String errorCode;

    @JsonProperty("error-arg")
    private String errorArg;

    public ApiErrorResponse(String errorCode, String errorArg) {
        this.errorCode = errorCode;
        this.errorArg = errorArg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorArg() {
        return errorArg;
    }

    public void setErrorArg(String errorArg) {
        this.errorArg = errorArg;
    }
}
