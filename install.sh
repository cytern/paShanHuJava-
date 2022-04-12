git fetch
git pull
echo "更新分支完毕  准备重启euerka"
start1=`sh ./euerka-2020/start.sh`
echo "更新分支完毕  准备重启gateWay"
start2=`sh ./gateway-2060/start.sh`
echo "更新分支完毕  准备重启jsoup"
start3=`sh ./jsoup-2030/start.sh`
