package br.com.estudo.estudo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Error implements Serializable {
    @JsonProperty("time")
    private OffsetDateTime errorTime;
    @JsonProperty("message")
    private String errorMessage;

    public OffsetDateTime getErrorTime() {
        return this.errorTime;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    @JsonProperty("time")
    public void setErrorTime(OffsetDateTime errorTime) {
        this.errorTime = errorTime;
    }

    @JsonProperty("message")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Error() {
    }

    public Error(OffsetDateTime errorTime, String errorMessage) {
        this.errorTime = errorTime;
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error = (Error) o;
        return Objects.equals(errorTime, error.errorTime) && Objects.equals(errorMessage, error.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorTime, errorMessage);
    }

    @Override
    public String toString() {
        return "Error{" +
                "errorTime=" + errorTime +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

}
