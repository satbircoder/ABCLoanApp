@echo off
mkdir app
jar --create --file=app/CreateLoans.jar --main-class=createloans.CreateLoans -C classes .
pause