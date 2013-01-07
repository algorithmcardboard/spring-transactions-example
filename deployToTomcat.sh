#!/usr/bin/zsh
wget --output-document=deploy http://cmdAdmin:s3cret@localhost:8080/manager/text/undeploy\?path\=/sampleApp --quiet
var=$(<deploy)

if [ $var = "OK - Undeployed application at context path /sampleApp" ];
then 
	print "Application stopped successfully. copying files";
	cp ./target/spring-transactions-example-0.0.1-SNAPSHOT.war /home/anirudhan/applications/apache-tomcat-7.0.34/webapps/sampleApp.war
	print "sleeping for 10 seconds";
	sleep 10;
	wget --output-document=deploy http://cmdAdmin:s3cret@localhost:8080/manager/text/list --quiet
	var=`cat deploy | grep sampleApp | grep running`;
	print "Status is "$var;
	if [ ! $var = "" ];
		then print "Started  application successfully...";
		else print "Couldn't start application";
	fi
else print 'Unable to stop application. exiting....';
fi

