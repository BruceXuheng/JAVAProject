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
            
        7. 获取客户机的IP地址
        
            String getRemoteAddr()
            
            
    2. 获取







## Http 响应数据格式









