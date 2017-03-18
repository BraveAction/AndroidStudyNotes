#学习参考网站:http://www.cnblogs.com/ph829/p/4759124.html
#规定cmake程序的最低版本。这行命令是可选的，我们可以不写这句话，但在有些情况下,
#如果CMakeLists.txt文件中使用了一些高版本cmake特有的一些命令的时候，就需要加上这样一行，提醒用户升级到该版本之后再执行cmake。
cmake_minimum_required(VERSION 3.4.1)


#project (CRNode)
#指定项目的名称。项目最终编译生成的可执行文件并不一定是这个项目名称，而是由另一条命令确定的，稍候我们再介绍。
#但是这个项目名称还是必要的，在cmake中有两个预定义变量：< projectname >_BINARY_DIR以及< projectname >_SOURCE_DIR，
#在我们的项目中，两个变量分别为：CRNode_BINARY_DIR和CRNode_SOURCE_DIR。内部编译情况下两者相同，
#后面我们会讲到外部编译,两者所指代的内容会有所不同。要理解这两个变量的定义，我们首先需要了解什么是“外部构建（out-of-source build）”，
#我们将在下一小节中介绍“外部构建”。同时cmake还预定义了PROJECT_BINARY_DIR和PROJECT_SOURCE_DIR变量。在我们的项目中，PROJECT_BINARY_DIR等同于CRNode_BINARY_DIR，
#PROJECT_SOURCE_DIR等同于CRNode_SOURCE_DIR。在实际的应用用，我强烈推荐使用PROJECT_BINARY_DIR和PROJECT_SOURCE_DIR变量，
#这样即使项目名称发生变化也不会影响CMakeLists.txt文件。

#改变目标存放路径,就在哪里加入上述的定义,定义的目标文件,可能是可执行二进制、动态库、静态库。
add_library(hello-jni SHARED
            hello-jni.c)

# Include libraries needed for hello-jni lib
target_link_libraries(hello-jni
                      android
                      log)
