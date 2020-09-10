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