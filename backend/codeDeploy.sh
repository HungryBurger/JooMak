#!/bin/bash

REPOSITORY=/home/ec2-user/joomak # (1)
PROJECT_NAME=backend
JAR_NAME=backend-0.0.1-SNAPSHOT.jar

echo "> Build 파일 복사"
echo $REPOSITORY/build/libs/$JAR_NAME
sudo cp $REPOSITORY/build/libs/$JAR_NAME $REPOSITORY/ # (5)

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
JAR_NAME=$(ls -tr ${REPOSITORY} | grep ${JAR_NAME} | tail -n 1) # (8)
echo "> JAR Name: $JAR_NAME"

echo "nohup파일 삭제"
rm -f $REPOSITORY/nohup.out

echo "Springboot 배포시작"
nohup java -jar \
  -Dspring.config.location=classpath:/application.yml,/home/ec2-user/app/application-real-db.yml \
  -Dspring.profiles.active=real \
  $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &
