deployment options:
- Using Gretty 3 plugin (and Jetty 10)
```
../gradlew appRunWar  # press Enter key to stop Jetty when done
```
- "Smart Tomcat" plugin for IDEA - TODO
- manual build/copy
```
../gradlew build
cp build/libs.web-ui.war $CATALINA_BASE/webapps/
```
in either case http://localhost:8080/web-ui/ shows

```
Known Protocols:

- protocolId: dkw, plugin: bb.spi.pb.ProtocolB
- protocolId: abc, plugin: bb.spi.pb.ProtocolB
- protocolId: agx, plugin: bb.spi.pa.ProtocolA
- protocolId: apx, plugin: bb.spi.pa.ProtocolA
- protocolId: mbb, plugin: bb.spi.pb.ProtocolB
- protocolId: bmw, plugin: bb.spi.pb.ProtocolB
```
and `catalina.out` will have this
```
INFO [main] org.apache.catalina.startup.Catalina.start Server startup in [4201] milliseconds
will not load: bb.spi.pf.ProtocolF
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

2 plugins loaded OK (1 warning[s]) in 7 ms
```

see also:
- [Gretty tasks](https://gretty-gradle-plugin.github.io/gretty-doc/Gretty-tasks.html)
