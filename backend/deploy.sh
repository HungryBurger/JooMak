#!/bin/bash

REPOSITORY=/home/ec2-user/app/step1/JooMak # (1)
PROJECT_NAME=backend

cd $REPOSITORY/
pwd $REPOSITORY

echo "> Git Pull"
git pull

echo "> backend 경로 이동"
cd backend

echo "> Build 파일 권한 추가"
sudo chmod +x $REPOSITORY/$PROJECT_NAME/build/libs/*.jar
sudo chmod +x $REPOSITORY/$PROJECT_NAME

echo "> 파일 빌드"
sudo chmod +x gradlew
pkill -f '.*GradleDaemon.*'
./gradlew clean build --stacktrace

echo "> Build 파일 복사"
sudo cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/ # (5)

echo "> 현재 위치"
pwd
echo "> 현재 구동중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -f ${PROJECT_NAME}) # (6)

echo "> 현재 구동중인 애플리케이션 pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then # (7)
    echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
    echo "> kill -15 $CURRENT_PID"
    sudo kill -15 $CURRENT_PID
    sleep 5
fi

echo "> 새 애플리케이션 배포"
JAR_NAME=$(ls -tr ${REPOSITORY} | grep 'backend-0.0.1-SNAPSHOT.jar' | tail -n 1) # (8)
echo "> JAR Name: $JAR_NAME"

echo "nohup파일 삭제"
rm -f /home/ec2-user/nohup.out

echo "nohup java -jar $REPOSITORY/$JAR_NAME 2>&1 &"
nohup java -jar \
        -Dspring.config.location=classpath:/application.yml,/home/ec2-user/app/application-real-db.yml\
        -Dspring.profiles.active=real \
        $REPOSITORY/$JAR_NAME 2>&1 &


