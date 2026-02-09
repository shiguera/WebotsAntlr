@echo off
chcp 65001 >NUL
setlocal EnableExtensions

REM ---- 0) Establecer WEBOTS_HOME ----
set "WEBOTS_HOME=C:\Program Files\Webots"

REM ---- 1) Parámetro por defecto ----
set "PARAM_JAVA=%~1"
if "%PARAM_JAVA%"=="" set "PARAM_JAVA=programa_1.rbl"

REM ---- 2) DLL path (equivalente a LD_LIBRARY_PATH) ----
set "PATH=%CD%\lib;%PATH%"

REM ---- 3) Detectar Webots (proceso GUI: webotsw.exe) ----
tasklist /FI "IMAGENAME eq webotsw.exe" 2>NUL | find /I "webotsw.exe" >NUL
if %ERRORLEVEL%==0 (
    echo ✅ Webots ya esta ejecutandose
) else (
    echo 🚀 Arrancando Webots...
    start "" "%WEBOTS_HOME%\msys64\mingw64\bin\webotsw.exe" "%CD%\src\robolang_webots\MiniMundo.wbt"
    timeout /t 5 /nobreak >NUL
)

REM ---- 4) Lanzar controlador Java ----
echo ⚙️  Controlador: interpretes.InterpreteWebots %PARAM_JAVA%
java -cp "bin;lib\Controller.jar;lib\antlr-4.13.2-complete.jar" ^
     -Djava.library.path=lib ^
     interpretes.InterpreteWebots "%PARAM_JAVA%"

endlocal
