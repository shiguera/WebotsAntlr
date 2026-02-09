@echo off
chcp 65001 >NUL
setlocal EnableExtensions

REM ============================================================
REM Ejecuta interpretes.InterpreteStdDraw (versión Windows)
REM Permite pasar fichero fuente .rbl como parámetro
REM ============================================================

REM ---- Parámetro por defecto ----
set "PARAM_JAVA=%~1"
if "%PARAM_JAVA%"=="" set "PARAM_JAVA=programa_1.rbl"

REM ---- Classpath completo (en Windows separador = ;) ----
set "CP=bin;lib\antlr-4.13.2-complete.jar;lib\StdAudio.jar;lib\Controller.jar"

REM ---- Ejecutar ----
echo Ejecutando interpretes.InterpreteStdDraw %PARAM_JAVA%
java -Dfile.encoding=UTF-8 -cp "%CP%" interpretes.InterpreteStdDraw "%PARAM_JAVA%"

endlocal

