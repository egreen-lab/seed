package org.egreen.seed.impl.component.config;

import org.egreen.seed.impl.component.SeedComponentActivator;
import org.egreen.seed.impl.component.config.model.ComponentConfig;
import org.egreen.seed.impl.config.model.SeedConfiguration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by dewmal on 3/22/15.
 */
public class XMLBasedComponentResolver implements ComponentResolver {
    @Override
    public ComponentConfig getComponentConfiguration(SeedComponentActivator seedComponentActivator) throws Exception {

        try {
            Reader in = new InputStreamReader(seedComponentActivator.componentConfiguration());

            JAXBContext jaxbContext = JAXBContext.newInstance(ComponentConfig.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();


            return (ComponentConfig) unmarshaller.unmarshal(in);

        } catch (JAXBException e) {
            // TODO handle this exception
            e.printStackTrace();
        }

        // We need to populate a SeedConfiguration from the seed.xml file.
        return null;
    }
}
