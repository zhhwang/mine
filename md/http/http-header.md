### 通用首部字段
##### Cache-control：控制缓存的行为

 注：指令的参数可以多选，通过“,”分隔
 
 缓存请求指令
 1. no-cache， 强制向源服务器再次验证
 2. no-store，不缓存请求或响应的任何内容
 3. max-age=[秒]，必需， 响应的最大Age值
 4. max-stale(=[秒])，可省略，接收已过期的响应
 5. min-fresh=[秒]， 必需， 期望在制定时间内的响应仍有效
 6. no-transform， 代理不可更改媒体类型
 7. only-if-cache， 从缓存获取资源
 8. cache-extension， 新指令标记（token）
 
 缓存响应指令
 1. public， 可向任意方提供响应的缓存
 2. private， 仅向特定用户返回响应
 3. no-cache， 缓存前必须先确认其有效性
 4. no-transform， 代理不可更改媒体类型
 5. must-revalidate
 6. proxy-revalidate
 7. max-age=[秒]
 8. s-maxage=[秒]
 9. cache-extension
 
 ##### Connection: 控制不再转发给代理的首部字段，管理持久链接
 1. 首部字段名： 表示该首部字段不再进行转发
 2. close， 服务器断开HTTP1.1的持久连接
 3. Keep-Alive， 维持HTTP1.1之前的http版本的连接
 
 ##### Date: 表明创建HTTP报文的日期和时间

 ##### Pragma: 是HTTP/1.1之前版本的遗留字段，仅作为与HTTP/1.0的向后兼容而定义
 1. Pargma:no-cache
 
 ##### Trailer: 事先说明在报文中体后记录了哪些字段，用在HTTP/1.1版本分块传输编码时
 
 ##### Transfer-Encoding: 规定传输报文主体时采用的编码方式
 
 ##### Upgrade: 用于检测HTTP协议及其他协议是否可使用更高的版本进行通信
 
 ##### Via： 追踪客户端与服务器之间的请求和响应报文的传输路径
 
 ##### Warning: 告知用户雨鞋与缓存相关的问题的警告
 1. Warning:[警告码][警告的主机：端口号]"[警告内容]"([日期时间])
 2. 110，Response is stale （响应已过期）
 3. 111， Revalidation failed （再验证失败，服务器无法到达等原因）
 4. 112， Disconnection operaation (断开连接操作，代理与互联网连接被故意切断)
 5. 113， Heuristic expiration （试探性过期，有效缓存的设定时间大于24小时的情况下，响应的使用期超过24小时）
 6. 199， Miscellaneout warning (杂项警告，任意的警告内容)
 7. 214， Transformation applied (使用了转换，代理对内容编码或媒体类型等执行了某些处理)
 8. 299， Miscellaneous persistent warning (持久杂项警告，任意的警告内容)
 ### 请求首部字段