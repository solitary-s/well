#### 配置
```yaml
# 数据源配置
spring:
   # 数据源配置
  datasource: 
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/well?characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Shanghai
    username: root
    password: 123456
    druid:
      initial-size: 8
      min-idle: 1
      max-active: 20
      max-wait: 60000
      time-between-eviction-runsMillis: 60000
      min-evictable-idle-timeMillis: 300000
      validation-query: SELECT 1
      testWhileIdle: true
      testOnBorrow: true
      testOnReturn: false
      pool-prepared-statements: true
      max-open-prepared-statements: 20
      max-pool-prepared-statement-per-connection-size: 20
      statViewServlet:
        enabled: true

# MyBatis配置
mybatis:
    # 搜索指定包别名
    typeAliasesPackage: com.aloneness.**.domain,com.aloneness.**.vo
    # 配置mapper的扫描，找到所有的mapper.xml映射文件
    mapperLocations: classpath*:mybatis/**/*Mapper.xml
    # 加载全局的配置文件
    configLocation: classpath:mybatis/mybatis-config.xml

```