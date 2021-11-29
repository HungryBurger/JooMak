#!/bin/bash

REPOSITORY=/var/lib/jenkins/workspace/joomak-backend # (1)
PROJECT_NAME=backend

echo "> Build 파일 권한 추가"

chmod +x $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/

echo "> Build 파일 복사"

cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/ # (5)

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

JAR_NAME=$(ls -tr $REPOSITORY/ | grep *.jar | tail -n 1) # (8)

echo "> JAR Name: $JAR_NAME"
