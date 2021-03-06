package com.morcinek.android.codegenerator.codegeneration.builders.file;

import com.morcinek.android.codegenerator.codegeneration.builders.CodeBuilder;
import org.apache.commons.lang3.StringUtils;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ClassNameBuilder implements CodeBuilder {

    private String fileName;

    public ClassNameBuilder(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String builtString() {
        return getResourceName(fileName);
    }

    private String getResourceName(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : fileName.split("_")) {
            // YXC 如果布局开头为activity|fragment|layout, 忽略掉该单词
            if (stringBuilder.length() == 0 && (word.equals("activity") || word.equals("fragment")|| word.equals("layout"))){
                continue;
            }
            stringBuilder.append(StringUtils.capitalize(word));
        }
        return stringBuilder.toString();
    }

    @Override
    public String getKey() {
        return "CLASS_NAME";
    }
}
