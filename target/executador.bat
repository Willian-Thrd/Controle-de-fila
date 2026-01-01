@echo off
cd /d "%~dp0"

echo Iniciando boot...
call queueController.bat

java -jar queue-controller-1.00.0.jar
echo Loading...
pause