<<<<<<< HEAD
@ECHO OFF
set /P port=Enter your port:
START "runas /user:administrator" cmd /K "cd c:\users\lab_services_student\AppData\Local\Android\Sdk\platform-tools & adb connect localhost:%port%"
=======
@ECHO OFF
set /P port=Enter your port:
START "runas /user:administrator" cmd /K "cd c:\users\lab_services_student\AppData\Local\Android\Sdk\platform-tools & adb connect localhost:%port%"
>>>>>>> 1d6f59135aecac265dd757b2a33916f783db17fb
