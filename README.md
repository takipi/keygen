keygen
======

Takipi Key Generator creates a secret key and installation scripts to be used when installing Takipi (https://app.takipi.com)<br/>
You will need to Use it when you install Takipi on a new machine or you can update the key (usually located in /opt/takipi/work/secret.key)


Installation
-------------
a. Fork / Get the code and run<br/>
```mvn clean compile assembly:single```<br/>
b. Download the latest release<br/>
https://s3.amazonaws.com/app-takipi-com/keygen/keygen-1.1.0-jar-with-dependencies.jar

Usage
======
USERNAME and PASSWORD are the ones you use to login to Takipi app (https://app.takipi.com)<br/>
If you install Takipi on a machine behind a proxy you can also pass the proxy address (i.e http://192.168.1.11:8080) 
as an argument. The generated installation script will use it when installing Takipi.

```java -jar keygen-1.1.0-jar-with-dependencies.jar USERNAME PASSWORD [PROXY]```

----------
