package org.egreen.seed.kernel.feature;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 * Created by dewmal on 4/5/15.
 */
@XmlRootElement
public class Feature {

    @XmlAttribute(name = "class")
    private String featureClass;

    @XmlAttribute(name = "name")
    private String methodName;

    @XmlElementWrapper(name = "params")
    @XmlElement(name = "param")
    private Param[] params;

    @XmlElement
    private Result result;


    public String getFeatureClass() {
        return featureClass;
    }


    public Param[] getParams() {
        return params;
    }


    public Result getResult() {
        return result;
    }

    public String getMethodName() {
        return methodName;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "featureClass='" + featureClass + '\'' +
                ", methodName='" + methodName + '\'' +
                ", params=" + Arrays.toString(params) +
                ", result=" + result +
                '}';
    }

    public String getFeatureKey() {
        return featureClass + "." + methodName;
    }
}
