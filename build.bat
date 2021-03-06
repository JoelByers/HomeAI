@echo off
echo. 
echo BUILDING-------------------------------------------
@echo on
javac -classpath Utils\lib\jSerialComm-2.7.0.jar Utils\src\*.java
jar cf Builds\Utils.jar Utils\src\*.class
copy Builds\Utils.jar Server
copy Builds\Utils.jar Client
javac -classpath Server\* Server\src\*.java
jar cfm Builds\Server.jar Server\Manifest.txt Server\src\*.class
copy Server\voce.config.xml Builds
copy Server\grammar Builds
copy Server\speechText Builds\speechText
javac -classpath Client\lib\* Client\src\*.java
jar cfm Builds\Client.jar Client\Manifest.txt Client\src\*.class
@echo off
echo. 
echo DONE-----------------------------------------------
@echo on