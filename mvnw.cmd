@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements.  See the NOTICE file
@REM distributed with this work for additional information
@REM regarding copyright ownership.  The ASF licenses this file
@REM to you under the Apache License, Version 2.0 (the
@REM "License"); you may not use this file except in compliance
@REM with the License.  You may obtain a copy of the License at
@REM
@REM    http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing,
@REM software distributed under the License is distributed on an
@REM "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
@REM KIND, either express or implied.  See the License for the
@REM specific language governing permissions and limitations
@REM under the License.
@REM ----------------------------------------------------------------------------

@REM ----------------------------------------------------------------------------
@REM Maven Start Up Batch script
@REM
@REM Required ENV vars:
@REM JAVA_HOME - location of a JDK home dir
@REM
@REM Optional ENV vars
@REM M2_HOME - location of maven2's installed home (optional)
@REM MAVEN_BATCH_ECHO - set to 'on' to enable the echoing of the batch commands
@REM MAVEN_BATCH_PAUSE - set to 'on' to wait for a keystroke before ending
@REM MAVEN_OPTS - parameters passed to the Java VM when running Maven
@REM     e.g. to debug Maven itself, use
@REM set MAVEN_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000
@REM MAVEN_SKIP_RC - flag to disable loading of mavenrc files
@REM ----------------------------------------------------------------------------

@setlocal

set ERROR_CODE=0

@REM To isolate internal variables from possible post scripts, we use another setlocal
@setlocal

@REM ==== START VALIDATION ====
if not "%JAVA_HOME%" == "" goto OkJHome

echo.
echo Error: JAVA_HOME not found in your environment. >&2
echo Please set the JAVA_HOME variable in your environment to match the >&2
echo location of your Java installation. >&2
echo.
goto error

:OkJHome
if exist "%JAVA_HOME%\bin\java.exe" goto init

echo.
echo Error: JAVA_HOME is set to an invalid directory. >&2
echo JAVA_HOME = "%JAVA_HOME%" >&2
echo Please set the JAVA_HOME variable in your environment to match the >&2
echo location of your Java installation. >&2
echo.
goto error

@REM ==== END VALIDATION ====

:init

@REM Find the project base dir, i.e. the directory that contains the folder ".mvn".
@REM Fallback to current working directory if not found.

set MAVEN_PROJECTBASEDIR=%MAVEN_BASEDIR%
IF "%MAVEN_PROJECTBASEDIR%"=="" (
set MAVEN_PROJECTBASEDIR=%CD%
)

@REM Extension to allow automatically downloading the maven-wrapper.jar from Maven-central
@REM This allows using the maven wrapper in projects that prohibit checking in binary data.
if exist "%BASE_DIR%\.mvn\wrapper\maven-wrapper.jar" (
    if "%MVNW_VERBOSE%" == "true" (
        echo Found .mvn\wrapper\maven-wrapper.jar
    )
) else (
    if not "%MVNW_REPOURL%" == "" (
        SET DOWNLOAD_URL="%MVNW_REPOURL%/org/apache/maven/wrapper/maven-wrapper/3.1.1/maven-wrapper-3.1.1.jar"
    )
    if "%MVNW_VERBOSE%" == "true" (
        echo Couldn't find .mvn\wrapper\maven-wrapper.jar, downloading it ...
        echo Downloading from: %DOWNLOAD_URL%
    )

    powershell -Command "&{"^
	"$webclient = new-object System.Net.WebClient;"^
	"if (-not ([string]::IsNullOrEmpty('%MVNW_USERNAME%') -and [string]::IsNullOrEmpty('%MVNW_PASSWORD%'))) {"^
	"$webclient.Credentials = new-object System.Net.NetworkCredential('%MVNW_USERNAME%', '%MVNW_PASSWORD%');"^
	"}"^
	"[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; $webclient.DownloadFile('%DOWNLOAD_URL%', '%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar')"^
	"}"
    if "%ERRORLEVEL%" == "0" (
        if "%MVNW_VERBOSE%" == "true" (
            echo Successfully downloaded .mvn\wrapper\maven-wrapper.jar
        )
    ) else (
        if "%MVNW_VERBOSE%" == "true" (
            echo Failed to download .mvn\wrapper\maven-wrapper.jar
        )
        echo Error failed to download maven-wrapper.jar >&2
        exit /b 1
    )
)
@REM End of extension

@REM Provide a "standardized" way to retrieve the CLI args that will
@REM work with both Windows and non-Windows executions.
if ERRORLEVEL 1 goto error
goto OkMHome

:OkMHome
set MAVEN_HOME=%MAVEN_PROJECTBASEDIR%\.mvn\wrapper
if "%MVNW_VERBOSE%" == "true" (
  echo Couldn't find .mvn\wrapper\maven-wrapper.jar, downloading it ...
  echo Downloading from: https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.1.1/maven-wrapper-3.1.1.jar
)

powershell -Command "&{"^
	"$webclient = new-object System.Net.WebClient;"^
	"if (-not ([string]::IsNullOrEmpty('%MVNW_USERNAME%') -and [string]::IsNullOrEmpty('%MVNW_PASSWORD%'))) {"^
	"$webclient.Credentials = new-object System.Net.NetworkCredential('%MVNW_USERNAME%', '%MVNW_PASSWORD%');"^
	"}"^
	"[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; $webclient.DownloadFile('https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.1.1/maven-wrapper-3.1.1.jar', '%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar')"^
	"}"

if exist "%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar" (
    if "%MVNW_VERBOSE%" == "true" (
        echo Found .mvn\wrapper\maven-wrapper.jar
    )
) else (
    echo.
    echo Error: Failed to download maven-wrapper.jar. Exiting.
    exit /b 1
)

@REM Provide a "standardized" way to retrieve the CLI args that will
@REM work with both Windows and non-Windows executions.

setlocal enabledelayedexpansion
for /F "usebackq tokens=*" %%a in (`find /V "" ^< "%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.properties"`) do (
    if "!option!"=="" (
        set "option=%%a"
    ) else (
        set "option=!option! %%a"
    )
)

set MAVEN_OPTS=!option! %MAVEN_OPTS%

:setBuildDir
if not "%MAVEN_PROJECTBASEDIR%"=="" goto baseDirFound
cd /d %~dp0
if "%~dp0"=="" goto baseDirFound
cd ..
:baseDirFound
@REM If no M2_HOME set by user, use default value
if "%M2_HOME%"=="" (
  if exist "%MAVEN_PROJECTBASEDIR%\.mvn\wrapper" (
    set "M2_HOME=%MAVEN_PROJECTBASEDIR%\.mvn\wrapper"
  )
)

@REM If no M2_HOME set by user, use default value
if "%M2_HOME%"=="" (
  set "M2_HOME=%ProgramFiles%\Apache\apache-maven-3.8.1"
)

set MAVEN_JAVA_EXE="%JAVA_HOME%\bin\java.exe"
set CLASSWORLDS_JAR="%M2_HOME%\.mvn\wrapper\maven-wrapper.jar"
set WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain

set DOWNLOAD_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.1.1/maven-wrapper-3.1.1.jar"

@REM Extension to allow automatically downloading the maven-wrapper.jar from Maven-central
@REM This allows using the maven wrapper in projects that prohibit checking in binary data.
if exist "%CLASSWORLDS_JAR%" (
    if "%MVNW_VERBOSE%" == "true" (
      echo Found %CLASSWORLDS_JAR%
    )
) else (
    if not "%MVNW_REPOURL%" == "" (
      set DOWNLOAD_URL="%MVNW_REPOURL%/org/apache/maven/wrapper/maven-wrapper/3.1.1/maven-wrapper-3.1.1.jar"
    )
    if "%MVNW_VERBOSE%" == "true" (
      echo Couldn't find %CLASSWORLDS_JAR%, downloading it ...
      echo Downloading from: %DOWNLOAD_URL%
    )

    powershell -Command "&{"^
	"$webclient = new-object System.Net.WebClient;"^
	"if (-not ([string]::IsNullOrEmpty('%MVNW_USERNAME%') -and [string]::IsNullOrEmpty('%MVNW_PASSWORD%'))) {"^
	"$webclient.Credentials = new-object System.Net.NetworkCredential('%MVNW_USERNAME%', '%MVNW_PASSWORD%');"^
	"}"^
	"[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; $webclient.DownloadFile('%DOWNLOAD_URL%', '%CLASSWORLDS_JAR%')"^
	"}"
    if "%ERRORLEVEL%" == "0" (
        if "%MVNW_VERBOSE%" == "true" (
            echo Successfully downloaded %CLASSWORLDS_JAR%
        )
    ) else (
        if "%MVNW_VERBOSE%" == "true" (
            echo Failed to download %CLASSWORLDS_JAR%
        )
        echo Error failed to download maven-wrapper.jar >&2
        exit /b 1
    )
)
@REM End of extension

%MAVEN_JAVA_EXE% %JVM_CONFIG_MAVEN_PROPS% %MAVEN_OPTS% %MAVEN_DEBUG_OPTS% -classpath %CLASSWORLDS_JAR% "%WRAPPER_LAUNCHER%" %MAVEN_CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
set ERROR_CODE=1

:end
@endlocal & set ERROR_CODE=%ERROR_CODE%

if not "%MAVEN_SKIP_RC%"=="" goto skipRcPost
@REM check for post script, e.g. mvnw.cmd.post
if exist "%MAVEN_PROJECTBASEDIR%\mvnw.cmd.post" call "%MAVEN_PROJECTBASEDIR%\mvnw.cmd.post"
:skipRcPost

exit /b %ERROR_CODE%
