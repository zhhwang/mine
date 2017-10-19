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
 
#####Accept:通知服务器用户代理能够处理的媒体类型及媒体类型的相对优先级
1. 文本文件： text/html, text/plain, text/css, application/xhtml+xml, application/xml...
2. 图片文件： image/jpeg, image/gif, image/png...
3. 视频文件： video/mpeg, video/quicktime...
4. 应用程序使用的二进制文件：application/octet-stream, application/zip...
5. 举例：Accept: text/plain; q=0.3, text/htm
#####Accept-Charset:通知服务器用户代理支持的字符集及字符集的相对有限顺序
1. iso-8859-5
2. unicode-1-1; q=0.8

#####Accept-Encoding:通知服务器用户代理支持的内容编码及内容编码的优先级顺序
1. gzip： Lempel-Ziv算法及32位循环冗余校验
2. compress： UNIX文件压缩程序，Lempel-Ziv-Welch算法
3. deflate： zlib格式和deflate算法
4. identity： 不执行压缩或不会变化的默认编码格式

#####Accept-Language:通知服务器用户代理能够处理的自然语言集
1. 举例： Accept-Language: zh-cn,zh;q=0.7, en-us,en;q=0.3

#####Authorization:通知服务器用户代理的认证信息（证书值）

#####Expect：通知服务器出现某种特定行为，无法理解是返回417
1. 100-continue：等待状态码100响应的客户端在发生请求时，需要指定该值

#####From:通知服务器用户代理的电子邮件地址
1. 使用代理时，应尽可能包含From首部字段

#####Host：通知服务器请求的资源所处的互联网主机名和端口号

#####If-Match:只有If-Match的字段值跟ETag值匹配一致时，服务器才会接受请求
1. 实体标记（ETag）是与特定资源关联的确定值。资源更新后ETag也会随之更新
2. 匹配失败返回状态码412

#####If-Modified-Since：如果在该字段指定的日期时间后，资源发生了更新，服务器会接受请求

#####If-None-Match:只有该字段值与ETag值不一致时，可处理该请求。

#####If-Range:字段值若是跟ETag值或更新的日期时间匹配一直，那么就做范围请求处理；反之返回全部资源
1. GET /index.html
   If-Range:"123456"
   Range:bytes=5001-10000
   
#####If-Unmodified-Since:通知服务器，指定的资源只有在字段值内指定的日期时间之后，未发生更新的情况下，才能处理请求
1. 若发生了更新，返回412 Precondition Failed

#####Max-Forwards:只能再往下转发{字段值}次，就返回响应

#####Proxy-Authorization:服务器认证所需要的信息
1. Proxy-Authorization: Basic dGlwOjkpNLAGfFY5

#####Range:通知服务器请求的范围
1. Range: bytes=5001-10000

#####Referer: 通知服务器请求的原始资源的URI（当前URI是由哪个web页面发起的）

#####TE:告知服务器客户端能够处理响应的传输编码方式及相对优先级。它和首部字段Accept-Encoding的功能很像，但是用于传输编码
1. TE:gzip, deflate;q=0.5
2. TE:trailers   指定伴随trailer字段的分块传输编码的方式

##### User-Agent:将创建请求的浏览器和用户代理名称等信息传达给服务器

### 响应首部字段
由服务器向客户端返回响应报文中所使用的字段，用户补充响应的附加信息、服务器信息，以及对客户端的附加要求等信息

##### Accept-Range: 通知客户端服务器是否能处理范围请求
1. Accept-Range:bytes
2. Accept-Range:none

##### Age: 通知客户端源服务器在多久前创建了响应，单位为秒
1. Age:600
2. ??? 若创建该响应的服务器是缓存服务器，Age值是指缓存后的响应再次发起认证到认证完成的时间值。代理创建响应时必须加上首部字段Age

##### ETag：通知客户端实体标识
1. 对每份资源以字符串形式做唯一性标识
2. 资源更新时，ETag值也需要更新
3. ETag: "usagi-1234"  强ETag，不论实体发生多么细微的变化都会改变其值
4. ETag: W/"usagi-1234" 弱ETag，只有资源发生了根本改变，产生差异时才会改变ETag

##### Location: 通知客户端所访问资源的重定向地址
 1. Location: http://www.usagidesign.jp/samole.html
 
##### Proxy-Authenticate: 把代理服务器所要求的认证信息发送给客户端

##### Retry-After:通知客户端多久之后再次发送请求
1. 可以指定具体的日期时间，可以是创建响应后的秒数

##### Server：通知客户端当前服务器上安装的HTTP服务器应用程序的信息
1. Server: Apache/2.2.17(Unix)

##### Vary: 可对缓存进行控制
1. Vary: Accept-Language 
2. 从代理服务器接收到源服务器返回包含Vary指定项的响应之后，若再要进行缓存，仅对请求中含有相同Vary指定首部字段的请求返回缓存。即使对相同资源发起请求，但由于Vary指定的首部字段不相同，因此必须要从源服务器重新获取资源

##### WWW-Authenticate:用于HTTP访问认证，通知客户端使适用于访问请求URI所指定资源的认证方案（Basic或Digest）和带参数提示的质询。返回401时，肯定带有此首部字段

### 实体首部字段
包含在请求报文和响应报文中的实体部分所使用的首部，用户补充内容的更新时间等与实体相关的信息

##### Allow：通知客户端能够支持Request-URI指定资源的所有HTTP方法

##### Content-Encoding: 通知客户端服务器对实体的主体部分选用的内容编码方式。内容编码是指在不丢失实体信息的前提下所进行的的压缩
1. gzip
2. compress
3. deflate
4. identity

##### Content-Language: 通知客户端实体主体使用的自然语言
 
##### Content-Length: 通知客户端实体主体部分的大小，单位是字节。 不与内容编码（Content-Encoding）共用

##### Content-Location: 当返回的页面内容与实际请求的对象不同时，指定实体主体所在的URI
1. 例如访问http://www.hackr.jp/返回的对象确是http://www.hackr.jp/index-ja.html等类似情况

##### Content-MD5: 客户端和服务器使用相同的算法，检查报文主体在传输过程中是否保持完整，以确认传输到达
1. 无法检验是否被篡改（MD5可同时被篡改）

##### Content-Range:针对范围请求，告知客户端作为响应返回的实体的哪个部分符合范围请求
1. Content-Range: bytes 5001-10000/10000

##### Content-Type:说明实体主体内对象的媒体类型
1. Content-Type: text/html; charset=UTF-8

##### Expires: 通知客户端资源失效的日期

##### Last-Modified: 通知客户端资源最后一次修改的时间


### 为Cookie服务的首部字段

##### Cookie：请求首部字段

##### Set-Cookie：响应首部字段
1. NAME=VALUE
2. expires=Date(不明确指定则默认浏览器关闭前为止)
3. path=Path(将服务器上的文件目录作为Cookie的适用对象)
4. domain=域名（作为Cookie适用对象的域名）
5. secure (仅在HTTPS安全通信时才会发送Cookie)
6. httpOnly （加以限制，使Cookie不能被JavaScript访问）

### 其他首部

##### X-Frame-Options: HTTP响应首部
1. DENY： 所有其他页面的frame都不允许加载该页面
2. SAMEORIGIN: 仅同源域名下的页面的frame允许加载该页面

##### X-XSS-Protection: HTTP响应首部
1. 0：将XSS过滤设置成无效状态
2. 1：将XSS过滤设置成有效状态

##### DNT: Do Not Track，拒绝自信信息被收集
1. 0： 同意被追踪
2. 0： 拒绝被追踪

##### P3P 隐私设定