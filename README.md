# Spring Cloud Alibaba

## 项目介绍



### 开发环境

- 操作系统：macOS Mojave 10.14.2
- 开发工具：Intellig IDEA
- 数据库：MySQL 8.0.13
- Java SDK : Oracle JDK 1.8.152

### 部署环境

- 操作系统：Linux CentOS7.4-64bit

### 项目管理工具

- 项目构建：Maven + Nexus
- 代码管理：Git + GitHub
- 镜像管理：Docker Registry

### 后台主要技术栈

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

### 前后台分离

前端框架：NodeJS + VUE + Axios

---

### 持续集成

GitHub+Jenkins

---

### 拓扑结构

![拓扑结构](https://github.com/MrTallon/Mind-Palace/blob/master/img/%E6%8B%93%E6%89%91.png?raw=true)

### Service

| 服务名称                                 | 服务端口 | 服务说明       |
| ---------------------------------------- | -------- | -------------- |
| **以下为通用服务**                       |          |                |
| myshop-service-gateway                   | 9000     | 服务网关       |
| myshop-service-reg                       | 9501     | 用户注册       |
| myshop-service-sso                       | 9502     | 单点登录       |
| myshop-service-cache                     | 9503     | 缓存服务       |
| myshop-service-oss                       | 9504     | 文件上传       |
| myshop-service-forget                    | 9505     | 忘记密码       |
| myshop-service-search                    | 9506     | 全文检索       |
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






## 亮点详解
### Skywalking链路追踪

及时配图

### Maven Assembly
目的是提供工程依赖元素、模块、网站文档等其他文件存放到单个归档文件里。


### RocketMQ
高性能，高可用，高并发。

经过多次双十一洗礼，稳定可靠。





## 具体需求及处理

### json字符串不显示为null的标签
```
@JsonInclude(JsonInclude.Include.NON_NULL)
```


### 开发环境的报错信息有详情，生产环境不暴露错误详情
用日志级别控制显示详情
```
applicationContext.getEnvironment().getProperty("com.funtl.myshop")
```
动态读取配置文件中的日志级别
> 生产环境应该屏蔽敏感信息，detail字段最好在生产环境不可见


## 使用到的设计模式

### 简单工厂模式
整理响应数据的输出

### 单例模式
保证唯一的工厂


### 外观模式




---

### 未完待续···






特别感谢**Lusifer**提供的技术帮助 














