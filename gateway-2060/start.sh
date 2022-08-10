#确定是否有程序启动
jarName="gateway-dev.jar"
jarPort="2060"
pid12345=`lsof -i:$jarPort | sed -n "2, 1p" | awk '{print $2}'`
if [ "$pid12345" = "" ]
then
 echo "2060端口未占用"
else
 echo "端口已占用，尝试关闭"
 kill -9 "$pid12345"
fi

echo "************************************安装gateWay****************************************"
mvn clean install -Pdev -Dmaven.test.skip=true
echo "************************************删除原来的jar包****************************************"
# 删除 原来位置的jar包
rm -rf /home/ubuntu/export/project/javaJar/$jarName
cp -rf ./target/$jarName /home/ubuntu/export/project/javaJar
#启动项目
BUILD_ID=dontKillMecd
nohup java -jar /home/ubuntu/export/project/javaJar/$jarName > /home/ubuntu/export/project/javaJar/gateway.file 2>&1 &
echo "===================================安装gateWay完毕======================================"