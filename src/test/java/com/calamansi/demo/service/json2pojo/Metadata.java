
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
    "refusal",
    "finishReason",
    "index",
    "id",
    "role",
    "messageType"
})
@Generated("jsonschema2pojo")
public class Metadata {

    @JsonProperty("refusal")
    private String refusal;
    @JsonProperty("finishReason")
    private String finishReason;
    @JsonProperty("index")
    private Integer index;
    @JsonProperty("id")
    private String id;
    @JsonProperty("role")
    private String role;
    @JsonProperty("messageType")
    private String messageType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("refusal")
    public String getRefusal() {
        return refusal;
    }

    @JsonProperty("refusal")
    public void setRefusal(String refusal) {
        this.refusal = refusal;
    }

    @JsonProperty("finishReason")
    public String getFinishReason() {
        return finishReason;
    }

    @JsonProperty("finishReason")
    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("messageType")
    public String getMessageType() {
        return messageType;
    }

    @JsonProperty("messageType")
    public void setMessageType(String messageType) {
        this.messageType = messageType;
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
