
###响应状态码
1. 1xx：Informational（信息性状态码），接收的请求正在处理
2. 2xx：Success（成功状态码），请求正常处理完毕
3. 3xx：Redirection（重定向状态码），需要进行附加操作以完成请求
4. 4xx：Client Error（客户端错误状态码），服务器无法处理请求
5. 5xx：Server Error（服务器错误状态码），服务器处理请求出错

#####常见错误码
1. 200，OK，正常处理
2. 204，No Content，请求处理成功，但没有资源可返回
3. 206，Partial Content，客户端进行了范围请求，而服务器执行了这部分请求
4. 301，Moved Permanently，永久性重定向，客户端更新请求地址
5. 302，Found，临时性重定向，禁止POST变成GET，希望用户（本次）能使用新的URI访问
6. 303，See Other，请求对应的资源存在着另一个URI，(本次)应使用GET请求新的URI
7. 304，Not Modified，客户端发送附带条件的请求，服务器允许请求却不满足条件，不返回响应主体，与重定向无关
8. 307，Temporary Redirect，临时重定向，每种浏览器出来响应时行为有可能不同
9. 400，Bad Request，语法错误
10. 401，Unauthorized， HTTP认证失败
11. 403，Forbidden，资源拒绝访问
12. 404，Not Found，资源未找到
13. 500，Internal Server Error，服务端内部异常
14. 503，Service Unavailable，服务器超负载或停机维护，不发处理请求
 
 注：304中附带的条件，是指GET的请求报文中包含If-Match，If-Modified-Since，If-None-Match，If-Range，If-Unmodified-Since中任一首部
 
###Web服务器
#####代理
1. 缓存代理（Caching Proxy）：缓存源服务器资源
2. 透明代理（Transparent Proxy）：不做任何处理
#####网关
利用网关可以由HTTP请求转化为其他协议通信
#####隧道
确保客户端和服务器进行安全的通信

####缓存
1. 客户端的缓存
2. 代理服务器的缓存
