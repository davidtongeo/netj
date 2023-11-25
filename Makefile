build:
	mkdir build;
	javac -d ./build/ Main.java
	cd ./build; jar -cfe netj.jar Main *
clean:
	rm -rf ./build/
