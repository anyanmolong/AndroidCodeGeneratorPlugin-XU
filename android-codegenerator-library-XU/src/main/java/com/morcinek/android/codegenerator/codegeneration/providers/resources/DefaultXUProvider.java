package com.morcinek.android.codegenerator.codegeneration.providers.resources;

import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.extractor.model.Resource;

import java.util.Set;

/**
 * XU版Default供应者
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class DefaultXUProvider extends AbstractResourceProvider {

    public DefaultXUProvider(Resource resource) {
        super(resource);
    }

    @Override
    public Set<String> provideInterface() {
        return null;
    }

    @Override
    public Set<String> provideAssignment() {
        return Sets.newHashSet("");
    }

    @Override
    public Set<String> provideField() {
        return Sets.newHashSet("xu");
    }

    @Override
    public Set<String> provideMethod() {
        return null;
    }
}
