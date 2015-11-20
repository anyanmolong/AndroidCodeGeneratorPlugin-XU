package com.morcinek.android.codegenerator.codegeneration.builders.resources;

import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplateManager;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * FieldsXU代码块生成器
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class FieldsXUBuilder extends ResourceCodeBuilder {

    private StringBuilder stringBuilder;

    public FieldsXUBuilder(List<ResourceProvider> resourceProviders, TemplatesProvider templatesProvider) {
        super(resourceProviders, templatesProvider);
    }

    @Override
    protected void initializeFields() {
        stringBuilder = new StringBuilder();
    }

    /**
     * 根据获得的资源来组装代码块
     * @param resourceProvider
     */
    @Override
    protected void processResourceProvider(ResourceProvider resourceProvider) {
        if (resourceProvider.provideField() != null) {
//            System.out.println("类名:"+ resourceProvider.getClass().toString());
            // 获得view列表, 生成对应的代码块列表
            for (String field : resourceProvider.provideField()) {
                // 读取该view对应的Provider(供应者)类提供的模版
                TemplateManager templateManager = getTemplateManager(field);

                // 将模版中的"RESOURCE_ID, RESOURCE_TYPE等"关键字替换mxl中view节点实体的对应信息, 从而获得实际代码
                templateManager.addTemplateValues(resourceProvider.provideValues());
                Map<String, String> map = resourceProvider.provideValues();

                // 如果view名称为"class名+数字"的系统生成名称, 则跳过
                if (isNumeric(StringUtils.capitalize(map.get("RESOURCE_NAME")).replace(map.get("RESOURCE_TYPE"), ""))) {
                    continue;
                }

                templateManager.addTemplateValues(resourceProvider.provideValues());
                stringBuilder.append(templateManager.getResult());
            }
        }
    }

    /**
     * 判断字符串是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    private TemplateManager getTemplateManager(String assignment) {
        return new TemplateManager(templatesProvider.provideTemplateForName("Field_"+ assignment +"_template"));
    }

    @Override
    public String builtString() {
        // 返回组装完成的代码块
        return prepareBuildString(stringBuilder.toString());
    }

    @Override
    public String getKey() {
        return "FIELDS_XU";
    }
}
