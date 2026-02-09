@echo off
chcp 65001 >NUL
setlocal EnableExtensions

REM InterpreteConsola - Ejecuta código RoboLang en consola
REM Default: programa_1.rbl

REM ---- 1) Parámetro por defecto ----
set "PARAM_JAVA=%~1"
if "%PARAM_JAVA%"=="" set "PARAM_JAVA=programa_1.rbl"

REM ---- 2) VERIFICAR archivo existe ----
if not exist "%PARAM_JAVA%" (
    echo.
    echo ╔════════════════════════════════════════════════╗
    echo ║ ❌ ERROR: Archivo '%PARAM_JAVA%' no encontrado ║
    echo ╚════════════════════════════════════════════════╝
    echo.
    echo 📂 Archivos disponibles:
    dir *.rbl 2>nul || echo    Ningún .rbl encontrado
    echo.
    pause
    exit /b 1
)

REM ---- 3) Mensaje principal ----
echo.
echo ╔════════════════════════════════════════════════╗
echo ║ ⌨️  InterpreteConsola - Archivo: %PARAM_JAVA%  ║
echo ╚════════════════════════════════════════════════╝
echo.

REM ---- 4) Classpath completo (wildcard lib\*) ----
set "CP=bin;lib\*"

echo ⚙️  Ejecutando en consola...
java -cp "%CP%" ^
     interpretes.InterpreteConsola "%PARAM_JAVA%"

echo.
echo ╔══════════════════════════════════════════════╗
echo ║ 🎉 Ejecución consola finalizada              ║
echo ╚══════════════════════════════════════════════╝
echo.

