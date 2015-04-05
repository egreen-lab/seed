package org.egreen.seed.feature;

import org.egreen.seed.impl.config.model.FeatureModel;
import org.egreen.seed.impl.config.model.ProviderModel;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dewmal on 4/2/15.
 */
public class FeatureRegistration {

    private final FeatureModel<?> feature;

    private ProviderModel[] providers = new ProviderModel[]{};

    public FeatureRegistration(FeatureModel<?> feature) {
        this.feature = feature;
    }


    public FeatureModel<?> getFeature() {
        return feature;
    }


    public ProviderModel[] getProviders() {
        return providers;
    }

    public void setProviders(ProviderModel[] providers) {
        this.providers = providers;
    }

    /**
     * Set Provider to Feature Registration
     *
     * @param provider
     */
    public void setProvider(ProviderModel provider) {
        if (getProviderModel(provider.getId()) == null) {
            List<ProviderModel> providerModels = Arrays.asList(providers);
            providerModels.add(provider);
            providers = providerModels.toArray(providers);
        }
    }


    /**
     * Get Provider Model
     *
     * @param providerId
     * @return
     */
    public ProviderModel getProviderModel(long providerId) {
        ProviderModel providerModel = null;
        if (providerId == -1) {
            providerModel = providers[0];
        } else {
            for (int i = 0; i < providers.length; i++) {
                providerModel = providers[i];
                boolean equals = providerModel.checkId(providerId);
                if (equals) {
                    break;
                }
                providerModel = null;
            }
        }
        return providerModel;
    }
}
