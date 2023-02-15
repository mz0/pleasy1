NEW "flavored" build draft-1: available ProtocolPlugin[s] differ between flavors etc.

currently 3 flavors defined:
1. AB - ProtocolA, ProtocolB
1. AF - ProtocolA, ProtocolF
1. default Protocol[A|B|F]

We can build/run one flavor at a time. Flavor is selected as a Gradle Project property `flavor`
```
../gradlew war -Pflavor=AB
```

deployment options:
- Using Gretty 3 plugin (and Jetty 10) - press **Enter** key to stop Jetty when done
```
../gradlew appRunWar -Pflavor=AB
```
- manual build/copy
```
../gradlew build -Pflavor=AB
cp build/libs.web-ui.war $CATALINA_BASE/webapps/
```
- "Smart Tomcat" plugin for IDEA - TODO, not recommended a.t.m. (no idea how to pass -Pfoo=bar to Gradle task 'war')

in either case http://localhost:8080/web-ui/ shows
```
 Known Protocols:

  protocolId       plugin
  dkw        bb.spi.pb.ProtocolB
  abc        bb.spi.pb.ProtocolB
  agx        bb.spi.pa.ProtocolA
  apx        bb.spi.pa.ProtocolA
  mbb        bb.spi.pb.ProtocolB
  bmw        bb.spi.pb.ProtocolB
```
and console (or `catalina.out`) will have this
```
> Task :web-ui:appRunWar
Press any key to stop the server.

bb.spi.pb.ProtocolB instantiated
bb.spi.pa.ProtocolA instantiated
collecting supported protocol IDs
adding ID 'dkw' for bb.spi.pb.ProtocolB
adding ID 'abc' for bb.spi.pb.ProtocolB
adding ID 'mbb' for bb.spi.pb.ProtocolB
adding ID 'bmw' for bb.spi.pb.ProtocolB
adding ID 'agx' for bb.spi.pa.ProtocolA
WARNING: ID 'abc' for bb.spi.pa.ProtocolA conflicts with bb.spi.pb.ProtocolB
adding ID 'apx' for bb.spi.pa.ProtocolA

2 plugins loaded OK (1 warning[s]) in 5 ms
```
**NB** "Press any key to stop the server." is a lie. Use **Enter** to do so.

see also:
- [Gretty tasks](https://gretty-gradle-plugin.github.io/gretty-doc/Gretty-tasks.html)
