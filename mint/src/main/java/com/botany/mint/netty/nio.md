NIO 简单模型

````
    interface ChannelHandler{
        void channelReadable(Channel channel);
        void channelWritable(Channel channel);
    }
    
    class Channel{
        Socket socket;
        Event event;//读，写或者连接
    }

    //IO线程主循环:
    class IoThread extends Thread{
        public void run(){
            Channel channel;
            while(channel=Selector.select()){//选择就绪的事件和对应的连接
                if(channel.event==accept){
                    registerNewChannelHandler(channel);//如果是新连接，则注册一个新的读写处理器
                }
                if(channel.event==write){
                    getChannelHandler(channel).channelWritable(channel);//如果可以写，则执行写事件
                }
                if(channel.event==read){
                    getChannelHandler(channel).channelReadable(channel);//如果可以读，则执行读事件
                }
            }
        }
        Map<Channel，ChannelHandler> handlerMap;//所有channel的对应事件处理器
    }
````

标准/典型的Reactor：
1. 等待事件到来（Reactor负责）。
2. 将读就绪事件分发给用户定义的处理器（Reactor负责）
3. 读数据（用户处理器负责）。
4. 处理数据（用户处理器负责）。

改进实现的模拟Proactor：
1. 步骤1：等待事件到来（Proactor负责）
2. 得到读就绪事件，执行读数据（现在由Proactor负责）
3. 将读完成事件分发给用户处理器（Proactor负责）
4. 处理数据（用户处理器负责）

Selector.wakeup(): 解除阻塞在Selector.select()/select(long)上的线程，立即返回。
1. 注册了新的channel或者事件。
2. channel关闭，取消注册。

NIO问题:
1. 使用NIO!=高性能，当连接数<1000，并发程度不高或者局域网环境下NIO并没有显著的性能优势。
2. NIO并没有完全屏蔽平台差异，它仍然是基于各个操作系统的I/O系统实现的，差异仍然存在。使用NIO做网络编程构建事件驱动模型并不容易，陷阱重重。
3. 推荐大家使用成熟的NIO框架，如Netty，MINA等。解决了很多NIO的陷阱，并屏蔽了操作系统的差异，有较好的性能和编程模型。

NIO特点：
1. 事件驱动模型
2. 避免多线程
3. 单线程处理多任务
4. 非阻塞I/O，I/O读写不再阻塞，而是返回0
5. 基于block的传输，通常比基于流的传输更高效
6. 更高级的IO函数，zero-copy
7. IO多路复用大大提高了Java网络应用的可伸缩性和实用性
