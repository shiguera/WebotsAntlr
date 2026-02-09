@echo off
chcp 65001 >NUL
setlocal EnableExtensions

REM Menu principal - Lanzador interactivo Robolang

REM ---- Mensaje principal ----
echo.
echo ╔══════════════════════════════════════════════╗
echo ║ 🏠 Menu Principal Robolang                   ║
echo ╚══════════════════════════════════════════════╝
echo.

REM ---- Classpath completo (wildcard lib\*) ----
set "CP=bin;lib\*"

echo ⚙️  Lanzando menú interactivo...
java -cp "%CP%" ^
     -Djava.library.path=lib ^
     main.Menu

echo.
echo ╔══════════════════════════════════════════════╗
echo ║ 🏠 Menu cerrado                              ║
echo ╚══════════════════════════════════════════════╝
echo.
pause

