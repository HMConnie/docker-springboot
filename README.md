1,安装idea docker 插件 <br>
2,在云服务器Center OS7上面修改 docker.service<br>
 2.1 /lib/systemd/system/docker.service <br>
 2.2 ExecStart=/usr/bin/dockerd   后面加上"-H tcp://0.0.0.0:2375 -H unix://var/run/docker.sock" <br>
 2.3 systemctl daemon-reload <br>
 2.4 service docker restart <br>
3,配置docker 启动<br>
 3.1 Edit Configurations> 点击+ > Docker > Dockerfile <br>
 3.2 选择Dockerfile文件位置 >镜像名imageName:tag >容器名>端口映射 > 点击ok <br>
4,编写Dockerfile文件<br>
  4.1请查看Dockerfile文件即可<br>
5,进入Portainer docker图像化web服务系统<br>
  启动命令:docker run -d -p 9000:9000 --restart=always   -v /var/run/docker.sock:/var/run/docker.sock --name docker-portainer  registry.cn-beijing.aliyuncs.com/yanxj-88/portainer:latest <br>
     
6,启动mysql:5.7<br>
  6.1 容器环境变量:MYSQL_ROOT_PASSWORD=123456 <br>
  6.2 容器数据卷映射   <br>
   /opt/mysql/data:/var/lib/mysql <br>
   /opt/mysql/my.cnf:/etc/mysql/my.cnf <br>
  6.3 请查看my.cnf即可   <br>
   
       
7,启动apollo 镜像命令如下<br>
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

8,发布到AliYun的Center OS云服务器中<br>
  8.1,右侧选择maven > Lifecyle > install > target目录成的xx.jar文件<br>
  8.2,点击右上角，build dockerfile<br>