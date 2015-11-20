package com.morcinek.android.codegenerator.codegeneration.providers.resources;

import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.extractor.model.Resource;

import java.util.Set;

/**
 * XU版Button供应者
 * 三种Provider类是根据View的class类型进行分类, 从而重写provide...()方法以控制生成不同的代码块模版或忽略
 * 返回null为跳过不生成代码块,
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ButtonXUProvider extends AbstractResourceProvider {

 /*   ${IMPORTS}

    public class ${CLASS_NAME}Activity extends Activity ${INTERFACES} {

        ${FIELDS} // 写入成员代码块

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.${RESOURCE_NAME});

            ${ASSIGNMENTS} // 写入分配代码块
        }

        ${METHODS} // 写入方法代码块
    }*/

    public ButtonXUProvider(Resource resource) {
        super(resource);
    }

    @Override
    public Set<String> provideInterface() {
        return Sets.newHashSet("OnClickListener");
    }

    /**
     * 提供view的分配代码
     * @return
     */
    @Override
    public Set<String> provideAssignment() {
        return Sets.newHashSet("Button");
    }

    /**
     * 提供view的成员代码(null表示跳过不提供)
     * @return
     */
    @Override
    public Set<String> provideField() {
//        return null;
        // 改为读取"resources/Field_xu_template"模版文件
        return Sets.newHashSet("xu");
    }

    /**
     * 提供view的相关方法
     * @return
     */
    @Override
    public Set<String> provideMethod() {
        return Sets.newHashSet("OnClickListener");
    }

}
