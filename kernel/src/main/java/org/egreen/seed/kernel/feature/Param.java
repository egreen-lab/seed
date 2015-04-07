package org.egreen.seed.kernel.feature;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by dewmal on 4/5/15.
 */
public class Param {


    @XmlAttribute(name = "class")
    private String paramClass;
    @XmlAttribute(name = "name")
    private String paramName;

    public String getParamClass() {
        return paramClass;
    }


    public String getParamName() {
        return paramName;
    }


    @Override
    public String toString() {
        return "Param{" +
                "paramClass='" + paramClass + '\'' +
                ", paramName='" + paramName + '\'' +
                '}';
    }
}
