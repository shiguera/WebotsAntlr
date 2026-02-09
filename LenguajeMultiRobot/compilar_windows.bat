@echo off
chcp 65001 >NUL
setlocal EnableExtensions

REM ============================================================
REM Compila todo el proyecto Java
REM Ejecutar desde el directorio raiz del proyecto
REM Los .class se guardan en /bin
REM ============================================================

REM ---- Crear directorio bin si no existe ----
if not exist bin mkdir bin

REM ---- Classpath (Windows usa ;) ----
set "CP=lib\Controller.jar;lib\antlr-4.13.2-complete.jar"

echo Compilando proyecto...

javac -encoding UTF-8 -cp "%CP%" ^
      -d bin ^
      src\main\*.java src\lenguaje\*.java src\interpretes\*.java src\sound\*.java ^
      src\robolang_webots\*.java src\robolang_stddraw\*.java src\robolang_consola\*.java

if %ERRORLEVEL%==0 (
    echo.
    echo [OK] Compilacion completada
) else (
    echo.
    echo [ERROR] Fallo en compilacion
)

endlocal
