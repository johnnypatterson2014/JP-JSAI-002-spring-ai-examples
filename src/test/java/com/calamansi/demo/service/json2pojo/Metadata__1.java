
package com.calamansi.demo.service.json2pojo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "finishReason",
    "contentFilters",
    "empty"
})
@Generated("jsonschema2pojo")
public class Metadata__1 {

    @JsonProperty("finishReason")
    private String finishReason;
    @JsonProperty("contentFilters")
    private List<Object> contentFilters;
    @JsonProperty("empty")
    private Boolean empty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("finishReason")
    public String getFinishReason() {
        return finishReason;
    }

    @JsonProperty("finishReason")
    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    @JsonProperty("contentFilters")
    public List<Object> getContentFilters() {
        return contentFilters;
    }

    @JsonProperty("contentFilters")
    public void setContentFilters(List<Object> contentFilters) {
        this.contentFilters = contentFilters;
    }

    @JsonProperty("empty")
    public Boolean getEmpty() {
        return empty;
    }

    @JsonProperty("empty")
    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
