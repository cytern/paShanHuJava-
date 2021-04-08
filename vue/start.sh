npm install
rm -rf ./dist/*
npm run build
rm -rf /export/project/pashanhuvue
mkdir /export/project/pashanhuvue
cp -rf ./dist/* /export/project/pashanhuvue