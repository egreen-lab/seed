package org.egreen.seed.impl.config.model;

/**
 * Created by dewmal on 4/1/15.
 */
public class ProviderModel {

    private long id;
    private FeatureModel featureModel;
    private String version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FeatureModel getFeatureModel() {
        return featureModel;
    }

    public void setFeatureModel(FeatureModel featureModel) {
        this.featureModel = featureModel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean checkId(long providerId) {
        return providerId == id;
    }
}
