package com.morcinek.android.codegenerator.codegeneration.providers.factories;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.*;
import com.morcinek.android.codegenerator.extractor.model.Resource;

/**
 * Fragment资源供应商工厂
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class FragmentXUResourceProvidersFactory implements ResourceProvidersFactory {

    @Override
    public ResourceProvider createResourceProvider(Resource resource) {
        if (isApplicable(resource, "Button", "ImageButton")) {
            return getResourceProviderWithContainerPrefix(new ButtonXUProvider(resource), "view.");
        }
//        else if (isApplicable(resource, "CheckBox", "EditText", "View")) {
//            return getResourceProviderWithContainerPrefix(new GetterXUProvider(resource), "getView().");
//        }
        return getResourceProviderWithContainerPrefix(new DefaultXUProvider(resource), "view.");
    }

    private AbstractResourceProvider getResourceProviderWithContainerPrefix(AbstractResourceProvider resourceProvider, String value) {
        resourceProvider.putExtra("CONTAINER_PREFIX", value);
        return resourceProvider;
    }

    private boolean isApplicable(Resource resource, String... resourcesNames) {
        return Lists.newArrayList(resourcesNames).contains(resource.getResourceType().getFullName());
    }
}
