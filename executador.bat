@echo off
cd /d "%~dp0target"

echo Iniciando boot...
call queueController.bat

echo Loading...
pause