run with `../gradlew run`

needs Java 11+ (ServiceLoader.Provider is a Java 9+ Interface)

console output:
```
> Task :app:run (Java 17)
will not load: bb.spi.pf.ProtocolF
bb.spi.pa.ProtocolA instantiated
bb.spi.pb.ProtocolB instantiated
collecting supported protocol IDs
adding ID 'agx' for bb.spi.pa.ProtocolA
adding ID 'abc' for bb.spi.pa.ProtocolA
adding ID 'apx' for bb.spi.pa.ProtocolA
adding ID 'dkw' for bb.spi.pb.ProtocolB
WARNING: ID 'abc' for bb.spi.pb.ProtocolB conflicts with bb.spi.pa.ProtocolA
adding ID 'mbb' for bb.spi.pb.ProtocolB
adding ID 'bmw' for bb.spi.pb.ProtocolB

2 plugins loaded OK (1 warning[s]) in 35 ms


Compatible IDs: dkw, agx, abc, apx, mbb, bmw
ProtocolId dkw - Handler bb.spi.pb.ProtocolB
ProtocolId agx - Handler bb.spi.pa.ProtocolA
ProtocolId abc - Handler bb.spi.pa.ProtocolA
ProtocolId apx - Handler bb.spi.pa.ProtocolA
ProtocolId mbb - Handler bb.spi.pb.ProtocolB
ProtocolId bmw - Handler bb.spi.pb.ProtocolB
```
Note 2 instantiations (ProtocolA, ProtocolB), both of them are used ("loaded" indeed)  
ProtocolF not loaded due to (hardcoded) configuration rule
