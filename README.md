在之前的文章中主要学习了javassist和javaagent的使用；
上一篇文章中主要是使用javassist在javaagent 中动态修改内容，但是只能写在代码中，这里我们使用系统默认和数据库两种方式实现。

一、系统默认：
1、入参打印：配置类的方法打印全部入参
2、打印返回结果：如果方法有返回值则打印方法返回值，如果为void则打印null
3、方法体添加（方法替换）添加try{}catch(){} 或try{}catch(){}finally{}

二、使用数据库配置内容
方法体替换信息使用数据库配置信息；具体是入参打印、返回值输出还是方法体替换可以看表结构SQL

