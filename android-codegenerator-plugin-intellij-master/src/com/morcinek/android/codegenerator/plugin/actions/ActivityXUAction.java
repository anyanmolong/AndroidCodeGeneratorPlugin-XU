package com.morcinek.android.codegenerator.plugin.actions;

import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.ActivityResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.ActivityXUResourceProvidersFactory;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ActivityXUAction extends LayoutAction {

    @Override
    protected String getResourceName() {
        return "Activity";
    }

    @Override
    protected String getTemplateName() {
        return "Activity_xu_template";
    }

    @Override
    protected ResourceProvidersFactory getResourceProvidersFactory() {
        return new ActivityXUResourceProvidersFactory();
    }
}
