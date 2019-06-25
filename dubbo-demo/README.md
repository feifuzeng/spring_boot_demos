# springboot整合使用dubbo
> 只是一个最简单的示例，consumer，producer是完全单独的工程，只是均引入了api工程，api主要就是定义接口方法和出入参

## 环境准备
1. 本地zookeeper

## 步骤
1. 启动zk
2. 启动producer工程
3. 启动consumer工程
4. 访问地址：http://localhost:18080/get
5. 若正确搭建，会返回一条数据


## Dubbo-Admin

* 源码：https://github.com/apache/dubbo-admin
* 开源演示环境地址：http://47.91.207.147/#/service

### 本地环境搭建