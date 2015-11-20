package com.morcinek.android.codegenerator.codegeneration.builders.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.ResourceTemplatesProvider;
import org.apache.commons.lang3.StringUtils;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.Mockito.when;

public class FieldsBuilderTest {

    private ResourceTemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    private ResourceCodeBuilder interfaceBuilder;

    private ResourceCodeBuilder provideFieldsBuilder(List<ResourceProvider> resourceProviders) {
        return new FieldsBuilder(resourceProviders, templatesProvider);
    }

    @Test
    public void builtNoFieldString() throws Exception {
        // given
        interfaceBuilder = provideFieldsBuilder(Lists.<ResourceProvider>newArrayList());

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo("");
    }

    @Test
    public void builtButtonsFieldString() throws Exception {
        // given
        ResourceProvider rp = getMockResourceProvider("button", Sets.newHashSet(""));
        interfaceBuilder = provideFieldsBuilder(Lists.newArrayList(rp));

        ArrayList<ResourceProvider> list =Lists.newArrayList(rp);

        interfaceBuilder = provideFieldsBuilder(list);

        for (ResourceProvider item: list){
            System.out.println(item.provideValues().toString());
            System.out.println(item.provideAssignment().toString());
            System.out.println(item.provideField().toString());
            System.out.println(item.provideMethod().toString());
            System.out.println(item.provideInterface().toString());
        }

        // when
        String value = interfaceBuilder.builtString();

        System.out.println("======");
        System.out.println(value);
        System.out.println("======");
        // then
//        Assertions.assertThat(value).isNotNull().isEqualTo("");
    }

    @Test
    public void builtDefaultFieldString() throws Exception {
        // given

        HashSet set = Sets.newHashSet("");

        ResourceProvider rp = getMockResourceProvider("tv_view", set);

        ArrayList<ResourceProvider> list =Lists.newArrayList(rp);

        interfaceBuilder = provideFieldsBuilder(list);

        for (ResourceProvider item: list){
            System.out.println(item.provideValues().toString());
            System.out.println(item.provideAssignment().toString());
            System.out.println(item.provideField().toString());
            System.out.println(item.provideMethod().toString());
            System.out.println(item.provideInterface().toString());
        }

        // when
        String value = interfaceBuilder.builtString();

        System.out.println("======");
        System.out.println(value);
        System.out.println("======");

        // then
//        Assertions.assertThat(value).isNotNull().isEqualTo("private View view;");
    }

    @Test
    public void builtTwoFieldString() throws Exception {
        // given
//        interfaceBuilder = provideFieldsBuilder(Lists.newArrayList(getMockResourceProvider("button", null), getMockResourceProvider("imageView3", Sets.newHashSet(""))));
        interfaceBuilder = provideFieldsBuilder(Lists.newArrayList(getMockResourceProvider("button", Sets.newHashSet("")), getMockResourceProvider("imageView", Sets.newHashSet(""))));

        // when
        String value = interfaceBuilder.builtString();
        System.out.println("======");
        System.out.println(value);
        System.out.println("======");
        // then
//        Assertions.assertThat(value).isNotNull().isEqualTo(
//                "private View view;"
//        );
    }

    private ResourceProvider getMockResourceProvider(String name, Set<String> fields) {
        ResourceProvider resourceProvider = Mockito.mock(ResourceProvider.class);
        Map<String, String> treeMap = Maps.newHashMap();
        treeMap.put("RESOURCE_TYPE", StringUtils.capitalize(name));
        treeMap.put("RESOURCE_NAME", name+3);
        treeMap.put("RESOURCE_ID", "R.id." + name+3); // 新加了Rid, 内注用

        when(resourceProvider.provideValues()).thenReturn(treeMap);
        when(resourceProvider.provideField()).thenReturn(fields);
        return resourceProvider;
    }
}