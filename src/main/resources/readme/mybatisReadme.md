## mybatis 设计思想
- 通过sqlsessionbeanFactory构建sqlsessionfactory同时,初始化configuration对象,加载mapper文件;
   缓存在concurrentMap中,并且MapperProxyFactory放入knowsMap里面.Key为Mapper对象的Class字符串,

- @Autowired注入mapper时,因为mapper没有具体的实现类,会找到knowsmap获取
  MapperProxyFactory对象,构造MapperProxy代理实现类;
  
- 执行mapper方法时,实际执行的是MapperProxy.invoke方法.因为MapperProxy
   实现了InvocationHandler,通过configuration获取MapperMethod,调用底层的
   PreparedStatement.update执行sql语句
