## Servlet

### 1、配置

1. 可通过web.xml配置

   ```
   <servlet>
           <servlet-name>login</servlet-name>
           <servlet-class>com.csw.jcs.servlet.LoginServlet</servlet-class>
           <!--load 标签 负数直接启动-->
           <load-on-startup>-1</load-on-startup>
       </servlet>
       <servlet-mapping>
           <servlet-name>login</servlet-name>
           <url-pattern>/login</url-pattern>
   ```

   

2. 可通过注解方式配置（java1.6以上支持）

```
@WebServlet(urlPatterns = "/login")
```



### 2、Servlet体系结构

2.1  Servlet 接口



2.2 GenericServlet 抽象类



2.3 HttpServlet 抽象类

```
1.继承HttpServlet
2.复写 doGet、doPost()
```



3、Servlet的路径配置

```
@WebServlet({"/loginhttp","/loginhttp2"})
@WebServlet("/user/*")// * 通配符

```



## Http请求数据格式

1、请求航

​	请求方式，请求url，

​	请求方式：GET、POST

2、请求头

​	请求头名称：请求头值

​	获取浏览器类型 做兼容

​	referer盗链、统计数据

​	

3、请求空行

​	空行 分割 头和体

4、请求体

​	post封装消息请求参数





字符串格式：

```
Request URL: http://localhost/StudyWeb/login
Request Method: POST
Status Code: 200 
Remote Address: [::1]:80
Referrer Policy: no-referrer-when-downgrade
Content-Length: 0
Date: Sun, 17 Nov 2019 04:25:25 GMT
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7
Cache-Control: max-age=0
Connection: keep-alive
Content-Length: 16
Content-Type: application/x-www-form-urlencoded
Cookie: JSESSIONID=8321256AD5E656AE322F11998F1A350B; JSESSIONID=02678F20FB21D0236655B5790EED5577
Host: localhost
Origin: http://localhost
Referer: http://localhost/StudyWeb/
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36
username: 1232131
login	
```



Request：获取请求消息

1、request和reqponse原理

​	都是有服务器创建

2、request对象继承体系结构

​	ServletRequest

​	HttpServletRequest

​	org.apache....RequestFacade



3、request 功能
1. 获取请求行数据
    * GET 
    * 方法
        1. 获取请求方式：GET/POSt
        
            String getMethod()
            
        2. 获取虚拟目录
        
            String getContextPath()
            
        3. 获取Servlet路径
        
            String getServletpath()
            
        4. 获取get方式请求参数
        
            String getQueryString()
            
        5. 获取请求URI：
        
            String getRequestURI()
            
            StringBUffer getRequestURL()
            
        6. 获取协议版本
        
            String getProtocol()
              `` 
        7. 获取客户机的IP地址
        
            String getRemoteAddr()
            
            
    2. 获取

       ​	1.设置请求数据编码

       ​	request.setCharacterEncoding("utf-8");



### doGet获取参数转Bean类

1.需要导入

>commons-beanutils-1.9.4.jar
>
>commons-collections-3.2.2.jar(如果导入beanUtils包报错，需要再导入collections包，java.lang.NoClassDefFoundError: org/apache/commons/collections/FastHashMap)

2.Bean类需创建 具体如下

```
//2.第二种使用BeanUtils包
Map<String,String[]> map = request.getParameterMap();
UserBean loginUser2 = new UserBean();
try {
    BeanUtils.populate(loginUser2,map);
} catch (IllegalAccessException | InvocationTargetException e) {
    e.printStackTrace();
}
```

3.其他使用方法：

setProperty()

getProperty()

populate(object,map) 讲map集合的键值对，封装到Bean中 




## Http 响应数据格式

### 1.请求消息：客户端发送服务器数据

​	数据格式：

		1. 请求行
	
		2. 请求头
		
		3. 请求空行
		
		4. 请求体



2.响应消息：服务器端发送客户端的数据

​	数据格式：

```
	1. 响应行
		1.组成：协议/版本 响应状态码 状态码描述
		2.响应状态码：
			1.状态码3位数
			2.分类：
			1**：服务器接收客户端消息，但是没有接收完成，等待一段时间后，发送1**多状态码
			2**：成功，代表200
			3**：重定向，302重定向；304访问缓存
			4**：客户端错误 404对应路径没有资源；405请求方式没有对应do**方法
			5**：服务器端错误 500服务器内部异常

	2. 响应头
		1.格式：头名称-值
		2.常见的响应头：
			1.Content-type：服务器告诉客户端响应体的数据格式和编码
			2.content-disposition：服务器告诉客户端以什么格式打开响应数据。
			in-lin
			attachment；filename***：
	
	3. 响应空行
	
	4. 响应体：传输数据
```



### 2. Response - 重定向

* 功能：设置响应消息
   	1. 设置响应行
   	2. 设置响应头 setHeader()
   	3. 设置响应体 
       		1. 获取输入流
             	1. 字符输出流：PrintWriter getWriter()
             	2. 字节输出流：ServletOutputStream getOutputStream()
       		2. 使用输出流，将数据输出到客户端浏览器

重定向案例：

```
//重定向处理
        //No.1
        response.sendRedirect("/StudyWeb/LoginSuccessServlet");
        //No.2
        response.setStatus(302);        				      response.setHeader("location","/LoginSuccessServlet");
```

2. 重定向特点：redirect

   1. 地址栏变化

   2. 重定向可以访问其他服务器资源

   3. 是两次请求，不能使用request对象共享数据

3. 转发特点：forwar

      1. 转发地址栏路径不变
      2. 转发只能访问当前服务器下的资源
      3. 转发试一次请求，可以使用request对象来共享数据

      

​       动态获取虚拟目录：contextPath

​	request.getContextPath();





## 验证码



## ServletContext对象

1.概念：代表整个web应用，可以和程序的容器（服务器）来通信

2.获取：

 1. 通过request对象获取

    request.getServletContext()

	2. 通过HttpServlet获取

    this.getServletContext()

3.功能：

​	1.获取MIME类型

​		*MIME类型 在互联网通讯过程中定义的一种文件数据类型

​			*格式：大类型小类型 ;text/html;

​		*获取：String getMimeType（String file）

​	2.域对象：共享数据

​		servletContext.setAttribute(String,Object)

​		getAttribute()

​		removeAttribute()



​	3.获取文件的真实（服务器）路径



# 下载文件

步骤：

1.定义页面，编辑超链接href属性，指向servlet，传递资源名称filename

2.定义Servlet

​	获取文件名称

​	使用字符输入流加载文件进内存

​	指定response的响应头：content-dispostion:attachment;filename=xxx

​	将数据写出到response输出流

##  中文文件名显示

需要Utils判断浏览器



# Cookies

客户端技术Cookie



## 步骤

1.创建Cookie对象，绑定数据

​	*newCookie(String ，String）

2.发送Cookie对象

​	response.addCookie(Cookie cookie)

3.获取Cookie 拿到数据

​	Cookie[] request.getCookies()



## 原理

1.给予响应头set-cookie和请求头cookie实现



## 注意事项

1.是否可以发送多个cookie：可以创建多个Cookie对象

2.cookie保存时间：

​	1.默认情况下，浏览器关闭，cookie数据销毁

​	2.持久化存储，setMaxAge（int seconds）

​		参数：1.正数：将Cookie数据写到硬盘的文件中，持久化存储。cookie存活时间。2：负数：默认值，关闭浏览器即销毁。3：零：删除cookie信息。



3.cookie是否可以存中文

​	tomcat8之前 cookie不能直接存储中文数据 需要中文数据转码

​	tomcat8之后可以支持

4.cookie获取范围多大？ 单个4kb限制，一个域名下20个左右

​	setPath(String path) :设置取值范围

5.共享问题：

​	1.同一个tomcat服务器中，多个web项目

​	setPath("/") 可以共享

​	2.不同tomcat服务器间

​	setDomain(String path) 设置一级域名，多个服务器之间cookie可共享

​	setDomain(".baidu.com"),那么tieba.baidu.com and news.baidu.com中cookie可以共享。

​	



## 场景

