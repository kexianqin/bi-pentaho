#!/usr/bin/env bash

chmod +x ./gradlew

./gradlew
./gradlew clean
./gradlew build --stacktrace
