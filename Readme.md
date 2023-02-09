run with `./gradlew app:run`

needs Java 11+, Java 8 cannot build SWT here

console output (after 2 clicks):
```
> Task :app:run (Java 17)
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
WARNING: ID 'dkw' for bb.spi.pf.ProtocolF conflicts with bb.spi.pb.ProtocolB
WARNING: ID 'abc' for bb.spi.pf.ProtocolF conflicts with bb.spi.pa.ProtocolA
WARNING: ID 'mbb' for bb.spi.pf.ProtocolF conflicts with bb.spi.pb.ProtocolB
WARNING: ID 'bmw' for bb.spi.pf.ProtocolF conflicts with bb.spi.pb.ProtocolB

2 plugins loaded OK (5 warning[s]) in 20 ms

Compatible IDs: dkw, agx, abc, apx, mbb, bmw
Compatible IDs: dkw, agx, abc, apx, mbb, bmw
```
Note 3 instantiations (ProtocolA, ProtocolB, ProtocolF), but only 2 of them are used ("loaded")  
due to conflicts (all 4 IDs of ProtocolF conflict with ProtocolB)
