[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-android--codegenerator--plugin--intellij-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1443)

Android Studio/IntelliJ IDEA Plugin for Android code generation
================

Plugin for generation of Android code from XML files (layouts, menus).

For more information please see [the website](http://tmorcinek.github.io/android-codegenerator-plugin-intellij)

Or see the plugin in [jetbrains repository](https://plugins.jetbrains.com/plugin/7595?pr=idea).


Core Library
-------

This plugin is based on a library: [android-codegenerator-library](https://github.com/tmorcinek/android-codegenerator-library).
The library is responsible for:

 - extracting important information from XML files
 - generating Java code based on extracted information and templates


JetBrains Repository
-------

You can install plugin from repository: 
`Preferences/Settings->Plugins->Browse repositories...` 
Then type in search: 
`Android code Generator`


Download & Installation
-------

All available versions of plugin are in [releases](https://github.com/tmorcinek/android-codegenerator-plugin-intellij/releases)
You can download zip file from [latest release](https://github.com/tmorcinek/android-codegenerator-plugin-intellij/releases/latest) and install it manually in:  
`Preferences/Settings->Plugins->Install plugin from disk` 


Change notes
-------

<b>Version 1.0.1</b>
<ul>
    <li>多行文件输入框增加滚动条</li>
</ul>



License
-------

    Copyright 2014 Tomasz Morcinek.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
