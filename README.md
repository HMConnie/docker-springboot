# Docker 启动springboot项目说明
## 1,安装idea docker 插件 
## 2,在云服务器Center OS7上面修改 docker.service
  1. /lib/systemd/system/docker.service 
  2. ExecStart=/usr/bin/dockerd   后面加上"-H tcp://0.0.0.0:2375 -H unix://var/run/docker.sock" 
  3. systemctl daemon-reload 
  4. service docker restart 
## 3,配置docker 启动
  1. Edit Configurations> 点击+ > Docker > Dockerfile 
  2. 选择Dockerfile文件位置 >镜像名imageName:tag >容器名>端口映射 > 点击ok 
## 4,编写Dockerfile文件
  ```sh
  # 基础镜像使用java
  FROM frolvlad/alpine-oraclejdk8:slim
  # 作者
  MAINTAINER HMConnie <HMConnie@sina.com>
  # VOLUME 指定了临时文件目录为/tmp。
  # 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
  VOLUME /tmp
  # 将jar包添加到容器中并更名为app.jar
  ADD  target/sgcai-boot-0.0.2-SNAPSHOT.jar app.jar
  # 运行jar包
  ENTRYPOINT ["java","-jar","/app.jar"]
  ```
## 5,进入Portainer(备注:docker图形化界面,此处不解释安装过程)
   ```sh
  启动命令:docker run -d -p 9000:9000 --restart=always   -v /var/run/docker.sock:/var/run/docker.sock --name docker-portainer  registry.cn-beijing.aliyuncs.com/yanxj-88/portainer:latest 
   ```
## 6,启动mysql:5.7
  1. 容器环境变量:MYSQL_ROOT_PASSWORD=123456 
  2. 容器数据卷映射   
  ```sh
   /opt/mysql/data:/var/lib/mysql 
   /opt/mysql/my.cnf:/etc/mysql/my.cnf 
  ```
  3. 请查看my.cnf即可   
   
       
## 7,启动apollo 镜像命令如下
```sh
docker run -e DEV_DB='jdbc:mysql://172.18.0.3:3306/ApolloConfigDB?characterEncoding=utf8' \
 -e DEV_DB_USER='root' \
 -e DEV_DB_PWD='123456' \
 -e DEV_ADMIN_PORT=8190 \
 -e DEV_CONFIG_PORT=8180 \
 -e DEV_IP='47.94.37.157' \
 -e PORTAL_DB='jdbc:mysql://172.18.0.3:3306/ApolloPortalDB?characterEncoding=utf8' \
 -e PORTAL_DB_USER='root' \
 -e PORTAL_DB_PWD='123456' \
 -e JAVA_OPTS='-Deureka.service.url=http://localhost:8180/eureka/' \
 -p 8170:8170 \
 -p 8180:8180 \
 -p 8190:8190 \
 -v /docker/apollo/logs/100003171:/opt/logs/100003171  \
 -v /docker/apollo/logs/100003172:/opt/logs/100003172  \
 -v /docker/apollo/logs/100003173:/opt/logs/100003173  \
 --name apollo docker-apollo:0615071417
```

## 8,发布到AliYun的Center OS云服务器中
  1.右侧选择maven > Lifecyle > install > target目录成的xx.jar文件
  2.点击右上角，build dockerfile