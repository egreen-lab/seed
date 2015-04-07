package org.egreen.seed.kernel;

import org.egreen.seed.kernel.feature.Feature;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by dewmal on 4/5/15.
 */
public interface FeatureGrabber {

    List<Feature> getFeatures();


    void bindFeatureRegistry(FeatureRegistry featureRegistry);


}
