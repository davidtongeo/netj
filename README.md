# Netj
> A minimalistic http request sender.

## Requeriments
- It uses `JDK 11+` since it's built with the [HttpRequest](https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpRequest.html). <br>
- You need to have `make` for building from source. Alternatively, you could use the 2nd method.

## Build

  In the source files, there is a **Makefile** which you can use to build *netj*. <br>
```bash
# 1st method (Recommended)
git clone https://github.com/davidtongeo/netj --depth 1
cd netj
make
cd build
```
```bash
# 2nd method
git clone https://github.com/davidtongeo/netj --depth 1
cd netj
mkdir build
javac -d ./build/ Main.java
cd ./build
jar -cfe netj.jar Main *
```

# Usage

the **Makefile** should have created the `netj.jar` which will provide a manual
```bash
# assuming you are in the `build` directory. 
java -jar netj.jar -help
```
Output:
```
[HELP OPTION]

Usage: netj <URL> <OPTIONS>    Example: netj https://www.google.com -html
Defaults: The default request verb is GET


[OPTIONS]

-post: Sends a POST request.
-body <body content>: Set the body for the request.
-headers <arg1> <arg2>: Sets the headers for the request.
-help: Show this message (who would know right?)
```
