package org.egreen.seed.impl.component.config.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by dewmal on 3/22/15.
 */
@XmlRootElement(name = "feature")
public class FeatureConfig {

    @XmlElement(name = "interface", required = true)
    private String Interface;


    @XmlElement(name = "class", required = true)
    private String ClassName;

    public String getClassName() {
        if (ClassName != null)
            ClassName = ClassName.trim();
        return ClassName;
    }


    public String getInterface() {
        if (Interface != null)
            Interface = Interface.trim();
        return Interface;
    }

    @Override
    public String toString() {
        return "FeatureConfig{" +
                "Interface='" + Interface + '\'' +
                ", ClassName='" + ClassName + '\'' +
                '}';
    }
}
