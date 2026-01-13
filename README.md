# mall

<p>
  <a href="#wechat-official-account"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%85%AC%E4%BC%97%E5%8F%B7-macrozheng-blue.svg" alt="WeChat Official Account"></a>
  <a href="#community"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E4%BA%A4%E6%B5%81-%E5%BE%AE%E4%BF%A1%E7%BE%A4-2BA245.svg" alt="Community"></a>
  <a href="https://github.com/macrozheng/mall-learning"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%AD%A6%E4%B9%A0%E6%95%99%E7%A8%8B-mall--learning-green.svg" alt="Tutorial"></a>
  <a href="https://github.com/macrozheng/mall-swarm"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/Cloud%E7%89%88%E6%9C%AC-mall--swarm-brightgreen.svg" alt="SpringCloud Version"></a>
  <a href="https://github.com/macrozheng/mall-admin-web"><img src="https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%90%8E%E5%8F%B0%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F-mall--admin--web-green.svg" alt="Admin System"></a>
  <a href="https://github.com/macrozheng/mall-app-web"><img src="https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E5%89%8D%E5%8F%B0%E5%95%86%E5%9F%8E%E9%A1%B9%E7%9B%AE-mall--app--web-green.svg" alt="Front-end Shop"></a>
  <a href="https://gitee.com/macrozheng/mall"><img src="http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/badge/%E7%A0%81%E4%BA%91-%E9%A1%B9%E7%9B%AE%E5%9C%B0%E5%9D%80-orange.svg" alt="Gitee"></a>
</p>

## Notes

> 1. Quick try: [Online demo](https://www.macrozheng.com/admin/index.html).
> 2. Full tutorial: [“mall Tutorial”](https://www.macrozheng.com).
> 3. Video tutorials (latest): [“mall Video Tutorial”](https://www.macrozheng.com/mall/foreword/mall_video.html).
> 4. Microservices version: project based on Spring Cloud Alibaba: [mall-swarm](https://github.com/macrozheng/mall-swarm).
> 5. Branch info: `master` branch is based on Spring Boot 2.7 + JDK 8, `dev-v3` branch is based on Spring Boot 3.2 + JDK 17.

## Overview

The `mall` project aims to build a complete e-commerce system implemented with mainstream technologies.

## Documentation

Documentation: [https://www.macrozheng.com](https://www.macrozheng.com)

## Project Introduction

The `mall` project is an e-commerce system including both front-end shop and back-end admin systems. It is implemented with SpringBoot + MyBatis and supports Docker container deployment. The front-end shop includes homepage, product recommendations, search, product display, shopping cart, order process, member center, customer service, help center, etc. The admin system includes product management, order management, member management, promotion management, operations, content management, reporting, finance, permission management, settings, and other modules.

### Demo

#### Admin System

Front-end project `mall-admin-web` repository: https://github.com/macrozheng/mall-admin-web

Demo: [https://www.macrozheng.com/admin/index.html](https://www.macrozheng.com/admin/index.html)

![Admin system demo](./document/resource/mall_admin_show.png)

#### Front-end Shop

Front-end project `mall-app-web` repository: https://github.com/macrozheng/mall-app-web

Demo (best viewed in mobile mode): [https://www.macrozheng.com/app/](https://www.macrozheng.com/app/)

![Front-end shop demo](./document/resource/re_mall_app_show.jpg)

### Project Structure

```lua
mall
├── mall-common -- utilities and common code
├── mall-mbg -- MyBatisGenerator generated DB access code
├── mall-security -- common SpringSecurity module
├── mall-admin -- admin system APIs
├── mall-search -- Elasticsearch-based product search
├── mall-portal -- front-end shop APIs
└── mall-demo -- test code used when building the framework
```

### Technology Stack

#### Backend

| Technology           | Description                          | Website                                        |
| -------------------- | ------------------------------------ | ---------------------------------------------- |
| SpringBoot           | Web application framework            | https://spring.io/projects/spring-boot         |
| SpringSecurity       | Authentication and authorization     | https://spring.io/projects/spring-security     |
| MyBatis              | ORM framework                        | http://www.mybatis.org/mybatis-3/zh/index.html |
| MyBatisGenerator     | Data layer code generator            | http://www.mybatis.org/generator/index.html    |
| Elasticsearch        | Search engine                        | https://github.com/elastic/elasticsearch       |
| RabbitMQ             | Message queue                        | https://www.rabbitmq.com/                      |
| Redis                | In-memory data store                 | https://redis.io/                              |
| MongoDB              | NoSQL database                       | https://www.mongodb.com                        |
| LogStash             | Log collection tool                  | https://github.com/elastic/logstash            |
| Kibana               | Log visualization                    | https://github.com/elastic/kibana              |
| Nginx                | Static resource server               | https://www.nginx.com/                         |
| Docker               | Container engine                     | https://www.docker.com                         |
| Jenkins              | CI/CD tool                           | https://github.com/jenkinsci/jenkins           |
| Druid                | Database connection pool             | https://github.com/alibaba/druid               |
| OSS                  | Object storage                       | https://github.com/aliyun/aliyun-oss-java-sdk  |
| MinIO                | Object storage                       | https://github.com/minio/minio                 |
| JWT                  | JWT authentication support           | https://github.com/jwtk/jjwt                   |
| Lombok               | Java language enhancements           | https://github.com/rzwitserloot/lombok         |
| Hutool               | Java utility library                 | https://github.com/looly/hutool                |
| PageHelper           | MyBatis physical pagination plugin   | http://git.oschina.net/free/Mybatis_PageHelper |
| Swagger-UI           | API documentation UI                 | https://github.com/swagger-api/swagger-ui      |
| Hibernate-Validator  | Validation framework                 | http://hibernate.org/validator                 |

#### Frontend

| Technology       | Description                   | Website                                 |
| ---------------- | ---------------------------- | ---------------------------------------- |
| Vue              | Front-end framework           | https://vuejs.org/                       |
| Vue-router       | Routing framework             | https://router.vuejs.org/                |
| Vuex             | Global state management       | https://vuex.vuejs.org/                  |
| Element          | UI component library          | https://element.eleme.io                 |
| Axios            | HTTP client                   | https://github.com/axios/axios           |
| v-charts         | Chart library based on ECharts| https://v-charts.js.org/                 |
| js-cookie        | Cookie management             | https://github.com/js-cookie/js-cookie   |
| nprogress        | Progress bar component        | https://github.com/rstacruz/nprogress    |

#### Mobile

| Technology     | Description                 | Website                                      |
| -------------- | -------------------------- | --------------------------------------------- |
| Vue            | Core front-end framework   | https://vuejs.org                             |
| Vuex           | Global state management    | https://vuex.vuejs.org                        |
| uni-app        | Mobile front-end framework | https://uniapp.dcloud.io                      |
| mix-mall       | E-commerce template        | https://ext.dcloud.net.cn/plugin?id=200      |
| luch-request   | HTTP request framework     | https://github.com/lei-mu/luch-request       |

#### Architecture Diagrams

##### System Architecture

![System architecture](./document/resource/re_mall_system_arch.jpg)

##### Business Architecture

![Business architecture](./document/resource/re_mall_business_arch.jpg)

#### Module Overview

##### Admin System `mall-admin`

- Product management: [feature diagram - product.jpg](document/resource/mind_product.jpg)
- Order management: [feature diagram - order.jpg](document/resource/mind_order.jpg)
- Promotion management: [feature diagram - promotion.jpg](document/resource/mind_sale.jpg)
- Content management: [feature diagram - content.jpg](document/resource/mind_content.jpg)
- User management: [feature diagram - user.jpg](document/resource/mind_member.jpg)

##### Front-end Shop `mall-portal`

[feature diagram - portal.jpg](document/resource/mind_portal.jpg)

#### Development Progress

![Development progress](./document/resource/re_mall_dev_flow.jpg)

## Environment Setup

### Development Tools

| Tool           | Description                | Website                                                                 |
| -------------- | -------------------------- | ----------------------------------------------------------------------- |
| IDEA           | IDE                       | https://www.jetbrains.com/idea/download                                 |
| RedisDesktop   | Redis client               | https://github.com/qishibo/AnotherRedisDesktopManager                   |
| Robomongo      | MongoDB client             | https://robomongo.org/download                                          |
| SwitchHosts    | Local hosts manager        | https://oldj.github.io/SwitchHosts/                                     |
| X-shell        | Remote SSH client          | http://www.netsarang.com/download/software.html                         |
| Navicat        | Database client            | http://www.formysql.com/xiazai.html                                     |
| PowerDesigner  | Database design tool       | http://powerdesigner.de/                                                |
| Axure          | Prototype design tool      | https://www.axure.com/                                                  |
| MindMaster     | Mind map tool              | http://www.edrawsoft.cn/mindmaster                                      |
| ScreenToGif    | GIF recorder               | https://www.screentogif.com/                                            |
| ProcessOn      | Flowchart tool             | https://www.processon.com/                                               |
| PicPick        | Image editing tool         | https://picpick.app/zh/                                                 |
| Snipaste       | Screenshot tool            | https://www.snipaste.com/                                               |
| Postman        | API testing tool           | https://www.postman.com/                                                 |
| Typora         | Markdown editor            | https://typora.io/                                                       |

### Development Environment

| Tool            | Version | Download                                                         |
| --------------- | ------- | ---------------------------------------------------------------- |
| JDK             | 1.8     | https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html |
| MySQL           | 5.7     | https://www.mysql.com/                                           |
| Redis           | 7.0     | https://redis.io/download                                        |
| MongoDB         | 5.0     | https://www.mongodb.com/download-center                          |
| RabbitMQ        | 3.10.5  | http://www.rabbitmq.com/download.html                            |
| Nginx           | 1.22    | http://nginx.org/en/download.html                                |
| Elasticsearch   | 7.17.3  | https://www.elastic.co/downloads/elasticsearch                   |
| Logstash        | 7.17.3  | https://www.elastic.co/cn/downloads/logstash                     |
| Kibana          | 7.17.3  | https://www.elastic.co/cn/downloads/kibana                       |

### Setup Steps

> Windows Deployment

- For Windows setup, see: [mall backend development environment setup](https://www.macrozheng.com/mall/start/mall_deploy_windows.html);
- Note: If you only start the `mall-admin` module, you only need MySQL and Redis;
- Clone the `mall-admin-web` project and import it into your IDE for build: [frontend repo](https://github.com/macrozheng/mall-admin-web);
- Frontend installation and deployment instructions: [mall frontend environment setup](https://www.macrozheng.com/mall/start/mall_deploy_web.html).

> Docker Deployment

- For installing CentOS 7.6 in a VM, see: [Virtual machine installation and Linux usage guide](https://www.macrozheng.com/mall/deploy/linux_install.html);
- Building Docker images for this project: [Build Docker image for SpringBoot apps using Maven plugin](https://www.macrozheng.com/project/maven_docker_fabric8.html);
- Docker container deployment: [mall deployment on Linux using Docker](https://www.macrozheng.com/mall/deploy/mall_deploy_docker.html);
- Docker Compose deployment: [mall deployment on Linux using Docker Compose](https://www.macrozheng.com/mall/deploy/mall_deploy_docker_compose.html);
- Automated deployment with Jenkins on Linux: [mall automated deployment with Jenkins](https://www.macrozheng.com/mall/deploy/mall_deploy_jenkins.html);

## WeChat Official Account

Join the WeChat group for discussion: follow the official account "**macrozheng**" and reply "**Join group**".

![Official account QR code](./document/resource/qrcode_for_macrozheng_258.jpg)

## License

[Apache License 2.0](https://github.com/macrozheng/mall/blob/master/LICENSE)

Copyright (c) 2018-2025 macrozheng
