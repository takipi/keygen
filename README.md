keygen
======

OverOps Key Generator creates a secret key and installation scripts to be used when installing Takipi (https://app.overops.com)<br/>
You will need to Use it when you install OverOps on a new machine or you can update the key (usually located in /opt/takipi/work/secret.key)


Installation
-------------
a. Fork / Get the code and run<br/>
```mvn clean compile assembly:single```<br/>
b. Download the latest release<br/>
https://s3.amazonaws.com/app-takipi-com/keygen/keygen-1.2.0-jar-with-dependencies.jar

Usage
======
USERNAME and PASSWORD are the ones you use to login to OverOps app (https://app.overops.com)<br/>

```java -jar keygen-1.2.0-jar-with-dependencies.jar USERNAME PASSWORD```

----------
