#!/bin/bash
DATE='date +%Y-%m-%d'
echo $DATE
#source /root/.bash_profile
export JAVA_HOME=/data/java/jdk/jdk1.8.0_221
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=$PATH:$JAVA_HOME/bin
export MAVEN_HOME=/data/java/maven/apache-maven-3.3.9
export PATH=$MAVEN_HOME/bin:$PATH
DIR=/muuu/java/erp/erp
CONSUL_HOSTNAME=172.21.0.132
port=8081


i=1
while ((i<=60))
do
	sleep 2
	pidstr=`ps -ef | grep $port | grep -v grep | awk '{print $2}'`
	if [ -z "$pidstr" ]
		then break;
	fi
	echo ' The service is going down ----------'
	let i++
done

echo ' service is waiting down----------'
sleep 20

ps -ef | grep $port | grep -v grep | awk '{print $2}' | xargs kill -9
echo ' service was down----------'

cd $DIR
#git pull origin hui
git pull
mvn clean package
if [ $? != 0 ];then
	echo "打包出错"
else
	cd target/
      JARFILE=erp-0.0.1-SNAPSHOT.jar
        nohup java -jar $JARFILE  --server.port=8081 --spring.redis.host=r-uf6hkzgkz13kbqhfzq.redis.rds.aliyuncs.com --spring.datasource.hikari.maximum-pool-size=300 --spring.datasource.username=root --spring.datasource.password=1234qwer --sql.url=localhost:3306/erp  --log.path=/muuu/java/logs/erp >/dev/null 2> out.log &
        if [ $? = 0 ];then

                sleep 30
                 tail -n 50 out.log
        fi

fi

echo 'update over.................................'
