run with `./gradlew app:run`

needs Java 8+

console output (after a click):
```
> Task :app:run (Java 8)
will not load: bb.spi.pf.ProtocolF
collecting supported protocol IDs
bb.spi.pa.ProtocolA instantiated
adding ID 'agx' for bb.spi.pa.ProtocolA
adding ID 'abc' for bb.spi.pa.ProtocolA
adding ID 'apx' for bb.spi.pa.ProtocolA
bb.spi.pb.ProtocolB instantiated
adding ID 'dkw' for bb.spi.pb.ProtocolB
WARNING: ID 'abc' for bb.spi.pb.ProtocolB conflicts with bb.spi.pa.ProtocolA
adding ID 'mbb' for bb.spi.pb.ProtocolB
adding ID 'bmw' for bb.spi.pb.ProtocolB
bb.spi.pf.ProtocolF instantiated
not loading bb.spi.pf.ProtocolF

2 plugins loaded OK (1 warning[s]) in 11 ms


Compatible IDs: dkw, agx, abc, apx, mbb, bmw
ProtocolId dkw - Handler bb.spi.pb.ProtocolB
ProtocolId abc - Handler bb.spi.pa.ProtocolA
ProtocolId agx - Handler bb.spi.pa.ProtocolA
ProtocolId apx - Handler bb.spi.pa.ProtocolA
ProtocolId mbb - Handler bb.spi.pb.ProtocolB
ProtocolId bmw - Handler bb.spi.pb.ProtocolB
```
Note 3 instantiations (ProtocolA, ProtocolB, ProtocolF), two of them are used ("loaded" indeed)  
ProtocolF is not used due to (hardcoded) configuration rule
