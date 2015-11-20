package com.morcinek.android.codegenerator.codegeneration.providers.resources;

import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.extractor.model.Resource;

import java.util.Set;

/**
 * XU版Getter供应者
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class GetterXUProvider extends AbstractResourceProvider {

    public GetterXUProvider(Resource resource) {
        super(resource);
    }

    @Override
    public Set<String> provideInterface() {
        return null;
    }

    @Override
    public Set<String> provideAssignment() {
        return null;
    }

    @Override
    public Set<String> provideField() {
        return null;
    }

    @Override
    public Set<String> provideMethod() {
        return Sets.newHashSet("Getter");
    }
}