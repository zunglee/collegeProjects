javac *.java
rmic SortServerImpl
start rmiregistry
start java SortServerImpl 1
start java SortServerImpl 2
java cli 172.19.0.74 172.19.0.74
