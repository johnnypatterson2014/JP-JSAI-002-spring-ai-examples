
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
    "promptTokens",
    "completionTokens",
    "totalTokens",
    "nativeUsage"
})
@Generated("jsonschema2pojo")
public class Usage {

    @JsonProperty("promptTokens")
    private Integer promptTokens;
    @JsonProperty("completionTokens")
    private Integer completionTokens;
    @JsonProperty("totalTokens")
    private Integer totalTokens;
    @JsonProperty("nativeUsage")
    private NativeUsage nativeUsage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("promptTokens")
    public Integer getPromptTokens() {
        return promptTokens;
    }

    @JsonProperty("promptTokens")
    public void setPromptTokens(Integer promptTokens) {
        this.promptTokens = promptTokens;
    }

    @JsonProperty("completionTokens")
    public Integer getCompletionTokens() {
        return completionTokens;
    }

    @JsonProperty("completionTokens")
    public void setCompletionTokens(Integer completionTokens) {
        this.completionTokens = completionTokens;
    }

    @JsonProperty("totalTokens")
    public Integer getTotalTokens() {
        return totalTokens;
    }

    @JsonProperty("totalTokens")
    public void setTotalTokens(Integer totalTokens) {
        this.totalTokens = totalTokens;
    }

    @JsonProperty("nativeUsage")
    public NativeUsage getNativeUsage() {
        return nativeUsage;
    }

    @JsonProperty("nativeUsage")
    public void setNativeUsage(NativeUsage nativeUsage) {
        this.nativeUsage = nativeUsage;
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
