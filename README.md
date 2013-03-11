keygen
======

Takipi Key Generator creates a secret key to be used with Takipi app (https://app.takipi.com)<br/>
You will need to Use it when you install Takipi on a new machine or you can update the key (usually located in /opt/takipi/work/secret.key)


Installation
------------
a. Fork / Get the code and run<br/>
```mvn clean compile assembly:single```<br/>
b. Download latest release<br/>
https://s3.amazonaws.com/app-takipi-com/keygen/keygen-1.0.0-jar-with-dependencies.jar

Usage
=====
USERNAME and PASSWORD are the ones you use to login to Takipi app (https://app.takipi.com)<br/>
NAMESPACES are your top namcespaces i.e. com.company;org.mycompany2.product<br/>
If you plan to install Takipi on a machine behind a PROXY you can also pass it (i.e http://192.168.1.11:8080) 
and the output will include information on how to install Takipi behind it.

```java -jar keygen-1.0.0-jar-with-dependencies.jar USERNAME PASSWORD NAMESPACES [PROXY]```

----------
