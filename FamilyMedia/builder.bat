%~d0
cd /d %~dp0

:BACKUP
copy src\main\resources\sql.properties %TEMP%

:RELEASE
copy src\main\resources_release\sql.properties src\main\resources

:BUILD
call mvn clean
call mvn package

:RECOVER
copy %TEMP%\sql.properties src\main\resources

pause
