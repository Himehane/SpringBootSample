# SpringBootSample
## 一个简单的SpringBoot示例
### 用到的技术
* 数据库使用mysql
* 整合了redis缓存
* 新增开启ANSI格式的日志输出
* 数据库连接池使用 HikariCP (Hi·ka·ri [hi·ka·'lē] (Origin: Japanese): light; ray.) 
* 持久层框架使用mybatis
* 持久层分页采用PageHelper
* 搜索采用Solr，利用spring-data-solr来实现

### 项目简介
项目的目的在于构建简单的缓存搜索等样例，通过继承的方式可以拓展实现相应的业务功能，可以使用伪静态来配合mvc实现静态化页面，也可以直接使用jsp配合MVC渲染数据，亦或者纯html+AJAX请求REST接口来实现页面展示，目的在于整合常用中间件或常用组件，实现基础方法，可以见到创建项目基础或测试平台。我会不断完善整合功能。    

