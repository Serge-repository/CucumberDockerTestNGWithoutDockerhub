#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# TAGS
# CUCUMBER_OPTIONS

echo "Checking if hub is ready - $HUB_HOST"

while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java -cp CucumberDockerTestNG.jar:CucumberDockerTestNG-tests.jar:libs/* -Dbrowser=$browser -DHUB_HOST=$HUB_HOST -Dcucumber.filter.tags="$TAGS" -Dcucumber.options="$CUCUMBER_OPTIONS" org.testng.TestNG -testclass RunnerTest