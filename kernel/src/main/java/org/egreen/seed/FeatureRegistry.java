package org.egreen.seed;

import org.egreen.seed.feature.FeatureRegistration;
import org.egreen.seed.impl.config.model.FeatureModel;
import org.egreen.seed.impl.config.model.ProviderModel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dewmal on 4/2/15.
 */
public class FeatureRegistry {

    // Maps Component Registry
    private Map<FeatureModel, FeatureRegistration> featureRegsitry = Collections.synchronizedMap(new HashMap<FeatureModel, FeatureRegistration>());


    /**
     * @param featureModel
     * @param providerModel
     */
    public void register(FeatureModel featureModel, ProviderModel providerModel) {
        FeatureRegistration featureRegistration = featureRegsitry.get(featureModel);
        if (featureRegistration == null) {
            featureRegistration = new FeatureRegistration(featureModel);
        }
        if (providerModel != null) {
            featureRegistration.setProvider(providerModel);
        }
    }


    /**
     *
     *
     *
     * @param featureModel
     * @param providerId
     * @return
     */
    public ProviderModel getFeature(FeatureModel featureModel, long providerId) {
        FeatureRegistration featureRegistration = featureRegsitry.get(featureModel);
        ProviderModel providerModel = null;
        if (featureRegistration != null) {
            providerModel = featureRegistration.getProviderModel(providerId);
        }
        return providerModel;
    }

}
