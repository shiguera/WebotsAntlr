@echo off
chcp 65001 >NUL
setlocal EnableExtensions

REM Este script permite ejecutar el InterpreteWebots.
REM Se puede pasar como parámetro el nombre del fichero fuente RoboLang.
REM Default: 'programa_1.rbl'

REM ---- 0) Establecer WEBOTS_HOME ----
set "WEBOTS_HOME=C:\Program Files\Webots"

REM ---- 1) Parámetro por defecto ----
set "PARAM_JAVA=%~1"
if "%PARAM_JAVA%"=="" set "PARAM_JAVA=programa_1.rbl"

REM ---- 2) VERIFICAR archivo existe
if not exist "%PARAM_JAVA%" (
    echo ❌ ERROR: Archivo '%PARAM_JAVA%' no encontrado
    echo    Busca: dir *.rbl
    exit /b 1
)

echo.
echo ╔══════════════════════════════════════════════╗
echo ║ 🎮 InterpreteWebots - Windows                ║
echo ║ Archivo: %PARAM_JAVA%                        ║
echo ╚══════════════════════════════════════════════╝
echo.

REM ---- 3) DLL path ----
set "WEBOTS_LIB=%WEBOTS_HOME%\lib\controller"
set "PATH=%CD%\lib;%WEBOTS_LIB%;%WEBOTS_HOME%\msys64\mingw64\bin;%PATH%"

REM ---- 4) Detectar y manejar Webots ----
tasklist /FI "IMAGENAME eq webotsw.exe" 2>NUL | find /I "webotsw.exe" >NUL
if errorlevel 1 (
    echo 🚀 Arrancando Webots...
    start "" "%WEBOTS_HOME%\msys64\mingw64\bin\webotsw.exe" "%CD%\src\webots\MiniMundo.wbt"
    timeout /t 10 /nobreak >NUL  REM Aumenta a 10s para carga completa
) else (
    echo ✅ Webots detectado (asumiendo mundo cargado)
)

REM Limpia pipes residuales opcional (ejecuta si persiste):
REM rmdir /s /q "%TEMP%\webots_*" 2>nul

REM ---- 4) Lanzar controlador Java ----
echo ⚙️  Controlador: interpretes.InterpreteWebots %PARAM_JAVA%
java -cp "bin;lib\Controller.jar;lib\antlr-4.13.2-complete.jar" ^
     -Djava.library.path=lib ^
     interpretes.InterpreteWebots "%PARAM_JAVA%"

echo.
echo 🎉 Simulacion finalizada

endlocal
