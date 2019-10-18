# MyTestNG
工程描述：
利用JAVA语言，结合TestNG测试框架和Rest Assured测试框架，实现了接口测试框架的整合。
使之具有Rest Assured的测试case的简洁编写优点，
同时具有TestNG详细测试报告的优点。

语言：JAVA

测试框架：TestNG + Rest Assured

配置文件：

pom.xml
  Maven编辑的工程，需要配置依赖包，如：rest assured相关、report相关、testng相关
  
application.properties
  请求地址，比如url和uri的统一配置，便于管理和维护


大致思路：
1、登录成功后，先后调用展业的各模块的各接口：
    客户管理、客户线索、财经早报、朋友圈助手、精品海报、转发助手
    每个模块最后一个层级，单独创建一个.java文件
2、登录接口共用，BeforeSuite，登录成功后的token存储到mysql中，其余接口入参token取自mysql
3、case校验分两层：接口返回校验、数据层（insert、update、delete）
4、测试结果以report形式展示
5、report.html发送到邮箱
6、v1.0版本只写正向的case

