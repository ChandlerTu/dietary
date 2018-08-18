#!/bin/sh

ps -ef|grep dietary-|grep -v grep|awk '{print $2}'|xargs kill

sleep 1

cd `dirname $0`

java -jar dietary-1.0.0-SNAPSHOT.jar --spring.config.additional-location=dietary.properties &
