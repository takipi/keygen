keygen
======

Takipi Key Generator creates a secret key and installation scripts to be used when installing Takipi (https://app.takipi.com)<br/>
You will need to Use it when you install Takipi on a new machine or you can update the key (usually located in /opt/takipi/work/secret.key)


Installation
-------------
a. Fork / Get the code and run<br/>
```mvn clean compile assembly:single```<br/>
b. Download the latest release<br/>
https://s3.amazonaws.com/app-takipi-com/keygen/keygen-1.0.0-jar-with-dependencies.jar

Usage
======
USERNAME and PASSWORD are the ones you use to login to Takipi app (https://app.takipi.com)<br/>
PACKAGES are your top packages i.e. "com.company;org.mycompany2.product"<br/>
If you plan to install Takipi on a machine behind a proxy  you can also pass its address (i.e http://192.168.1.11:8080) 
for use bt the installation scripts.

```java -jar keygen-1.0.0-jar-with-dependencies.jar USERNAME PASSWORD "PACKAGES" [PROXY]```

----------
