@echo off
cd /d "%~dp0"
call gradlew.bat compileJava --console=plain
if %errorlevel%==0 (
    echo.
    echo [AI] BUILD OK
) else (
    echo.
    echo [AI] BUILD FAILED
)
