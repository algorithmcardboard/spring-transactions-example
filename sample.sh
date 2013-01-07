#!/usr/bin/zsh


var=`cat deploy | grep sampleApp | grep running`;
print $var;

