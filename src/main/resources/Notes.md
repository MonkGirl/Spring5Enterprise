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