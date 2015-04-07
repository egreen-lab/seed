package org.egreen.seed.kernel.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.egreen.seed.kernel.FeatureGrabber;
import org.egreen.seed.kernel.FeatureRegistry;
import org.egreen.seed.kernel.feature.Feature;
import org.egreen.seed.kernel.feature.Root;
import org.osgi.framework.Bundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by dewmal on 4/5/15.
 */
public class XMLFeatureGrabber implements FeatureGrabber {
    private static final Log LOG = LogFactory.getLog(XMLFeatureGrabber.class);
    private Bundle bundle;
    private FeatureRegistry featureRegistry;


    public XMLFeatureGrabber(Bundle bundle) {
        this.bundle = bundle;

    }


    @Override
    public List<Feature> getFeatures() {
        Enumeration<URL> entrs = bundle.findEntries("/FEATURE/", "*.xml", true);
        LOG.info(entrs);
        if (entrs == null || !entrs.hasMoreElements()) {
            return null;
        }

        while (entrs.hasMoreElements()) {
            URL e = (URL) entrs.nextElement();

            LOG.info(e);
            JAXBContext jaxbContext = null;
            try {
                jaxbContext = JAXBContext.newInstance(Root.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Root root = (Root) jaxbUnmarshaller.unmarshal(e.openStream());

                LOG.info(root);

                for (Feature feature : root.getFeatures()) {
                    featureRegistry.save(feature.getFeatureKey(), feature);
                }


            } catch (JAXBException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }


        }
        return null;
    }

    @Override
    public void bindFeatureRegistry(FeatureRegistry featureRegistry) {
        this.featureRegistry = featureRegistry;
    }

}
