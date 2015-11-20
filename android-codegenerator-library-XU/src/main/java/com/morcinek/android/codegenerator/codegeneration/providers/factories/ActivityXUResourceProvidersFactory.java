package com.morcinek.android.codegenerator.codegeneration.providers.factories;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.*;
import com.morcinek.android.codegenerator.extractor.model.Resource;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ActivityXUResourceProvidersFactory implements ResourceProvidersFactory {

    @Override
    public ResourceProvider createResourceProvider(Resource resource) {

        // isApplicable()方法美中不足的是不能带正则表达式匹配一些自定义view
        if (isApplicable(resource, "Button", "ImageButton")) {
            return new ButtonXUProvider(resource);
        }
//        else if (isApplicable(resource, "CheckBox", "EditText", "View")) {
//            return new GetterXUProvider(resource);
//        }
        return new DefaultXUProvider(resource);
    }

    private boolean isApplicable(Resource resource, String... resourcesNames) {
        return Lists.newArrayList(resourcesNames).contains(resource.getResourceType().getFullName());
    }
}
