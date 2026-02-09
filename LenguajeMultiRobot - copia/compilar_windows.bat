@echo off
<<<<<<< HEAD
REM Este script compila todo el proyecto.
REM Para ejecutarlo, hay que estar situado en el directorio raíz del proyecto.
REM Los ficheros compilados .class se guardan en el directorio bin

setlocal EnableExtensions

echo "🔨 Compilando proyecto Robolang..."

javac -cp "lib\Controller.jar;lib\antlr-4.13.2-complete.jar" ^
    -d bin ^
    src\main\*.java src\lenguaje\*.java src\interpretes\*.java ^
    src\sound\*.java src\webots\*.java src\stddraw\*.java src\consola\*.java

if not errorlevel 1 (
    echo ✅ Compilacion exitosa
) else (
    echo ❌ Errores de compilacion
)

=======
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
>>>>>>> a5c0b5a3e7f7fda96eb130339a8532417174f2b5
