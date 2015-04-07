package org.egreen.seed.kernel.feature;

import javax.xml.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dewmal on 4/5/15.
 */
@XmlRootElement
public class Root {




    @XmlElementWrapper(name = "features")
    @XmlElement(name = "feature")
    private List<Feature> features;

    public List<Feature> getFeatures() {
        return features;
    }



    @Override
    public String toString() {
        return "Root{" +

                ", features=" + features +
                '}';
    }
}
