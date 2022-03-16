git fetch
git pull
echo "更新分支完毕  准备重启euerka"
sh euerka-2020/start.sh
echo "更新分支完毕  准备重启gateWay"
sh gateway-2060/start.sh
echo "更新分支完毕  准备重启jsoup"
sh jsoup-2030/start.sh
