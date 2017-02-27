#!/usr/bin/env bash

cp /home/data/java/youpin-bi-service/env.properties env.properties

chmod +x ./gradlew

./gradlew
./gradlew clean
./gradlew build --stacktrace
./gradlew jacocoTestReport
