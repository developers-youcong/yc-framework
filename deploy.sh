mvn clean package -Dmaven.test.skip=true

Cur_Dir=$(pwd)

TARGET_DIR="/D//test/jar//"

echo $Cur_Dir


if [ $? -ne 0 ]; then
        echo "fail"
else
    cp $Cur_Dir/yc-gateway/target/yc-gateway-1.0.jar $TARGET_DIR
	cp $Cur_Dir/yc-auth/target/yc-auth-1.0.jar $TARGET_DIR
	cp $Cur_Dir/yc-modules/yc-admin/target/yc-admin-1.0.jar $TARGET_DIR
    cp $Cur_Dir/yc-modules/yc-cms/target/yc-cms-1.0.jar $TARGET_DIR
    cp $Cur_Dir/yc-modules/yc-crawler/target/yc-crawler-1.0.jar $TARGET_DIR
    cp $Cur_Dir/yc-modules/yc-file/target/yc-file-1.0.jar $TARGET_DIR
    cp $Cur_Dir/yc-modules/yc-job/target/yc-job-1.0.jar $TARGET_DIR
    cp $Cur_Dir/yc-modules/yc-monitor-server/target/yc-monitor-server-1.0.jar $TARGET_DIR
    cp $Cur_Dir/yc-modules/yc-plugins/target/yc-plugins-1.0.jar $TARGET_DIR
	cp $Cur_Dir/yc-modules/yc-wechat/target/yc-wechat-1.0.jar $TARGET_DIR
    mvn clean
	echo "package success"
fi
