
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
    "messageType",
    "metadata",
    "toolCalls",
    "media",
    "text"
})
@Generated("jsonschema2pojo")
public class Output__1 {

    @JsonProperty("messageType")
    private String messageType;
    @JsonProperty("metadata")
    private Metadata__3 metadata;
    @JsonProperty("toolCalls")
    private List<Object> toolCalls;
    @JsonProperty("media")
    private List<Object> media;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("messageType")
    public String getMessageType() {
        return messageType;
    }

    @JsonProperty("messageType")
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @JsonProperty("metadata")
    public Metadata__3 getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata__3 metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("toolCalls")
    public List<Object> getToolCalls() {
        return toolCalls;
    }

    @JsonProperty("toolCalls")
    public void setToolCalls(List<Object> toolCalls) {
        this.toolCalls = toolCalls;
    }

    @JsonProperty("media")
    public List<Object> getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(List<Object> media) {
        this.media = media;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
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
