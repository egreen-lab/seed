package org.egreen.seed.impl.component.config.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by dewmal on 3/22/15.
 */
@XmlRootElement(name = "component")
public class ComponentConfig {

    @XmlElement
    private String name;

    @XmlElement
    private String id;

    // XmLElementWrapper generates a wrapper element around XML representation

    @XmlElementWrapper(name = "features")
    @XmlElement(name = "feature")
    private List<FeatureConfig> featureConfigs;


    public String getName() {
        return name;
    }

    public List<FeatureConfig> getFeatureConfigs() {
        return featureConfigs;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ComponentConfig{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", featureConfigs=" + featureConfigs +
                '}';
    }
}
