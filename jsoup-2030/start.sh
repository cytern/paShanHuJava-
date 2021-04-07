#确定是否有程序启动
jarName="server-dev.jar"
jarPort="2030"
pid12345=`lsof -i:$jarPort | sed -n "2, 1p" | awk '{print $2}'`
if [ "$pid12345" = "" ]
then
 echo "端口未占用"
else
 echo "端口已占用，尝试关闭"
 kill -9 "$pid12345"
fi

echo "mvn install gateway"
mvn clean install -Pdev -Dmaven.test.skip=true
echo "delete project gateway"
# 删除 原来位置的jar包
rm -rf /export/project/javaJar/$jarName
cp -rf ./target/$jarName /export/project/javaJar
#启动项目
nohup java -jar /export/project/javaJar/$jarName &