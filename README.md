## 1. 项目介绍



### 1.1 开发环境

- 操作系统：macOS 10.14.2
- 开发工具：Intellig IDEA
- 数据库：MySQL 8.0.13
- Java SDK : Oracle JDK 1.8.152

### 1.2 部署环境

- 操作系统：Linux CentOS7.4-64bit

### 1.3 项目管理工具

- 项目构建：Maven + Nexus
- 代码管理：Git + GitHub
- 镜像管理：Docker Registry

### 1.4 后台主要技术栈

- 核心框架：Spring Boot + Spring Cloud Alibaba
- ORM框架：Mybatis-Plus
- 数据库连接池：Alibaba Druid
- 数据库缓存：Redis Sentinel
- 消息中间件：RocketMQ
- 全文检索引擎：ElasticSearch
- 分布式链路追踪：SkyWalking
- 分布式文件系统：Alibaba OSS
- 分布式系统网关：Spring Cloud GateWay
- 分布式协调系统：Spring Cloud Alibaba Nacos Server
- 分布式配置中心：SpringCloud ALibaba Config
- 分布式熔断降级：Spring Cloud Alibaba Sentinel
- 反向代理负载均衡：Nginx

---

### 1.5 前后台分离

前端框架：NodeJS + VUE + Axios

---

### 1.6 持续集成

GitHub+Jenkins

---

### 1.7 拓扑结构

![拓扑结构](https://github.com/MrTallon/Mind-Palace/blob/master/img/%E6%8B%93%E6%89%91.png?raw=true)

### 1.8 Service

| 服务名称                                 | 服务端口 | 服务说明       |
| ---------------------------------------- | -------- | -------------- |
| **以下为通用服务**                       |          |                |
| myshop-service-gateway                   | 9000     | 服务网关       |
| myshop-service-reg                       | 9501     | 用户注册       |
| myshop-service-email                     | 9876     | 邮箱任务       |
| myshop-external-skywalking               | 8080     | 链路追踪       |
| myshop-service-sso                       | 9502     | 单点登录       |
| myshop-service-cache                     | 9503     | 缓存服务       |
| myshop-service-oss                       | 9504     | 文件上传       |
| myshop-service-forget                    | 9505     | 忘记密码       |
| myshop-service-search                    | 9506     | 全文检索       |
| myshop-service-datetime                  |          | 全局时钟       |
| **以下为服务提供者**                     |          |                |
| myshop-service-provider-content-category | 10101    | 内容分类提供者 |
| myshop-service-provider-content          | 10102    | 内容服务提供者 |
| myshop-service-provider-item-cat         | 10103    | 商品分类提供者 |
| myshop-service-provider-item-desc        | 10104    | 商品详情提供者 |
| myshop-service-provider-item             | 10105    | 商品服务提供者 |
| myshop-service-provider-order            | 10106    | 订单服务提供者 |
| myshop-service-provider-order-item       | 10107    | 订单项提供者   |
| myshop-service-provider-order-shipping   | 10108    | 购物车提供者   |
| **以下为服务消费者**                     |          |                |
| myshop-service-consumer-content-category | 10201    | 内容分类消费者 |
| myshop-service-consumer-content          | 10202    | 内容服务消费者 |
| myshop-service-consumer-item-cat         | 10203    | 商品分类消费者 |
| myshop-service-consumer-item-desc        | 10204    | 商品详情消费者 |
| myshop-service-consumer-item             | 10205    | 商品服务消费者 |
| myshop-service-consumer-order            | 10206    | 订单服务消费者 |
| myshop-service-consumer-order-item       | 10207    | 订单项消费者   |
| myshop-service-consumer-order-shipping   | 10208    | 购物车消费者   |


#### 本地服务(127.0.0.1)


#### 远程服务(42.157.128.41)






## 2. 亮点详解
### 2.1 Skywalking链路追踪
这一块真的是有天坑，祝各位好运吧

首先，skywalking因为宿主机的ip问题，始终无法通过docker镜像启动（也可能是我的问题）

通过官网下载sk文件，修改application.yml的h2及elasticsearch信息，直接启动。

1. 启动nacos
![启动nacos](https://github.com/MrTallon/MyShop/blob/master/myshop-commons/images/%E5%90%AF%E5%8A%A8nacos.png?raw=true)
2. 启动elasticsearch
![启动es](https://github.com/MrTallon/MyShop/blob/master/myshop-commons/images/%E5%90%AF%E5%8A%A8es.png?raw=true)
3. 启动skywalking
![启动sk](https://github.com/MrTallon/MyShop/blob/master/myshop-commons/images/%E5%90%AF%E5%8A%A8skywalking.png?raw=true)
4. 启动本地服务，发送请求
![启动服务](https://github.com/MrTallon/MyShop/blob/master/myshop-commons/images/%E5%90%AF%E5%8A%A8%E6%9C%8D%E5%8A%A1.png?raw=true)
5. nacos服务注册成功
![nacos成功](https://github.com/MrTallon/MyShop/blob/master/myshop-commons/images/nacos%E6%B3%A8%E5%86%8C%E6%9C%8D%E5%8A%A1.png?raw=true)
6. skywalking监测服务详情
![sk成功](https://github.com/MrTallon/MyShop/blob/master/myshop-commons/images/sk%E7%9B%91%E6%B5%8B%E6%9C%8D%E5%8A%A1.png?raw=true)

### 2.2 Maven Assembly
目的是提供工程依赖元素、模块、网站文档等其他文件存放到单个归档文件里,方便后期维护。
![as](https://github.com/MrTallon/MyShop/blob/master/myshop-commons/images/as%E6%8F%92%E4%BB%B6.png?raw=true)

### 2.3 邮件任务
Spring Boot + RocketMQ + Thymeleaf 异步消息队列发送模版邮件

#### 2.3.1 RocketMQ
![mq](https://github.com/MrTallon/MyShop/blob/master/myshop-commons/images/rocketmq.jpg?raw=true)
高性能，高可用，高并发。
经过多次双十一洗礼，稳定可靠。


### 2.4 Swagger2 接口文档
在线测试接口，并且极大的简化了接口文档的编写。
![sw](https://github.com/MrTallon/MyShop/blob/master/myshop-commons/images/swagger.jpg?raw=true)





## 3. 具体需求及处理

### 3.1 json字符串不显示为null的标签

```
@JsonInclude(JsonInclude.Include.NON_NULL)
```

### 3.2 用日志级别控制显示信息

开发环境的报错信息有详情，生产环境不暴露错误详情(应该屏蔽敏感信息，detail字段最好在生产环境不可见)
```yaml
#动态读取配置文件中的日志级别
applicationContext.getEnvironment().getProperty("com.funtl.myshop")
```

### 3.3 跨域

使用Spring Cloud服务网关，基于reactive解决跨域问题
所有服务都在API网关聚合，所以其他模块不需要再做跨域处理


## 4. 使用到的设计模式

### 简单工厂模式

### 单例模式

### 外观模式




---

### 未完待续···






特别感谢**Lusifer**提供的技术帮助 














