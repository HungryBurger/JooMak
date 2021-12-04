#!/bin/bash

REPOSITORY=/var/lib/jenkins/workspace/joomak-backend # (1)
PROJECT_NAME=backend
JAR_NAME=backend-0.0.1-SNAPSHOT.jar

echo "> Build 파일 권한 추가"

sudo chmod +x $REPOSITORY/$PROJECT_NAME/build/libs/*.jar
sudo chmod +x $REPOSITORY/$PROJECT_NAME

echo "> Build 파일 복사"
sudo cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/ # (5)

echo "> 현재 위치"
pwd
echo "> 현재 구동중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -f ${PROJECT_NAME}*.jar) # (6)

echo "> 현재 구동중인 애플리케이션 pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then # (7)
    echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
    echo "> kill -15 $CURRENT_PID"
    kill -15 $CURRENT_PID
    sleep 5
fi

echo "> 새 애플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/ | grep 'backend-0.0.1' | tail -n 1) # (8)

echo "> JAR Name: $JAR_NAME"
nohup java -jar $REPOSITORY/$JAR_NAME &