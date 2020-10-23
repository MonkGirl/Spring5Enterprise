

# Spring IoC容器

* IoC流程
    * 创建BeanFactory 
        * IoC启动开始
        * 创建BeanFactory
        * 解析Bean的定义
        * 将BeanName和BeanDefinition注册到BeanFactory的ConcurrentHashMap中，BeanName保存到ArrayList中
    * 实例化Bean
        * 遍历保存BeanName的ArrayList
        * 依次实例化Bean
    * 依赖注入
        * 分析Bean的依赖关系
        * 注入依赖关系
        * IoC启动完成       
    
* Bean的生命周期
    * Bean自身方法
    * Bean生命周期接口方法
    * 容器级生命周期接口方法
    * 工厂后处理器接口方法
    
   |Spring Bean 生命周期各阶段|相关接口及方法|
   |:----------------------|:-----------|
   |Bean自身方法|Bean本身业务方法，配置文件中init-method(注解PostConstruct)和<br/>destroy-method(注解PreDestroy)指定方法|
   |Bean生命周期接口方法|InitializingBean接口<br/>DisposableBean接口<br/>BeanNameAware接口<br/>ApplicationContextAware接口<br/>BeanFactoryAware接口<br/>其他|
   |容器级生命周期接口方法|InstantiationAwareBeanPostProcessor接口实现<br/>BeanPostProcessor接口实现|
   |工厂级生命周期接口方法|AspectJWeavingEnabler<br/>ConfigurationClassPostProcessor<br/>CustomAutowireConfigurer|
  
* 容器级生命周期方法有InstantiationAwareBeanPostProcessor和BeanPostProcessor，其实现类称为后处理器。容器级生命周期接口的实现独立于
Spring IoC容器中的bean，是以容器扩展的形式注册到Spring中的。后处理器影响范围是全局的Spring IoC容器中的Bean。
  
  |接口|解释|
  |:------|:-----|
  |BeanPostProcessor接口|此接口的方法可以对Bean的属性进行更改|
  |InstantiationAwareBeanPostProcessor接口|在Bean实例化前、Bean实例化后进行操作，也可以对Bean实例化后进行属性操作，BeanPostProcessor的子接口|
  |InstantiationAwareBeanPostProcessorAdapter|适配器类|
  
* JDK动态代理的条件是被代理的对象必须实现接口。

* CGLIB动态代理的实现需要实现MethodInterceptor接口，重写intercept()方法。

* Spring AOP相关概念

  |概念|解释|
  |:-----|:-----|
  |横切关注点（Crosscut concern）|一些具有横切多个不同软件模块的行为|
  |切面（Aspect）|切面就是对横向关注点的抽象|
  |连接点（JointPoint）|连接点是在程序执行过程中某个特定的点，Spring只支持方法类型的连接点|
  |切入点（Pointcut）|切入点是匹配连接点的拦截规则，在满足这个切入点的连接点上运行通知，切入点表达式如何和连接点匹配是AOP的核心，Spring默认使用AspectJ切入点语法|
  |通知（Advice）|在切面上拦截到某个特定的连接点之后执行的动作|
  |目标对象（Target Object）|目标对象，被一个或多个切面所通知的对象，及业务中需要进行增强的业务对象|
  |织入（Weaving）|织入是把切面作用到目标对象，然后产生一个代理对象的过程|
  |引入（Introduction）|引入是用来在运行时给一个类声明额外的方法或属性，即不需为类实现一个接口，就能使用接口中的方法|
  
* proxy-target-class="true"强制使用CGLIB代理  

  |切入点类型|解释|
  |:-------|:------|
  |StaticMethodMatcherPointcut|静态方法切入点|
  |DynamicMethodMatcherPointcut|动态方法切入点|
  |AnnotationMatchingPointcut|注解切入点|
  |ExpressionPointcut|表达式切入点|
  |ControlFlowPointcut|流程切入点|
  |ComposablePointcut|复合切入点|
  |TruePointcut|标准切入点|
  
* Spring中支持若干个AspectJ切点指示器，它们用不同的方式描述目标类的连接点

  |Aspect指示器|功能描述|
  |:----------|:-----|
  |args()|通过判断目标类方法运行时入参对象的类型定义指定连接点|
  |@args()|通过判断目标方法运行时入参是否标注特定注解来指定连接点|
  |execution()|匹配满足某一匹配条件的目标方法的连接点|
  |this()|代理类按类型匹配于指定类，则被代理的目标类所有连接点匹配切点|
  |target()|限制连接点匹配目标对象为指定类型的类|
  |@target()|限制连接点匹配目标对象为特定注解标注的类|
  |within()|匹配特定域下的所有连接点|
  |@within()|限制匹配特定注解标注的类的连接点|
  |@annotation()|限制匹配带有指定注解的连接点|
  
* 当注解点“低于”入参类型点时，那么入参类型点的所有子孙类都可以被“@args()”匹配，否则将不会被“@args()”匹配。

* @annotation匹配被指定注解标记的所有方法。

* execution是最常用的函数，语法如：execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)

| 表达式                         | 功能描述                             |
| ------------------------------ | ------------------------------------ |
| 类模式表达式中的.*             | 匹配包中的所有类，不包括子孙包中的类 |
| 类模式表达式中的..*            | 匹配包中以及子孙包中的所有类         |
| 方法入参表达式中的*            | 匹配任意类型参数                     |
| 方法入参表达式中的**           | 匹配任意类型参数且参数不限个数       |
| execution(* make(int, String)) | 匹配make(int, String)方法            |

* target()表示目标类型是指定的类型时，目标类型的所有方法都匹配到。target()可以匹配所有实现类及其子孙类中的所有方法。“@target”匹配标注了指定注解的类。
* this()与target()几乎是等效的，两者在引介切面的情况下略有差别。
* @DeclareParents注解有AspectJ提供，指定满足表达式的类将自动实现某些接口，在运行时会将生成的代理类实现指定的接口。
* within()与execution()的功能类似，两者的区别是，within()定义的连接点的最小范围是类级别，而execution()定义的连接点的最小范围可以精确到方法的入参，因此可以认为execution()涵盖了within()的功能。

* Spring AOP的实现是通过 创建目标对象的代理类，并对目标对象进行拦截来实现的。



# Spring WebFlux

* **编译器重排序**：编译器保证不改变单线程执行结果的前提下，可以调整多线程语句执行顺序。

* **处理器重排序**：如果不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序。

* 响应式编程(Reactive Programmaing)就是与异步数据流交互的一种编程方式。原则：保持数据的不变性；没有共享；阻塞是有害的。

* 在Reactor中，数据流发布者（Publisher）由Flux和Mono两个类表示，它们都提供了丰富的操作符（operator）。一个Flux对象代表一个包含0个或多个（0..N）元素的响应式序列，而一个Mono对象代表0或一个（0..1）元素的结果。

* 作为数据流的发布者，Flux和Mono都可以发出三种数据信号 ，元素值、错误信号和完成信号。错误信号和完成信号都是终止信号 。

* Reactor提供了多线程工具类Schedulers，该类提供的静态方法可以更快创建以下几种多线程环境。
  * 获取当前线程环境Schedulers.immediate().
  * 获取可重用的单线程环境Schedulers.single().
  * 获取弹性线程池环境Schedulers.elastic().
  * 获取固定大小线程池环境Schedulers.parallel().
  * 获取自定义线程池环境Schedulers.fromExecutorService(ExecutorService).
  
* 从SpringMVC项目可以直接升级到Spring WebFlux，只需要在web.xml中的DispatcherServlet中增加属性<async-supported>true</async-supported>.

* 传统SpringMVC由两个注解来配合工作
  * @Controller：定义处理逻辑。
  * @RequestMapping：定义方法对特定URL进行响应。

* WebFlux函数式开发中，提供了类似HandlerFunction和RouterFunction接口来实现SpringMVC的类似功能。
  * HandlerFunction：相当于Controller中的具体处理方法，输入为请求，输出为封装在Mono中的响应。
  * RouterFunction：相当于RequestMapping，将URL映射到具体的HandlerFunction，输入为请求，输出为封装在Mono中的HandlerFunction。
  
* 在WebFlux中，请求和响应不再是WebMVC中的ServletRequest和ServletResponse，而是ServerRequest和ServerResponse，它们提供了对非阻塞和回压特性的支持，以及Http消息体与响应式类型Mono和Flux的转换方法。

# Kotlin

* Kotlin特性

  * 完全兼容java
  * 使用极少的代码量可实现功能，且代码末尾无需分号结尾。
  * 是空安全的，使用Kotlin语言可以有效避免空指针出现。
  * 支持Lambda表达式。
  * public：默认作用域。
  * internal：同模块可见。
  * protected：类似java中protected，对子类可见。
  * private：当前源文件内使用，常量val和变量var，默认都是private。

* Kotlin函数的定义需要用fun来定义，Kotlin函数可以指定返回值类型，也可以使用推断返回值类型，无返回值可以使用Unit标示，也可以不写明返回值。

# Spring 5

  ## HTTP2

* 二进制协议：HTTP 1.x的解析是基于文本的，HTTP 2的解析是基于二进制的。

* 多路复用：每个请求都有一个ID，这样在一个连接上可以发送多个请求，并且在传输过程中是混杂在一起的，接收方可以根据请求的ID将请求再归属 到不同的服务端请求里。

* 请求优先级：为了避免线头堵塞（Head Of Line Block），优先加载重要资源。

* 报头压缩：HTTP2协议拥有HPACK，HPACK的目的是尽可能减少客户端请求与服务器响应之间的头部信息重复所导致的性能开销，

* 服务端推送：HTTP 1.x只能是客户端主动拉取资源，HTTP2支持从服务器端推送资源到客户端。

* 流控制：流控制管理数据的传输，使数据发送者不会让数据接收者不堪重负。


  ## JUnit5

* JUnit Platform是基于JVM的运行测试的基础框架，JUnit Platform定义了开发运行在这个测试框架上的TestEngine API。

* JUnit Jupiter是在JUnit5中编写测试用例和扩展的新编程模式和扩展模型。

* JUnit Vintage提供了一个TestEngine在平台上运行基于JUnit3和JUnit4的测试。

# Log4j2
* Configuration根节点
    * status指定Log4j2本身的日志打印级别。
    * monitorinterval属性，用于指定Log4j自动重新配置的监测间隔时间，单位是秒，最小值5S
    
* Appenders元素：是Configuration元素的子节点，可以指定日志输出路径，常见的日志输出路径有控制台、文件和网络Socket等。
    * Console：用于将日志输出到控制台。name属性指定Appender的名字;target属性可以为SYSTEM_OUT或SYSTEM_ERR,一般使用SYSTEM_OUT;PatternLayout设置日志输出格式。
    * File：用于将日志输出到指定文件。fileName指定输出日志的目标文件，带全路径的文件名
    * RollingFile：用于将日志输出到滚动文件中。Policies元素指定滚动日志的策略
        * TimeBasedTriggeringPolicy：基于时间的滚动策略。interval配置滚动一次的时间，默认1h，modulate=true用于调整时间。
        * SizeBasedTriggeringPolicy：基于指定文件大小的滚动策略。size属性用来定义每个日志文件的大小。
    
* Loggers元素
    * Root：用于指定项目的根日志，如果没有单独指定Logger，则会使用Root作为默认的日志输出。level属性，从低到高顺序All<Trace<Debug<Info<Warn<Error<Fatal<OFF;AppenderRef是Root的子节点，用于指定将日志输出到Appenders元素定义的Appenders中。
    * Logger：用于单独指定日志的形式。
    
* PatternLayout：用于控制日志输出格式。     

    # Spring MVC

* `<aop:aspectj-autoproxy/>`声明自动为spring容器中那些配置@aspectj切面的bean创建代理，织入切面。当然，spring在内部依旧采用annotationAwareAspectAutoProxyCreator进行自动代理的创建工作，但具体实现的细节已经被`<aop:aspectj-autoproxy/>`隐藏起来了。`<aop:aspectj-autoproxy/>`有一个proxy-target-class属性，默认为false，表示使用jdk动态代理织入增强，当配置为true时，表示使用CGLIB动态代理技术织入增强。不过即使设置为false，如果目标类没有声明接口，则spring将自动使用CGLIB动态代理。

* `<context:annotation-config/>`是用于激活那些已经在Spring容器中注册过的bean上面的注解，也就是显示的向Spring注册

    * AutowriedAnnotationBeanPostProcessor

    * CommonAnnotationBeanPostProcessor

    * PersistenceAnnotationBeanPostProcessor

    * RequiredAnnotationBeanPostProcessor

        这四个Processor，注册这4个BeanPostProcessor的作用，就是为了系统能够识别相应的注解。BeanPostProcessor就是处理注解的处理器。
    
* `<mvc:annotation-driven/>`，该注解会自动注册RequestMappingHandlerMapping与RequestMappingHandlerAdapter两个Bean，这是Spring MVC为“@Controller”分发请求所必需的，并且提供了数据绑定支持、“@NumberFormatannotation”支持，“@DataTimeFormat”支持、“@Valid”读写XML的支持（JAXB）和读写JSON的支持（默认jackson）等功能。

  # Spring Mybatis

* spring-jdbc.xml中可以使用`<context:property-placeholder location="***"/>`加载spring-jdbc.properties属性文件，也可以使用注册bean的方法加载属性文件

    <bean id="***" class="org.springframework.context.support.PropertySourcesPlaceholderConfigurer">

    ​	<property name="location" value="classpath:***"/>

    </bean>

    ​      

          # Spring Transaction

* 一个逻辑处理单元要成为事务，必须满足ACID（原子性、一致性、隔离性和持久性）属性。

    * 原子性（Atomicity）：一个事务内的操作，要么全部执行成功，要么全部执行不成功。
    * 一致性（Consistency）：事务执行后，数据库状态与其他业务规则保持一致。
    * 隔离性（Isolation）：每个事务独立运行。
    * 持久性（Durability）：事务一旦提交，数据库中的数据必须被永久地保存下来。

* 事务的隔离级别分为四种。

    * READ_UNCOMMITTED: 已读但未提交，会造成“脏读”。
    * READ_COMMITTED: 不可重复读级别。
    * REPEATEABLE_READ:可重复读级别。
    * SERIALIZABLE: 顺序读是最严格的事务隔离级别。不能并发执行。

* 事务隔离级别

    | 事务隔离级别              | 脏读                 | 不可重复读           | 幻读                 |
    | :------------------------ | -------------------- | -------------------- | -------------------- |
    | ISOLATION_DEFAULT         | 同数据库事务隔离级别 | 同数据库事务隔离级别 | 同数据库事务隔离级别 |
    | ISOLATION_READ_UNCOMMITED | 允许                 | 允许                 | 允许                 |
    | ISOLATION_READ_COMMITED   | 禁止                 | 允许                 | 允许                 |
    | ISOLATION_REPETABLE_READ  | 禁止                 | 禁止                 | 允许                 |
    | ISOLATION_SERIALIZABLE    | 禁止                 | 禁止                 | 禁止                 |

* 事务传播行为：用来描述由某一个事务传播行为修饰的方法被嵌套进另一个的时候，事务的传播性。

    | 事务传播行为类别          | 说明                                                         |
    | ------------------------- | ------------------------------------------------------------ |
    | PROPAGATION_REQUIRED      | 如果当前没有事务，就新建一个事务；如果已经存在一个事务中，就加入到这个事务中。 |
    | PROPAGATION_SUPPORTS      | 支持当前事务。如果当前没有事务，就以非事务方式执行。         |
    | PROPAGATON_MANDATORY      | 使用当前事务。如果当前没有事务，就抛出异常。                 |
    | PROPAGATION_REQUIRES_NEW  | 新建事务。如果当前存在事务，把当前事务挂起。                 |
    | PROPAGATION_NOT_SUPPORTED | 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。   |
    | PROPAGATION_NEVER         | 以非事务方式执行操作，如果当前存在事务，则抛出异常。         |
    | PROPAGATION_NESTED        | 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。与PROPAGATION_REQUIRES_NEW的差别是PROPAGATION_REQUIRES_NEW另起一个事务，将于其父事务相互独立。PROPAGATION_NESTED事务和其父事务时相依的，其要等 父事务一起提交。 |

# Spring Redis

* Redis支持：String字符串类型；Hash哈希类型，键值对集合；List列表类型，用于保存元素列表；Set集合类型，存放多个元素的无序集合；SortedSet有序集合类型，每个元素都会关联一个double类型的分数。

* redis String类型相关命令

  | 命令                                                  | 解释                                                         |
  | ----------------------------------------------------- | ------------------------------------------------------------ |
  | SET key value [EX seconds] [PX milliseconds] [NX\|XX] | 设置键值数据，SET key value EX second效果等同于SETEX key second value。SET key value PX millisecond效果等同于PSETEX key millisecond value。NX键不存在时对键进行操作，XX键存在时对键进行操作。SET key value NX等同于SETNX key value。 |
  | GET key                                               | 获取key的value值                                             |
  | GETRANGE key start end                                | 查询key对用value的子字符串。                                 |
  | GETSET key value                                      | 将key的值设置为value，然后返回旧的value值。                  |
  | MGET key1 key2...                                     | 批量获取多个key的值。                                        |
  | SETEX key timeout value                               | 创建键值对，并设置key的过期时间为timeout，单位秒。           |
  | TTL key                                               | 查询key的剩余时间，TTL（Time To Live），-2表示该key不存在。  |
  | SETNX key value                                       | SETEX（Set if Not Exists）                                   |
  | SETRANGE key offset value                             | 用value参数覆盖key所存储的字符串值，从偏移量offset开始。     |
  | STRLEN key                                            | 返回key的字符串长度                                          |
  | MSET key1 value1 key2 value2                          | 同时设置一个或多个键值对。                                   |
  | MSETNX key1 value1 key2 value2                        | 当且仅当所有给定的key都不存在，同时设置一个或多个key-value   |
  | INCR key                                              | 将key中存储的数字类型的value值加一。                         |
  | INCRBY key increment                                  | 将key中存储的数字类型的value值加increment。                  |
  | DECR key                                              | 将key中存储的数字类型的value值减一。                         |
  | DECRBY key decrement                                  | 将key中存储的数字类型的value值减decrement。                  |
  | APPEND key value                                      | 如果key存在一个字符串值，则将value追加到原值后面。           |

* Hash类型命令

  | 命令                                  | 解释                                        |
  | ------------------------------------- | ------------------------------------------- |
  | HSET key field value                  | 设置key中filed属性值为value。               |
  | HGET key field                        | 获取存储在哈希表key中field的值。            |
  | HEXISTS key field                     | 查看哈希表中指定字段是否存在。              |
  | HINCRBY key field increment           | 将指定哈希表key中的field数值增加increment。 |
  | HGETALL key                           | 获取哈希表key中所有的字段和值。             |
  | HKEYS key                             | 获取哈希表key中所有的字段。                 |
  | HLEN key                              | 获取哈希表key中所有字段个数。               |
  | HMGET key field1 field2               | 获取哈希表key中所有给定字段的值。           |
  | HMSET key field1 value1 field2 value2 | 同时将多个键值对存放在key中。               |
  | HVALS key                             | 获取哈希表key中所有的值。                   |

* List类型命令

  | 命令                                  | 解释                                                         |
  | ------------------------------------- | ------------------------------------------------------------ |
  | LPUSH key value [value2]              | 将一个或多个值插入列表的头部。                               |
  | LRANGE key start stop                 | 获取列表指定范围内的元素。                                   |
  | RPUSH key value [value2]              | 将一个或多个值插入列表的尾部。                               |
  | LINDEX key index                      | 查询列表key指定位置index的值。                               |
  | BLPOP key1 [key2] timeout             | 移除并返回列表的第一个元素，如果列表没有元素会阻塞列表直到等待超时或发现可移除元素为止。 |
  | BRPOP key1 [key2]                     | 移除并返回列表的最后一个元素，如果列表没有元素胡阻塞列表直到等待超时或发现可移除元素为止。 |
  | LINSERT key BEFORE\|AFTER pivot value | 在列表元素的前或者后插入元素。                               |
  | LTRIM key start stop                  | 对一个列表进行截取，让列表只保留指定区间的元素，不在指定区间的元素删除。 |

* Set类型命令

  | 命令                       | 解释                                                   |
  | -------------------------- | ------------------------------------------------------ |
  | SADD key member1 member2   | 向集合key中添加一个或多个元素。                        |
  | SMEMBERS key               | 查看集合key中素有元素。                                |
  | SCARD key                  | 查询集合key中元素个数。                                |
  | SISMEMBER key member       | 判断member是否是key中的元素。                          |
  | SDIFF key1 [key2]          | 查询给定所有集合的差集。key1中去掉同时存在key2中元素。 |
  | SINTER key1 [key2]         | 查询给定所有集合的交集。                               |
  | SUNION key1 [key2]         | 查询给定所有集合的合集。                               |
  | SRANDMEMBER key [count]    | 返回集合key中count个随机元素。                         |
  | SPOP key                   | 移除并返回集合中一个随机元素。                         |
  | SREM key member1 [member2] | 移除集合中一个或多个元素。                             |

* SortedSet类型命令

  | 命令                                        | 解释                                                         |
  | ------------------------------------------- | ------------------------------------------------------------ |
  | ZADD key score1 member1 [score2 member2]    | 向有序集合添加一个或多个元素，且不存在重复元素。             |
  | ZCARD key                                   | 获取有序集合key的元素个数。                                  |
  | ZRANGE key start end [withscores]           | 返回指定区间有序集合的元素。                                 |
  | ZCOUNT key min max                          | 计算分数在指定区间元素的个数。                               |
  | ZRANGEBYSCORE key min max                   | 通过分数查询指定区间的元素。                                 |
  | ZRANK key member                            | 返回有序集合key中指定成员的索引值。                          |
  | ZREVRANGE key start end [withscores]        | 通过索引区间，按照分数从高到低顺序查询有序集合中指定区间内的成员。 |
  | ZREVRANGEBYSCORE key start end [withscores] | 通过分数区间，按照分数从高到底顺序查询有序集合中指定区间内的成员。 |
  | ZREVRANK key member                         | 查询有序集合按分数递减排序是，指定元素的排名。               |
  | ZSCORE key member                           | 查询有序集合中指定成员的分数值。                             |
  | ZREM key member1 [member2]                  | 删除有序集合中一个或多个成员。                               |
  | ZREMRANGEBYSCORE key min max                | 删除有序集合中给定分数区间的所有元素。                       |

* Redis分别提供了RDB（Redis DataBase）和AOF（Append Only File）两种持久化模式。

* Redis主从复制架构的特点是主节点负责接收写入数据的请求，从节点负责接收查询数据的请求，主节点定期把数据同步给从节点。

* 主从复制架构虽然可以提交读并发，但也有缺点：
  * 如果主节点出现问题，则不能提供服务。
  * 主节点单机写能力有限。
  
* 哨兵机制（sentinel）：主节点出现故障时，由Redis哨兵自动完成故障发现和转移，并通知Redis客户端，实现高可用性。

* 集群模式（cluster）：可以在多个Redis节点之间进行数据共享的结构。Redis集群通过分区容错（partition）来提高可用性（availability），即使集群中一部分节点失效或者无法进行通讯，集群可以继续处理命令请求。
  * 将数据切分到多个Redis节点。
  * 当集群中部分节点失效或者无法通讯时，整个集群仍可以处理请求。
  
* 为了使Redis集群在出现问题时仍可以正常运行，Redis集群对节点使用了主从复制功能，及集群中的每个节点有1个Master主节点和若干个从节点。

* CAP原则：一个分布式系统中，一致性（consistency）、可用性（availability）、分区容错性（partition tolernace）三者不可兼得。Redis集群不保证强一致性。

  * 对于Majority一方，如果一个节点未能在节点超时所设定的时限内重新联系上集群，那么集群会将这个主节点视为下线，并使用从节点来替代这个主节点工作。
  * 队友Minority一方，如果一个节点未能在节点超时所设定的时限内重新联系上集群，那么它将停止处理写命令，并向客户端报告错误。

* 如下两种情况发生，整个集群不可用。

  * 某个Master节点下线，并且这个Master节点没有可用的Slave节点。
  * 集群中过半数Master节点下线，无论Master节点是否有Slave节点。
  
* 缓存穿透：频繁查询根本不存在的数据，导致缓存层和存储层都不会命中。

  * 缓存空对象
  * 布隆过滤器拦截

* 缓存雪崩：缓存大量是小或者缓存整体不能提供服务，导致大量请求到达存储层。

  * 保存缓存层的高可用性：使用哨兵模式，或者集群模式。
  * 限流降级组件。Hystrix
  * 缓存不过期。
  * 优化缓存过期时间。
  * 使用互斥锁重建缓存。
  * 异步重建缓存。

# Spring ZooKeeper

* ZooKeeper是开放代码的分布式协调服务框架，是一个为分布式应用提供一致性服务的组件。

  | 角色               | 描述                                                     |
  | ------------------ | -------------------------------------------------------- |
  | 领导者（Leader）   | 领导者负责投票的发起和决议，更新系统状态                 |
  | 跟随着（Follower） | 接受客户端请求并返回结果，在选举阶段参与投票             |
  | 观察者（Observer） | 接受客户端连接，将写请求转发给Leader，不参与选举阶段投票 |
  | 客户端（Client）   | 请求的发起方                                             |

* 每个Znode由三部分组成

  | 名称     | 解释                          |
  | -------- | ----------------------------- |
  | stat     | 存储状态信息                  |
  | data     | 存储数据，数据大小不能超过1MB |
  | children | 存储子节点                    |

* Znode类型

  | 类型                  | 解释         |
  | --------------------- | ------------ |
  | PERSISTENT            | 持久节点     |
  | PERSISTENT_SEQUENTIAL | 持久顺序节点 |
  | EPHEMERAL             | 临时节点     |
  | EPHEMERAL_SEQUENTIAL  | 临时顺序节点 |

* Curator可以监听变动的节点路径。

  | 节点              | 解释                                                         |
  | ----------------- | ------------------------------------------------------------ |
  | NodeCache         | 对一个节点进行监听，监听事件包括指定路径的增删改查操作       |
  | PathChildrenCache | 对指定路径节点的一级子目录进行监听，对其子目录的增删改查进行监听，不对该节点的操作进行监听。 |
  | TreeCache         | 对整个目录进行监听，可以设置监听深度。                       |

  # Spring Kafka
  
* Kafka是一种高吞吐量的分布式订阅消息系统。具有高性能、多副本备份、横向扩展能力。生产者往队列里写消息，消费者从队列里取消息进行业务逻辑。

* Kafka的功能：
  * **解耦**：消息系统在应用系统中间插入一个隐含的、基于数据的接口层，各个应用系统的处理过程都要实现这个接口。
  * **冗余**：Kafka把数据进行持久化直到消息已经被完全处理。
  * **扩展性**：由于Kafka对应用系统进行了解耦，所以增大消息入队和处理的频率很容易，只要另外增加处理过程即可，不要改变代码，也不需要调节参数。
  * **峰值处理能力**：使用消息队列能够使关键组件顶住突发访问压力，而不会因为突发的超负荷请求而导致应用系统完全崩溃。
  * **可复用性**：系统的一部分组件失效时，不会影响这个系统。
  
* Kafka相关术语

  | 字段           | 描述                                                         |
  | -------------- | ------------------------------------------------------------ |
  | Broker         | Kafka集群包含一个或者多个服务器，集群中每个服务器被称为Broker |
  | Topic          | 每条发布到Kafka集群的消息都有一个类别，被称为Topic           |
  | Partition      | Partition是物理上的概念，每个Topic分为一个或者多个Partition  |
  | Producer       | 负责发布消息到Kafka Broker的客户端                           |
  | Consumer       | 消息消费者，从Kafka Broker读取消息的客户端                   |
  | Consumer Group | 每个Consumer属于一个特定的Consumer Group                     |

* 消费组（Consumer Group）是Kafka提供的可扩展且具有容错性的消费者机制。

* ISR(In-Sync-Replicas)副本同步队列。LEO(LogEndOffset)：表示每个Partition的log文件中的最后一条消息的位置。HW(HighWatermark)：是指Consumer能够看到的Partition消息的位置。

  # Spring MyCat

* **垂直分库**：根据业务进行划分，将同一业务相关数据划分在同一数据库中。

* **水平分库**：按照一定的规则对数据库进行划分，每个数据库的表结构相同，数据存储在不同的数据库中。

* **垂直分表**：将一个大表根据业务功能拆分成多个分表。

* **水平分表**：按照一定的规则对数据表进行划分，每个数据表结构形同。

  # Sharding-jdbc

  # Dubbo
  
* 远程过程调用协议（RPC：Remote Procedure Call）是一种通过网络从远程计算机程序上请求的服务，而不需要客户端程序了解底层网络技术的协议。RPC协议使用了某些传输协议，如TCP或UDP，为通信程序之间传输信息数据。在OSI网络通信模型中，RPC跨越了传输层和应用层。

* **RPC**调用流程：

  * **Client**为服务调用方，以本地调用的方式调用服务。
  * **Client Stub**接受调用方的调用请求后，将方法和参数等序列化为消息体。 
  * **Client Stub**寻找服务地址，并将消息发送到服务端。
  * **Server Stub**接受消息体，并将消息反序列化。
  * **Server Stub**使用反序列化的结果进行服务端本地调用。
  * **Server**服务端本地执行成功并返回结果给**Server Stub**。
  * **Server Stub**将结果序列化，并通过网络传输给调用方。
  * **Client Stub**接收到响应消息体，并反序列化。
  * **Client**最终得到服务端响应结果。

* **SPI**(Service Provider Interface)，是java提供的一套用来被第三方实现或者扩展的API，SPI可以用来启用框架扩展和替换组件。

  