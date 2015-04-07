package org.egreen.seed.kernel.feature;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by dewmal on 4/5/15.
 */
public class Result {

    @XmlAttribute(name = "class")
    private String resultClass;


    public String getResultClass() {
        return resultClass;
    }


    @Override
    public String toString() {
        return "Result{" +
                "resultClass='" + resultClass + '\'' +
                '}';
    }
}
