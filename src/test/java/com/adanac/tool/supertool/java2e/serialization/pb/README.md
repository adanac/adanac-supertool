##第一步：定义数据结构

首先要定义protobuf的数据结构，这里要写一个.proto文件。这个文件有点类似于定义一个类。例如定义一个Person，保存文件PersonMsg.proto（注意文件名和里面的message名不要一样）。

##第二步：protoc.exe生成Java代码

使用文件protoc.exe，cmd命令行运行：

protoc.exe --java_out=E:\java PersonMsg.proto

输入文件是PersonMsg.proto，也就是定义数据结构的文件；输出文件夹是E:\java，将java文件生成在E:\java中。运行命令成功后会生成PersonMsg.java

##第三步：序列化
##第四步：反序列化
一般来说，序列化和反序列化是分开的。例如网络传输，由一方将数据序列化后发送给另一方来接收并解析，序列化发送和接收反序列化并不在一起。但是下面为了例子简单将二者写在同一程序中。