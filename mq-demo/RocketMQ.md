# 简介
>RocketMQ是阿里开源的消息中间件，目前已经捐献个Apache基金会，它是由Java语言开发的，具备高吞吐量、高可用性、适合大规模分布式系统应用等特点，经历过双11的洗礼，实力不容小觑。

* 官网：https://rocketmq.apache.org/
* 快速入门：https://rocketmq.apache.org/docs/quick-start/
* 阿里云帮助文档：https://help.aliyun.com/document_detail/29532.html
# RocketMQ中文文档
本文分三篇,分别从概念原理,	集群搭建	,java接入实战 顺序消息和事务消息讲解
本篇内容参照官方文档(Alibaba,apache),原文讲的很简白,本篇引用,不做赘述.
## 基本概念及优势
rocketmq是一个基于发布订阅队列模型的消息中间件,具有高可用,高性能,高实时,天然分布式等特点,(支撑过数次Alibaba双十一),能保证消息严格有序,亿级消息堆积等,设计模型和传统的消息中间件一样,如下(不包含协议)
![image](https://img-blog.csdnimg.cn/20181123211616907.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MDUzMzExMQ==,size_16,color_FFFFFF,t_70)
### 物理部署结构
![image](https://img-blog.csdnimg.cn/20181123211723750.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MDUzMzExMQ==,size_16,color_FFFFFF,t_70)
由上图结构,rocketmq由四大部分组成(集群模式):
NameServer Cluster(名称服务器),
Broker Cluster(代理),
Producer Cluster(生产者),
Consumer Cluster(消费者);
它们中的每一个都可以水平扩展，而不会出现单点故障。如上截图所示

**NameServer**
名称服务器提供轻量级服务发现和路由。每个名称服务器记录完整的路由信息，提供相应的读写服务，支持快速存储扩展

NameServer是一个几乎无状态的功能齐全的服务器，主要包括两个功能：
1.broker 管理，nameserver 接受来自broker集群的注册信息并提供心跳来检测他们是否可用。
2.路由管理 每一个nameserver都持有关于broker集群和队列的全部路由信息，用来向客户端提供查询。
我们知道 ，rocketMQ客户端（生产者/消费者）会从nameserver查询队列的路由信息.
有四种方式能够让客户端湖区到nameserver的地址：
(1).通过程序，像这样producer.setNamesrvAddr(“ip:port”)(最实用)
(2).java 配置项，这么用rocketmq.namesrv.addr
(3).环境变量 NAMESRV_ADDR
(4).HTTP 端点
其中优先级:程序>java配置>环境变量>Http端点
**Broker**
Broker通过提供轻量级主题和队列机制来处理消息存储。它们支持Push和Pull模型，包含容错机制(2个副本或3个副本)，提供了极强的峰值处理里能力和按照时间顺序存储数以百万记的消息存储能力，此外，代理提供了灾难恢复、丰富的度量统计和警报机制，这些都是在传统的消息传递系统中缺乏的

broker server负责消息的存储传递，消息查询，保证高可用等等。
像下图所示，broker server有一些非常重要的子模块：
(1)remoting（远程） 模块，broker的入口，处理从客户端发起的请求。
(2)client manager（客户端管理） 管理各个客户端（生产者/消费者）还有维护消费者主题订阅。
(3)store（存储服务），提供简单的api来在磁盘保持或者查询消息。
(4)HA 高可用服务 提供主从broker的数据同步。
(5)index(索引服务)为消息建立索引提供消息快速查询。
![image](https://img-blog.csdnimg.cn/20181123215307952.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MDUzMzExMQ==,size_16,color_FFFFFF,t_70)
**Producer**
produce支持分布式部署，分布式的produce通过broker集群提供的各种负载均衡策略将消息发送到broker集群中。发送过程支持快速失败是低延迟的

**Consumer**
消费者也支持在推送和者拉取模式下分布式部署，支持集群消费和消息广播。提供实时的消息订阅机制，能够满足大多数消费者的需求.

### 名词解释

**Topic**

消息主题，一级消息类型，通过 Topic 对消息进行分类。

**Tag**

消息标签，二级消息类型，用来进一步区分某个 Topic 下的消息分类。

**Producer**

消息生产者，也称为消息发布者，负责生产并发送消息。

**Producer ID**

一类 Producer 的标识，这类 Producer 通常生产并发送一类消息，且发送逻辑一致。

**Producer 实例**

Producer 的一个对象实例，不同的 Producer 实例可以运行在不同进程内或者不同机器上。Producer 实例线程安全，可在同一进程内多线程之间共享。

**Consumer**

消息消费者，也称为消息订阅者，负责接收并消费消息。

**Consumer ID**

一类 Consumer 的标识，这类 Consumer 通常接收并消费一类消息，且消费逻辑一致。

**Consumer 实例**

Consumer 的一个对象实例，不同的 Consumer 实例可以运行在不同进程内或者不同机器上。一个 Consumer 实例内配置线程池消费消息。

**集群消费**

一个 Consumer ID 所标识的所有 Consumer 平均分摊消费消息。例如某个 Topic 有 9 条消息，一个 Consumer ID 有 3 个 Consumer 实例，那么在集群消费模式下每个实例平均分摊，只消费其中的 3 条消息。

**广播消费**

一个 Consumer ID 所标识的所有 Consumer 都会各自消费某条消息一次。例如某个 Topic 有 9 条消息，一个 Consumer ID 有 3 个 Consumer 实例，那么在广播消费模式下每个实例都会各自消费 9 条消息。

**定时消息**

Producer 将消息发送到 MQ 服务端，但并不期望这条消息立马投递，而是推迟到在当前时间点之后的某一个时间投递到 Consumer 进行消费，该消息即定时消息。

**延时消息**

Producer 将消息发送到 MQ 服务端，但并不期望这条消息立马投递，而是延迟一定时间后才投递到 Consumer 进行消费，该消息即延时消息。

**事务消息**

MQ 提供类似 X/Open XA 的分布事务功能，通过 MQ 事务消息能达到分布式事务的最终一致。

**顺序消息**

MQ 提供的一种按照顺序进行发布和消费的消息类型, 分为全局顺序消息和分区顺序消息。

**顺序发布**

对于指定的一个 Topic，客户端将按照一定的先后顺序进行发送消息。

**顺序消费**

对于指定的一个 Topic，按照一定的先后顺序进行接收消息，即先发送的消息一定会先被客户端接收到。

**全局顺序消息**

对于指定的一个 Topic，所有消息按照严格的先入先出（FIFO）的顺序进行发布和消费。

**分区顺序消息**

对于指定的一个 Topic，所有消息根据 sharding key 进行区块分区。同一个分区内的消息按照严格的 FIFO 顺序进行发布和消费。Sharding key 是顺序消息中用来区分不同分区的关键字段，和普通消息的 key 是完全不同的概念。

**消息堆积**

Producer 已经将消息发送到 MQ 服务端，但由于 Consumer 消费能力有限，未能在短时间内将所有消息正确消费掉，此时在 MQ 服务端保存着未被消费的消息，该状态即消息堆积。

**消息过滤**

订阅者可以根据消息标签（Tag）对消息进行过滤，确保订阅者最终只接收被过滤后的消息类型。消息过滤在 MQ 服务端完成。

**消息轨迹**

在一条消息从发布者发出到订阅者消费处理过程中，由各个相关节点的时间、地点等数据汇聚而成的完整链路信息。通过消息轨迹，用户能清晰定位消息从发布者发出，经由 MQ 服务端，投递给消息订阅者的完整链路，方便定位排查问题。

**重置消费位点**

以时间轴为坐标，在消息持久化存储的时间范围内（默认3天），重新设置消息订阅者对其订阅 Topic 的消费进度，设置完成后订阅者将接收设定时间点之后由消息发布者发送到 MQ 服务端的消息。


## 消息类型
### 普通消息
指没特性的消息,仅仅是个消息,区别于有特性的定时和延时消息、顺序消息和事务消息.
发送普通消息有三种方式:
1. 可靠同步发送

原理：同步发送是指消息发送方发出数据后，会在收到接收方发回响应之后才发下一个数据包的通讯方式。

应用场景：此种方式应用场景非常广泛，例如重要通知邮件、报名短信通知、营销短信系统等。
2. 可靠异步发送

原理：异步发送是指发送方发出数据后，不等接收方发回响应，接着发送下个数据包的通讯方式。 MQ 的异步发送，需要用户实现异步发送回调接口（SendCallback）。消息发送方在发送了一条消息后，不需要等待服务器响应即可返回，进行第二条消息发送。发送方通过回调接口接收服务器响应，并对响应结果进行处理。

应用场景：异步发送一般用于链路耗时较长，对 RT 响应时间较为敏感的业务场景，例如用户视频上传后通知启动转码服务，转码完成后通知推送转码结果等。
3. 单向（Oneway）发送

原理：单向（Oneway）发送特点为发送方只负责发送消息，不等待服务器回应且没有回调函数触发，即只发送请求不等待应答。 此方式发送消息的过程耗时非常短，一般在微秒级别。

应用场景：适用于某些耗时非常短，但对可靠性要求并不高的场景，例如日志收集。

### 定时消息和延时消息
**定时消息**：Producer 将消息发送到 MQ 服务端，但并不期望这条消息立马投递，而是推迟到在当前时间点之后的某一个时间投递到 Consumer 进行消费，该消息即定时消息。
**延时消息**：Producer 将消息发送到 MQ 服务端，但并不期望这条消息立马投递，而是延迟一定时间后才投递到 Consumer 进行消费，该消息即延时消息。
适用场景
消息生产和消费有时间窗口要求：比如在电商交易中超时未支付关闭订单的场景，在订单创建时会发送一条 MQ 延时消息。这条消息将会在30分钟以后投递给消费者，消费者收到此消息后需要判断对应的订单是否已完成支付。 如支付未完成，则关闭订单。如已完成支付则忽略。
通过消息触发一些定时任务，比如在某一固定时间点向用户发送提醒消息。
使用方式
定时消息和延时消息的使用在代码编写上存在略微的区别：
发送定时消息需要明确指定消息发送时间点之后的某一时间点作为消息投递的时间点。
发送延时消息时需要设定一个延时时间长度，消息将从当前发送时间点开始延迟固定时间之后才开始投递。

### 顺序消息
顺序消息（FIFO 消息）是 MQ 提供的一种严格按照顺序进行发布和消费的消息类型。 顺序消息指消息发布和消息消费都按顺序进行。
**顺序发布**：对于指定的一个 Topic，客户端将按照一定的先后顺序发送消息。
**顺序消费**：对于指定的一个 Topic，按照一定的先后顺序接收消息，即先发送的消息一定会先被客户端接收到。
**全局顺序** : 对于指定的一个 Topic，所有消息按照严格的先入先出（FIFO）的顺序进行发布和消费。
![image](https://img-blog.csdnimg.cn/2018112415513262.png)
全局顺序适用场景
性能要求不高，所有的消息严格按照 FIFO 原则进行消息发布和消费的场景
**分区顺序**
对于指定的一个 Topic，所有消息根据 sharding key 进行区块分区。 同一个分区内的消息按照严格的 FIFO 顺序进行发布和消费。 Sharding key 是顺序消息中用来区分不同分区的关键字段，和普通消息的 Key 是完全不同的概念。
![image](https://img-blog.csdnimg.cn/20181124155200143.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MDUzMzExMQ==,size_16,color_FFFFFF,t_70)
适用场景
性能要求高，以 sharding key 作为分区字段，在同一个区块中严格的按照 FIFO 原则进行消息发布和消费的场景。

示例
【例一】用户注册需要发送发验证码，以用户 ID 作为 sharding key， 那么同一个用户发送的消息都会按照先后顺序来发布和订阅。

【例二】电商的订单创建，以订单 ID 作为 sharding key，那么同一个订单相关的创建订单消息、订单支付消息、订单退款消息、订单物流消息都会按照先后顺序来发布和订阅。

阿里巴巴集团内部电商系统均使用分区顺序消息，既保证业务的顺序，同时又能保证业务的高性能。

2.4 事务消息
常见的分布式事务解决方案有：最终一致性，两阶段／三界阶段提交，TCC，本地消息表等。这些解决方案中，最终一致性的性能最好。可以通过RocketMQ实现最终一致性。
RocketMQ事务消息实现方式:
**事务消息**：MQ 提供类似 X/Open XA 的分布事务功能，通过 MQ 事务消息能达到分布式事务的最终一致。
**半消息**：暂不能投递的消息，发送方已经将消息成功发送到了 MQ 服务端，但是服务端未收到生产者对该消息的二次确认，此时该消息被标记成“暂不能投递”状态，处于该种状态下的消息即半消息。
**消息回查**：由于网络闪断、生产者应用重启等原因，导致某条事务消息的二次确认丢失，MQ 服务端通过扫描发现某条消息长期处于“半消息”时，需要主动向消息生产者询问该消息的最终状态（Commit 或是 Rollback），该过程即消息回查。

这篇讲的挺细致:[分布式开放消息系统(RocketMQ)的原理与实践](https://www.jianshu.com/p/453c6e7ff81c)

## 消息模型
### 集群消费
**集群**： MQ 约定使用相同 Consumer ID 的订阅者属于同一个集群。同一个集群下的订阅者消费逻辑必须完全一致（包括 Tag 的使用），这些订阅者在逻辑上可以认为是一个消费节点。

**集群消费**当使用集群消费模式时，MQ 认为任意一条消息只需要被集群内的任意一个消费者处理即可

![消息模型](https://img-blog.csdnimg.cn/20181124164351495.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MDUzMzExMQ==,size_16,color_FFFFFF,t_70)
**适用场景和注意事项**
消费端集群化部署，每条消息只需要被处理一次。
由于消费进度在服务端维护，可靠性更高。
集群消费模式下，每一条消息都只会被分发到一台机器上处理
集群消费模式下，不保证每一次失败重投的消息路由到同一台机器上，因此处理消息时不应该做任何确定性假设。

### 广播消费
当使用广播消费模式时，MQ 会将每条消息推送给集群内所有注册过的客户端，保证消息至少被每台机器消费一次。
![消息模型](https://img-blog.csdnimg.cn/2018112416441434.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MDUzMzExMQ==,size_16,color_FFFFFF,t_70)
**适用场景和注意事项**
广播消费模式下**不支持顺序消息**。
每条消息都需要被相同逻辑的多台机器处理。
消费进度在客户端维护，出现重复的概率稍大于集群模式。
广播模式下，MQ 保证每条消息至少被每台客户端消费一次，但是并不会对消费失败的消息进行失败重投，因此业务方需要关注消费失败的情况。
广播模式下，客户端第一次启动时默认从最新消息消费。客户端的消费进度是被持久化在客户端本地的隐藏文件中，因此不建议删除该隐藏文件，否则会丢失部分消息。
广播模式下，每条消息都会被大量的客户端重复处理，因此推荐尽可能使用集群模式。
目前仅 Java 客户端支持广播模式。
广播模式下服务端不维护消费进度，所以 MQ 控制台不支持消息堆积查询和堆积报警功能。

### 点对点(P2P)
点对点（Point to Point, 简称 P2P），顾名思义，是一对一的消息传递模式，即只有一个消息发送者和一个消息接收者。而发布/订阅（Pub/Sub）通常用于一对多或多对多的消息群发场景，拥有一个或多个消息发送者和多个消息接收者。

在点对点（P2P）模型中，发送者发送消息时已经明确该消息预期的接收方信息，并明确该消息只需要被特定的单个客户端消费。发送者发送消息时通过 Topic 信息直接指定接收者，接收者无需提前进行订阅即可获取该消息。
点对点模式可以节省接收方注册订阅关系的成本，而且收发消息的链路有单独的优化，推送延迟更低。
**P2P和pub/sub的区别**:
发送消息时，Pub/Sub 模式需要按照和接收端约定好的 Topic 发送消息，而 P2P 模式下无需事先约定传输消息的 Topic，发送端可以直接按照规范发送消息到目标的接收客户端。
接收消息时，Pub/Sub 模式需要按照和发送端约定好的 Topic 提前订阅才能收到消息，而 P2P 模式下无需事先订阅，可以简化接收端的程序逻辑，并节省订阅的成本。

## 消息过滤
消息过滤可在broker和consumer端过滤,一般在consumer上过滤,因为单消息量大时,broker压力过重,影响吞吐量
做好过滤得明确为什么要产生这样的消息,明确topic和tag设计的侧重.
**Topic**：消息主题，通过 Topic 对不同的业务消息进行分类；
**Tag**：消息标签，用来进一步区分某个 Topic 下的消息分类，MQ 允许消费者按照Tag 对消息进行过滤，确保消费者最终只消费到他关注的消息类型。
topic是一级标签,tag是二级标签.
**使用准则**:
1.消息类型是否一致,事务消息,顺序消息等
2.业务相关性:没有直接关联的话应用多个topic,例如订单,物流,支付,而男装订单,女装订单则可以使用tag
3.消息量级是否相当：A消息是万亿量级,B消息是轻量级但要求实时性高,即便A和B符合准则1,2,也挺该使用不同topic,避免B消息被 "拖累"

## 刷盘策略
先看下影响消息可靠性的几种情况：

1.Broker正常关闭
2.Broker异常Crash
3.OS Crash
4.机器掉电，但是能立即恢复供电情况。
5.机器无法开机（可能是cpu、主板、内存等关键设备损坏）
6.磁盘设备损坏。
1,2,3,4四种情况都属于硬件资源可立即恢复情况,异步复制的话,可以保证99%的消息不丢失.5,6属于单点故障,同步刷盘可保证所有消息不丢失

### 异步复制(异步刷盘)
当集群做了主从配置(多主多从),producer向master发送消息,master立马返回,此后根据设置的策略,slave从master上pull消息,进行同步,当master挂了后,slave不会主动提升为master,但仍可订阅

### 同步双写
producer向master发送消息,只有master和slave都写入成功时,才返回.性能较异步略低,适用于对消息严格的业务,比如带money



# 安装与使用
1. 环境要求：
64bit OS, Linux/Unix/Mac is recommended;
64bit JDK 1.8+;
Maven 3.2.x;
Git;
4g+ free disk for Broker server
2. 下载编译
Click [here](http://rocketmq.apache.org/release_notes/release-notes-4.4.0/) to download the 4.4.0 source release.
```bash
> unzip rocketmq-all-4.4.0-source-release.zip
> cd rocketmq-all-4.4.0/
> mvn -Prelease-all -DskipTests clean install -U
> cd distribution/target/apache-rocketmq
```
3. 启动 Name Server
```bash
  > nohup sh bin/mqnamesrv &
  > tail -f ~/logs/rocketmqlogs/namesrv.log
  The Name Server boot success...
```
⚠️注意事项：若在启动过程中查看日志报错如下：
```bash
ERROR: Please set the JAVA_HOME variable in your environment, We need Java(x64)! !!
```
打开启动脚本runserver.sh以及runbroker.sh文件，发现有如下三行：
```bash
[ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=$HOME/jdk/java
[ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=/usr/java
[ ! -e "$JAVA_HOME/bin/java" ] && error_exit "Please set the JAVA_HOME variable in your environment, We need java(x64)!"
```
这里默认设置java安装路径为$HOME/jdk/java,其中第二行是阿里巴巴集团内部服务器上的java目录，若报以上错误，将这一行注释掉。然后第一行的JAVA_HOME的值改为自己机器的Java安装目录。然后再次起送mqnameserver以及mqbroker，观察日志发现启动成功：
特别是MAC OS
> tips: 
MAC OS reference :[MAC OS Start](http://xiajunhust.github.io/2016/11/12/RocketMQ%E6%BA%90%E7%A0%81%E5%AD%A6%E4%B9%A0%E4%B9%8B%E4%B8%80-MAC%E7%B3%BB%E7%BB%9F%E5%8D%95%E6%9C%BA%E7%8E%AF%E5%A2%83%E6%90%AD%E5%BB%BA/)
4. 启动 Broker
```bash
  > nohup sh bin/mqbroker -n localhost:9876 &
  > tail -f ~/logs/rocketmqlogs/broker.log 
  The broker[%s, 172.30.30.233:10911] boot success...
```
启动自动创建topic
```bash
nohup sh mqbroker -n localhost:9876 autoCreateTopicEnable=true &
```
5. 发送消费消息

6. 关闭 Servers
```bash
> sh bin/mqshutdown broker
The mqbroker(36695) is running...
Send shutdown request to mqbroker(36695) OK

> sh bin/mqshutdown namesrv
The mqnamesrv(36664) is running...
Send shutdown request to mqnamesrv(36664) OK

```
# RocketMQ插件
## RocketMQ-Console
> RocketMQ-Console是RocketMQ项目的扩展插件，是一个图形化管理控制台，提供Broker集群状态查看，Topic管理，Producer、Consumer状态展示，消息查询等常用功能，这个功能在安装好RocketMQ后需要额外单独安装、运行。
1. 进入[rocketmq-externals](https://github.com/apache/rocketmq-externals)项目GitHub地址，如下图，可看到RocketMQ项目的诸多扩展项目，其中就包含我们需要下载的rocketmq-console。
2. 使用git命令下载项目源码，由于我们仅需要rocketmq-console，故下载此项目对应分支即可。
```bash
$ git clone -b release-rocketmq-console-1.0.0 https://github.com/apache/rocketmq-externals.git
```
3. 进入项目文件夹并按照实际情况修改对应配置文件
```properties
server.contextPath=
server.port=8080
#spring.application.index=true
spring.application.name=rocketmq-console
spring.http.encoding.charset=UTF-8
spring.http.encoding.enabled=true
spring.http.encoding.force=true
logging.config=classpath:logback.xml
#if this value is empty,use env value rocketmq.config.namesrvAddr  NAMESRV_ADDR | now, you can set it in ops page.default localhost:9876
rocketmq.config.namesrvAddr=localhost:9876
#if you use rocketmq version < 3.5.8, rocketmq.config.isVIPChannel should be false.default true
rocketmq.config.isVIPChannel=
#rocketmq-console's data path:dashboard/monitor
rocketmq.config.dataPath=/tmp/rocketmq-console/data
#set it false if you don't want use dashboard.default true
rocketmq.config.enableDashBoardCollect=true
```
Name Server地址默认为空，注释说可以在启动项目后在后台配置，经测试，后台配置切换失败，有报错，所以打包前需修改配置文件明确给出Name Server地址，或者启动服务的时候给出rocketmq.config.namesrvAddr参数值。
4. 将项目打成jar包，并运行jar文件。
```bash
$ mvn clean package -Dmaven.test.skip=true
$ java -jar target/rocketmq-console-ng-1.0.0.jar
#如果配置文件没有填写Name Server
$ java -jar target/rocketmq-console-ng-1.0.0.jar --rocketmq.config.namesrvAddr='127.0.0.1:9876'
```
5. 启动成功后，访问地址http://localhost:8080/rocketmq, 即可进入管理后台操作。

## RocketMQ命令行管理工具(CLI Admin Tool)
> 命令行管理工具（CLI Admin Tool）对RocketMQ集群的管理提供了更多精细化的管理命令，命令行的方式对操作人员的要求稍高一些，当然，掌握了使用方法，就会简单高效很多。命令行管理工具无需额外安装，已经包含在${RocketMQ_HOME}/bin文件夹下面。

上面已经讲过命令行管理工具已经包含在RocketMQ项目中，我们进入项目下的bin文件夹，并执行命令bash mqadmin:
```bash
The most commonly used mqadmin commands are:
   updateTopic          Update or create topic
   deleteTopic          Delete topic from broker and NameServer.
   updateSubGroup       Update or create subscription group
   deleteSubGroup       Delete subscription group from broker.
   updateBrokerConfig   Update broker's config
   updateTopicPerm      Update topic perm
   topicRoute           Examine topic route info
   topicStatus          Examine topic Status info
   topicClusterList     get cluster info for topic
   brokerStatus         Fetch broker runtime status data
   queryMsgById         Query Message by Id
   queryMsgByKey        Query Message by Key
   queryMsgByUniqueKey  Query Message by Unique key
   queryMsgByOffset     Query Message by offset
   printMsg             Print Message Detail
   printMsgByQueue      Print Message Detail
   sendMsgStatus        send msg to broker.
   brokerConsumeStats   Fetch broker consume stats data
   producerConnection   Query producer's socket connection and client version
   consumerConnection   Query consumer's socket connection, client version and subscription
   consumerProgress     Query consumers's progress, speed
   consumerStatus       Query consumer's internal data structure
   cloneGroupOffset     clone offset from other group.
   clusterList          List all of clusters
   topicList            Fetch all topic list from name server
   updateKvConfig       Create or update KV config.
   deleteKvConfig       Delete KV config.
   wipeWritePerm        Wipe write perm of broker in all name server
   resetOffsetByTime    Reset consumer offset by timestamp(without client restart).
   updateOrderConf      Create or update or delete order conf
   cleanExpiredCQ       Clean expired ConsumeQueue on broker.
   cleanUnusedTopic     Clean unused topic on broker.
   startMonitoring      Start Monitoring
   statsAll             Topic and Consumer tps stats
   allocateMQ           Allocate MQ
   checkMsgSendRT       check message send response time
   clusterRT            List All clusters Message Send RT
   getNamesrvConfig     Get configs of name server.
   updateNamesrvConfig  Update configs of name server.
   getBrokerConfig      Get broker config by cluster or special broker!
   queryCq              Query cq command.
   sendMessage          Send a message
   consumeMessage       Consume message
```
上面清单中左边为命令名称，右边为命令含义的解释，可以看到，大部分我们常用的功能已包含其中，具体如何使用这些命令，可以通过执行bash mqadmin help <command>来了解细节，我们以常用命令updateTopic为例，执行bash mqadmin help updateTopic,打印如下信息：
```bash
usage: mqadmin updateTopic [-b <arg>] [-c <arg>] [-h] [-n <arg>] [-o <arg>] [-p <arg>] [-r <arg>] [-s <arg>]
       -t <arg> [-u <arg>] [-w <arg>]
 -b,--brokerAddr <arg>       create topic to which broker
 -c,--clusterName <arg>      create topic to which cluster
 -h,--help                   Print help
 -n,--namesrvAddr <arg>      Name server address list, eg: 192.168.0.1:9876;192.168.0.2:9876
 -o,--order <arg>            set topic's order(true|false)
 -p,--perm <arg>             set topic's permission(2|4|6), intro[2:W 4:R; 6:RW]
 -r,--readQueueNums <arg>    set read queue nums
 -s,--hasUnitSub <arg>       has unit sub (true|false)
 -t,--topic <arg>            topic name
 -u,--unit <arg>             is unit topic (true|false)
 -w,--writeQueueNums <arg>   set write queue nums
```
可以看见，刚才新建的TopicTest以及一些系统默认的topic。如果想学习了解这些命令的源码实现可以点击查看[这里](https://github.com/apache/rocketmq/tree/master/tools)。
# 参考
* apache:http://rocketmq.apache.org/docs/motivation/
* alibaba:https://help.aliyun.com/document_detail/29532.html
* https://my.oschina.net/buru1kan/blog/1814356
* http://xiajunhust.github.io/2016/11/12/RocketMQ%E6%BA%90%E7%A0%81%E5%AD%A6%E4%B9%A0%E4%B9%8B%E4%B8%80-MAC%E7%B3%BB%E7%BB%9F%E5%8D%95%E6%9C%BA%E7%8E%AF%E5%A2%83%E6%90%AD%E5%BB%BA/
