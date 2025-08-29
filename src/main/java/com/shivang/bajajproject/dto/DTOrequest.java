package com.shivang.bajajproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class DTOrequest {

    @NotNull(message = "data array is required")
    @JsonProperty("data")
    private List<String> data;

    public DTOrequest() {
    }

    public DTOrequest(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
