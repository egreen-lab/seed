/*
*  Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.egreen.seed.config;

import org.egreen.seed.config.model.SeedConfiguration;
import org.egreen.seed.utils.Utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class XMLBasedConfigProvider implements SeedConfigProvider {

    public SeedConfiguration getSeedConfiguration() {

        String configFileLocation = Utils.getSeedXMLLocation();
        try {
            Reader in = new FileReader(configFileLocation);

            JAXBContext jaxbContext = JAXBContext.newInstance(SeedConfiguration.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            //TODO remove.
            unmarshaller.setListener(new Unmarshaller.Listener() {
                @Override
                public void beforeUnmarshal(Object target, Object parent) {
                    super.beforeUnmarshal(target, parent);
                }

                @Override
                public void afterUnmarshal(Object target, Object parent) {
                    super.afterUnmarshal(target, parent);

                }
            });

            return (SeedConfiguration) unmarshaller.unmarshal(in);

        } catch (JAXBException e) {
            // TODO handle this exception
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            //dfd
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        // We need to populate a SeedConfiguration from the seed.xml file.
        return null;
    }
}
