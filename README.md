# Powerful Schedule

![1](https://img.shields.io/github/issues/xxh160/Schedule)
![2](https://img.shields.io/github/stars/xxh160/Schedule)
![3](https://img.shields.io/github/forks/xxh160/Schedule)
![4](https://img.shields.io/github/license/xxh160/Schedule)

通过Java FX实现的课程表。

期望实现的功能有：

- 导入、导出、显示课程表；
- 智能课程排序。

## 特性

|名称|描述|
|---|---|
|导入|解析选定的`xml`文件，并且保存在`课程表列表`内|
|显示|在`课程表列表`中选择课程表显示|
|导出|在`课程表列表`内选择课程表导出相应的`xml`文件|
|排序|选定课程表后，点击`解决课程冲突`，会根据课程状态生成冲突解决方案。新生成的课程表的名字是源课程表名称加上后缀`_resolved`，具体方案在其中的`description`区块中描述|

## 设计

MVC设计模式。

- `models`包下存放各种数据模型及枚举类；
- `controllers`包下有和视图`views`一一对应的控制类，以及总的controller`Controller`；
- `utils`包下存放各种通用的工具类。

### models

- `Course`类是最基础的课程模型，其中存放课程的各种数据。特别地，它的特性通过`CourseFeature`数组描述。
- `CourseFeature`是存放课程特性的枚举类。`escapable`表示可以免修，`movalbe`表示可以调课；
