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