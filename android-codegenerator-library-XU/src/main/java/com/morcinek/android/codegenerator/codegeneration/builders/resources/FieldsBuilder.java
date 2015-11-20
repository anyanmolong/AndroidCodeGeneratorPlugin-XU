package com.morcinek.android.codegenerator.codegeneration.builders.resources;

import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplateManager;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Fields代码块生成器
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class FieldsBuilder extends ResourceCodeBuilder {

    private StringBuilder stringBuilder;

    public FieldsBuilder(List<ResourceProvider> resourceProviders, TemplatesProvider templatesProvider) {
        super(resourceProviders, templatesProvider);
    }

    @Override
    protected void initializeFields() {
        stringBuilder = new StringBuilder();
    }

    @Override
    protected void processResourceProvider(ResourceProvider resourceProvider) {
        if (resourceProvider.provideField() != null) {
            for (String field : resourceProvider.provideField()) {
                TemplateManager templateManager = getTemplateManager(field);
                templateManager.addTemplateValues(resourceProvider.provideValues());
                stringBuilder.append(templateManager.getResult());
            }
        }
    }

    private TemplateManager getTemplateManager(String assignment) {
        return new TemplateManager(templatesProvider.provideTemplateForName("Field_"+ assignment +"_template"));
    }

    @Override
    public String builtString() {
        return prepareBuildString(stringBuilder.toString());
    }

    @Override
    public String getKey() {
        return "FIELDS";
    }
}
