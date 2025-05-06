
package com.calamansi.demo.service.json2pojo;

import java.util.LinkedHashMap;
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
    "requestsLimit",
    "requestsRemaining",
    "tokensLimit",
    "tokensRemaining",
    "requestsReset",
    "tokensReset"
})
@Generated("jsonschema2pojo")
public class RateLimit {

    @JsonProperty("requestsLimit")
    private Integer requestsLimit;
    @JsonProperty("requestsRemaining")
    private Integer requestsRemaining;
    @JsonProperty("tokensLimit")
    private Integer tokensLimit;
    @JsonProperty("tokensRemaining")
    private Integer tokensRemaining;
    @JsonProperty("requestsReset")
    private String requestsReset;
    @JsonProperty("tokensReset")
    private String tokensReset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("requestsLimit")
    public Integer getRequestsLimit() {
        return requestsLimit;
    }

    @JsonProperty("requestsLimit")
    public void setRequestsLimit(Integer requestsLimit) {
        this.requestsLimit = requestsLimit;
    }

    @JsonProperty("requestsRemaining")
    public Integer getRequestsRemaining() {
        return requestsRemaining;
    }

    @JsonProperty("requestsRemaining")
    public void setRequestsRemaining(Integer requestsRemaining) {
        this.requestsRemaining = requestsRemaining;
    }

    @JsonProperty("tokensLimit")
    public Integer getTokensLimit() {
        return tokensLimit;
    }

    @JsonProperty("tokensLimit")
    public void setTokensLimit(Integer tokensLimit) {
        this.tokensLimit = tokensLimit;
    }

    @JsonProperty("tokensRemaining")
    public Integer getTokensRemaining() {
        return tokensRemaining;
    }

    @JsonProperty("tokensRemaining")
    public void setTokensRemaining(Integer tokensRemaining) {
        this.tokensRemaining = tokensRemaining;
    }

    @JsonProperty("requestsReset")
    public String getRequestsReset() {
        return requestsReset;
    }

    @JsonProperty("requestsReset")
    public void setRequestsReset(String requestsReset) {
        this.requestsReset = requestsReset;
    }

    @JsonProperty("tokensReset")
    public String getTokensReset() {
        return tokensReset;
    }

    @JsonProperty("tokensReset")
    public void setTokensReset(String tokensReset) {
        this.tokensReset = tokensReset;
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
