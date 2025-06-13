@echo off
call compile.cmd
echo.
cd ./bin
java app.App
cd ..
echo.
