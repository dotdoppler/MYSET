#log

###2016/3/13
很久就想搞一个类似于个人网站的玩意，放在tomcat里跑跑,也可以以项目来驱动自己学习。
初步完成 spring,springMVC环境的搭建，暂时不用ORM框架，以后可以玩玩MyBatis.


2016/3/14
spring MVC 静态资源的问题 最好放在webapp目录下
页面使用Free Bootstrap Theme--Worthy


###2016/3/15
前端施工中，主页：修改CSS, 添加背景图片


###2016/3/16
单例模式 静态工厂方法 DateUtil
搞清楚spring mvc的viewResolver到底怎么用 搞了一下午一晚上还是不怎么清楚啊日
ViewandModel......

###2016/3/20
####working.....hate css.

2016/3/21
算了，还是搞个简单的图书管理系统吧


###2016/3/22
注册功能施工中....
客户端密码校验 

###2016/3/23
持久层框架用 MyBatis试试
正在整合Spring和MyBatis....好多配置文件啊啊啊啊

###2016/3/24
配置文件好多...有点混乱...先把MyBatis整清楚再去整合Spring吧


###2016/3/24
用注解+接口的方式还是直接用xml?  它们之间的关系？ 其实是用接口去对应xml文件？ 接口是用来绑定的？
当你程序需要执行的时候，系统会去寻找对应的sql语句，
你如果存在两个 那么系统就会迷茫 不知道该选择哪一个 所以就报错了  
xml格式最后在编译的时候也是存放在内存中，相当于一段代码
所以他和注解表示的作用是一样的 两个一样的东西 最后系统选择的时候肯定会报错的 因为不知道选哪一个 原来两种方式其实是一样的


###2016/3/26
####xml文件中的 namespace是用来绑定接口的 官方文档还是建议用映射文件，功能更强大，注解的方式更适合执行一些简单的sql语句
select标签中的id属性对应的是接口中方法的名称
再用注解来试试
啊啊啊啊 为什么
<pre><code>
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
<property name="dataSource" ref="dataSource" />
<property name="configLocation" value="classpath:MyBatis-Configuration.xml"></property>
</bean> 
</code></pre>
这个不加 就接口就和xml绑定不了啊啊啊阿   fxxxxxxxxxxx 弄了一下午
	
	
	
###2016/3/29	
处理登陆请求	
loginName这个字段应该是unique,注册的时候也要验证。
要返回List<String> resultType="String" 
验证功能完成中
今天搞ajax的时候，一个有趣的地方，每个迭代中都要发送一个get请求，因为迭代的速度太快，
一个请求还没有完成就进行下一个迭代，在chrome和ff上，除最后一个请求外，其它请求都被取消了。所以该怎么办呢？设置延时（不太好）还是其他办法？
所以不能采用异步请求而是采用同步请求，由于JS的for循环与ajax非同步运行，因此导致for循环结束了而ajax却还未执行。设为同步是一个办法，错误还有个原因是xhr重用了？
如果采用的是异步请求的方式，如果每次迭代的时候都去new一个XMLHttpRequest,这样每次请求都能完成，但是结果还是还是不准确，有些程序还未被执行。
明白了，原来是每次迭代去执行几行代码，应该把发送ajax异步请求的代码放在一个函数中，每次迭代就去调用这个函数，这样就行了。
这个问题是出现在另一个项目中的，终于解决了，interesting。



###2016/3/30
<p>注册功能基本完成，能验证密码是否一致，用户名是否重复。
<p>编码有问题，输入中文、日文有乱码。


###2016/3/31
####处理编码问题,在web.xml中配置一个过滤器，将编码设置为utf-8,目前只过滤指定路径
####真不用jsp了，不渲染页面了，直接返回html页面。  但是这样客户端与服务器该怎样通信呢？SpringMVC可以用注解拿到指定的参数，但是对于提交表单怎么办？并没有绑定表单。
####@RequestParam("userInputForm") User user 这样是不行的
####@ModelAttribute  User user 要这样
####将处理业务的代码从controller里面分离出去，放在service中
####controller该做的事：
<p>处理请求参数
<p>渲染和重定向
<p>选择model和service
<p>处理Session和Cookie
<p>总的说来，就是让controller去调用服务，而不是在controller里处理业务逻辑，业务是善变的，而controller不是。（Command 命令模式）
<p>把代码分离出去了，controller看着清爽多了。

###2016/4/1
####处理登陆
#### 问题 HTTP Status 405 - Request method 'POST' not supported
#### 搞笑原来是没加\
#### 方法中是直接返回一个html页面，这是个静态资源，可能问题出在这里。
#### 从日志里看一下springMVC是怎样处理请求的：
2016-04-01 19:37:34 DispatcherServlet.java DEBUG [org.springframework.web.servlet.DispatcherServlet] DispatcherServlet with name 'springMVC' processing GET request for [/OneLibrary/regist]
<p> 用'springMVC'这个DispatcherServlet处理GET request for [/OneLibrary/regist]
2016-04-01 19:37:34 AbstractHandlerMethodMapping.java DEBUG [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping] Looking up handler method for path /regist
2016-04-01 19:37:34 AbstractHandlerMethodMapping.java DEBUG [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping] Returning handler method [public java.lang.String doppler.controller.RegistController.renderRegistForm()]
<p>寻找处理改请求的方法，然后返回一个了方法   public java.lang.String doppler.controller.RegistController.renderRegistForm() 
2016-04-01 19:37:34 AbstractBeanFactory.java DEBUG [org.springframework.beans.factory.support.DefaultListableBeanFactory] Returning cached instance of singleton bean 'registController'
<p>这里spring返回了一个单例controller，
2016-04-01 19:37:34 DispatcherServlet.java DEBUG [org.springframework.web.servlet.DispatcherServlet] Last-Modified value for [/OneLibrary/regist] is: -1
2016-04-01 19:37:34 AbstractAutowireCapableBeanFactory.java DEBUG [org.springframework.beans.factory.support.DefaultListableBeanFactory] Invoking afterPropertiesSet() on bean with name 'WEB-INF/html/registPage.html'
2016-04-01 19:37:34 DispatcherServlet.java DEBUG [org.springframework.web.servlet.DispatcherServlet] Rendering view [org.springframework.web.servlet.view.JstlView: name 'WEB-INF/html/registPage.html'; URL [WEB-INF/html/registPage.html]] in DispatcherServlet with name 'springMVC'
<p>因为返回的是字符串（其实是想直接返回一个html） 所以交给了一个视图解析器去渲染。可是我并没有配置一个解析器，比如InternalResourceViewResolver，所以用的是默认的JstlView？
2016-04-01 19:37:34 InternalResourceView.java DEBUG [org.springframework.web.servlet.view.JstlView] Forwarding to resource [WEB-INF/html/registPage.html] in InternalResourceView 'WEB-INF/html/registPage.html'
<p>这里为什么又发送了一次get请求？405错误问题应该是出现在了这里。 所以是把这个路径WEB-INF/html/registPage.html 作为一个get请求？  
2016-04-01 19:37:34 DispatcherServlet.java DEBUG [org.springframework.web.servlet.DispatcherServlet] DispatcherServlet with name 'springMVC' processing GET request for [/OneLibrary/WEB-INF/html/registPage.html]
2016-04-01 19:37:34 AbstractHandlerMethodMapping.java DEBUG [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping] Looking up handler method for path /WEB-INF/html/registPage.html
2016-04-01 19:37:34 AbstractHandlerMethodMapping.java DEBUG [org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping] Did not find handler method for [/WEB-INF/html/registPage.html]
2016-04-01 19:37:34 AbstractUrlHandlerMapping.java DEBUG [org.springframework.web.servlet.handler.SimpleUrlHandlerMapping] Matching patterns for request [/WEB-INF/html/registPage.html] are [/WEB-INF/html/**]
2016-04-01 19:37:34 AbstractUrlHandlerMapping.java DEBUG [org.springframework.web.servlet.handler.SimpleUrlHandlerMapping] URI Template variables for request [/WEB-INF/html/registPage.html] are {}
2016-04-01 19:37:34 AbstractUrlHandlerMapping.java DEBUG [org.springframework.web.servlet.handler.SimpleUrlHandlerMapping] Mapping [/WEB-INF/html/registPage.html] to HandlerExecutionChain with handler [ResourceHttpRequestHandler [locations=[ServletContext resource [/WEB-INF/html/]], resolvers=[org.springframework.web.servlet.resource.PathResourceResolver@3e6fe1b6]]] and 1 interceptor
2016-04-01 19:37:34 DispatcherServlet.java DEBUG [org.springframework.web.servlet.DispatcherServlet] Last-Modified value for [/OneLibrary/WEB-INF/html/registPage.html] is: -1
2016-04-01 19:37:34 DispatcherServlet.java DEBUG [org.springframework.web.servlet.DispatcherServlet] Null ModelAndView returned to DispatcherServlet with name 'springMVC': assuming HandlerAdapter completed request handling
2016-04-01 19:37:34 FrameworkServlet.java DEBUG [org.springframework.web.servlet.DispatcherServlet] Successfully completed request 

<p>这是出错的地方：
2016-04-01 20:52:11 DefaultCorsProcessor.java DEBUG [org.springframework.web.cors.DefaultCorsProcessor] Skip CORS processing, request is a same-origin one
2016-04-01 20:52:11 AbstractHandlerExceptionResolver.java DEBUG [org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver] Resolving exception from handler 
[ResourceHttpRequestHandler [locations=[ServletContext resource [/WEB-INF/html/]], resolvers=[org.springframework.web.servlet.resource.PathResourceResolver@493d0640]]]: org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'POST' not supported
2016-04-01 20:52:11 AbstractHandlerExceptionResolver.java DEBUG [org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver] Resolving exception from handler 
[ResourceHttpRequestHandler [locations=[ServletContext resource [/WEB-INF/html/]], resolvers=[org.springframework.web.servlet.resource.PathResourceResolver@493d0640]]]: org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'POST' not supported
2016-04-01 20:52:11 DefaultHandlerExceptionResolver.java WARN [org.springframework.web.servlet.PageNotFound] Request method 'POST' not supported
现在不直接返回一个路径而是重定向就没有问题了
Skip CORS processing....跨域了？并没有，跳过了
spring mvc到底是怎么工作的啊


<p>还有一个需要注意的地方，spring的controller默认是单例的，也是非线程安全的，这意味着请求过来其实都是一个实例在处理
<p>所有为什么要这样做呢？
<p>优点：可以提高性能
<p>缺点:由于只有一个Controller的instance，当多个线程调用它的时候，它里面的instance变量就不是线程安全的

#####所以应该尽量避免在controller里面定义实例变量
#####SpringMVC多线程环境中如何保证对象的安全性？
<p>"不要使用可变的成员变量，当然可以使用service，因为service基本上都是不可变的，因为service除了各种dao，也没有可变的成员变量" 确实是这样



###2016/4/3
####登陆以后的页面可以搞成一个单页应用
####jason还是好耍

###2016/4/6--7
####被idea虐哭了。。。。


###2016/4/9
####user与book之间该如何关联？还是多对多吧
####搭建数据库,映射实体,配置映射文件