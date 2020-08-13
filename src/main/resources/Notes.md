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
  
   
   