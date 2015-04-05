package org.egreen.seed.impl.config.model;

import java.util.List;

/**
 * Created by dewmal on 4/1/15.
 */
public class ComponentModel {

    private List<FeatureModel> featureModels;
    private List<ProviderModel> providerModels;
    private String version;
    private String name;
    private String id;

    public List<FeatureModel> getFeatureModels() {
        return featureModels;
    }

    public void setFeatureModels(List<FeatureModel> featureModels) {
        this.featureModels = featureModels;
    }


    public List<ProviderModel> getProviderModels() {
        return providerModels;
    }

    public void setProviderModels(List<ProviderModel> providerModels) {
        this.providerModels = providerModels;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
